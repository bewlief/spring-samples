package com.umar.actionforms;

import com.umar.model.Employee;
import org.apache.struts.action.ActionForm;

import java.util.ArrayList;
import java.util.List;

public class DepartmentForm extends ActionForm {

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setEmployee(int index, Employee employee) {
        employees.set(index, employee);
    }

    public Employee getEmployee(int index) {
        if(null == employees) {
            employees = new ArrayList<>();
        }
        while (index >= employees.size()) {
            employees.add(new Employee());
            index++;
        }
        return employees.get(index);
    }

    private List<Employee> employees;
}
