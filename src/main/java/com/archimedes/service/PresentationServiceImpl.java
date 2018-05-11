package com.archimedes.service;

import com.archimedes.common.util.ExceptionHandlerUtils;
import com.archimedes.domain.Presentation;
import com.archimedes.domain.PresentationRepository;
import com.archimedes.domain.User;

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
    	ExceptionHandlerUtils.throwIfIdNotNull(presentation.getId());
        presentationRepository.save(presentation);

    }

    @Override
    public Optional<Presentation> getPresentation(Long id) {
    	ExceptionHandlerUtils.throwIfNonexisting(presentationRepository,id);
        return presentationRepository.findById(id);
    }
    
    @Override
    public List<Presentation> getAllPresentations(){
    	Iterable<Presentation> presentations =  presentationRepository.findAll();
        List<Presentation> presentationList = new ArrayList<Presentation>();
    	for(Presentation presentation:presentations){
            presentationList.add(presentation);
        }
        return presentationList;
    }

    @Override
    public void updatePresentation(Long id, Presentation presentation) {
    	ExceptionHandlerUtils.throwIfNonexisting(presentationRepository,id);
    	ExceptionHandlerUtils.throwIfInconsistent(id, presentation.getId());
    	Optional<Presentation> existdPresentation = presentationRepository.findById(id);
    	presentation.setVersion(existdPresentation.get().getVersion());
    	
        presentationRepository.save(presentation);
    }

}
