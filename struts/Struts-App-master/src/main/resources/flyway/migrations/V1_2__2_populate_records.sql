CREATE USER admin password 'admin';
GRANT ALTER ANY SCHEMA TO admin;

insert into `departments` (dept_code, dept_name, dept_address) values('HR', 'Human Resource','14-A, 5th Floor, Infinity Tower, GGN');
insert into `departments` (dept_code, dept_name, dept_address) values('ACC', 'Accounts','14-B, 5th Floor, Infinity Tower, GGN');
insert into `departments` (dept_code, dept_name, dept_address) values('FO', 'Front Office','14-C, 5th Floor, Infinity Tower, GGN');
insert into `departments` (dept_code, dept_name, dept_address) values('SA', 'Sales','15-A, 6th Floor, Infinity Tower, GGN');
insert into `departments` (dept_code, dept_name, dept_address) values('DY', 'Delivery','15-B, 6th Floor, Infinity Tower, GGN');

insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('John Berenger','Sr. Manager HR', 'EM_0001', 2500000, 1,  parsedatetime('17-01-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Anita Kim', 'Sr. Associate Hiring', 'EM_0002', 1500000, 1, parsedatetime('02-02-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Murphy Richards','Associate Hiring', 'EM_0003', 700000, 1, parsedatetime('17-02-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Ashley John','Associate Hiring','EM_0004', 720000, 1, parsedatetime('17-02-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));

insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Anjali Mehta', 'Sr. Manager Accounts', 'EM_0006', 3500000, 2, parsedatetime('17-02-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Anjali Bhardwaj', 'Sr. Chartered Accountant', 'EM_0007', 3000000, 2, parsedatetime('17-10-2013 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Sheela Sharma', 'Chartered Accountant', 'EM_0008', 1500000, 2, parsedatetime('13-12-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Sheela Deshpande', 'Associate Accounts', 'EM_0009', 1000000, 2, parsedatetime('17-05-2014 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));

insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Jack Studd', 'Sr. Manager Front Office', 'EM_00010', 2500000, 3, parsedatetime('11-03-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Nicholas Cage', 'Receptionist', 'EM_00011', 1500000, 3, parsedatetime('15-03-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Tim Berg', 'Receptionist', 'EM_00012', 1500000, 3, parsedatetime('15-03-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));

insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Kim Sharma', 'Head Sales','EM_00014', 4000000, 4, parsedatetime('18-06-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Josey Wales', 'Lead Sales','EM_00015', 3000000, 4, parsedatetime('19-10-2014 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Jack Thorn', 'Associate Sales','EM_00016', 700000, 4, parsedatetime('27-08-2015 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Ryan Dikk', 'Associate Sales','EM_00017', 650000, 4, parsedatetime('31-05-2016 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));

insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Kim Sharma', 'Head Delivery','EM_00018', 4000000, 5, parsedatetime('27-07-2014 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Sarah Parker', 'Sr. Manager','EM_00019', 3500000, 5, parsedatetime('17-09-2014 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Sandra John', 'Project Lead','EM_00020', 3200000, 5, parsedatetime('17-09-2014 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Sandra Pollack', 'Project Lead','EM_00021', 2500000, 5, parsedatetime('18-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Nick Ahmet', 'Sr. Associate Tech','EM_00022', 220000, 5, parsedatetime('17-09-2015 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Ahmet Tuvogalu', 'Sr. Associate Tech','EM_00023', 220000, 5, parsedatetime('16-07-2016 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Kim Sharma', 'Sr. Associate Tech','EM_00024', 220000, 5, parsedatetime('17-07-2016 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Jitin Sharma', 'Associate Tech','EM_00025', 150000, 5, parsedatetime('18-07-2016 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Gaurav Chaudhary', 'Associate Tech','EM_00026', 150000, 5, parsedatetime('16-07-2016 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Gaurav Khanna', 'Associate Tech','EM_00027', 180000, 5, parsedatetime('13-07-2016 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Uma Yadav', 'Associate Tech','EM_00028', 160000, 5, parsedatetime('16-07-2016 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Umesh Dua', 'Associate Tech','EM_00029', 150000, 5, parsedatetime('26-07-2016 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Kajal Kumar', 'Associate Tech','EM_00030', 140000, 5, parsedatetime('16-08-2016 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Kajal Kumar', 'Sr. Associate QA','EM_00031', 210000, 5, parsedatetime('16-08-2016 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Manisha Lamba', 'Sr. Associate QA','EM_00032', 200000, 5, parsedatetime('16-07-2016 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Manish Kumar', 'Associate QA','EM_00033', 1400000, 5, parsedatetime('16-07-2016 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Mayank Pant', 'Associate QA','EM_00034', 1200000, 5, parsedatetime('16-07-2016 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into `employees` (empl_name, designation, empl_code, salary, dept_id, hiring_date) values('Deepak Joshi', 'Associate QA','EM_00035', 1200000, 5, parsedatetime('16-07-2016 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));

