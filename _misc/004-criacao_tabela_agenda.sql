CREATE TABLE agenda (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  telefone VARCHAR(10) NOT NULL,
  dataRegistro timestamp,
  PRIMARY KEY (id)
);