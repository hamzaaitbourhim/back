// StructureEvaluationService.java
package com.csa.csaback.service;

import com.csa.csaback.model.StructureEvaluation;
import com.csa.csaback.repository.StructureEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StructureEvaluationService {

    private final StructureEvaluationRepository structureEvaluationRepository;

    @Autowired
    public StructureEvaluationService(StructureEvaluationRepository structureEvaluationRepository) {
        this.structureEvaluationRepository = structureEvaluationRepository;
    }

    // CREATE operation
    public StructureEvaluation createStructureEvaluation(StructureEvaluation structureEvaluation) {
        Double id = structureEvaluation.getNoEvaluation();

        if (id == null) {
            throw new RuntimeException("StructureEvaluation ID cannot be null");
        }

        Optional<StructureEvaluation> existingStructureEvaluation = structureEvaluationRepository.findById(id);

        if (existingStructureEvaluation.isPresent()) {
            throw new RuntimeException("StructureEvaluation with ID " + id + " already exists");
        } else {
            return structureEvaluationRepository.save(structureEvaluation);
        }
    }

    // READ operation
    public List<StructureEvaluation> getAllStructureEvaluations() {
        return StreamSupport
                .stream(structureEvaluationRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    // UPDATE operation
    public StructureEvaluation updateStructureEvaluation(Double id, StructureEvaluation updatedStructureEvaluation) {
        Optional<StructureEvaluation> existingStructureEvaluationOptional = structureEvaluationRepository.findById(id);

        if (existingStructureEvaluationOptional.isPresent()) {
            StructureEvaluation existingStructureEvaluation = existingStructureEvaluationOptional.get();
            // Update all fields using the values from updatedStructureEvaluation
            existingStructureEvaluation.setDateCreation(updatedStructureEvaluation.getDateCreation());
            existingStructureEvaluation.setEtat(updatedStructureEvaluation.getEtat());

            return structureEvaluationRepository.save(existingStructureEvaluation);
        } else {
            throw new RuntimeException("StructureEvaluation not found with ID: " + id);
        }
    }

    // DELETE operation
    public void deleteStructureEvaluation(Double id) {
        Optional<StructureEvaluation> structureEvaluation = structureEvaluationRepository.findById(id);

        if (structureEvaluation.isPresent()) {
            structureEvaluationRepository.deleteById(id);
        } else {
            throw new RuntimeException("StructureEvaluation not found with ID: " + id);
        }
    }
}
