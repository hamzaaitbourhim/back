package com.csa.csaback.repository;

import com.csa.csaback.model.Employe;
import org.springframework.data.repository.CrudRepository;

public interface EmployeRepository extends CrudRepository<Employe, Double> {
}