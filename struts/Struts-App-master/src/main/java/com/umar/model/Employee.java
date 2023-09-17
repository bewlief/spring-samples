package com.umar.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Employee implements Serializable {

    private int id;
    private String name;
    private String employeeCode;
    private double salary;
    private Department department;
    private Calendar hiringDate;
    private String designation;

    public Employee(){

    }

    public Employee(int id, String name, String employeeCode, double salary, Department department, Date hiringDate, String designation) {
        this.id = id;
        this.name = name;
        this.employeeCode = employeeCode;
        this.salary = salary;
        this.department = department;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(hiringDate);
        this.hiringDate = calendar;
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public Calendar getHiringDate() {
        return hiringDate;
    }

    public String getFormattedHiringDate() {
        return String.format("%s-%s-%s", hiringDate.get(Calendar.YEAR), hiringDate.get(Calendar.MONTH), hiringDate.get(Calendar.DATE));
    }

    public void setHiringDate(Calendar hiringDate) {
        this.hiringDate = hiringDate;
    }

    public void setHiringDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        this.hiringDate = calendar;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (employeeCode != null ? !employeeCode.equals(employee.employeeCode) : employee.employeeCode != null)
            return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (employeeCode != null ? employeeCode.hashCode() : 0);
        return result;
    }
}
