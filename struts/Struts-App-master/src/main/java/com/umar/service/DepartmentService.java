package com.umar.service;

import com.umar.model.Department;
import com.umar.model.Employee;

import java.util.List;

public interface DepartmentService {

    List<Employee> getAllEmployees();
    void addToDepartment(Employee employee, Department department);
    Department getByName(String name);
    Department getById(int id);
}
