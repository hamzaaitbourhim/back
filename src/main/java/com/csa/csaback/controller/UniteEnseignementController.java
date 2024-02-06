// UniteEnseignementController.java
package com.csa.csaback.controller;

import com.csa.csaback.model.UniteEnseignement;
import com.csa.csaback.service.UniteEnseignementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unite-enseignements")
public class UniteEnseignementController {

    private final UniteEnseignementService uniteEnseignementService;

    @Autowired
    public UniteEnseignementController(UniteEnseignementService uniteEnseignementService) {
        this.uniteEnseignementService = uniteEnseignementService;
    }

    // CREATE operation
    @PostMapping
    public ResponseEntity<?> createUniteEnseignement(@RequestBody UniteEnseignement uniteEnseignement) {
        try {
            return ResponseEntity.ok(uniteEnseignementService.createUniteEnseignement(uniteEnseignement));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    // READ operation
    @GetMapping
    public ResponseEntity<List<UniteEnseignement>> getAllUniteEnseignements() {
        List<UniteEnseignement> uniteEnseignements = uniteEnseignementService.getAllUniteEnseignements();
        return new ResponseEntity<>(uniteEnseignements, HttpStatus.OK);
    }

    // UPDATE operation
    @PutMapping("/{codeUe}")
    public ResponseEntity<?> updateUniteEnseignement(@PathVariable String codeUe, @RequestBody UniteEnseignement updatedUniteEnseignement) {
        try {
            UniteEnseignement updated = uniteEnseignementService.updateUniteEnseignement(codeUe, updatedUniteEnseignement);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    // DELETE operation
    @DeleteMapping("/{codeUe}")
    public ResponseEntity<?> deleteUniteEnseignement(@PathVariable String codeUe) {
        try {
            uniteEnseignementService.deleteUniteEnseignement(codeUe);
            return ResponseEntity.ok("Unite Enseignement with codeUe \"" + codeUe + "\" deleted successfully.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
