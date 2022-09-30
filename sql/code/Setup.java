package code;

/****************************Installation***************************************
 * 
 * Install mySQL workbench from: https://dev.mysql.com/downloads/mysql/
 * 
 * Open MYSQL Command Line Client
 * 
 * Below are few sample queries:-
 * 
 * show databases;  // semicolon is mandatory after query
 * create database [db_name];
 * use [db_name]; // to go inside that db
 * drop database [db_name] // to delete database
 * 
 * create table [table_name](col1 datatype, col2 datatype, col3 datatype.......);
 * create table user(id int(11) primary key, name varchar(100) not null, city varchar(50));  // The size mentioned are the maximum size
 * 
 * desc user;
+-------+--------------+------+-----+---------+-------+
| Field | Type         | Null | Key | Default | Extra |
+-------+--------------+------+-----+---------+-------+
| id    | int          | NO   | PRI | NULL    |       |
| name  | varchar(100) | NO   |     | NULL    |       |
| city  | varchar(50)  | YES  |     | NULL    |       |
+-------+--------------+------+-----+---------+-------+

 * show tables; // to show table just name
 * alter table user rename to student; // to rename table 
 * truncate table [table_name] // only data goes table remains while in case of drop both table and data goes;
 * 
 * insert into [table_name](id, name, city) values(12, 'durgesh', 'delhi');
 * insert into [table_name] values(23, 'ankit', 'kanpur');
 *
 */


