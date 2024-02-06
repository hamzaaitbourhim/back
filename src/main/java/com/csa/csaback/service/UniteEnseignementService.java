// UniteEnseignementService.java
package com.csa.csaback.service;

import com.csa.csaback.model.UniteEnseignement;
import com.csa.csaback.repository.UniteEnseignementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UniteEnseignementService {

    private final UniteEnseignementRepository uniteEnseignementRepository;

    @Autowired
    public UniteEnseignementService(UniteEnseignementRepository uniteEnseignementRepository) {
        this.uniteEnseignementRepository = uniteEnseignementRepository;
    }

    // CREATE operation
    public UniteEnseignement createUniteEnseignement(UniteEnseignement uniteEnseignement) {
        if (uniteEnseignement.getCodeUe() == null) {
            throw new RuntimeException("Unite Enseignement code (codeUe) cannot be null");
        }

        Optional<UniteEnseignement> existingUniteEnseignement = uniteEnseignementRepository.findById(uniteEnseignement.getCodeUe());

        if (existingUniteEnseignement.isPresent()) {
            throw new RuntimeException("Unite Enseignement with codeUe " + uniteEnseignement.getCodeUe() + " already exists");
        } else {
            return uniteEnseignementRepository.save(uniteEnseignement);
        }
    }

    // READ operation
    public List<UniteEnseignement> getAllUniteEnseignements() {
        return StreamSupport
                .stream(uniteEnseignementRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    // UPDATE operation
    public UniteEnseignement updateUniteEnseignement(String codeUe, UniteEnseignement updatedUniteEnseignement) {
        Optional<UniteEnseignement> existingUniteEnseignementOptional = uniteEnseignementRepository.findById(codeUe);

        if (existingUniteEnseignementOptional.isPresent()) {
            updatedUniteEnseignement.setCodeUe(codeUe);
            return uniteEnseignementRepository.save(updatedUniteEnseignement);
        } else {
            throw new RuntimeException("Unite Enseignement not found with codeUe: " + codeUe);
        }
    }

    // DELETE operation
    public void deleteUniteEnseignement(String codeUe) {
        Optional<UniteEnseignement> uniteEnseignement = uniteEnseignementRepository.findById(codeUe);

        if (uniteEnseignement.isPresent()) {
            uniteEnseignementRepository.deleteById(codeUe);
        } else {
            throw new RuntimeException("Unite Enseignement not found with codeUe: " + codeUe);
        }
    }
}
