package com.archimedes.controller;

import com.archimedes.model.Presentation;
import com.archimedes.service.PresentationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@Api(value = "PresentationController", description = "Presentation Api")
@RestController
@RequestMapping("/Presentations")
public class PresentationController {
    @Autowired
    PresentationService presentationService;

    @ApiOperation(value = "Add a presentation", notes = "Add a presentation.",  response= Void.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully create the resource"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
    @RequestMapping(method= RequestMethod.POST)
    public void addPresentation(
    		@ApiParam(name = "presentation", value = "JSON data of the presentation to be created.", required = true)@RequestBody Presentation presentation){
        presentationService.addPresentation(presentation);
    }

    @ApiOperation(value = "Get a presentation", notes = "Get a presentation by id." )
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully create the resource"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Optional<Presentation> getPresentation(
    		@ApiParam(name = "id", value = "Id to update.", required = true) @PathVariable Long id){
        return presentationService.getPresentation(id);
    }
    
    
    @ApiOperation(value = "View a list of available presentations.", notes="View a list of available presentations.",  response= List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(method= RequestMethod.GET)
    public List<Presentation> getPresentations(){
        return presentationService.getAllPresentations();
    }
    
    
    @ApiOperation(value = "Update a presentation.", notes = "Update a presentation by id." ,  response= Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = "/{id}", method = { RequestMethod.PATCH })
    public ResponseEntity<Void> update(
    		@ApiParam(name = "id", value = "Id to update.", required = true)@PathVariable long id, 
    		@ApiParam(name = "presentation", value = "Update presentation info.")@RequestBody Presentation presentation) {

        presentationService.updatePresentation(id, presentation);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
