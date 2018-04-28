package com.archimedes.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.archimedes.model.User;
import com.archimedes.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "UserController", description = "User Api.")
@RestController
@RequestMapping("/Users")
public class UserController {
Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	UserService userService;
	
	@ApiOperation(value = "Add a user", notes = "Add a user.",  response= Void.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully create the resource"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> addUser(
			@ApiParam(name = "user", value = "JSON data of the user to be created.", required = true) @RequestBody User user){
		logger.info("Prepare to create new user");

		userService.addUser(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Get a user", notes = "Get a user by id.")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully create the resource"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<User>> getUser(
			@ApiParam(name = "id", value = "Id to update.", required = true) @PathVariable Long id){
		logger.info("logging in " + id);
		return new ResponseEntity<Optional<User>>(userService.getUser(id),HttpStatus.OK);
	}

	@ApiOperation(value = "View a list of available users.", notes="View a list of available users.",  response= List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers(){
		return  new ResponseEntity<List<User>>(userService.getUsers(),HttpStatus.OK);
	}


	@ApiOperation(value = "Update a user.", notes = "Update a user by id.",  response= Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@RequestMapping(value = "/{id}", method = { RequestMethod.PATCH })
	public ResponseEntity<Void> update(
			@ApiParam(name = "id", value = "Id to update.", required = true)@PathVariable long id,
			@ApiParam(name = "user", value = "Update user info.") @RequestBody User user) {

		userService.updateUser(id, user);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
}
