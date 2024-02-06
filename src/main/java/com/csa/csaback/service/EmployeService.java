// EmployeService.java
package com.csa.csaback.service;

import com.csa.csaback.model.Employe;
import com.csa.csaback.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeService {

    private final EmployeRepository employeRepository;

    @Autowired
    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    // CREATE operation
    public Employe createEmploye(Employe employe) {
        Double noContactIli = employe.getNoContactIli();

        if (noContactIli == null) {
            throw new RuntimeException("Employe ID cannot be null");
        }

        Optional<Employe> existingEmploye = employeRepository.findById(noContactIli);

        if (existingEmploye.isPresent()) {
            throw new RuntimeException("Employe with ID " + noContactIli + " already exists");
        } else {
            return employeRepository.save(employe);
        }
    }

    // READ operation
    public List<Employe> getAllEmployes() {
        return StreamSupport
                .stream(employeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    // UPDATE operation
    public Employe updateEmploye(Double noContactIli, Employe updatedEmploye) {
        Optional<Employe> existingEmployeOptional = employeRepository.findById(noContactIli);

        if (existingEmployeOptional.isPresent()) {
            Employe existingEmploye = existingEmployeOptional.get();
            // Update all fields using the values from updatedEmploye
            existingEmploye.setFonction(updatedEmploye.getFonction());
            existingEmploye.setMailPro(updatedEmploye.getMailPro());
            existingEmploye.setNom(updatedEmploye.getNom());
            existingEmploye.setPrenom(updatedEmploye.getPrenom());
            existingEmploye.setTelPro(updatedEmploye.getTelPro());
            existingEmploye.setEntreprise(updatedEmploye.getEntreprise());
            existingEmploye.setDiplome(updatedEmploye.getDiplome());

            return employeRepository.save(existingEmploye);
        } else {
            throw new RuntimeException("Employe not found with ID: " + noContactIli);
        }
    }

    // DELETE operation
    public void deleteEmploye(Double noContactIli) {
        Optional<Employe> employe = employeRepository.findById(noContactIli);

        if (employe.isPresent()) {
            employeRepository.deleteById(noContactIli);
        } else {
            throw new RuntimeException("Employe not found with ID: " + noContactIli);
        }
    }
}
