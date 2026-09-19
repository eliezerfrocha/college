Create database vendaIF;
Use vendaIF;
/* Criação das tabelas */

Create table cliente (
    codCliente int auto_increment primary key,
    Nome varchar(50),
    Endereco varchar(50),
    Telefone varchar(11),
    CNPJ varchar(14)
);
create table categoria(
codCat int auto_increment primary key,
nomeCategoria varchar(50));

Create table produto(
codProduto int auto_increment primary key,
nome varchar(30) unique not null,
valorUnit numeric(7,2),
quantidade smallint,
codCat int,
foreign key(codCat) references categoria(codCat));




Create table Pedido (
    codPedido int auto_increment primary key,
    codCliente int,
    dataCompra date,
    valorTotal numeric(7 , 2 ),
Status varchar(20),
    Foreign key (codcliente)
        references cliente (codCliente)
);
Create table ItemPedido(
codItem int auto_increment primary key,
codProduto int,
codPedido int,
quantidade smallint,
valorItem numeric(7,2),
Foreign key(codPedido) references Pedido(codPedido), 
Foreign key(codProduto) references produto(codProduto));



insert into cliente values (1, 'Bike e Peças', 'Av professora minervina', '34991227473', '01234567880012');
insert into cliente values (2, 'Supermercado Marques', 'Av jose fonseca e silva', '34991999473', '77573318000196');
insert into cliente values (3, 'Supermercado Compre Certo', 'Av professor juscelino', '34991111473', '04312596000116');
insert into cliente values (4, 'Happy Shop', 'Av aurora', '34991227473', '87499588000158');
insert into cliente values (5, '@Tech Eletrônicos', 'Av brasilia', '34991237473', '00592926000113');
insert into cliente values (6, 'Mãos a Obra Materiais para construção', 'Rua marques', '34999997473', '00511927000222');
insert into cliente values (7, 'Farmácia Saúde e Bem Estar', 'Rua jose pedreiro', '34912337473', '00112936000333');


insert into categoria values (1, 'Brinquedos');
insert into categoria values (2, 'Esporte');
insert into categoria values (3, 'Eletrônicos');
insert into categoria values (4, 'Saude');
insert into categoria values (5, 'Casa e construção');
insert into categoria values (6, 'Outros');

-- Brinquedos
insert into produto values (1, 'Boneco homem de ferro', 289.99, 15, 1);
insert into produto values (2, 'Barbie', 320.20, 20, 1);

-- Esporte
insert into produto values (3, 'Luva de box', 269, 35, 2);
insert into produto values (4, 'Peteca', 39.50, 10, 2);
insert into produto values (5, 'Bola golf', 29, 30, 2);


-- Tecnologia
insert into produto values (6, 'Teclado rayzer', 890, 20, 3);
insert into produto values (7, 'Mouse generico', 100, 30, 3);

-- Saude
insert into produto values (8, 'Dipirona', 30, 10, 4);
insert into produto values (9, 'Eno', 69.25, 20, 4);

-- Casa e construção
insert into produto values (10, 'Tinta branca', 123, 30, 5);
insert into produto values (11, 'Tapete de sala', 400, 40, 5);
insert into produto values (12, 'Cano Tigre', 20, 140, 5);
insert into produto values (13, 'Sofa 4 lugares', 1620, 20, 5);
insert into produto values (14, 'Cama de Casal', 2420, 20, 5);




