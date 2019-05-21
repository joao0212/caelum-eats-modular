CREATE TABLE user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE(name)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE role (
  authority varchar(255) NOT NULL,
  PRIMARY KEY (authority)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE user_authorities (
  user_id bigint(20) NOT NULL,
  authorities_authority varchar(255) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (authorities_authority) REFERENCES role(authority)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
