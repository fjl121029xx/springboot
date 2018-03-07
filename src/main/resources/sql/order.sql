CREATE DATABASE db_product
  DEFAULT CHARSET utf8;

CREATE TABLE products (
  pid   INT NOT NULL  PRIMARY KEY AUTO_INCREMENT,
  pname VARCHAR(200),
  type VARCHAR(50),
  price DOUBLE,
  create_time DATE
)