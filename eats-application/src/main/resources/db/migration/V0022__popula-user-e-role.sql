insert into role(authority) values ('ROLE_ADMIN');
insert into role(authority) values ('ROLE_PARCEIRO');

-- senha: 123456
insert into user (id, name, password) values (1, 'admin', '{bcrypt}$2a$10$3Qrx0rv8qSmZ8s3RlD5qE.upleP7.Qzbg5EoIAm62evEkY4c023TK');
insert into user (id, name, password) values (2, 'longfu', '{bcrypt}$2a$10$3Qrx0rv8qSmZ8s3RlD5qE.upleP7.Qzbg5EoIAm62evEkY4c023TK');

insert into user_authorities (user_id, authorities_authority) values (1, 'ROLE_ADMIN');
insert into user_authorities (user_id, authorities_authority) values (2, 'ROLE_PARCEIRO');

update restaurante r set r.user_id = 2 where r.id = 1;
