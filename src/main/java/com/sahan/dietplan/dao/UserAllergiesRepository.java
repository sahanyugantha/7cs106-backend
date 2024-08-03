package com.sahan.dietplan.dao;

import com.sahan.dietplan.model.UserAllergies;
import com.sahan.dietplan.model.UserAllergiesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAllergiesRepository extends JpaRepository<UserAllergies, UserAllergiesId> {
    List<UserAllergies> findByIdTblProfileId(Integer tblProfileId);
}
