// EmployeController.java
package com.csa.csaback.controller;

import com.csa.csaback.model.Employe;
import com.csa.csaback.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {

    private final EmployeService employeService;

    @Autowired
    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    // CREATE employe
    @PostMapping
    public ResponseEntity<?> createEmploye(@RequestBody Employe employe) {
        try {
            return ResponseEntity.ok(employeService.createEmploye(employe));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    // GET all employes
    @GetMapping
    public ResponseEntity<List<Employe>> getAllEmployes() {
        List<Employe> employes = employeService.getAllEmployes();
        return new ResponseEntity<>(employes, HttpStatus.OK);
    }

    // UPDATE employe by noContactIli
    @PutMapping("/{noContactIli}")
    public ResponseEntity<?> updateEmploye(@PathVariable Double noContactIli, @RequestBody Employe updatedEmploye) {
        try {
            Employe updated = employeService.updateEmploye(noContactIli, updatedEmploye);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    // DELETE employe by noContactIli
    @DeleteMapping("/{noContactIli}")
    public ResponseEntity<?> deleteEmploye(@PathVariable Double noContactIli) {
        try {
            employeService.deleteEmploye(noContactIli);
            return ResponseEntity.ok("Employe with ID \"" + noContactIli + "\" deleted successfully.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
