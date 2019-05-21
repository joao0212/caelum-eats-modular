CREATE TABLE item_do_cardapio (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  descricao varchar(255) DEFAULT NULL,
  nome varchar(150) DEFAULT NULL,
  preco decimal(19,2) NOT NULL,
  preco_promocional decimal(19,2) DEFAULT NULL,
  categoria_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (categoria_id) REFERENCES categoria_do_cardapio(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
