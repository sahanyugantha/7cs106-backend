package com.sahan.dietplan.dao;

import com.sahan.dietplan.model.DietaryPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietaryPreferenceRepository extends JpaRepository<DietaryPreference, Integer> {
}
