create database assignment;

CREATE TABLE assignment.bitcoin (
  id INT NOT NULL,
  disclaimer Varchar(50),
  chartname varchar(20),
  PRIMARY KEY (id));
  
CREATE TABLE assignment.`time` (
time_id INT NOT NULL AUTO_INCREMENT,
updated varchar(50),
updateduk varchar(50),
updatedISO varchar(50),
  PRIMARY KEY (time_id));
  
CREATE TABLE assignment.`bitcoin-price-index` (
bpi_id INT NOT NULL AUTO_INCREMENT,
`code` varchar(50),
symbol varchar(50),
rate varchar(50),
description varchar(50),
rate_float float, 
  PRIMARY KEY (bpi_id));
  
select * from assignment.bitcoin;
select * from assignment.`bitcoin-price-index`;
select * from assignment.time;