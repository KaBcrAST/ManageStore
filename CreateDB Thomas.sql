CREATE DATABASE IF NOT EXISTS thomas;
USE thomas;

SET PASSWORD FOR 'root'@'localhost' = PASSWORD('root');

DROP TABLE IF EXISTS user;

CREATE TABLE user(
UserId int not null AUTO_INCREMENT PRIMARY KEY, 
UserMail varchar(30) not null,
UserName varchar(30) not null,
UserSurname varchar(30) not null,
UserPassword varchar(60) not null,
UserPseudo varchar(30) not null, 
RoleID int not null,
StoreID int not null
);


 
insert into user(UserMail, UserName, UserSurname, UserPassword ,UserPseudo, RoleID, StoreId)
values ('admin@store.fr','admin','administrateur','jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=' ,'ADMIN', 1,1);


DROP TABLE IF EXISTS store;

CREATE TABLE IF NOT EXISTS   store(
StoreId int not null AUTO_INCREMENT PRIMARY KEY, 
StoreName varchar(30) not null,
StoreLocation varchar(30) not null
);


insert into store (storeName, storelocation) values ('Magasin central', 'Lille');

 
DROP TABLE IF EXISTS product ;

create table product(
ProductId int not null AUTO_INCREMENT PRIMARY KEY, 
ProductName varchar(30) not null,
Productdescription varchar(30),
ProductPrice int not null,
UnitID int
);


DROP TABLE IF EXISTS listofemail ;

create table listofemail(
EmailId int not null AUTO_INCREMENT PRIMARY KEY, 
UserMail varchar(30) not null,
Name varchar(30) not null,
Surname varchar(30) not null,
WhiteList boolean not null
);


insert into listofemail (usermail, Name, Surname, Whitelist) values ('admin@store.fr','admin','Administrateur',True);

 
DROP TABLE IF EXISTS productinstore;
 
create table productinstore(
pisID int not null AUTO_INCREMENT PRIMARY KEY,
StoreId int not null,
ProductId int not null,
Quantity int null);

select * from product

drop table if exists uniteofmeasure;

create table uniteofmeasure(
UnitID int not null AUTO_INCREMENT PRIMARY KEY,
Unitdescription varchar(50));

insert into uniteofmeasure (Unitdescription) values ('Pound');
insert into uniteofmeasure (Unitdescription) values ('Ton');
insert into uniteofmeasure (Unitdescription) values ('Unit');
insert into uniteofmeasure (Unitdescription) values ('SquareMeter');
insert into uniteofmeasure (Unitdescription) values ('Meter');
