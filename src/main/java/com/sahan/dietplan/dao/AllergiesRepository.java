package com.sahan.dietplan.dao;

import com.sahan.dietplan.model.Allergies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllergiesRepository extends JpaRepository<Allergies, Integer> {
}
