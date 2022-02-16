package com.softwareone.skillMatrix.api;

import com.softwareone.skillMatrix.model.JobTitle;
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
public class JobTitleController implements JobtitleApi {

    public ResponseEntity<List<JobTitle>> getAllJobTitles(String name) {
        return new ResponseEntity<>(Arrays.asList(createJobTitle()), HttpStatus.OK);
    }

    public ResponseEntity<JobTitle> addJobTitle(@RequestBody JobTitle jobTitle) {
        return new ResponseEntity<>(jobTitle, HttpStatus.CREATED);
    }

    public ResponseEntity<JobTitle> getJobTitleById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(createJobTitle(), HttpStatus.OK);
    }

    public ResponseEntity<Void> updateJobTitle(Integer id, @RequestBody JobTitle jobTitle) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Void> deleteJobTitle(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private JobTitle createJobTitle() {
        JobTitle jobTitle = new JobTitle();

        jobTitle.setId(5);
        jobTitle.setJobTitle("Developer");



        return jobTitle;
    }
}

