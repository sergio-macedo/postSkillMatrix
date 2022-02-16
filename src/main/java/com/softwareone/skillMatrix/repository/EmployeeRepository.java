package com.softwareone.skillMatrix.repository;

import com.softwareone.skillMatrix.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> getAllEmployees(String name, String skillName, String languageName);

    Employee addEmployee(Employee employee);

    Employee getEmployeeById(String id);

    void updateEmployee(String id, Employee employee);

    void deleteEmployee(String id);
}
