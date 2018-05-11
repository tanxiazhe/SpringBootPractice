package com.archimedes.service;

import java.util.List;
import java.util.Optional;

import com.archimedes.domain.Conference;



public interface ConferenceService {

	void addConference(Conference conference);

	Optional<Conference> getConference(Long id);

	List<Conference> getConferences();

	void updateConference(Long id, Conference conference);
}
