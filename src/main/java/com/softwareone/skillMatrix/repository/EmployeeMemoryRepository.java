package com.softwareone.skillMatrix.repository;

import com.softwareone.skillMatrix.model.Employee;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// TODO add skills and remove skills to and from an employee. Access function. Also search by name. Search by id of the skill and employee.
@Component
public class EmployeeMemoryRepository implements EmployeeRepository {
    private static Map<String, Employee> map = new HashMap<>();

    @Override
    public List<Employee> getAllEmployees(String name, String skillName, String languageName) {
        Stream<Employee> employees = map.values().stream();

        if (name != null) {
            employees = employees.filter(employee -> employee.getFirstName().contains(name) || employee.getLastName().contains(name));
        }
        if (skillName != null) {
            employees = employees.filter(employee -> employee.getEmployeeSkills().stream().anyMatch(skill -> skill.getSkillName().contains(skillName)));

        }
        if(languageName != null) {
            employees = employees.filter(employee -> employee.getEmployeeLanguages().stream().anyMatch(language -> language.getLanguageName().contains(languageName)));
        }
        return employees.collect(Collectors.toList());
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setId(UUID.randomUUID().toString());
        map.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return map.get(id);
    }

    @Override
    public void updateEmployee(String id, Employee employee) {
        map.put(id, employee);
    }

    @Override
    public void deleteEmployee(String id) {
        map.remove(id);
    }
}
