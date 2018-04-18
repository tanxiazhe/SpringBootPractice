package com.archimedes.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.archimedes.model.Conference;
import com.archimedes.service.ConferenceService;

@RestController
@RequestMapping("/conference")
public class ConferenceController {
	@Autowired
	ConferenceService conferenceService;
	
	@RequestMapping(method=RequestMethod.POST)
	public void addConference(@RequestBody Conference conference){
		conferenceService.addConference(conference);
	}
	
	@RequestMapping("/{id}")
	public Optional<Conference> getConference(@PathVariable Long id){
		return conferenceService.getConference(id);
//		return "hello";
	}

}