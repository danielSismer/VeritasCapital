create database veritas_capital;

use veritas_capital;

create table titular(
id int primary key auto_increment,
nome varchar(45) not null,
cpf varchar(15) not null
);

create table conta(
id int primary key auto_increment,
titular int not null,
foreign key (titular) references titular(id),
numero varchar(60) unique not null,
saldo double(8,2) not null,
tipo enum("CONTA_CORRENTE", "CONTA_POUPANÇA") not null
);

create table conta_poupanca(
id int auto_increment not null,
foreign key (id) references conta(id),
taxaRendimento double (2,2) not null
);

create table conta_corrente(
id int auto_increment not null,
foreign key (id) references conta(id),
movimentacaoDiaria double (8,2) not null
);

create table movimentacao(
id int primary key auto_increment,
titular_remetente int not null,
foreign key (titular_remetente) references titular(id),
titular_destinatario int not null,
foreign key (titular_destinatario) references titular(id),
tipo enum("DEPOSITO", "SAQUE", "TRANSFERENCIA")	not null,
valor double(8,2),
data_horario datetime not null default current_timestamp
);