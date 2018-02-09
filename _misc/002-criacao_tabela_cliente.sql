CREATE TABLE cliente (
  codigo BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  idade INTEGER,
  sexo VARCHAR(1) NOT NULL,
  profissao VARCHAR(30),
  PRIMARY KEY (codigo)
);


