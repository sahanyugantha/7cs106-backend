package com.sahan.dietplan.dao;

import com.sahan.dietplan.model.UserAllergies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAllergiesRepository extends JpaRepository<UserAllergies, UserAllergies.UserAllergiesId> {
    UserAllergies findByProfileIdAndAllergiesId(Integer profileId, Integer allergiesId);
}
