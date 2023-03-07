package code;

/********************************Questions*******************************************
create table EmployeeInfo (EmpID int(20) primary key, EmpFname varchar(30), EmpLname varchar(30), Department varchar(30), Project varchar(30), 
Address varchar(30), DOB varchar(30), Gender varchar(30));

mysql> create table EmployeePosition (EmpID int(20), EmpPosition varchar(30), DateOfJoining varchar(30), salary int(20), foreign key(EmpID) 
references EmployeeInfo(EmpID));

mysql> insert into EmployeeInfo values(1, 'Sanjay', 'Mehra', 'HR', 'P1', 'Hyderabad(HYD)', '01/12/1976', 'M');
Query OK, 1 row affected (0.44 sec)

mysql> insert into EmployeeInfo values(2, 'Ananya', 'Mishra', 'Admin', 'P2', 'Delhi(DEL)', '02/05/1968', 'F');
Query OK, 1 row affected (0.27 sec)

mysql> insert into EmployeeInfo values(3, 'Rohan', 'Diwan', 'Account', 'P3', 'Mumbai(BOM)', '01/01/1980', 'M');
Query OK, 1 row affected (0.24 sec)

mysql> insert into EmployeeInfo values(4, 'Sonia', 'Kulkarni', 'HR', 'P1', 'Hyderabad(HYD)', '02/05/1992', 'F');
Query OK, 1 row affected (0.20 sec)

mysql> insert into EmployeeInfo values(5, 'Ankit', 'Kapoor', 'Admin', 'P2', 'Delhi(DEL)', '03/07/1994', 'M');
Query OK, 1 row affected (0.06 sec)

----------------------------------------------------------------------------------------------------------------

mysql> insert into EmployeePosition values(1, 'Manager', '01/05/2022', '500000');
Query OK, 1 row affected (0.03 sec)

mysql> insert into EmployeePosition values(2, 'Executive', '02/05/2022', '75000');
Query OK, 1 row affected (0.11 sec)

mysql> insert into EmployeePosition values(3, 'Manager', '01/05/2022', '90000');
Query OK, 1 row affected (0.07 sec)

mysql> insert into EmployeePosition values(2, 'Lead', '02/05/2022', '85000');
Query OK, 1 row affected (0.06 sec)

mysql> insert into EmployeePosition values(1, 'Executive', '01/05/2022', '300000');
Query OK, 1 row affected (0.09 sec)

----------------------------------------------------------------------------------------------------------------

mysql> select * from EmployeeInfo;
		+-------+----------+----------+------------+---------+----------------+------------+--------+
		| EmpID | EmpFname | EmpLname | Department | Project | Address        | DOB        | Gender |
		+-------+----------+----------+------------+---------+----------------+------------+--------+
		|     1 | Sanjay   | Mehra    | HR         | P1      | Hyderabad(HYD) | 01/12/1976 | M      |
		|     2 | Ananya   | Mishra   | Admin      | P2      | Delhi(DEL)     | 02/05/1968 | F      |
		|     3 | Rohan    | Diwan    | Account    | P3      | Mumbai(BOM)    | 01/01/1980 | M      |
		|     4 | Sonia    | Kulkarni | HR         | P1      | Hyderabad(HYD) | 02/05/1992 | F      |
		|     5 | Ankit    | Kapoor   | Admin      | P2      | Delhi(DEL)     | 03/07/1994 | M      |
		+-------+----------+----------+------------+---------+----------------+------------+--------+

mysql> select * from EmployeePosition;
		+-------+-------------+---------------+--------+
		| EmpID | EmpPosition | DateOfJoining | salary |
		+-------+-------------+---------------+--------+
		|     1 | Manager     | 01/05/2022    | 500000 |
		|     2 | Executive   | 02/05/2022    |  75000 |
		|     3 | Manager     | 01/05/2022    |  90000 |
		|     2 | Lead        | 02/05/2022    |  85000 |
		|     1 | Executive   | 01/05/2022    | 300000 |
		+-------+-------------+---------------+--------+

-------------------------------------------------------------------------------------------------------------------

Q1> Write a query to fetch the EmpFname from the EmployeeInfo table in the upper case and use the ALIAS name as EmpName.
==> mysql> select UPPER(EmpFname) as EmpName from EmployeeInfo;
		+---------+
		| EmpName |
		+---------+
		| SANJAY  |
		| ANANYA  |
		| ROHAN   |
		| SONIA   |
		| ANKIT   |
		+---------+


Q2> Write a query to fetch the number of employees working in the department ‘HR’.
==> mysql> select count(*) from EmployeeInfo where Department='HR';
		+----------+
		| count(*) |
		+----------+
		|        2 |
		+----------+


Q3> Write a query to get the current date.
==> mysql> select sysdate();
		+---------------------+
		| sysdate()           |
		+---------------------+
		| 2022-10-01 16:46:15 |
		+---------------------+


Q4> Write a query to retrieve the first four characters of  EmpLname from the EmployeeInfo table.
==> mysql> select substring(EmpLname,1,4) from EmployeeInfo;
		+-------------------------+
		| substring(EmpLname,1,4) |
		+-------------------------+
		| Mehr                    |
		| Mish                    |
		| Diwa                    |
		| Kulk                    |
		| Kapo                    |
		+-------------------------+
		
		
Q5> Write a query to fetch only the place name(string before brackets) from the Address column of EmployeeInfo table.
==> mysql> SELECT SUBSTRING(Address, 1, LOCATE('(',Address)-1) FROM EmployeeInfo;
		+----------------------------------------------+
		| SUBSTRING(Address, 1, LOCATE('(',Address)-1) |
		+----------------------------------------------+
		| Hyderabad                                    |
		| Delhi                                        |
		| Mumbai                                       |
		| Hyderabad                                    |
		| Delhi                                        |
		+----------------------------------------------+
		
		
Q6> Write a query to create a new table that consists of data and structure copied from the other table.
==> mysql> create table newtable as select * from EmployeeInfo;


Q7> Write q query to find all the employees whose salary is between 50000 to 100000.
==> mysql> select * from EmployeeInfo where EmpID in (select EmpID from EmployeePosition where salary between 50000 and 100000);
		+-------+----------+----------+------------+---------+-------------+------------+--------+
		| EmpID | EmpFname | EmpLname | Department | Project | Address     | DOB        | Gender |
		+-------+----------+----------+------------+---------+-------------+------------+--------+
		|     2 | Ananya   | Mishra   | Admin      | P2      | Delhi(DEL)  | 02/05/1968 | F      |
		|     3 | Rohan    | Diwan    | Account    | P3      | Mumbai(BOM) | 01/01/1980 | M      |
		+-------+----------+----------+------------+---------+-------------+------------+--------+
		

Q8> Write a query to find the names of employees that begin with ‘S’
==> mysql> select * from EmployeeInfo where EmpFname like 'S%';
		+-------+----------+----------+------------+---------+----------------+------------+--------+
		| EmpID | EmpFname | EmpLname | Department | Project | Address        | DOB        | Gender |
		+-------+----------+----------+------------+---------+----------------+------------+--------+
		|     1 | Sanjay   | Mehra    | HR         | P1      | Hyderabad(HYD) | 01/12/1976 | M      |
		|     4 | Sonia    | Kulkarni | HR         | P1      | Hyderabad(HYD) | 02/05/1992 | F      |
		+-------+----------+----------+------------+---------+----------------+------------+--------+
		
		
Q9> Write a query to fetch top N records.
==> mysql> select * from EmployeePosition order by salary desc limit 2;
		+-------+-------------+---------------+--------+
		| EmpID | EmpPosition | DateOfJoining | salary |
		+-------+-------------+---------------+--------+
		|     1 | Manager     | 01/05/2022    | 500000 |
		|     1 | Executive   | 01/05/2022    | 300000 |
		+-------+-------------+---------------+--------+
		
		
Q10> Write a query to retrieve the EmpFname and EmpLname in a single column as “FullName”. The first name and the last name must be separated with space.
==> mysql> select concat(EmpFname,' ',EmpLname) from EmployeeInfo;
		+-------------------------------+
		| concat(EmpFname,' ',EmpLname) |
		+-------------------------------+
		| Sanjay Mehra                  |
		| Ananya Mishra                 |
		| Rohan Diwan                   |
		| Sonia Kulkarni                |
		| Ankit Kapoor                  |
		+-------------------------------+
		
		
Q11> Write a query find number of employees whose DOB is between 02/05/1970 to 31/12/1975 and are grouped according to gender
==> mysql> select count(*) from EmployeeInfo where DOB between '02/05/1970' and '31/12/1975' group by gender;
		+----------+
		| count(*) |
		+----------+
		|        1 |
		|        1 |
		+----------+
		
		
Q12> Write a query to fetch all the records from the EmployeeInfo table ordered by EmpLname in descending order and Department in the ascending order.
==> SELECT * FROM EmployeeInfo ORDER BY EmpFname desc, Department asc;


Q13> Write a query to fetch details of employees whose EmpLname ends with an alphabet ‘A’ and contains five alphabets.
==> mysql> select * from employeeinfo where emplname like '____a';
		+-------+----------+----------+------------+---------+----------------+------------+--------+
		| EmpID | EmpFname | EmpLname | Department | Project | Address        | DOB        | Gender |
		+-------+----------+----------+------------+---------+----------------+------------+--------+
		|     1 | Sanjay   | Mehra    | HR         | P1      | Hyderabad(HYD) | 01/12/1976 | M      |
		+-------+----------+----------+------------+---------+----------------+------------+--------+
		
		
Q14> Write a query to fetch details of all employees excluding the employees with first names, “Sanjay” and “Sonia” from the EmployeeInfo table.
==> mysql> select * from employeeinfo where empfname not in ('Sanjay','Sonia');
		+-------+----------+----------+------------+---------+-------------+------------+--------+
		| EmpID | EmpFname | EmpLname | Department | Project | Address     | DOB        | Gender |
		+-------+----------+----------+------------+---------+-------------+------------+--------+
		|     2 | Ananya   | Mishra   | Admin      | P2      | Delhi(DEL)  | 02/05/1968 | F      |
		|     3 | Rohan    | Diwan    | Account    | P3      | Mumbai(BOM) | 01/01/1980 | M      |
		|     5 | Ankit    | Kapoor   | Admin      | P2      | Delhi(DEL)  | 03/07/1994 | M      |
		+-------+----------+----------+------------+---------+-------------+------------+--------+
		
		
Q16> Write a query to fetch details of employees with the address as “DELHI(DEL)”.
==> SELECT * FROM EmployeeInfo WHERE Address LIKE 'DELHI(DEL)%';


Q17> Write a query to fetch all employees who also hold the managerial position.?
==> mysql> select * from employeeinfo where empid in (select empid from employeeposition where empposition='manager');
		+-------+----------+----------+------------+---------+----------------+------------+--------+
		| EmpID | EmpFname | EmpLname | Department | Project | Address        | DOB        | Gender |
		+-------+----------+----------+------------+---------+----------------+------------+--------+
		|     1 | Sanjay   | Mehra    | HR         | P1      | Hyderabad(HYD) | 01/12/1976 | M      |
		|     3 | Rohan    | Diwan    | Account    | P3      | Mumbai(BOM)    | 01/01/1980 | M      |
		+-------+----------+----------+------------+---------+----------------+------------+--------+
	SELECT E.EmpFname, E.EmpLname, P.EmpPosition FROM EmployeeInfo E INNER JOIN EmployeePosition P ON E.EmpID = P.EmpID AND P.EmpPosition IN ('Manager');
	

Q18> Write a query to calculate the even and odd records from a table.
==> SELECT EmpID FROM (SELECT rowno, EmpID from EmployeeInfo) WHERE MOD(rowno,2)=0;
	SELECT EmpID FROM (SELECT rowno, EmpID from EmployeeInfo) WHERE MOD(rowno,2)=1;


19> Write a SQL query to retrieve employee details from EmployeeInfo table who have a date of joining in the EmployeePosition table.
==> mysql> select * from employeeinfo where empid in(select empid from employeeposition);
		+-------+----------+----------+------------+---------+----------------+------------+--------+
		| EmpID | EmpFname | EmpLname | Department | Project | Address        | DOB        | Gender |
		+-------+----------+----------+------------+---------+----------------+------------+--------+
		|     1 | Sanjay   | Mehra    | HR         | P1      | Hyderabad(HYD) | 01/12/1976 | M      |
		|     2 | Ananya   | Mishra   | Admin      | P2      | Delhi(DEL)     | 02/05/1968 | F      |
		|     3 | Rohan    | Diwan    | Account    | P3      | Mumbai(BOM)    | 01/01/1980 | M      |
		+-------+----------+----------+------------+---------+----------------+------------+--------+
	SELECT * FROM EmployeeInfo E WHERE EXISTS (SELECT * FROM EmployeePosition P WHERE E.EmpId = P.EmpId);
	
	
20> Write a query to retrieve two minimum and maximum salaries from the EmployeePosition table.
==> mysql> select distinct salary from employeeposition order by salary limit 2;
		+--------+
		| salary |
		+--------+
		|  75000 |
		|  85000 |
		+--------+

	mysql> select distinct salary from employeeposition order by salary desc limit 2;
		+--------+
		| salary |
		+--------+
		| 500000 |
		| 300000 |
		+--------+
		
		
21> Write a query to find the Nth highest salary from the table without using TOP/limit keyword.
==> mysql> select salary from employeeposition e1 where 3 = (select count(distinct(e2.salary)) from employeeposition e2 where e2.salary > e1.salary);
		+--------+
		| salary |
		+--------+
		|  85000 |
		+--------+
	SELECT Salary FROM EmployeePosition E1 WHERE N-1 = (SELECT COUNT( DISTINCT ( E2.Salary )) FROM EmployeePosition E2 WHERE E2.Salary >  E1.Salary );
	
	
22> Write a query to retrieve duplicate records from a table.
==> SELECT EmpID, EmpFname, Department COUNT(*) 
	FROM EmployeeInfo GROUP BY EmpID, EmpFname, Department 
	HAVING COUNT(*) > 1;
	
	
23> Q23. Write a query to retrieve the list of employees working in the same department.

Q26> Write a query to display the first and the last record from the EmployeeInfo table.
==> SELECT * FROM EmployeeInfo WHERE EmpID = (SELECT MIN(EmpID) FROM EmployeeInfo);


Q27> Write a query to retrieve Departments who have less than 2 employees working in it.
==> mysql> select department, count(empid) from employeeinfo group by department having count(empid)<2;
		+------------+--------------+
		| department | count(empid) |
		+------------+--------------+
		| Account    |            1 |
		+------------+--------------+
		
		
28> Write a query to find the third-highest salary from the EmpPosition table.
==> mysql> select salary from employeeposition order by salary desc limit 1 offset 2;
		+--------+
		| salary |
		+--------+
		|  90000 |
		+--------+


Q29. Write a query to retrieve EmpPostion along with total salaries paid for each of them.
1
SELECT EmpPosition, SUM(Salary) from EmployeePosition GROUP BY EmpPosition;
		

*/