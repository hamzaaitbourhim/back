package com.csa.csaback.service;

import com.csa.csaback.model.Formation;
import com.csa.csaback.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FormationService {

    private final FormationRepository formationRepository;

    @Autowired
    public FormationService(FormationRepository formationRepository) {
        this.formationRepository = formationRepository;
    }


    // CREATE operation
    public Formation createFormation(Formation formation) {
        String codeFormation = formation.getCodeFormation();

        if (codeFormation == null) {
            throw new RuntimeException("Code Formation cannot be null");
        }

        Optional<Formation> existingFormation = formationRepository.findById(codeFormation);

        if (existingFormation.isPresent()) {
            throw new RuntimeException("Formation with code " + codeFormation + " already exists");
        } else {
            return formationRepository.save(formation);
        }
    }


    // READ operation
    public List<Formation> getAllFormations() {

        // Convert Iterable to List
        return StreamSupport
                .stream(formationRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }


    // UPDATE operation
    public Formation updateFormation(String codeFormation, Formation updatedFormation) {
        Optional<Formation> existingFormationOptional = formationRepository.findById(codeFormation);

        if (existingFormationOptional.isPresent()) {
            Formation existingFormation = existingFormationOptional.get();
            existingFormation.setDebutHabilitation(updatedFormation.getDebutHabilitation());
            existingFormation.setDiplome(updatedFormation.getDiplome());
            existingFormation.setDoubleDiplome(updatedFormation.getDoubleDiplome());
            existingFormation.setFinHabilitation(updatedFormation.getFinHabilitation());
            existingFormation.setN0Annee(updatedFormation.getN0Annee());
            existingFormation.setNomFormation(updatedFormation.getNomFormation());
            // Update other fields as needed
            return formationRepository.save(existingFormation);
        } else {
            throw new RuntimeException("Formation not found with code: " + codeFormation);
        }
    }


    // DELETE operation
    public void deleteFormation(String codeFormation) {
        Optional<Formation> formation = formationRepository.findById(codeFormation);

        if (formation.isPresent()) {
            formationRepository.deleteById(codeFormation);
        } else {
            throw new RuntimeException("Formation not found with code: " + codeFormation);
        }
    }

}
