package com.archimedes.service;

import java.util.Optional;

import com.archimedes.model.Conference;

public interface ConferenceService {

	void addConference(Conference conference);

	Optional<Conference> getConference(Long id);
	
}
