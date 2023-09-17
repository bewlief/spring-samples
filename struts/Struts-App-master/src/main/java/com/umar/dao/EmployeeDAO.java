package com.umar.dao;

import com.umar.jdbc.JdbcConnectionManager;
import com.umar.jdbc.ResultSetMapper;
import com.umar.model.Department;
import com.umar.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class EmployeeDAO extends JdbcPersistenceServiceImpl<Employee> {

    public static final String ID = "id";
    public static final String NAME = "empl_name";
    public static final String SALARY = "salary";
    public static final String EMPL_CODE = "empl_code";
    public static final String TBL_EMPLOYEE = "employees";
    public static final String SELECT = "SELECT * FROM ";

    public EmployeeDAO() {
        super(JdbcConnectionManager.getJdbcUtil());
    }

    public static final ResultSetMapper<Employee> EMPLOYEE_DEPT_MAPPER = new ResultSetMapper<Employee>() {
        @Override
        public Employee map(ResultSet resultSet) throws SQLException {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt(ID));
            employee.setName(resultSet.getString(NAME));
            employee.setSalary(resultSet.getDouble(SALARY));
            Date date = resultSet.getDate("hiring_date");
            employee.setDesignation(resultSet.getString("designation"));
            employee.setHiringDate(date);
            employee.setEmployeeCode(resultSet.getString(EMPL_CODE));
            Department department = new Department();
            department.setDeptCode(resultSet.getString("dept_code"));
            department.setDeptName(resultSet.getString("dept_name"));
            department.setAddress(resultSet.getString("dept_address"));
            employee.setDepartment(department);
            return employee;
        }
    };

    @Override
    public Employee find(Long id) {
        String sql = SELECT + TBL_EMPLOYEE + " WHERE " + ID + " = ?";
        List<Employee> employees = select(sql, EMPLOYEE_DEPT_MAPPER, id);
        if(employees.isEmpty()) {
            throw new RuntimeException(String.format("No employee found with the given id : %d ",id));
        }
        return employees.get(0);
    }

    @Override
    public Employee find(Employee employee) {
        String sql = SELECT + TBL_EMPLOYEE + " WHERE " + NAME + "=? AND " + EMPL_CODE + "=?";
        List<Employee> employees = select(sql,EMPLOYEE_DEPT_MAPPER, employee.getName(), employee.getEmployeeCode());
        if(employees.isEmpty()) {
            throw new RuntimeException(String.format("No employee found with the given name : %s and code %s",employee.getName(), employee.getEmployeeCode()));
        }
        return employees.get(0);
    }

    public List<Employee> find(String name) {
        String sql = SELECT + TBL_EMPLOYEE + " WHERE " + NAME + "LIKE % ?";
        List<Employee> employees = select(sql,EMPLOYEE_DEPT_MAPPER, name);
        return employees;
    }

    @Override
    public List<Employee> getAll() {
        String sql = "SELECT e.*, d.dept_code, d.dept_name, d.dept_address from employees e INNER JOIN departments d on e.dept_id = d.id";
        return select(sql, EMPLOYEE_DEPT_MAPPER);
    }


    public int save(Employee employee) {
        String sql = "INSERT INTO " + TBL_EMPLOYEE + "(name, empl_code, salary, dept_id) VALUES(?,?,?,?)";
        String name = employee.getName();
        String emplCode = employee.getEmployeeCode();
        double salary = employee.getSalary();
        int dept_id = employee.getDepartment().getId();
        return super.save(sql, name, emplCode, salary, dept_id);
    }
}
