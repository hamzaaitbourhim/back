package com.csa.csaback.service;

import com.csa.csaback.model.NotationStage;
import com.csa.csaback.repository.NotationStageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class NotationStageService {

    private final NotationStageRepository notationStageRepository;

    @Autowired
    public NotationStageService(NotationStageRepository notationStageRepository) {
        this.notationStageRepository = notationStageRepository;
    }

    // CREATE operation
    public NotationStage createNotationStage(NotationStage notationStage) {
        Double id = notationStage.getNoBareme();

        if (id == null) {
            throw new RuntimeException("NotationStage ID cannot be null");
        }

        Optional<NotationStage> existingNotationStage = notationStageRepository.findById(id);

        if (existingNotationStage.isPresent()) {
            throw new RuntimeException("NotationStage with ID " + id + " already exists");
        } else {
            return notationStageRepository.save(notationStage);
        }
    }

    // READ operation
    public List<NotationStage> getAllNotationStages() {
        return StreamSupport
                .stream(notationStageRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    // UPDATE operation
    public NotationStage updateNotationStage(Double id, NotationStage updatedNotationStage) {
        Optional<NotationStage> existingNotationStageOptional = notationStageRepository.findById(id);

        if (existingNotationStageOptional.isPresent()) {
            NotationStage existingNotationStage = existingNotationStageOptional.get();
            // Update all fields using the values from updatedNotationStage
            existingNotationStage.setCoeffEnt(updatedNotationStage.getCoeffEnt());
            existingNotationStage.setCoeffRapport(updatedNotationStage.getCoeffRapport());
            existingNotationStage.setCoeffSoutenance(updatedNotationStage.getCoeffSoutenance());
            existingNotationStage.setDateCreation(updatedNotationStage.getDateCreation());
            existingNotationStage.setEtatBareme(updatedNotationStage.getEtatBareme());

            return notationStageRepository.save(existingNotationStage);
        } else {
            throw new RuntimeException("NotationStage not found with ID: " + id);
        }
    }

    // DELETE operation
    public void deleteNotationStage(Double id) {
        Optional<NotationStage> notationStage = notationStageRepository.findById(id);

        if (notationStage.isPresent()) {
            notationStageRepository.deleteById(id);
        } else {
            throw new RuntimeException("NotationStage not found with ID: " + id);
        }
    }
}
