package com.csa.csaback.service;

import com.csa.csaback.model.Promotion;
import com.csa.csaback.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PromotionService {

    private final PromotionRepository promotionRepository;

    @Autowired
    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    // CREATE operation
    public Promotion createPromotion(Promotion promotion) {
        String anneePro = promotion.getAnneePro();

        if (anneePro == null) {
            throw new RuntimeException("anneePro cannot be null");
        }

        Optional<Promotion> existingPromotion = promotionRepository.findById(anneePro);

        if (existingPromotion.isPresent()) {
            throw new RuntimeException("Promotion with year " + anneePro + " already exists");
        } else {
            return promotionRepository.save(promotion);
        }
    }

    // READ operation
    public List<Promotion> getAllPromotions() {
        return StreamSupport
                .stream(promotionRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    // UPDATE operation
    public Promotion updatePromotion(String anneePro, Promotion updatedPromotion) {
        Optional<Promotion> existingPromotionOptional = promotionRepository.findById(anneePro);

        if (existingPromotionOptional.isPresent()) {
            Promotion existingPromotion = existingPromotionOptional.get();

            // Update all fields using the values from updatedPromotion
            existingPromotion.setCommentaire(updatedPromotion.getCommentaire());
            existingPromotion.setDateRentree(updatedPromotion.getDateRentree());
            existingPromotion.setDateReponseLalp(updatedPromotion.getDateReponseLalp());
            existingPromotion.setDateReponseLp(updatedPromotion.getDateReponseLp());
            existingPromotion.setEtatPreselection(updatedPromotion.getEtatPreselection());
            existingPromotion.setLieuRentree(updatedPromotion.getLieuRentree());
            existingPromotion.setNbEtuSouhaite(updatedPromotion.getNbEtuSouhaite());
            existingPromotion.setProcessusStage(updatedPromotion.getProcessusStage());
            existingPromotion.setSiglePro(updatedPromotion.getSiglePro());
            existingPromotion.setFormation(updatedPromotion.getFormation());
            existingPromotion.setNotationStage(updatedPromotion.getNotationStage());
            existingPromotion.setEnseignant(updatedPromotion.getEnseignant());
            existingPromotion.setStructureEvaluation(updatedPromotion.getStructureEvaluation());

            return promotionRepository.save(existingPromotion);
        } else {
            throw new RuntimeException("Promotion not found with year: " + anneePro);
        }
    }

    // DELETE operation
    public void deletePromotion(String anneePro) {
        Optional<Promotion> promotion = promotionRepository.findById(anneePro);

        if (promotion.isPresent()) {
            promotionRepository.deleteById(anneePro);
        } else {
            throw new RuntimeException("Promotion not found with year: " + anneePro);
        }
    }
}
