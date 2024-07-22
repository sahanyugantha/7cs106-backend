package com.sahan.dietplan.dao;

import com.sahan.dietplan.model.MedicalConditions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalConditionsRepository extends JpaRepository<MedicalConditions, Integer> {
}

