CREATE DATABASE cwierkacz;
USE cwierkacz;

CREATE TABLE users (
	userid : number(11) NOT NULL PRIMARY KEY,
	name : varchar2(50) NOT NULL,
	email : varchar(100) NOT NULL,
);

CREATE SEQUENCE seq_userid ....