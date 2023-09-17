CREATE TABLE IF NOT EXISTS `departments` (
`id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
`dept_code` char(5),
`dept_name` varchar(20),
`dept_address` varchar(50)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8; 


CREATE TABLE IF NOT EXISTS `employees` (
`id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
`empl_name` varchar(30),
`empl_code` varchar(50),
`designation` varchar(30),
`salary` REAL,
`dept_id` BIGINT,
`hiring_date` DATE
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

/*
drop ALIAS if exists TO_DATE;
CREATE ALIAS TO_DATE as '
import java.text.*;
@CODE
java.util.Date toDate(String s, String dateFormat) throws Exception {
  return new SimpleDateFormat(dateFormat).parse(s);
}
';
*/
