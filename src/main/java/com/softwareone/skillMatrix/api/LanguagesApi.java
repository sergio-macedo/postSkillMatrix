/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.softwareone.skillMatrix.api;

import com.softwareone.skillMatrix.model.Language;
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
public interface LanguagesApi {

    @Operation(summary = "adds a new Language", description = "Add a new Language to the system", security = {
        @SecurityRequirement(name = "basicAuth")    }, tags={ "languages" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Success. Body includes the auto-generated key for the new customer", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = Integer.class))),
        
        @ApiResponse(responseCode = "405", description = "Invalid Input") })
    @RequestMapping(value = "/languages",
            produces = { MediaType.APPLICATION_JSON_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE },
            method = RequestMethod.POST)
    ResponseEntity<Language> addLanguage(@Parameter(in = ParameterIn.DEFAULT, description = "the new Language data in JSON format", required=true, schema=@Schema()) @Valid @RequestBody Language body);


    @Operation(summary = "delete an existing Language", description = "Deletes an existing language in the system.", security = {
        @SecurityRequirement(name = "basicAuth")    }, tags={ "languages" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "The language was deleted", content = @Content(mediaType = "*/*", schema = @Schema(implementation = Language.class))),
        
        @ApiResponse(responseCode = "404", description = "Language Not Found"),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error") })
    @RequestMapping(value = "/languages/{id}",
        produces = { "*/*" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteLanguage(@Parameter(in = ParameterIn.PATH, description = "the id of the language to update", required=true, schema=@Schema()) @PathVariable("id") Integer id);


    @Operation(summary = "reads all languages data", description = "This operation provides a view of the language data in JSON", security = {
        @SecurityRequirement(name = "basicAuth")    }, tags={ "languages" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Language.class))),
        
        @ApiResponse(responseCode = "404", description = "could not access the languages.") })
    @RequestMapping(value = "/languages",
        produces = { MediaType.APPLICATION_JSON_VALUE },
        method = RequestMethod.GET)
    ResponseEntity<List<Language>> getAllLanguages(@Parameter(in = ParameterIn.QUERY, description = "Filter languages where first or last name has any match.", required=false, schema=@Schema()) @RequestParam(value = "name", required = false) String name);


    @Operation(summary = "get language per id", description = "", security = {
        @SecurityRequirement(name = "basicAuth")    }, tags={ "languages" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "retrieves successfully the specific language", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Language.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        
        @ApiResponse(responseCode = "404", description = "Employee not found") })
    @RequestMapping(value = "/languages/{id}",
        produces = { MediaType.APPLICATION_JSON_VALUE },
        method = RequestMethod.GET)
    ResponseEntity<Language> getLanguageById(@Parameter(in = ParameterIn.PATH, description = "the id from the language", required=true, schema=@Schema()) @PathVariable("id") Integer id);




    @Operation(summary = "update existing language", description = "Updates an existing language with new data", security = {
        @SecurityRequirement(name = "basicAuth")    }, tags={ "languages" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Success."),
        
        @ApiResponse(responseCode = "404", description = "Language Not Found"),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error") })
    @RequestMapping(value = "/languages/{id}",
        consumes = { MediaType.APPLICATION_JSON_VALUE },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateLanguage(@Parameter(in = ParameterIn.PATH, description = "the id of the language to update", required=true, schema=@Schema()) @PathVariable("id") Integer id, @Parameter(in = ParameterIn.DEFAULT, description = "the updated Language data in JSON format", required=true, schema=@Schema()) @Valid @RequestBody Language body);

}
