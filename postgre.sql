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
codigoProduto varchar(10),
nome_produto varchar(40),
quantidade int,
preco numeric(8,2),
validade varchar(10),
data_fabricacao varchar(10),
primary key (idproduto)
);

create table estoqueteste(

idEstoqueProduto serial,
codigoProduto varchar(10),
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

create table fornecedorteste(
idFornecedor serial,
nomeFornecedor varchar(50),
cnpjFornecedor varchar(18),
produtoFornecido varchar(40),
telefoneFornecedor varchar(14),
emailFornecedor varchar(80),
primary key(idFornecedor)
);


create table caixateste(
cod serial,
entrada numeric(8,2),
saida   numeric(8,2),
Idcomanda int,
idfuncionario int,

primary key (cod)
);
create table testEndereco(

idEndereco serial,
rua varchar(60),
bairro varchar(50),
numero varchar(6),
cep varchar(12),
complemento varchar(100),

primary key (idendereco)
);

create table funcionariotest(
idFuncionario serial,
nomeFuncionario varchar(50),
cpfFuncionario varchar(14),
enderecoFuncionario varchar(50),
dataNascimentoFuncionario varchar(11),
sexoFuncionario varchar(10),
telefoneFuncionario varchar(15),
emailFuncionario varchar(50),
tipoFuncionario varchar(20),
login varchar(10),
senha varchar(10),
primary key(idFuncionario)
);

create table log(
cod serial,
data date,
autor varchar(20),
alteracao varchar(30),

primary key (cod)
);     

create function gera_log() returns trigger as

$$

Begin

         insert into log (data, autor, alteracao) values (now(), user, TG_OP);

         return new;

end;

$$
language 'plpgsql';

Create trigger gerarLog
AFTER insert
ON clientetest
FOR EACH ROW
execute PROCEDURE gera_log();



