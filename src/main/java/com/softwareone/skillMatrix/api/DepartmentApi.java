/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.softwareone.skillMatrix.api;

import com.softwareone.skillMatrix.model.Department;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-26T10:17:25.614Z[GMT]")
@Validated
public interface DepartmentApi {

    @Operation(summary = "adds a new department", description = "Add a new Department to the system", security = {
        @SecurityRequirement(name = "OAuth2", scopes = {
            "read",
"admin"        })    }, tags={ "department" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Success. Body includes the auto-generated key for the new customer", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = Integer.class))),
        
        @ApiResponse(responseCode = "405", description = "Invalid Input") })
    @RequestMapping(value = "/department",
            produces = { MediaType.APPLICATION_JSON_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE },
            method = RequestMethod.POST)
    ResponseEntity<Department> addDepartment(@Parameter(in = ParameterIn.DEFAULT, description = "the new Department data in JSON format", required=true, schema=@Schema()) @Valid @RequestBody Department body);


    @Operation(summary = "delete an existing Department", description = "Deletes an existing Department in the system.", security = {
        @SecurityRequirement(name = "OAuth2", scopes = {
            "read",
"admin"        })    }, tags={ "department" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "The Department was deleted", content = @Content(mediaType = "*/*", schema = @Schema(implementation = Department.class))),
        
        @ApiResponse(responseCode = "404", description = "Department Not Found"),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error") })
    @RequestMapping(value = "/department/{id}",
        produces = { "*/*" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteDepartment(@Parameter(in = ParameterIn.PATH, description = "the id of the Department to delete", required=true, schema=@Schema()) @PathVariable("id") Integer id);


    @Operation(summary = "get departments per Id", description = "", security = {
        @SecurityRequirement(name = "OAuth2", scopes = {
            "read",
"admin"        })    }, tags={ "department" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "retrieves successfully the specific Department", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Department.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        
        @ApiResponse(responseCode = "404", description = "Departments not found") })
    @RequestMapping(value = "/department/{id}",
        produces = { MediaType.APPLICATION_JSON_VALUE },
        method = RequestMethod.GET)
    ResponseEntity<Department> getDepartmentById(@Parameter(in = ParameterIn.PATH, description = "the id from the Department", required=true, schema=@Schema()) @PathVariable("id") Integer id);


    @Operation(summary = "reads all departments data", description = "This operation provides a view of the Departments data in JSON", security = {
        @SecurityRequirement(name = "OAuth2", scopes = {
            "read",
"admin"        })    }, tags={ "department" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Department.class))),
        
        @ApiResponse(responseCode = "404", description = "could not access the Departments.") })
    @RequestMapping(value = "/departments",
        produces = { MediaType.APPLICATION_JSON_VALUE},
        method = RequestMethod.GET)
    ResponseEntity<List<Department>> getAllDepartments(@Parameter(in = ParameterIn.QUERY, description = "Filter departments where first or last name has any match.", required=false, schema=@Schema()) @RequestParam(value = "name", required = false) String name);


    @Operation(summary = "search department through name", description = "", security = {
        @SecurityRequirement(name = "OAuth2", scopes = {
            "read",
"admin"        })    }, tags={ "search department" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Department.class))),
        
        @ApiResponse(responseCode = "404", description = "could not access the employees.") })
    @RequestMapping(value = "/department/{id}",
        consumes = { MediaType.APPLICATION_JSON_VALUE },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateDepartment(@Parameter(in = ParameterIn.PATH, description = "the id of the Department to update", required=true, schema=@Schema()) @PathVariable("id") Integer id, @Parameter(in = ParameterIn.DEFAULT, description = "the updated Department data in JSON format", required=true, schema=@Schema()) @Valid @RequestBody Department body);

}

