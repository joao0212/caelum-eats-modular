CREATE TABLE entrega (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  nome_do_cliente varchar(100) NOT NULL,
  cpf_do_cliente varchar(14) NOT NULL,
  email_do_cliente varchar(100) NOT NULL,
  telefone_do_cliente varchar(16) NOT NULL,
  cep varchar(9) NOT NULL,
  endereco varchar(255) NOT NULL,
  complemento varchar(255) DEFAULT NULL,
  pedido_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (pedido_id) REFERENCES pedido(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
