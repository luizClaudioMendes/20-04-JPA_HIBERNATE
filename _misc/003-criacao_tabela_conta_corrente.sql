CREATE TABLE conta_corrente (
  codigo BIGINT NOT NULL AUTO_INCREMENT,
  numero VARCHAR(12) NOT NULL,
  saldo DECIMAL,
  codigo_cliente BIGINT NOT NULL,
  PRIMARY KEY (codigo),
  FOREIGN KEY (codigo_cliente) REFERENCES cliente (codigo)
);