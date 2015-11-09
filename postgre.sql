create table clientetest(
id serial,
nome varchar(80),
cpf varchar(11),
dataNascimento varchar(14),
sexo varchar(20),
email varchar(50),
telefone varchar(15),
primary key (cpf)
)