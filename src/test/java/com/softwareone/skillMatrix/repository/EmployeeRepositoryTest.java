package com.softwareone.skillMatrix.repository;

import com.softwareone.skillMatrix.model.Employee;
import com.softwareone.skillMatrix.model.Skill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class EmployeeRepositoryTest {

    private EmployeeRepository employeeRepository = new EmployeeMemoryRepository();
    private List<Skill> employeeSkills = new ArrayList<>();

//    @BeforeEach
//    private void beforeEach() {
 //       employeeRepository.deleteAllEmployees();
 //   }

    @Test
    void getAllEmployees() {
        List<Employee> allEmployees = employeeRepository.getAllEmployees(null, null, null);
        Assertions.assertTrue(allEmployees.isEmpty());
    }

    @Test
    void addEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Lennon");

        employeeRepository.addEmployee(employee);

        List<Employee> allEmployees = employeeRepository.getAllEmployees(null, null, null);
        Employee actualEmployee = allEmployees.get(0);
        Assertions.assertEquals(actualEmployee.getFirstName(), employee.getFirstName());
        Assertions.assertEquals(actualEmployee.getLastName(), employee.getLastName());

    }

    @Test
    void getEmployeeById() {
        Employee employee = new Employee();
        employee.setId((UUID.randomUUID().toString()));
        employee.setFirstName("Paul");
        employee.setLastName("Mccartney");
        employeeRepository.addEmployee(employee);

        Employee actualEmployee = employeeRepository.getEmployeeById(employee.getId());

        Assertions.assertEquals(employee, actualEmployee);
    }

    @Test
    void updateEmployee() {
        Employee employee = new Employee();
        employee.setId(UUID.randomUUID().toString());
        employee.setFirstName("Ringo");
        employee.setLastName("Star");
        employeeRepository.addEmployee(employee);

        Employee updatedEmployee = new Employee();
        updatedEmployee.setId(employee.getId());
        updatedEmployee.setFirstName(employee.getFirstName());
        updatedEmployee.setLastName("Starr");
        employeeRepository.updateEmployee(updatedEmployee.getId(), updatedEmployee);

        Employee actualEmployee = employeeRepository.getEmployeeById(employee.getId());
        Assertions.assertEquals(updatedEmployee, actualEmployee);
    }

    @Test
    void deleteEmployee() {
        Employee employee = new Employee();
        employee.setId(UUID.randomUUID().toString());
        employee.setFirstName("Ringo");
        employee.setLastName("Star");
        employeeRepository.addEmployee(employee);

        employeeRepository.deleteEmployee(employee.getId());

        Employee actualEmployee = employeeRepository.getEmployeeById(employee.getId());
        Assertions.assertEquals(null, actualEmployee);
    }

    @Test
    void getAllEmployeesBySkill() {
        Skill skill  = new Skill();
        skill.setSkillName("c#");

        Employee employee = new Employee();
        employee.setId(UUID.randomUUID().toString());
        employee.addSkill(skill);
        employeeRepository.addEmployee(employee);

        Skill skill1 = new Skill();
        skill1.setSkillName("python");

        Employee employee1 = new Employee();
        employee1.setId(UUID.randomUUID().toString());
        employee1.addSkill(skill1);
        employeeRepository.addEmployee(employee1);

        List<Employee> allEmployees = employeeRepository.getAllEmployees(null, "c#", null);

        Assertions.assertEquals(1, allEmployees.size());
    }

    @Test
    void employeeAddSkills() {
        Skill employeeSkillItem = new Skill();
        Employee employee1 = new Employee();
        employee1.setId(UUID.randomUUID().toString());

        employeeRepository.addEmployee(employee1);
        employee1.addSkill(employeeSkillItem);

        List<Employee> allEmployees = employeeRepository.getAllEmployees(null, null, null);
        Employee actualEmployee = allEmployees.get(0);
        Assertions.assertEquals(actualEmployee.employeeSkills(employeeSkills), employee1.employeeSkills(employeeSkills));
    }

    @Test
    void employeeUpdateSkill() {
        Employee employee = new Employee();
        Skill employeeSkillItem = new Skill();
        employee.setId(UUID.randomUUID().toString());
        employeeSkillItem.setSkillName("c#");
        employeeSkillItem.setProficiency();
        employeeRepository.addEmployee(employee);
        employee.addSkill(employeeSkillItem);

        Employee updatedEmployee = new Employee();

        updatedEmployee.setId(employee.getId());
        updatedEmployee.addSkill(employeeSkillItem);
        employeeSkillItem.setSkillName("c#");
        employeeSkillItem.setProficiency();
        employeeRepository.updateEmployee(updatedEmployee.getId(), updatedEmployee);

        Employee actualEmployee = employeeRepository.getEmployeeById(employee.getId());
        Assertions.assertEquals(updatedEmployee, actualEmployee);
    }



}