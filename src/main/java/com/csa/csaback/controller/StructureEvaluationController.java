// StructureEvaluationController.java
package com.csa.csaback.controller;

import com.csa.csaback.model.StructureEvaluation;
import com.csa.csaback.service.StructureEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/structure-evaluations")
public class StructureEvaluationController {

    private final StructureEvaluationService structureEvaluationService;

    @Autowired
    public StructureEvaluationController(StructureEvaluationService structureEvaluationService) {
        this.structureEvaluationService = structureEvaluationService;
    }

    // CREATE structure evaluation
    @PostMapping
    public ResponseEntity<?> createStructureEvaluation(@RequestBody StructureEvaluation structureEvaluation) {
        try {
            return ResponseEntity.ok(structureEvaluationService.createStructureEvaluation(structureEvaluation));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    // GET all structure evaluations
    @GetMapping
    public ResponseEntity<List<StructureEvaluation>> getAllStructureEvaluations() {
        List<StructureEvaluation> structureEvaluations = structureEvaluationService.getAllStructureEvaluations();
        return new ResponseEntity<>(structureEvaluations, HttpStatus.OK);
    }

    // UPDATE structure evaluation by id
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStructureEvaluation(@PathVariable Double id, @RequestBody StructureEvaluation updatedStructureEvaluation) {
        try {
            StructureEvaluation updated = structureEvaluationService.updateStructureEvaluation(id, updatedStructureEvaluation);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    // DELETE structure evaluation by id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStructureEvaluation(@PathVariable Double id) {
        try {
            structureEvaluationService.deleteStructureEvaluation(id);
            return ResponseEntity.ok("StructureEvaluation with ID \"" + id + "\" deleted successfully.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
