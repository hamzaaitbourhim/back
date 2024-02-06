// ElementConstitutifService.java
package com.csa.csaback.service;

import com.csa.csaback.model.ElementConstitutif;
import com.csa.csaback.model.ElementConstitutifId;
import com.csa.csaback.repository.ElementConstitutifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ElementConstitutifService {

    private final ElementConstitutifRepository elementConstitutifRepository;

    @Autowired
    public ElementConstitutifService(ElementConstitutifRepository elementConstitutifRepository) {
        this.elementConstitutifRepository = elementConstitutifRepository;
    }

    // CREATE operation
    public ElementConstitutif createElementConstitutif(ElementConstitutif elementConstitutif) {
        ElementConstitutifId id = elementConstitutif.getId();
        if (id == null || id.getCodeEc() == null || id.getCodeUe() == null || id.getCodeFormation() == null) {
            throw new IllegalArgumentException("ElementConstitutif ID cannot be null");
        }

        Optional<ElementConstitutif> existingElementConstitutif = elementConstitutifRepository.findById(id);
        if (existingElementConstitutif.isPresent()) {
            throw new RuntimeException("ElementConstitutif with ID " + id + " already exists");
        }

        return elementConstitutifRepository.save(elementConstitutif);
    }

    // READ operation
    public List<ElementConstitutif> getAllElementConstitutifs() {
        return StreamSupport
                .stream(elementConstitutifRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    // UPDATE operation
    public ElementConstitutif updateElementConstitutif(ElementConstitutif elementConstitutif) {
        ElementConstitutifId id = elementConstitutif.getId();
        if (id == null || id.getCodeEc() == null || id.getCodeUe() == null || id.getCodeFormation() == null) {
            throw new IllegalArgumentException("ElementConstitutif ID cannot be null");
        }

        Optional<ElementConstitutif> existingElementConstitutif = elementConstitutifRepository.findById(id);
        if (!existingElementConstitutif.isPresent()) {
            throw new RuntimeException("ElementConstitutif not found with ID: " + id);
        }

        return elementConstitutifRepository.save(elementConstitutif);
    }

    // DELETE operation
    public void deleteElementConstitutif(String codeEc, String codeUe, String codeFormation) {
        ElementConstitutifId id = new ElementConstitutifId(codeEc, codeUe, codeFormation);
        elementConstitutifRepository.deleteById(id);
    }
}
