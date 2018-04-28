package com.archimedes.service;

import com.archimedes.model.Presentation;

import java.util.List;
import java.util.Optional;

public interface PresentationService {


    void addPresentation(Presentation presentation);

    Optional<Presentation> getPresentation(Long id);

    List<Presentation> getAllPresentations();

    void updatePresentation(Long id, Presentation presentation);
}
