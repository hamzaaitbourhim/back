// CandidatController.java
package com.csa.csaback.controller;

import com.csa.csaback.model.Candidat;
import com.csa.csaback.service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidats")
public class CandidatController {

    private final CandidatService candidatService;

    @Autowired
    public CandidatController(CandidatService candidatService) {
        this.candidatService = candidatService;
    }

    // CREATE candidat
    @PostMapping
    public ResponseEntity<?> createCandidat(@RequestBody Candidat candidat) {
        try {
            return ResponseEntity.ok(candidatService.createCandidat(candidat));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    // GET all candidats
    @GetMapping
    public ResponseEntity<List<Candidat>> getAllCandidats() {
        List<Candidat> candidats = candidatService.getAllCandidats();
        return new ResponseEntity<>(candidats, HttpStatus.OK);
    }

    // UPDATE candidat by noEtudiantNat
    @PutMapping("/{noEtudiantNat}")
    public ResponseEntity<?> updateCandidat(@PathVariable String noEtudiantNat, @RequestBody Candidat updatedCandidat) {
        try {
            Candidat updated = candidatService.updateCandidat(noEtudiantNat, updatedCandidat);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    // DELETE candidat by noEtudiantNat
    @DeleteMapping("/{noEtudiantNat}")
    public ResponseEntity<?> deleteCandidat(@PathVariable String noEtudiantNat) {
        try {
            candidatService.deleteCandidat(noEtudiantNat);
            return ResponseEntity.ok("Candidat with ID \"" + noEtudiantNat + "\" deleted successfully.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
