package com.archimedes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.archimedes.model.Conference;
import com.archimedes.persistence.ConferenceRepository;

@Service
public class ConferenceServiceImpl implements ConferenceService {

	@Autowired
	ConferenceRepository conferenceRepository;
	
	@Override
	public void addConference(Conference conference) {
		
		conferenceRepository.save(conference);
	}

	@Override
	public Optional<Conference> getConference(Long id) {
		return conferenceRepository.findById(id);
	}

}
