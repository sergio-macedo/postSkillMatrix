/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.softwareone.skillMatrix.api;

import com.softwareone.skillMatrix.model.Skill;
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
public interface SkillsApi {

    @Operation(summary = "adds a new skill", description = "Add a new Skill to the system", security = {
        @SecurityRequirement(name = "basicAuth")    }, tags={ "skills" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Success. Body includes the auto-generated key for the new customer", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = Integer.class))),
        
        @ApiResponse(responseCode = "405", description = "Invalid Input") })
    @RequestMapping(value = "/skills",
            produces = { MediaType.APPLICATION_JSON_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE },
            method = RequestMethod.POST)
    ResponseEntity<Skill> addSkill(@Parameter(in = ParameterIn.DEFAULT, description = "the new Skill data in JSON format", required=true, schema=@Schema()) @Valid @RequestBody Skill body);


    @Operation(summary = "delete an existing Skill", description = "Deletes an existing Skill in the system.", security = {
        @SecurityRequirement(name = "basicAuth")    }, tags={ "skills" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "The skill was deleted", content = @Content(mediaType = "*/*", schema = @Schema(implementation = Skill.class))),
        
        @ApiResponse(responseCode = "404", description = "Skill Not Found"),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error") })
    @RequestMapping(value = "/skills/{id}",
        produces = { "*/*" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteSkill(@Parameter(in = ParameterIn.PATH, description = "the id of the Skill to delete", required=true, schema=@Schema()) @PathVariable("id") String id);


    @Operation(summary = "reads all skills data", description = "This operation provides a view of the skill data in JSON", security = {
        @SecurityRequirement(name = "basicAuth")    }, tags={ "skills" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Skill.class))),
        
        @ApiResponse(responseCode = "404", description = "could not access the skills.") })
    @RequestMapping(value = "/skills",
        produces = { MediaType.APPLICATION_JSON_VALUE },
        method = RequestMethod.GET)
    ResponseEntity<List<Skill>> getAllSkills(@Parameter(in = ParameterIn.QUERY, description = "Filter skills where first or last name has any match.", required=false, schema=@Schema()) @RequestParam(value = "name", required = false) String name);



    @Operation(summary = "search skill through name", description = "", security = {
        @SecurityRequirement(name = "basicAuth")    }, tags={ "search skill" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Skill.class))),
        
        @ApiResponse(responseCode = "404", description = "could not access the employees.") })
    @RequestMapping(value = "/skills/{id}",
        produces = { MediaType.APPLICATION_JSON_VALUE },
        method = RequestMethod.GET)
    ResponseEntity<Skill> getSkillById(@Parameter(in = ParameterIn.PATH, description = "the id from the skill", required=true, schema=@Schema()) @PathVariable("id") String id);


    @Operation(summary = "update existing skill", description = "Updates an existing skill with new data", security = {
        @SecurityRequirement(name = "basicAuth")    }, tags={ "skills" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Success."),
        
        @ApiResponse(responseCode = "404", description = "Skill Not Found"),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error") })
    @RequestMapping(value = "/skills/{id}",
        consumes = { MediaType.APPLICATION_JSON_VALUE },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateSkill(@Parameter(in = ParameterIn.PATH, description = "the id of the skill to update", required=true, schema=@Schema()) @PathVariable("id") String id, @Parameter(in = ParameterIn.DEFAULT, description = "the updated Skills data in JSON format", required=true, schema=@Schema()) @Valid @RequestBody Skill body);

}

