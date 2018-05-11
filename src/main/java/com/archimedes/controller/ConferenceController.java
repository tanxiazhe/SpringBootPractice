package com.archimedes.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import com.archimedes.domain.Conference;
import com.archimedes.service.ConferenceService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "ConferenceController", description = "Conference Api.")
@RestController
@RequestMapping("/Conferences")
public class ConferenceController {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ConferenceService conferenceService;
	
	@ApiOperation(value = "Add a conference.", notes = "Add a conference.",  response= Void.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Successfully create the resource"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addConference(
			@ApiParam(name = "conference", value = "JSON data of the conference to be created.", required = true)@Valid @RequestBody Conference conference){
		logger.info("Prepare to create new conference");

		
		conferenceService.addConference(conference);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Get a conference.", notes = "Get a conference by id.")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully get the resource"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(value="/{id}", method = RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Conference>> getConference(
			@ApiParam(name = "id", value = "Id to update.", required = true) @Min(0) @PathVariable Long id){
		logger.info("logging in " + id);
		
		return new ResponseEntity<Optional<Conference>>(conferenceService.getConference(id),HttpStatus.OK);
	}

	@ApiOperation(value = "View a list of available conferences.", notes="View a list of available conferences.",  response= List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@RequestMapping( method = RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Conference>> getConferences(){
		return new ResponseEntity<List<Conference>>(conferenceService.getConferences(),HttpStatus.OK);
	}


	@ApiOperation(value = "Update a conference.", notes = "Update a conference by id.",  response= Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully update the resource"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@RequestMapping(value = "/{id}", method = { RequestMethod.PATCH }, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> update(
			@ApiParam(name = "id", value = "Id to update.", required = true)@PathVariable Long id,
			@ApiParam(name = "conference", value = "Update conference info.") @RequestBody Conference conference) {

		conferenceService.updateConference(id, conference);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
