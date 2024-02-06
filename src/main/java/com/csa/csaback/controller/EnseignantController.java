// EnseignantController.java
package com.csa.csaback.controller;

import com.csa.csaback.model.Enseignant;
import com.csa.csaback.service.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enseignants")
public class EnseignantController {

    private final EnseignantService enseignantService;

    @Autowired
    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    // CREATE enseignant
    @PostMapping
    public ResponseEntity<?> createEnseignant(@RequestBody Enseignant enseignant) {
        try {
            return ResponseEntity.ok(enseignantService.createEnseignant(enseignant));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    // GET all enseignants
    @GetMapping
    public ResponseEntity<List<Enseignant>> getAllEnseignants() {
        List<Enseignant> enseignants = enseignantService.getAllEnseignants();
        return new ResponseEntity<>(enseignants, HttpStatus.OK);
    }

    // UPDATE enseignant by id
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEnseignant(@PathVariable Integer id, @RequestBody Enseignant updatedEnseignant) {
        try {
            Enseignant updated = enseignantService.updateEnseignant(id, updatedEnseignant);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    // DELETE enseignant by id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEnseignant(@PathVariable Integer id) {
        try {
            enseignantService.deleteEnseignant(id);
            return ResponseEntity.ok("Enseignant with ID \"" + id + "\" deleted successfully.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
