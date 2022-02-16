package com.softwareone.skillMatrix.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softwareone.skillMatrix.model.Employee;
import com.softwareone.skillMatrix.model.Skill;
import com.softwareone.skillMatrix.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerMockMvcTest {

    private static List<Employee> EMPLOYEES =
            Arrays.asList(new Employee[] {
                    new Employee()
                            .id("1")
                            .firstName("John")
                            .addSkill(new Skill().id("1").skillName("Sing")),
                    new Employee()
                            .id("2")
                            .firstName("Paul")
                            .addSkill(new Skill().id("2").skillName("Play").proficiency(Skill.ProficiencyEnum.BEGINNER))
            });

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    public void getAllEmployeesBySkill() throws Exception {
        when(employeeRepository.getAllEmployees(null, "Play", null))
                .thenReturn(EMPLOYEES);

        String john = "{\"id\": \"1\", \"firstName\": \"John\", \"skills\": [ { \"skillName\": \"Sing\"} ]}";
        String paul = "{\"id\": \"2\", \"firstName\": \"Paul\", \"skills\": [ { \"skillName\": \"Play\"} ]}";
        String expectedJson = "[" + john + ", " + paul + "]";
        this.mockMvc.perform(get("/employees").param("skillName", "Play"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }

    @Test
    public void employeeAddSkills() throws Exception {
        String employeeId = "1";
        Employee employee = EMPLOYEES.get(0);

        when(employeeRepository.getEmployeeById(employeeId))
                .thenReturn(employee);

        Skill skill = new Skill()
                .id("6")
                .skillName("c#")
                .proficiency(Skill.ProficiencyEnum.BEGINNER)
                .category(Skill.CategoryEnum.HARD_SKILLS);

        mockMvc.perform(
                post("/employees/{id}/skills", employeeId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(skill))
                )
                .andExpect(status().isCreated());

        Employee updatedEmployee = employee.addSkill(skill);
        verify(employeeRepository, times(1)).updateEmployee(employeeId, updatedEmployee);
    }

    @Test
    void employeeUpdateSkill() throws Exception {

        String employeeId = "1";
        String skillId = "6";

        Employee employee = EMPLOYEES.get(0);
        Skill skill = new Skill()
                .id("6")
                .skillName("c#")
                .proficiency(Skill.ProficiencyEnum.BEGINNER)
                .category(Skill.CategoryEnum.HARD_SKILLS);
        employee.addSkill(skill);
        when(employeeRepository.getEmployeeById(employeeId)).thenReturn(employee);

        Skill newSkill = new Skill()
                .id("6")
                .skillName("c#")
                .proficiency(Skill.ProficiencyEnum.INTERMEDIATE)
                .category(Skill.CategoryEnum.HARD_SKILLS);


        mockMvc.perform(
                put("/employees/{id}/skills/{skillId}", employeeId, skillId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(skill))
                )
                .andExpect(status().isNoContent());

        Employee updatedEmployee = employee.removeSkill(skillId).addSkill(newSkill);
        verify(employeeRepository, times(1)).updateEmployee(employeeId, updatedEmployee);

    }


    private static String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}