// EnseignantService.java
package com.csa.csaback.service;

import com.csa.csaback.model.Enseignant;
import com.csa.csaback.repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EnseignantService {

    private final EnseignantRepository enseignantRepository;

    @Autowired
    public EnseignantService(EnseignantRepository enseignantRepository) {
        this.enseignantRepository = enseignantRepository;
    }

    // CREATE operation
    public Enseignant createEnseignant(Enseignant enseignant) {
        Integer id = enseignant.getNoEnseignant();

        if (id == null) {
            throw new RuntimeException("Enseignant ID cannot be null");
        }

        Optional<Enseignant> existingEnseignant = enseignantRepository.findById(id);

        if (existingEnseignant.isPresent()) {
            throw new RuntimeException("Enseignant with ID " + id + " already exists");
        } else {
            return enseignantRepository.save(enseignant);
        }
    }

    // READ operation
    public List<Enseignant> getAllEnseignants() {
        return StreamSupport
                .stream(enseignantRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    // UPDATE operation
    public Enseignant updateEnseignant(Integer id, Enseignant updatedEnseignant) {
        Optional<Enseignant> existingEnseignantOptional = enseignantRepository.findById(id);

        if (existingEnseignantOptional.isPresent()) {
            Enseignant existingEnseignant = existingEnseignantOptional.get();
            // Update all fields using the values from updatedEnseignant
            existingEnseignant.setAdresse(updatedEnseignant.getAdresse());
            existingEnseignant.setCp(updatedEnseignant.getCp());
            existingEnseignant.setEncPersoEmail(updatedEnseignant.getEncPersoEmail());
            existingEnseignant.setEncPersoTel(updatedEnseignant.getEncPersoTel());
            existingEnseignant.setEncUboEmail(updatedEnseignant.getEncUboEmail());
            existingEnseignant.setEncUboTel(updatedEnseignant.getEncUboTel());
            existingEnseignant.setIntFonction(updatedEnseignant.getIntFonction());
            existingEnseignant.setIntNoInsee(updatedEnseignant.getIntNoInsee());
            existingEnseignant.setIntProfEmail(updatedEnseignant.getIntProfEmail());
            existingEnseignant.setIntProfTel(updatedEnseignant.getIntProfTel());
            existingEnseignant.setIntSocAdresse(updatedEnseignant.getIntSocAdresse());
            existingEnseignant.setIntSocCp(updatedEnseignant.getIntSocCp());
            existingEnseignant.setIntSocNom(updatedEnseignant.getIntSocNom());
            existingEnseignant.setIntSocPays(updatedEnseignant.getIntSocPays());
            existingEnseignant.setIntSocVille(updatedEnseignant.getIntSocVille());
            existingEnseignant.setNom(updatedEnseignant.getNom());
            existingEnseignant.setPays(updatedEnseignant.getPays());
            existingEnseignant.setPrenom(updatedEnseignant.getPrenom());
            existingEnseignant.setSexe(updatedEnseignant.getSexe());
            existingEnseignant.setTelPort(updatedEnseignant.getTelPort());
            existingEnseignant.setType(updatedEnseignant.getType());
            existingEnseignant.setVille(updatedEnseignant.getVille());

            return enseignantRepository.save(existingEnseignant);
        } else {
            throw new RuntimeException("Enseignant not found with ID: " + id);
        }
    }

    // DELETE operation
    public void deleteEnseignant(Integer id) {
        Optional<Enseignant> enseignant = enseignantRepository.findById(id);

        if (enseignant.isPresent()) {
            enseignantRepository.deleteById(id);
        } else {
            throw new RuntimeException("Enseignant not found with ID: " + id);
        }
    }
}
