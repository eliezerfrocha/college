use db_pull_requests ; 

-- 01 - Criar função eh_ano_atual
DELIMITER $$
CREATE FUNCTION eh_ano_atual(data_input DATE) 
RETURNS BOOLEAN
DETERMINISTIC
BEGIN
    RETURN YEAR(data_input) = YEAR(CURDATE());
END$$
DELIMITER ;

-- Executar:
SELECT eh_ano_atual('2025-06-01');


-- 02 - Criar função extrair_frase
DELIMITER $$
CREATE FUNCTION extrair_frase(texto TEXT, palavra_chave VARCHAR(255)) 
RETURNS TEXT
DETERMINISTIC
BEGIN
    DECLARE pos_ini INT DEFAULT 1;
    DECLARE pos_fim INT DEFAULT 1;
    DECLARE frase TEXT;
    DECLARE tmp TEXT;
    SET tmp = texto;
    WHILE LOCATE(palavra_chave, tmp) > 0 DO
        SET pos_ini = LOCATE(palavra_chave, tmp);
        -- buscar início da frase
        WHILE pos_ini > 1 AND SUBSTRING(tmp, pos_ini - 1, 1) NOT IN ('.', '\n') DO
            SET pos_ini = pos_ini - 1;
        END WHILE;
        IF pos_ini > 1 THEN
            SET pos_ini = pos_ini + 1;
        END IF;
        -- buscar fim da frase
        SET pos_fim = LOCATE('.', tmp, LOCATE(palavra_chave, tmp));
        IF pos_fim = 0 OR (LOCATE('\n', tmp, LOCATE(palavra_chave, tmp)) < pos_fim AND LOCATE('\n', tmp, LOCATE(palavra_chave, tmp)) <> 0) THEN
            SET pos_fim = LOCATE('\n', tmp, LOCATE(palavra_chave, tmp));
        END IF;
        IF pos_fim = 0 THEN
            SET pos_fim = CHAR_LENGTH(tmp) + 1;
        END IF;
        SET frase = TRIM(SUBSTRING(tmp, pos_ini, pos_fim - pos_ini));
        IF RIGHT(frase, 1) = '.' THEN
            SET frase = LEFT(frase, LENGTH(frase) - 1);
        END IF;
        RETURN frase;
    END WHILE;
    RETURN NULL;
END$$
DELIMITER ;

-- Executar:
SELECT extrair_frase('Changed performed by Carlos. This pull request improves code readability. Another unrelated comment.', 'readability');


-- 03 - Adicionar coluna texto_readability à tabela pullrequests
ALTER TABLE pullrequests ADD COLUMN texto_readability VARCHAR(255);

-- Executar:
select texto_readability from pullrequests ;


-- 04 - Criar procedure atualizar_readability
DELIMITER $$
CREATE PROCEDURE atualizar_readability()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE pr_owner_repo VARCHAR(255);
    DECLARE pr_number INT;
    DECLARE pr_title VARCHAR(255);
    DECLARE pr_body TEXT;
    DECLARE frase TEXT;
    DECLARE cur CURSOR FOR 
        SELECT owner_repo, pr_number, title, body FROM pullrequests;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    OPEN cur;
    read_loop: LOOP
        FETCH cur INTO pr_owner_repo, pr_number, pr_title, pr_body;
        IF done THEN
            LEAVE read_loop;
        END IF;
        SET frase = extrair_frase(pr_title, 'readability');
        IF frase IS NULL THEN
            SET frase = extrair_frase(pr_body, 'readability');
        END IF;
        IF frase IS NOT NULL THEN
            UPDATE pullrequests 
            SET texto_readability = frase 
            WHERE owner_repo = pr_owner_repo 
              AND pr_number = pr_number;
        END IF;
    END LOOP;
    CLOSE cur;
END$$
DELIMITER ;

-- Executar:
CALL atualizar_readability();


-- 05 - Criar tabela pull_request_repetida
CREATE TABLE pull_request_repetida (
    id INT AUTO_INCREMENT PRIMARY KEY,
    owner_repo VARCHAR(255),
    pr_number INT,
    data_tentativa TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Executar:
select * from pull_request_repetida;


-- 06 - Criar trigger verificar_pullrequest_repetida
DELIMITER $$
CREATE TRIGGER verificar_pullrequest_repetida
BEFORE INSERT ON pullrequests
FOR EACH ROW
BEGIN
    IF EXISTS (
        SELECT 1 FROM pullrequests 
        WHERE owner_repo = NEW.owner_repo AND pr_number = NEW.pr_number
    ) THEN
        INSERT INTO pull_request_repetida(owner_repo, pr_number)
        VALUES (NEW.owner_repo, NEW.pr_number);
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Pull request duplicada. Inserção cancelada.';
    END IF;
END$$
DELIMITER ;

-- Teste:
-- Inserir o owner_repo em repositories - se ainda não existir
INSERT INTO repositories (
    owner_repo, language, stars, isFork, pullRequests, forks, 
    numberIssues, watchers, collaborators, lastUpdate
) VALUES ('repo/teste', 'Java', 10, 0, 5, 2, 0, 3, 2, NOW());

select * from repositories where owner_repo = 'repo/teste';
-- Inserção de um registro novo não duplicado
INSERT INTO pullrequests (
    owner_repo, pr_number, url, title, body, changedFiles, 
    mergedAt, mergedBy, author, keyword, texto_readability
) VALUES (
    'repo/teste', 101, 'http://example.com/pr/101', 'Initial commit', 
    'This is the initial pull request.', 5, NOW(), 'dev1', 'author1', 'initial', NULL
);
-- Inserção de um registro duplicado - deve ativar a trigger e bloquear
INSERT INTO pullrequests (
    owner_repo, pr_number, url, title, body, changedFiles, 
    mergedAt, mergedBy, author, keyword, texto_readability
) VALUES (
    'repo/teste', 101, 'http://example.com/pr/101-duplicate', 'Duplicate commit', 
    'Trying to insert duplicate.', 3, NOW(), 'dev2', 'author2', 'duplicate', NULL
);
-- consultar tabela pull_request_repetida
SELECT * FROM pull_request_repetida;

-- 07 - Criar procedure listar_pullrequests_com_participacao_insuficiente
DROP PROCEDURE IF EXISTS listar_pullrequests_com_participacao_insuficiente;

DELIMITER $$
CREATE PROCEDURE listar_pullrequests_com_participacao_insuficiente()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE pr_number INT;
    DECLARE pr_owner_repo VARCHAR(255);
    DECLARE pr_author VARCHAR(255);
    DECLARE pr_mergedBy VARCHAR(255);
    DECLARE distinct_count INT;
    DECLARE cur CURSOR FOR 
        SELECT pr_number, owner_repo, author, mergedBy FROM pullrequests;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    CREATE TEMPORARY TABLE IF NOT EXISTS resultado (
        pr_number INT,
        owner_repo VARCHAR(255)
    );
    OPEN cur;
    read_loop: LOOP
        FETCH cur INTO pr_number, pr_owner_repo, pr_author, pr_mergedBy;
        IF done THEN
            LEAVE read_loop;
        END IF;
        SELECT COUNT(DISTINCT login) INTO distinct_count
        FROM (
            SELECT pr_author AS login
            UNION
            SELECT pr_mergedBy
            UNION
            SELECT login FROM reviews WHERE owner_repo = pr_owner_repo AND pr_number = pr_number
        ) AS participantes
        WHERE login IS NOT NULL AND login <> '';
        IF distinct_count < 2 THEN
            INSERT INTO resultado(pr_number, owner_repo) VALUES (pr_number, pr_owner_repo);
        END IF;
    END LOOP;
    CLOSE cur;
    SELECT * FROM resultado;
    DROP TEMPORARY TABLE resultado;
END$$
DELIMITER ;

-- Executar:
CALL listar_pullrequests_com_participacao_insuficiente();



-- 08 - Criar trigger atualizar_changedfiles_mesma_linguagem

DELIMITER $$

CREATE TRIGGER atualizar_changedfiles_mesma_linguagem
AFTER INSERT ON changedfiles
FOR EACH ROW
BEGIN
    DECLARE linguagem_principal VARCHAR(255);
    DECLARE changed_files_atual INT;

    SELECT linguagem INTO linguagem_principal
    FROM pullrequests
    WHERE owner_repo = NEW.owner_repo;

    IF NEW.linguagem = linguagem_principal THEN
        SELECT changedFiles INTO changed_files_atual
        FROM pullrequests
        WHERE owner_repo = NEW.owner_repo AND pr_number = NEW.pr_number;

        IF changed_files_atual IS NULL THEN
            SET changed_files_atual = 0;
        END IF;

        UPDATE pullrequests
        SET changedFiles = changed_files_atual + 1
        WHERE owner_repo = NEW.owner_repo AND pr_number = NEW.pr_number;
    END IF;
END$$

DELIMITER ;

-- como testar:
-- insira um registro na tabela changedfiles com a mesma linguagem da pullrequest.
-- o campo changedFiles da pullrequest será incrementado.

