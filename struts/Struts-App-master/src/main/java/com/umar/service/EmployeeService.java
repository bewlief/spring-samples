package com.umar.service;

import com.umar.model.Department;
import com.umar.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee>findAll();
    Employee findById(int id);
    List<Employee> findByName(String name);
    void save(Employee employee);
    List<Employee> workingIn(Department department);
}
