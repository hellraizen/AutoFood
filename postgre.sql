create table clientetest(
id serial,
nome varchar(80),
cpf varchar(11),
dataNascimento varchar(14),
sexo varchar(20),
email varchar(50),
telefone varchar(15),
primary key (cpf)
);

create table produtoteste(

idProduto serial,
nome_produto varchar(40),
quantidade int,
preco numeric(8,2),
validade varchar(10),
data_fabricacao varchar(10),
primary key (idproduto)
);

create table estoqueteste(

idEstoqueProduto serial,
produtoEstoque varchar (40),
quantidade int,
dataEntrada varchar (10),
dataValidade varchar(10),
precoCusto numeric(8,2),
primary key(idEstoqueProduto)
);

create table comandateste(
vendaID serial,
Comandaid int,
NomeCliente varchar(50),
descricao varchar(40),
quantidadeVendida int,
valor numeric(8,2),
totalValor numeric(8,2),
primary key (vendaid)
);




