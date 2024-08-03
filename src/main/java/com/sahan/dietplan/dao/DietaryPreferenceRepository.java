package com.sahan.dietplan.dao;

import com.sahan.dietplan.model.DietaryPreference;
import com.sahan.dietplan.model.UserDietaryPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DietaryPreferenceRepository extends JpaRepository<DietaryPreference, Integer> {
   // List<UserDietaryPreferences> findByProfileId(Integer profileId);
}
