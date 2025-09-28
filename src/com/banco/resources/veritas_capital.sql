drop database veritas_capital;
create database veritas_capital;

use veritas_capital;

create table titular(
id int primary key auto_increment,
nome varchar(45) not null,
cpf varchar(15) unique not null
);

create table conta(
id int primary key auto_increment,
titular int not null,
foreign key (titular) references titular(id),
numero varchar(60) unique not null,
saldo double(8,2) not null,
tipo enum("CONTA_CORRENTE", "CONTA_POUPANÇA") not null
);

describe conta;

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
conta_remetente int not null,
foreign key (conta_remetente) references conta(id),
conta_destinatario int not null,
foreign key (conta_remetente) references conta(id),
tipo enum("DEPOSITO", "SAQUE", "TRANSFERENCIA")	not null,
valor double(8,2),
data_horario datetime not null default current_timestamp
);

select * from titular;
select * from movimentacao;

SELECT conta.id as id_conta, titular.id as id_titular, titular.nome as nome_titular, numero, saldo, tipo
from conta
LEFT JOIN titular on conta.titular = titular.id;

DELIMITER $$

DELIMITER $$

CREATE TRIGGER atualiza_saldo
AFTER INSERT ON movimentacao
FOR EACH ROW
BEGIN

    IF NEW.tipo = "SAQUE" THEN
		UPDATE conta
		SET saldo = saldo - NEW.valor
		WHERE id = NEW.conta_destinatario;
	ELSEIF NEW.tipo = "DEPOSITO" THEN
		UPDATE conta
		SET saldo = saldo + NEW.valor
		WHERE id = NEW.conta_destinatario;
	ELSEIF NEW.tipo = "TRANSFERENCIA" THEN
		UPDATE conta
        SET saldo = saldo + NEW.valor
        WHERE id = movimentacao.conta_destinatario;
        UPDATE conta
        SET saldo = saldo - NEW.valor
        WHERE id = movimentacao.conta_remetente;
	END IF;
END$$

DELIMITER ;

drop trigger atualiza_saldo;

show triggers;