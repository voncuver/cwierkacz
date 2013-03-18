CREATE DATABASE cwierkacz;
USE cwierkacz;

CREATE TABLE Customer (
	ownerid : number(11) NOT NULL PRIMARY KEY,
	name : varchar2(50) NOT NULL,
	email : varchar2(100) NOT NULL
);

CREATE TABLE TwitterUsers (
    ownerid : number(11) NOT NULL,
    userid : number(11) NOT NULL PRIMARY KEY,
    twitteruser : varchar2(50) NOT NULL,
    oauthkey : varchar2(255) NOT NULL
);

CREATE SEQUENCE seq_userid ....