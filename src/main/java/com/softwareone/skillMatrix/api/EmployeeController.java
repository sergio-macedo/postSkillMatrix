package com.softwareone.skillMatrix.api;

import com.softwareone.skillMatrix.model.Employee;
import com.softwareone.skillMatrix.model.Language;
import com.softwareone.skillMatrix.model.Skill;
import com.softwareone.skillMatrix.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController implements EmployeesApi {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public ResponseEntity<List<Employee>> getAllEmployees(String name, String skillName, String languageName) {
        return new ResponseEntity<>(employeeRepository.getAllEmployees(name, skillName, languageName), HttpStatus.OK);
    }

    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeRepository.addEmployee(employee), HttpStatus.CREATED);
    }

    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id) {
        return new ResponseEntity(employeeRepository.getEmployeeById(id), HttpStatus.OK);
    }

    public ResponseEntity<Void> updateEmployee(@PathVariable("id") String id, @RequestBody Employee employee) {
        employeeRepository.updateEmployee(id, employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") String id) {
        employeeRepository.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> employeeAddSkills(@PathVariable("id")  String id, Skill skill) {
        skill.setId(UUID.randomUUID().toString());
        Employee employee = employeeRepository.getEmployeeById(id);
        employee.addSkill(skill);
        employeeRepository.updateEmployee(employee.getId(), employee);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> employeeDeleteSkill(@PathVariable("id") String id ,@PathVariable("skillId") String skillId) {
        Employee employee = employeeRepository.getEmployeeById(id);
        employee.removeSkill(skillId);
        employeeRepository.updateEmployee(employee.getId(), employee);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> employeeUpdateSkill(String id, String skillId, Skill skill) {
        Employee employee = employeeRepository.getEmployeeById(id);
        employee.removeSkill(skillId);
        employee.addSkill(skill);
        employeeRepository.updateEmployee(employee.getId(), employee);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> employeeAddLanguages(@PathVariable("id") String id, Language employeeLanguageItem) {
        employeeLanguageItem.setId(UUID.randomUUID().toString());
        Employee employee = employeeRepository.getEmployeeById(id);
        employee.addEmployeeLanguagesItem(employeeLanguageItem);
        employeeRepository.updateEmployee(employee.getId(), employee);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> employeeDeleteLanguage(@PathVariable("id") String id ,@PathVariable("languageId") String languageId) {
        Employee employee = employeeRepository.getEmployeeById(id);
        employee.removeEmployeeLanguageItem(languageId);
        employeeRepository.updateEmployee(employee.getId(), employee);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
//    @Override
//    public ResponseEntity<Void> employeeDeleteSkill(@PathVariable("id") String id ,@PathVariable("skillId") String skillId) {
//        Employee employee = employeeRepository.getEmployeeById(id);
//        employee.removeEmployeeSkillItem(skillId);
//        employeeRepository.updateEmployee(employee.getId(), employee);
//
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    }



    @Override
    public ResponseEntity<List<Skill>> employeeGetSkills(String skillId) {
        return null;
    }




//    public Employee addEmployee() {
//
//        Employee employee = new Employee();
//
//        employee.setId(1);
//        employee.setFirstName("John");
//        employee.setLastName("Lennon");
//        employee.setBirthDate(LocalDate.parse("1960-01-01"));
//        employee.setEmail("john@beatles.com");
//        employee.setPassword("abcd");
//        employee.setMobileNumber("88469845");
//        employee.setLocation("Liverpool");
//        employee.setAboutMe("I'm a badass singer and song writer");
//        employee.setJobTitle("Band lead");
//        employee.setDepartment("Music");
//        employee.setEmployeeSkills(new ArrayList<>());
//        employee.setEmployeeLanguages(new ArrayList<>());
//
//        return employee;


//    }


}




















 //    public Employee addEmployee() {
 //        Employee employee3 = new Employee();
 //
 //        employee3.setId(2);
 //        employee3.setFirstName("Paul");
 //        employee3.setLastName("Mccartney");
 //        employee3.setBirthDate(LocalDate.parse("1960-01-01"));
 //        employee3.setEmail("Paul@beatles.com");
 //        employee3.setPassword("ram");
 //        employee3.setMobileNumber("88469845");
 //        employee3.setLocation("Liverpool");
 //        employee3.setAboutMe("I'm the captain and song writer");
 //        employee3.setJobTitle("Band lead");
 //        employee3.setDepartment("Music");
 //        employee3.setEmployeeSkills(new ArrayList<>());
 //        employee3.setEmployeeLanguages(new ArrayList<>());
 //
 //        return employee3;
 //    }

