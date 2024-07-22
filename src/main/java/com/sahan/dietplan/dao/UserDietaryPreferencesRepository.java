package com.sahan.dietplan.dao;

import com.sahan.dietplan.model.UserDietaryPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDietaryPreferencesRepository extends JpaRepository<UserDietaryPreferences, UserDietaryPreferences.UserDietaryPreferencesId> {

}
