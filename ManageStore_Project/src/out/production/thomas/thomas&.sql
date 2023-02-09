
create table user(
UserId int not null AUTO_INCREMENT PRIMARY KEY, 
UserMail varchar(100) not null,
UserName varchar(100) not null,
UserSurname varchar(100) not null,
UserPassword varchar(20) not null,
UserPseudo varchar(100), 
RoleID int not null 
)



select * from user
create user "test" identified by "test" 


SET PASSWORD FOR 'root'@'localhost' = PASSWORD('root');



