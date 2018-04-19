package com.archimedes.service;

import com.archimedes.model.Conference;
import com.archimedes.model.Presentation;
import com.archimedes.persistence.PresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PresentationServiceImpl implements PresentationService {

    @Autowired
    PresentationRepository presentationRepository;

    @Override
    public void addPresentation(Presentation presentation) {

        presentationRepository.save(presentation);

    }

    @Override
    public Optional<Presentation> getPresentation(Long id) {
        return presentationRepository.findById(id);
    }
    
    @Override
    public List<Presentation> getAllPresentations(){
    	Iterable<Presentation> presentations =  presentationRepository.findAll();
        List<Presentation> presentationList = new ArrayList();
    	for(Presentation presentation:presentations){
            presentationList.add(presentation);
        }
        return presentationList;
    }

    @Override
    public void updatePresentation(long id, Presentation presentation) {
        presentationRepository.save(presentation);
    }

}
