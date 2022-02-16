package com.softwareone.skillMatrix.api;

import com.softwareone.skillMatrix.model.Department;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;

/**
 *  TODO revisar responses dos métodos PUT and DELETE. Devem retornar 204 (NO_CONTENT) como abaixo
 *
 *        responses:
 *         "204":
 *           description: Success.
 */
@RestController
public class DepartmentController implements DepartmentApi {

    public ResponseEntity<List<Department>> getAllDepartments(String name) {
        return new ResponseEntity<>(Arrays.asList(createDepartment()), HttpStatus.OK);
    }

    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(createDepartment(), HttpStatus.OK);
    }

    public ResponseEntity<Void> updateDepartment(Integer id, @RequestBody Department department) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Void> deleteDepartment(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    private Department createDepartment() {
        Department department = new Department();
        department.setId(3);
        department.setDepartment("AppServices");

        return department;
    }
}
