package com.csa.csaback.service;

import com.csa.csaback.model.Etudiant;
import com.csa.csaback.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;

    @Autowired
    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    // CREATE operation
    public Etudiant createEtudiant(Etudiant etudiant) {
        String noEtudiantNat = etudiant.getNoEtudiantNat();

        if (noEtudiantNat == null) {
            throw new RuntimeException("Etudiant ID cannot be null");
        }

        Optional<Etudiant> existingEtudiant = etudiantRepository.findById(noEtudiantNat);

        if (existingEtudiant.isPresent()) {
            throw new RuntimeException("Etudiant with ID " + noEtudiantNat + " already exists");
        } else {
            return etudiantRepository.save(etudiant);
        }
    }



    // READ operation
    public List<Etudiant> getAllEtudiants() {
        return StreamSupport
                .stream(etudiantRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    // UPDATE operation
    public Etudiant updateEtudiant(String noEtudiantNat, Etudiant updatedEtudiant) {
        Optional<Etudiant> existingEtudiantOptional = etudiantRepository.findById(noEtudiantNat);

        if (existingEtudiantOptional.isPresent()) {
            Etudiant existingEtudiant = existingEtudiantOptional.get();
            // Update all fields using the values from updatedEtudiant
            existingEtudiant.setAbandonDate(updatedEtudiant.getAbandonDate());
            existingEtudiant.setAbandonMotif(updatedEtudiant.getAbandonMotif());
            existingEtudiant.setActuAdresse(updatedEtudiant.getActuAdresse());
            existingEtudiant.setActuCp(updatedEtudiant.getActuCp());
            existingEtudiant.setActuPays(updatedEtudiant.getActuPays());
            existingEtudiant.setActuVille(updatedEtudiant.getActuVille());
            existingEtudiant.setCodeCom(updatedEtudiant.getCodeCom());
            existingEtudiant.setCompteCri(updatedEtudiant.getCompteCri());
            existingEtudiant.setDateNaissance(updatedEtudiant.getDateNaissance());
            existingEtudiant.setDernierDiplome(updatedEtudiant.getDernierDiplome());
            existingEtudiant.setEmail(updatedEtudiant.getEmail());
            existingEtudiant.setEstDiplome(updatedEtudiant.getEstDiplome());
            existingEtudiant.setGrpeAnglais(updatedEtudiant.getGrpeAnglais());
            existingEtudiant.setLieuNaissance(updatedEtudiant.getLieuNaissance());
            existingEtudiant.setNationalite(updatedEtudiant.getNationalite());
            existingEtudiant.setNoEtudiantUbo(updatedEtudiant.getNoEtudiantUbo());
            existingEtudiant.setNom(updatedEtudiant.getNom());
            existingEtudiant.setPermAdresse(updatedEtudiant.getPermAdresse());
            existingEtudiant.setPermCp(updatedEtudiant.getPermCp());
            existingEtudiant.setPermPays(updatedEtudiant.getPermPays());
            existingEtudiant.setPermVille(updatedEtudiant.getPermVille());
            existingEtudiant.setPrenom(updatedEtudiant.getPrenom());
            existingEtudiant.setSexe(updatedEtudiant.getSexe());
            existingEtudiant.setSigleEtu(updatedEtudiant.getSigleEtu());
            existingEtudiant.setSituation(updatedEtudiant.getSituation());
            existingEtudiant.setTelFixe(updatedEtudiant.getTelFixe());
            existingEtudiant.setTelPort(updatedEtudiant.getTelPort());
            existingEtudiant.setUboEmail(updatedEtudiant.getUboEmail());
            existingEtudiant.setUniversite(updatedEtudiant.getUniversite());
            existingEtudiant.setPromotion(updatedEtudiant.getPromotion());

            return etudiantRepository.save(existingEtudiant);
        } else {
            throw new RuntimeException("Etudiant not found with ID: " + noEtudiantNat);
        }
    }

    // DELETE operation
    public void deleteEtudiant(String noEtudiantNat) {
        Optional<Etudiant> etudiant = etudiantRepository.findById(noEtudiantNat);

        if (etudiant.isPresent()) {
            etudiantRepository.deleteById(noEtudiantNat);
        } else {
            throw new RuntimeException("Etudiant not found with ID: " + noEtudiantNat);
        }
    }
}
