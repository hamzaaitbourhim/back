// NotationStageController.java
package com.csa.csaback.controller;

import com.csa.csaback.model.NotationStage;
import com.csa.csaback.service.NotationStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notation-stages")
public class NotationStageController {

    private final NotationStageService notationStageService;

    @Autowired
    public NotationStageController(NotationStageService notationStageService) {
        this.notationStageService = notationStageService;
    }

    // CREATE notation stage
    @PostMapping
    public ResponseEntity<?> createNotationStage(@RequestBody NotationStage notationStage) {
        try {
            return ResponseEntity.ok(notationStageService.createNotationStage(notationStage));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    // GET all notation stages
    @GetMapping
    public ResponseEntity<List<NotationStage>> getAllNotationStages() {
        List<NotationStage> notationStages = notationStageService.getAllNotationStages();
        return new ResponseEntity<>(notationStages, HttpStatus.OK);
    }

    // UPDATE notation stage by id
    @PutMapping("/{id}")
    public ResponseEntity<?> updateNotationStage(@PathVariable Double id, @RequestBody NotationStage updatedNotationStage) {
        try {
            NotationStage updated = notationStageService.updateNotationStage(id, updatedNotationStage);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    // DELETE notation stage by id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNotationStage(@PathVariable Double id) {
        try {
            notationStageService.deleteNotationStage(id);
            return ResponseEntity.ok("NotationStage with ID \"" + id + "\" deleted successfully.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
