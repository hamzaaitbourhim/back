// EtudiantController.java
package com.csa.csaback.controller;

import com.csa.csaback.model.Etudiant;
import com.csa.csaback.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    private final EtudiantService etudiantService;

    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    // CREATE etudiant
    @PostMapping
    public ResponseEntity<?> createEtudiant(@RequestBody Etudiant etudiant) {
        try {
            return ResponseEntity.ok(etudiantService.createEtudiant(etudiant));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    // GET all etudiants
    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantService.getAllEtudiants();
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    // UPDATE etudiant by noEtudiantNat
    @PutMapping("/{noEtudiantNat}")
    public ResponseEntity<?> updateEtudiant(@PathVariable String noEtudiantNat, @RequestBody Etudiant updatedEtudiant) {
        try {
            Etudiant updated = etudiantService.updateEtudiant(noEtudiantNat, updatedEtudiant);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    // DELETE etudiant by noEtudiantNat
    @DeleteMapping("/{noEtudiantNat}")
    public ResponseEntity<?> deleteEtudiant(@PathVariable String noEtudiantNat) {
        try {
            etudiantService.deleteEtudiant(noEtudiantNat);
            return ResponseEntity.ok("Etudiant with ID \"" + noEtudiantNat + "\" deleted successfully.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}