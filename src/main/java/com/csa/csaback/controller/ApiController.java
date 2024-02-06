package com.csa.csaback.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping
    public ResponseEntity<Map<String, Object>> apiInfo() {
        Map<String, Object> response = new HashMap<>();

        response.put("apiName", "UBO API");
        response.put("apiVersion", "1.0");
        response.put("status", "OK");
        response.put("message", "Hello, World! This is the UBO API version 1.0 for managing UBO data");
        response.put("contact", "ubo-api-support@example.com");
        response.put("apiStatus", "Operational");
        response.put("statusMessage", "API is running smoothly");

        // Links to resources with CRUD descriptions
        Map<String, Map<String, String>> resourceLinks = new HashMap<>();

        // Formations
        Map<String, String> formationLinks = new HashMap<>();
        formationLinks.put("create", "/api/formations (POST)");
        formationLinks.put("read", "/api/formations (GET)");
        formationLinks.put("update", "/api/formations/{id} (PUT)");
        formationLinks.put("delete", "/api/formations/{id} (DELETE)");
        resourceLinks.put("formations", formationLinks);

        // Promotions
        Map<String, String> promotionLinks = new HashMap<>();
        promotionLinks.put("create", "/api/promotions (POST)");
        promotionLinks.put("read", "/api/promotions (GET)");
        promotionLinks.put("update", "/api/promotions/{id} (PUT)");
        promotionLinks.put("delete", "/api/promotions/{id} (DELETE)");
        resourceLinks.put("promotions", promotionLinks);

        // Etudiants
        Map<String, String> etudiantLinks = new HashMap<>();
        etudiantLinks.put("create", "/api/etudiants (POST)");
        etudiantLinks.put("read", "/api/etudiants (GET)");
        etudiantLinks.put("update", "/api/etudiants/{id} (PUT)");
        etudiantLinks.put("delete", "/api/etudiants/{id} (DELETE)");
        resourceLinks.put("etudiants", etudiantLinks);

        response.put("resourceLinks", resourceLinks);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
