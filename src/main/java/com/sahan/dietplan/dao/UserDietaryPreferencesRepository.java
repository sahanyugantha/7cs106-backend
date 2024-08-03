package com.sahan.dietplan.dao;

import com.sahan.dietplan.model.UserDietaryPreferences;
import com.sahan.dietplan.model.UserDietaryPreferencesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDietaryPreferencesRepository extends JpaRepository<UserDietaryPreferences, UserDietaryPreferencesId> {
    List<UserDietaryPreferences> findByIdTblProfileId(int tblProfileId);
}
