-- Criação da tabela de Aluno
-- CREATE TABLE TB_ALUNO (
--     COD_ALUNO BIGINT AUTO_INCREMENT PRIMARY KEY,
--     NOME_ALUNO VARCHAR(100) NOT NULL,
--     DES_EMAIL VARCHAR(255) NOT NULL
-- );

-- Criação da tabela de Disciplina
-- CREATE TABLE TB_DISCIPLINA (
--     COD_DISCIPLINA BIGINT AUTO_INCREMENT PRIMARY KEY,
--     NOM_DISCIPLINA VARCHAR(100) NOT NULL,
--     NUM_HORAS INT NOT NULL
-- );

-- Criação da tabela de junção Aluno-Disciplina
-- CREATE TABLE TB_ALUNOS_CURSANDO (
--     COD_ALUNO BIGINT NOT NULL,
--     COD_DISCIPLINA BIGINT NOT NULL,
--     PRIMARY KEY (COD_ALUNO, COD_DISCIPLINA),
--     CONSTRAINT FK_ALUNO FOREIGN KEY (COD_ALUNO) REFERENCES TB_ALUNO(COD_ALUNO),
--     CONSTRAINT FK_DISCIPLINA FOREIGN KEY (COD_DISCIPLINA) REFERENCES TB_DISCIPLINA(COD_DISCIPLINA)
-- );

-- Inserção de dados na tabela Aluno
INSERT INTO tb_aluno (NOME_ALUNO, DES_EMAIL) VALUES ('João Silva', 'joao.silva@email.com');
INSERT INTO tb_aluno (NOME_ALUNO, DES_EMAIL) VALUES ('Maria Souza', 'maria.souza@email.com');

-- Inserção de dados na tabela Disciplina
INSERT INTO tb_disciplina (NOM_DISCIPLINA, NUM_HORAS) VALUES ('Matemática', 60);
INSERT INTO tb_disciplina (NOM_DISCIPLINA, NUM_HORAS) VALUES ('História', 45);
INSERT INTO tb_disciplina (NOM_DISCIPLINA, NUM_HORAS) VALUES ('Física', 50);

-- Associação entre Alunos e Disciplinas
-- João Silva cursa Matemática e Física
INSERT INTO tb_alunos_cursando (COD_ALUNO, COD_DISCIPLINA) VALUES (1, 1);
INSERT INTO tb_alunos_cursando (COD_ALUNO, COD_DISCIPLINA) VALUES (1, 3);

-- Maria Souza cursa História
INSERT INTO tb_alunos_cursando (COD_ALUNO, COD_DISCIPLINA) VALUES (2, 2);