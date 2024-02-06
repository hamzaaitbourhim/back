// PromotionController.java
package com.csa.csaback.controller;

import com.csa.csaback.model.Promotion;
import com.csa.csaback.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promotions")
public class PromotionController {

    private final PromotionService promotionService;

    @Autowired
    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    // CREATE promotion
    @PostMapping
    public ResponseEntity<?> createPromotion(@RequestBody Promotion promotion) {
        try {
            return ResponseEntity.ok(promotionService.createPromotion(promotion));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    // GET all promotions
    @GetMapping
    public ResponseEntity<List<Promotion>> getAllPromotions() {
        List<Promotion> promotions = promotionService.getAllPromotions();
        return new ResponseEntity<>(promotions, HttpStatus.OK);
    }

    // UPDATE promotion by anneePro
    @PutMapping("/{anneePro}")
    public ResponseEntity<?> updatePromotion(@PathVariable String anneePro, @RequestBody Promotion updatedPromotion) {
        try {
            Promotion updated = promotionService.updatePromotion(anneePro, updatedPromotion);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    // DELETE promotion by anneePro
    @DeleteMapping("/{anneePro}")
    public ResponseEntity<?> deletePromotion(@PathVariable String anneePro) {
        try {
            promotionService.deletePromotion(anneePro);
            return ResponseEntity.ok("Promotion with year \"" + anneePro + "\" deleted successfully.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
