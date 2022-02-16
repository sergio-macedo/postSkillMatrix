package com.softwareone.skillMatrix.api;

import com.softwareone.skillMatrix.model.Employee;
import com.softwareone.skillMatrix.model.Skill;
import com.softwareone.skillMatrix.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static com.softwareone.skillMatrix.model.Skill.ProficiencyEnum.BEGINNER;
import static com.softwareone.skillMatrix.model.Skill.ProficiencyEnum.INTERMEDIATE;

@SpringBootTest
//@AutoConfigureMockMvc
class EmployeeControllerTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeController employeeController;

    @Test
    public void getAllEmployeesBySkill() {
        Skill skill = new Skill();
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

        ResponseEntity<List<Employee>> response = employeeController.getAllEmployees(null, "python", null);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(1, response.getBody().size());
    }

    @Test
    public void employeeAddSkills() {
        Skill skill  = new Skill();
        skill.setSkillName("c#");

        Employee employee = new Employee();
        employee.setId(UUID.randomUUID().toString());
        employee.addSkill(skill);
        employeeRepository.addEmployee(employee);

        Skill newSkill = new Skill();
        newSkill.setSkillName("Java");
        ResponseEntity<Void> addSkillResponse = employeeController.employeeAddSkills(employee.getId(), newSkill);
        Assertions.assertEquals(HttpStatus.CREATED, addSkillResponse.getStatusCode());

        ResponseEntity<Employee> employeeByIdResponse = employeeController.getEmployeeById(employee.getId());
        Assertions.assertEquals(HttpStatus.OK, employeeByIdResponse.getStatusCode());
        Employee actualEmployee = employeeByIdResponse.getBody();
        Assertions.assertTrue(actualEmployee.getEmployeeSkills().stream().anyMatch(s -> s.getSkillName().contains("Java")));
    }

    @Test
    void employeeUpdateSkill() {
        Skill skill  = new Skill();
        skill.skillName("Java");
        skill.proficiency(BEGINNER);

        Employee employee = new Employee();
        employee.setId(UUID.randomUUID().toString());
        skill.setId(UUID.randomUUID().toString());
        employee.addSkill(skill);
        employeeRepository.addEmployee(employee);

        ResponseEntity<Void> removeSkillResponse = employeeController.employeeDeleteSkill(employee.getId(), skill.getId());
        Assertions.assertEquals(HttpStatus.NO_CONTENT, removeSkillResponse.getStatusCode());

        Skill newSkill = new Skill();
        newSkill.skillName("Java");
        newSkill.proficiency(INTERMEDIATE);
        ResponseEntity<Void> addSkillResponse = employeeController.employeeAddSkills(employee.getId(), newSkill);
        Assertions.assertEquals(HttpStatus.CREATED, addSkillResponse.getStatusCode());

        ResponseEntity<Employee> employeeByIdResponse = employeeController.getEmployeeById(employee.getId());
        Assertions.assertEquals(HttpStatus.OK, employeeByIdResponse.getStatusCode());
        Employee actualEmployee = employeeByIdResponse.getBody();
        Assertions.assertTrue(actualEmployee.getEmployeeSkills().stream().anyMatch(s -> s.getProficiency().equals(INTERMEDIATE)));
    }

}