package com.archimedes.service;

import java.util.List;
import java.util.Optional;

import com.archimedes.domain.Presentation;

public interface PresentationService {


    void addPresentation(Presentation presentation);

    Optional<Presentation> getPresentation(Long id);

    List<Presentation> getAllPresentations();

    void updatePresentation(Long id, Presentation presentation);
}
