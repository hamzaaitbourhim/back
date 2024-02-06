package com.csa.csaback.controller;

import com.csa.csaback.model.Formation;
import com.csa.csaback.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formations")
public class FormationController {

    private final FormationService formationService;

    @Autowired
    public FormationController(FormationService formationService) {
        this.formationService = formationService;
    }


    // CREATE formation
    @PostMapping
    public ResponseEntity<?> createFormation(@RequestBody Formation formation) {

        try {
            return ResponseEntity.ok(this.formationService.createFormation(formation));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    // GET all formations
    @GetMapping
    public ResponseEntity<List<Formation>> getAllFormations() {
        List<Formation> formations = formationService.getAllFormations();
        return new ResponseEntity<>(formations, HttpStatus.OK);
    }

    // UPDATE formation by code
    @PutMapping("/{codeFormation}")
    public ResponseEntity<?> updateFormation(@PathVariable String codeFormation, @RequestBody Formation updatedFormation) {
        try {
            Formation updated = formationService.updateFormation(codeFormation, updatedFormation);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }


    // DELETE formation by codeFormation
    @DeleteMapping("/{codeFormation}")
    public ResponseEntity<?> deleteFormation(@PathVariable String codeFormation) {
        try {
            formationService.deleteFormation(codeFormation);
            return ResponseEntity.ok("Formation with code \"" + codeFormation + "\" deleted successfully.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }


}
