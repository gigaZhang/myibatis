create database db_ajax_school
go
use db_ajax_school
go
create table student
(
	id int not null primary key identity(1,1),	
	username varchar(20),
	password varchar(20),
)

select * from student