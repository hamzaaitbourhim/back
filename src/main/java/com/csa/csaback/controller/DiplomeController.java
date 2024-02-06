// DiplomeController.java
package com.csa.csaback.controller;

import com.csa.csaback.model.Diplome;
import com.csa.csaback.service.DiplomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diplomes")
public class DiplomeController {

    private final DiplomeService diplomeService;

    @Autowired
    public DiplomeController(DiplomeService diplomeService) {
        this.diplomeService = diplomeService;
    }

    // CREATE diplome
    @PostMapping
    public ResponseEntity<?> createDiplome(@RequestBody Diplome diplome) {
        try {
            return ResponseEntity.ok(diplomeService.createDiplome(diplome));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    // GET all diplomes
    @GetMapping
    public ResponseEntity<List<Diplome>> getAllDiplomes() {
        List<Diplome> diplomes = diplomeService.getAllDiplomes();
        return new ResponseEntity<>(diplomes, HttpStatus.OK);
    }

    // UPDATE diplome by noEtudiantNat
    @PutMapping("/{noEtudiantNat}")
    public ResponseEntity<?> updateDiplome(@PathVariable String noEtudiantNat, @RequestBody Diplome updatedDiplome) {
        try {
            Diplome updated = diplomeService.updateDiplome(noEtudiantNat, updatedDiplome);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    // DELETE diplome by noEtudiantNat
    @DeleteMapping("/{noEtudiantNat}")
    public ResponseEntity<?> deleteDiplome(@PathVariable String noEtudiantNat) {
        try {
            diplomeService.deleteDiplome(noEtudiantNat);
            return ResponseEntity.ok("Diplome with ID \"" + noEtudiantNat + "\" deleted successfully.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
