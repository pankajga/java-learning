package code;

/********************Basic Queries*****************************
 * 
 * select * from student;
 * mysql> select * from student;
+----+---------+--------+
| id | name    | city   |
+----+---------+--------+
| 12 | durgesh | delhi  |
| 23 | ankit   | kanpur |
+----+---------+--------+

 * alter table student add country varchar(50); // to add column
 * mysql> select * from student;
+----+---------+--------+---------+
| id | name    | city   | country |
+----+---------+--------+---------+
| 12 | durgesh | delhi  | NULL    |
| 23 | ankit   | kanpur | NULL    |
+----+---------+--------+---------+
 *
 * update student set country='india' where id=12;
 * mysql> select * from student;
+----+---------+--------+---------+
| id | name    | city   | country |
+----+---------+--------+---------+
| 12 | durgesh | delhi  | india   |
| 23 | ankit   | kanpur | NULL    |
+----+---------+--------+---------+

 * mysql> select name as 'USERNAME', city as 'HOMETOWN' from student where country='india';
+----------+----------+
| USERNAME | HOMETOWN |
+----------+----------+
| durgesh  | delhi    |
| ankit    | kanpur   |
+----------+----------+

 * mysql> select distinct(country) from student;
+-----------+
| country   |
+-----------+
| india     |
| australia |
+-----------+

 * mysql> select * from student where country='india' and city='delhi';
+----+---------+-------+---------+
| id | name    | city  | country |
+----+---------+-------+---------+
| 12 | durgesh | delhi | india   |
+----+---------+-------+---------+

 * mysql> select * from student where country='india' or city='delhi';
+----+---------+--------+---------+
| id | name    | city   | country |
+----+---------+--------+---------+
| 12 | durgesh | delhi  | india   |
| 23 | ankit   | kanpur | india   |
+----+---------+--------+---------+

mysql> select * from student limit 2;
+----+---------+--------+---------+
| id | name    | city   | country |
+----+---------+--------+---------+
| 12 | durgesh | delhi  | india   |
| 23 | ankit   | kanpur | india   |
+----+---------+--------+---------+

mysql> select * from student;
+----+---------+--------+-----------+
| id | name    | city   | country   |
+----+---------+--------+-----------+
| 12 | durgesh | delhi  | india     |
| 23 | ankit   | kanpur | india     |
| 24 | ankit   | sydney | australia |
+----+---------+--------+-----------+

mysql> select * from student limit 2 offset 1;  // offset 1 mean leave 1 row then pick next 2
+----+-------+--------+-----------+
| id | name  | city   | country   |
+----+-------+--------+-----------+
| 23 | ankit | kanpur | india     |
| 24 | ankit | sydney | australia |
+----+-------+--------+-----------+

mysql> select * from student order by name;
+----+---------+--------+-----------+
| id | name    | city   | country   |
+----+---------+--------+-----------+
| 23 | ankit   | kanpur | india     |
| 24 | ankit   | sydney | australia |
| 12 | durgesh | delhi  | india     |
+----+---------+--------+-----------+

mysql> select * from student where name like '_n%';
+----+-------+--------+-----------+
| id | name  | city   | country   |
+----+-------+--------+-----------+
| 23 | ankit | kanpur | india     |
| 24 | ankit | sydney | australia |
+----+-------+--------+-----------+

mysql> select * from student where name like '%i_';
+----+-------+--------+-----------+
| id | name  | city   | country   |
+----+-------+--------+-----------+
| 23 | ankit | kanpur | india     |
| 24 | ankit | sydney | australia |
+----+-------+--------+-----------+

mysql> select name from student where id =(select MAX(id) from student);
+-------+
| name  |
+-------+
| ankit |
+-------+

mysql> create table laptops(lid int primary key, lmodel varchar(200), studentId int, foreign key(studentId) references student(id));

mysql> select * from laptops;
+-------+--------+-----------+
| lid   | lmodel | studentId |
+-------+--------+-----------+
| 13414 | HP     |        23 |
| 13454 | Dell   |        24 |
+-------+--------+-----------+

mysql> select student.name, student.city, laptops.lmodel from student, laptops where student.id=laptops.studentId;
+-------+--------+--------+
| name  | city   | lmodel |
+-------+--------+--------+
| ankit | kanpur | HP     |
| ankit | sydney | Dell   |
+-------+--------+--------+

mysql> select student.name, student.city, laptops.lmodel from student, laptops where student.id=laptops.studentId and student.city='kanpur';
+-------+--------+--------+
| name  | city   | lmodel |
+-------+--------+--------+
| ankit | kanpur | HP     |
+-------+--------+--------+

mysql> select student.name, laptops.lmodel from student inner join laptops on student.id=laptops.studentId;
+-------+--------+
| name  | lmodel |
+-------+--------+
| ankit | HP     |
| ankit | Dell   |
+-------+--------+
 */
