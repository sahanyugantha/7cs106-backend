package com.sahan.dietplan.dao;

import com.sahan.dietplan.model.UserAllergies;
import com.sahan.dietplan.model.UserAllergies.UserAllergiesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAllergiesRepository extends JpaRepository<UserAllergies, UserAllergiesId> {
    UserAllergies findByIdTblProfileIdAndIdTblAllergiesId(Integer tblProfileId, Integer tblAllergiesId);
}

