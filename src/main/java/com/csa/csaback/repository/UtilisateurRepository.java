package com.csa.csaback.repository;

import com.csa.csaback.model.Utilisateur;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {

    Optional<Utilisateur> findByNomUtilisateur(String nomUtilisateur);

}