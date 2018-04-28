package com.archimedes.service;

import com.archimedes.model.Conference;

import java.util.List;
import java.util.Optional;



public interface ConferenceService {

	void addConference(Conference conference);

	Optional<Conference> getConference(Long id);

	List<Conference> getConferences();

	void updateConference(Long id, Conference conference);
}
