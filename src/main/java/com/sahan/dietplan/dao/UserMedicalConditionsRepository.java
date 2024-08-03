package com.sahan.dietplan.dao;

import com.sahan.dietplan.model.UserMedicalConditions;
import com.sahan.dietplan.model.UserMedicalConditionsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMedicalConditionsRepository extends JpaRepository<UserMedicalConditions, UserMedicalConditionsId> {
    List<UserMedicalConditions> findByIdTblProfileId(int tblProfileId);
}
