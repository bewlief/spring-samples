alter table `employees` add constraint fk_dept_id foreign key (dept_id) references `departments`(`id`);

alter table `employees` add unique key uniq_emp_code (empl_code);