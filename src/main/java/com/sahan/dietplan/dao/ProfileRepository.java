package com.sahan.dietplan.dao;

import com.sahan.dietplan.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Profile findByTblUserId(Integer tblUserId);
}
