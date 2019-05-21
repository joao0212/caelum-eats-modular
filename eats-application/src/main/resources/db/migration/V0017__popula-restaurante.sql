-- Chinês Long Fu
INSERT INTO restaurante (id, aprovado, cnpj, nome, descricao, cep, endereco, taxa_de_entrega_em_reais, tempo_de_entrega_maximo_em_minutos, tempo_de_entrega_minimo_em_minutos, tipo_de_cozinha_id)
values (1, true, '98444252000104', 'Long Fu', 'O melhor da China aqui do seu lado.', '70238500', 'ShC/SUL COMERCIO LOCAL QD 404-BL D LJ 17-ASA SUL' , 6, 25, 40, 1);

INSERT INTO restaurante_forma_de_pagamento (restaurante_id, forma_de_pagamento_id) values (1, 1);
INSERT INTO restaurante_forma_de_pagamento (restaurante_id, forma_de_pagamento_id) values (1, 2);
INSERT INTO restaurante_forma_de_pagamento (restaurante_id, forma_de_pagamento_id) values (1, 3);
INSERT INTO restaurante_forma_de_pagamento (restaurante_id, forma_de_pagamento_id) values (1, 4);
INSERT INTO restaurante_forma_de_pagamento (restaurante_id, forma_de_pagamento_id) values (1, 5);

INSERT INTO horario_de_funcionamento (dia_da_semana, horario_de_abertura, horario_de_fechamento, restaurante_id) values ('SUNDAY', '11:00:00', '23:00:00', 1);
INSERT INTO horario_de_funcionamento (dia_da_semana, horario_de_abertura, horario_de_fechamento, restaurante_id) values ('MONDAY', '11:00:00', '23:00:00', 1);
INSERT INTO horario_de_funcionamento (dia_da_semana, horario_de_abertura, horario_de_fechamento, restaurante_id) values ('TUESDAY', '11:00:00', '23:00:00', 1);
INSERT INTO horario_de_funcionamento (dia_da_semana, horario_de_abertura, horario_de_fechamento, restaurante_id) values ('WEDNESDAY', '11:00:00', '23:00:00', 1);
INSERT INTO horario_de_funcionamento (dia_da_semana, horario_de_abertura, horario_de_fechamento, restaurante_id) values ('THURSDAY', '11:00:00', '23:00:00', 1);
INSERT INTO horario_de_funcionamento (dia_da_semana, horario_de_abertura, horario_de_fechamento, restaurante_id) values ('FRIDAY', '11:00:00', '23:00:00', 1);
INSERT INTO horario_de_funcionamento (dia_da_semana, horario_de_abertura, horario_de_fechamento, restaurante_id) values ('SATURDAY', '11:00:00', '23:00:00', 1);

INSERT INTO cardapio (id, restaurante_id) values (1, 1);

INSERT INTO categoria_do_cardapio (id, nome, cardapio_id) values (1, 'ENTRADAS', 1);
INSERT INTO categoria_do_cardapio (id, nome, cardapio_id) values (2, 'PRATOS PRINCIPAIS', 1);
INSERT INTO categoria_do_cardapio (id, nome, cardapio_id) values (3, 'BEBIDAS', 1);

-- ENTRADAS
INSERT INTO item_do_cardapio (
  nome,
  descricao,
  preco,
  preco_promocional,
  categoria_id
) values ('Gyoza Bovino - 6 unidades', 'Massa fina cozida a vapor recheada com carne temperada com gengibre', 23.5, null, 1);

INSERT INTO item_do_cardapio (
  nome,
  descricao,
  preco,
  preco_promocional,
  categoria_id
) values ('Pão Chinês - 3 unidades', 'Pão macio e fofinho recheado de frango e legumes', 11.9, 9.9, 1);

INSERT INTO item_do_cardapio (
  nome,
  descricao,
  preco,
  preco_promocional,
  categoria_id
) values ('Rolinho Primavera - 2 unidades', 'Massa fina recheada com carne, repolho e cenoura. Acompanha molho agridoce', 9.9, null, 1);

-- PRATOS PRINCIPAIS
INSERT INTO item_do_cardapio (
  nome,
  descricao,
  preco,
  preco_promocional,
  categoria_id
) values ('Yakissoba Clássico', 'Yakissoba de carne e frango acompanhado por legumes frescos e champignons', 40.9, 39.9, 2);

INSERT INTO item_do_cardapio (
  nome,
  descricao,
  preco,
  preco_promocional,
  categoria_id
) values ('Macarrão Xian', 'Macarrão com molho à base de shoyu, cubos de frango e legumes', 17.9, null, 2);

INSERT INTO item_do_cardapio (
  nome,
  descricao,
  preco,
  preco_promocional,
  categoria_id
) values ('Yakimeshi', 'Arroz soltinho refogado com flocos de ovos, pedacinhos de cenoura, apresuntado e cebolinha', 21.9, null, 2);

-- BEBIDAS
INSERT INTO item_do_cardapio (
  nome,
  descricao,
  preco,
  preco_promocional,
  categoria_id
) values ('Coca-Cola Lata 310 ML', null, 5.9, null, 3);

INSERT INTO item_do_cardapio (
  nome,
  descricao,
  preco,
  preco_promocional,
  categoria_id
) values ('Coca-Cola Zero Lata 310 ML', null, 5.9, null, 3);

INSERT INTO item_do_cardapio (
  nome,
  descricao,
  preco,
  preco_promocional,
  categoria_id
) values ('Cerveja Heineken Lata 350 ML', null, 6.9, null, 3);

