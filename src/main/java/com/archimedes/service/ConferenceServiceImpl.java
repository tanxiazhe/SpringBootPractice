package com.archimedes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.archimedes.model.Conference;
import com.archimedes.persistence.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    @Override
    public List<Conference> getConferences() {
        Iterable<Conference> conferences = conferenceRepository.findAll();
        List<Conference> conferenceList = new ArrayList<Conference>();
        for (Conference conference : conferences) {
            conferenceList.add(conference);
        }
        return conferenceList;
    }

    @Override
    public void updateConference(long id, Conference conference) {
        conferenceRepository.save(conference);
    }

}
