// CandidatService.java
package com.csa.csaback.service;

import com.csa.csaback.model.Candidat;
import com.csa.csaback.repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CandidatService {

    private final CandidatRepository candidatRepository;

    @Autowired
    public CandidatService(CandidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }

    // CREATE operation
    public Candidat createCandidat(Candidat candidat) {
        String noEtudiantNat = candidat.getNoEtudiantNat();

        if (noEtudiantNat == null) {
            throw new RuntimeException("Candidat ID cannot be null");
        }

        Optional<Candidat> existingCandidat = candidatRepository.findById(noEtudiantNat);

        if (existingCandidat.isPresent()) {
            throw new RuntimeException("Candidat with ID " + noEtudiantNat + " already exists");
        } else {
            return candidatRepository.save(candidat);
        }
    }

    // READ operation
    public List<Candidat> getAllCandidats() {
        return StreamSupport
                .stream(candidatRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    // UPDATE operation
    public Candidat updateCandidat(String noEtudiantNat, Candidat updatedCandidat) {
        Optional<Candidat> existingCandidatOptional = candidatRepository.findById(noEtudiantNat);

        if (existingCandidatOptional.isPresent()) {
            Candidat existingCandidat = existingCandidatOptional.get();
            // Update all fields using the values from updatedCandidat
            existingCandidat.setActuAdresse(updatedCandidat.getActuAdresse());
            existingCandidat.setActuCp(updatedCandidat.getActuCp());
            existingCandidat.setActuPays(updatedCandidat.getActuPays());
            existingCandidat.setActuVille(updatedCandidat.getActuVille());
            existingCandidat.setDateNaissance(updatedCandidat.getDateNaissance());
            existingCandidat.setDateReponseCan(updatedCandidat.getDateReponseCan());
            existingCandidat.setDateReponseIli(updatedCandidat.getDateReponseIli());
            existingCandidat.setDernierDiplome(updatedCandidat.getDernierDiplome());
            existingCandidat.setEmail(updatedCandidat.getEmail());
            existingCandidat.setLieuNaissance(updatedCandidat.getLieuNaissance());
            existingCandidat.setNationalite(updatedCandidat.getNationalite());
            existingCandidat.setNoOrdre(updatedCandidat.getNoOrdre());
            existingCandidat.setNom(updatedCandidat.getNom());
            existingCandidat.setPermAdresse(updatedCandidat.getPermAdresse());
            existingCandidat.setPermCp(updatedCandidat.getPermCp());
            existingCandidat.setPermPays(updatedCandidat.getPermPays());
            existingCandidat.setPermVille(updatedCandidat.getPermVille());
            existingCandidat.setPrenom(updatedCandidat.getPrenom());
            existingCandidat.setReponseCan(updatedCandidat.getReponseCan());
            existingCandidat.setReponseIli(updatedCandidat.getReponseIli());
            existingCandidat.setSelectionCourante(updatedCandidat.getSelectionCourante());
            existingCandidat.setSelectionOrigine(updatedCandidat.getSelectionOrigine());
            existingCandidat.setSexe(updatedCandidat.getSexe());
            existingCandidat.setSituation(updatedCandidat.getSituation());
            existingCandidat.setTelFixe(updatedCandidat.getTelFixe());
            existingCandidat.setTelPort(updatedCandidat.getTelPort());
            existingCandidat.setUniversite(updatedCandidat.getUniversite());
            existingCandidat.setPromotion(updatedCandidat.getPromotion());

            return candidatRepository.save(existingCandidat);
        } else {
            throw new RuntimeException("Candidat not found with ID: " + noEtudiantNat);
        }
    }

    // DELETE operation
    public void deleteCandidat(String noEtudiantNat) {
        Optional<Candidat> candidat = candidatRepository.findById(noEtudiantNat);

        if (candidat.isPresent()) {
            candidatRepository.deleteById(noEtudiantNat);
        } else {
            throw new RuntimeException("Candidat not found with ID: " + noEtudiantNat);
        }
    }
}
