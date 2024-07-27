package com.sahan.dietplan.dao;

import com.sahan.dietplan.model.UserMedicalConditions;
import com.sahan.dietplan.model.UserMedicalConditions.UserMedicalConditionsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMedicalConditionsRepository extends JpaRepository<UserMedicalConditions, UserMedicalConditionsId> {
    UserMedicalConditions findByIdTblProfileIdAndIdTblMedicalConditionsId(Integer tblProfileId, Integer tblMedicalConditionsId);
}
