// DiplomeService.java
package com.csa.csaback.service;

import com.csa.csaback.model.Diplome;
import com.csa.csaback.repository.DiplomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DiplomeService {

    private final DiplomeRepository diplomeRepository;

    @Autowired
    public DiplomeService(DiplomeRepository diplomeRepository) {
        this.diplomeRepository = diplomeRepository;
    }

    // CREATE operation
    public Diplome createDiplome(Diplome diplome) {

        String noEtudiantNat = diplome.getNoEtudiantNat();

        if (noEtudiantNat == null) {
            throw new RuntimeException("Diplome ID cannot be null");
        }

        Optional<Diplome> existingDiplome = diplomeRepository.findById(noEtudiantNat);

        if (existingDiplome.isPresent()) {
            throw new RuntimeException("Diplome with ID " + noEtudiantNat + " already exists");
        } else {
            return diplomeRepository.save(diplome);
        }
    }

    // READ operation
    public List<Diplome> getAllDiplomes() {
        return StreamSupport
                .stream(diplomeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    // UPDATE operation
    public Diplome updateDiplome(String noEtudiantNat, Diplome updatedDiplome) {
        Optional<Diplome> existingDiplomeOptional = diplomeRepository.findById(noEtudiantNat);

        if (existingDiplomeOptional.isPresent()) {
            Diplome existingDiplome = existingDiplomeOptional.get();
            // Update all fields using the values from updatedDiplome
            existingDiplome.setAdresse(updatedDiplome.getAdresse());
            existingDiplome.setAutorisationAnnuaire(updatedDiplome.getAutorisationAnnuaire());
            existingDiplome.setCp(updatedDiplome.getCp());
            existingDiplome.setEmailPerso(updatedDiplome.getEmailPerso());
            existingDiplome.setMailPro(updatedDiplome.getMailPro());
            existingDiplome.setNom(updatedDiplome.getNom());
            existingDiplome.setPortable(updatedDiplome.getPortable());
            existingDiplome.setPrenom(updatedDiplome.getPrenom());
            existingDiplome.setTelPerso(updatedDiplome.getTelPerso());
            existingDiplome.setTelPro(updatedDiplome.getTelPro());
            existingDiplome.setTypeEmploi(updatedDiplome.getTypeEmploi());
            existingDiplome.setVille(updatedDiplome.getVille());

            return diplomeRepository.save(existingDiplome);
        } else {
            throw new RuntimeException("Diplome not found with ID: " + noEtudiantNat);
        }
    }

    // DELETE operation
    public void deleteDiplome(String noEtudiantNat) {
        Optional<Diplome> diplome = diplomeRepository.findById(noEtudiantNat);

        if (diplome.isPresent()) {
            diplomeRepository.deleteById(noEtudiantNat);
        } else {
            throw new RuntimeException("Diplome not found with ID: " + noEtudiantNat);
        }
    }
}
