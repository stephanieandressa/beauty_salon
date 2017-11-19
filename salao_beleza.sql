CREATE DATABASE IF NOT EXISTS salao_beleza;

USE salao_beleza;

CREATE TABLE IF NOT EXISTS cliente (
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	email VARCHAR(100) NOT NULL,
	nome VARCHAR(100) NOT NULL,
	data_nascimento DATE,
	telefone VARCHAR(18)	
);

CREATE TABLE IF NOT EXISTS colaborador (
        id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        email VARCHAR(100) NOT NULL,
        nome VARCHAR(100) NOT NULL,
        data_nascimento DATE,
        telefone VARCHAR(18),
	funcao VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS horario_funcionamento (
        id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        hora TIME NOT NULL
);

CREATE TABLE IF NOT EXISTS agenda (
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	id_colaborador BIGINT NOT NULL REFERENCES colaborador(id),
	id_cliente BIGINT NOT NULL REFERENCES cliente(id),
	id_horario_funcionamento BIGINT NOT NULL REFERENCES horario_funcionamento(id),
	data_agendamento DATE NOT NULL
);
