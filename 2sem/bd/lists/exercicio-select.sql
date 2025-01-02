-- tabelas
select * from cargo
select * from departamento
select * from funcionario

-- exerciico 01
select cod_cargo, cod_depto, nome from funcionario where data_adm <= '2008-12-31'
select nome from cargo where salario between '2000' and '5000' 
select nome, salario from cargo where salario >= '3000'
select * from funcionario where nome like '%fernando silva%'

-- exerciico 02
select * from funcionario where nome like '%eira'
select * from funcionario where nome like '%Silv%'
select data_adm from funcionario where nome like 'P%' or nome like 'M%'
select data_adm from funcionario where nome not like 'J%' and nome not like 'G%'

-- exerciico 03
select * from departamento where sigla in ('INF', 'FIN')
select cod_func, nome from funcionario where sexo <> 'F' and cod_cargo not in (1,3)
select cod_cargo, salario, nome from cargo where cod_cargo in (4,5,3)