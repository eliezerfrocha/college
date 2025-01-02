/*
 * 01. Insira dados de pelo menos mais dois jogadores e pelo menos mais 10 partidas, colocando mais de uma partida por jogador.
 */
insert into Jogador values
(5, "Ana Silva", "anasil", "F", "ana.silva@gmail.com", "2001-05-10", 2500, 2000),
(6, "Carlos Eduardo", "cadu", "M", "cadu@gmail.com", "1997-12-12", 3000, 1500);

insert into Partida values
(5, "2023-06-10 09:00:00", "2023-06-10 10:00:00", 400, 5, 1),
(6, "2023-06-11 14:00:00", "2023-06-11 15:30:00", 300, 5, 2),
(7, "2023-06-12 16:00:00", "2023-06-12 17:00:00", 200, 5, 3),
(8, "2023-06-13 19:00:00", "2023-06-13 20:30:00", 500, 6, 1),
(9, "2023-06-14 10:00:00", "2023-06-14 11:00:00", 300, 6, 2),
(10, "2023-06-15 18:30:00", "2023-06-15 19:30:00", 450, 6, 3),
(11, "2024-06-01 09:00:00", "2024-06-01 10:30:00", 700, 5, 1),
(12, "2024-06-02 14:00:00", "2024-06-02 15:30:00", 500, 6, 2),
(13, "2024-06-03 16:30:00", "2024-06-03 18:00:00", 600, 5, 3),
(14, "2024-06-04 19:00:00", "2024-06-04 20:30:00", 400, 6, 1);


/*
 * 02. Utilizando junção de tabelas, gere os seguintes relatórios:
 */
-- a) Lista de jogadores com detalhes de poderes adquiridos, ordenados pela data (mais recente para mais antiga).
SELECT j.nickname,
       j.sexo,
       j.pontuacao,
       j.moedas,
       p.habilidade,
       a.dt_hora_aquisicao
FROM Jogador j
JOIN Adquire_poder a ON j.cod_jogador = a.cod_jogador
JOIN poder p ON a.cod_poder = p.cod_poder
ORDER BY a.dt_hora_aquisicao DESC;

-- b) Partidas jogadas por Roberto Carlos.
SELECT pa.cod_partida,
       pa.data_hora_inicio,
       pa.data_hora_termino,
       pa.pontos_obtidos,
       ce.caracteristicas
FROM Partida pa
JOIN Jogador j ON pa.cod_jogador = j.cod_jogador
JOIN Cenario ce ON pa.cod_cenario = ce.cod_cenario
WHERE j.nome = "Roberto Carlos";

-- c) Jogadores que participaram de partidas fora do cenário “Terrestre”.
SELECT DISTINCT j.*
FROM Partida pa
JOIN Jogador j ON pa.cod_jogador = j.cod_jogador
JOIN Cenario ce ON pa.cod_cenario = ce.cod_cenario
WHERE ce.caracteristicas != "Terrestre";

-- d) Jogadores que jogaram no período diurno no mês de junho de 2024.
SELECT j.nome,
       j.sexo,
       year(j.dt_nasc) AS ano_nascimento
FROM Partida pa
JOIN Jogador j ON pa.cod_jogador = j.cod_jogador
WHERE time(pa.data_hora_inicio) < '18:00:00'
  AND month(pa.data_hora_inicio) = 6
  AND year(pa.data_hora_inicio) = 2024;
 

/*
 * 03. Funções agregadas e agrupamentos
 */
-- a) Quantidade de partidas realizadas por jogador.
SELECT j.nickname,
       count(pa.cod_partida) AS partidas_realizadas
FROM Jogador j
LEFT JOIN Partida pa ON j.cod_jogador = pa.cod_jogador
GROUP BY j.nickname;
   
 -- b) Quantidade de partidas realizadas por mês e dia (2023 e 2024).
SELECT month(pa.data_hora_inicio) AS mes,
       day(pa.data_hora_inicio) AS dia,
       count(pa.cod_partida) AS partidas
FROM Partida pa
WHERE year(pa.data_hora_inicio) IN (2023,
                                    2024)
GROUP BY mes,
         dia;
   
-- c) Jogadores com mais de 200 pontos em partidas.
SELECT j.nome,
       sum(pa.pontos_obtidos) AS total_pontos
FROM Jogador j
JOIN Partida pa ON j.cod_jogador = pa.cod_jogador
GROUP BY j.nome
HAVING total_pontos > 200;
   
-- d) Partidas por característica do cenário.
SELECT ce.caracteristicas,
       count(pa.cod_partida) AS partidas
FROM Partida pa
JOIN Cenario ce ON pa.cod_cenario = ce.cod_cenario
GROUP BY ce.caracteristicas;
   
-- e) Quantidade de poderes adquiridos por jogador (decrescente).
SELECT j.nome,
       count(a.cod_aquisicao) AS poderes_adquiridos
FROM Jogador j
JOIN Adquire_poder a ON j.cod_jogador = a.cod_jogador
GROUP BY j.nome
ORDER BY poderes_adquiridos DESC;
   
   
/*
 * 04. Funções de manipulação de data, IF e concatenação
 */
-- a) Dias decorridos desde a última partida.
SELECT j.nome,
       datediff(now(), max(pa.data_hora_termino)) AS dias_desde_ultima_partida
FROM Jogador j
LEFT JOIN Partida pa ON j.cod_jogador = pa.cod_jogador
GROUP BY j.nome;
   
-- b) Tempo gasto na partida em horas.
SELECT j.nome,
       pa.data_hora_inicio,
       timestampdiff(HOUR, pa.data_hora_inicio, pa.data_hora_termino) AS horas_gastas
FROM Jogador j
JOIN Partida pa ON j.cod_jogador = pa.cod_jogador;
   
-- c) Média de minutos gastos em partidas por jogador.
SELECT j.nickname,
       avg(timestampdiff(MINUTE, pa.data_hora_inicio, pa.data_hora_termino)) AS media_minutos
FROM Jogador j
JOIN Partida pa ON j.cod_jogador = pa.cod_jogador
GROUP BY j.nickname;
   
-- d) Idade e classificação de maioridade.
SELECT j.nome,
       year(curdate()) - year(j.dt_nasc) AS idade,
       if(year(curdate()) - year(j.dt_nasc) >= 18, "Maior de idade", "Menor de idade") AS classificacao
FROM Jogador j;
   
-- e) Nome e alerta de vício com tempo em minutos.
SELECT concat(j.nome, " - ", j.nickname) AS jogador,
       sum(timestampdiff(MINUTE, pa.data_hora_inicio, pa.data_hora_termino)) AS tempo_gasto_minutos,
       CASE
           WHEN sum(timestampdiff(MINUTE, pa.data_hora_inicio, pa.data_hora_termino)) > 90 THEN "Risco de vício"
           ELSE "Normal"
       END AS alerta
FROM Jogador j
LEFT JOIN Partida pa ON j.cod_jogador = pa.cod_jogador
GROUP BY j.cod_jogador,
         j.nome,
         j.nickname;
