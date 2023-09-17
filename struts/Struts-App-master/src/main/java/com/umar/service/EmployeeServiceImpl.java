package com.umar.service;

import com.umar.dao.EmployeeDAO;
import com.umar.model.Department;
import com.umar.model.Employee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public EmployeeServiceImpl() {

    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.getAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.find(Long.valueOf(id));
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeDAO.find(name);
    }

    @Override
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    public List<Employee> workingIn(Department department) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
