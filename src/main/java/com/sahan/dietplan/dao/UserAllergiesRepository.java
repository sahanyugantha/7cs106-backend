package com.sahan.dietplan.dao;

import com.sahan.dietplan.model.UserAllergies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAllergiesRepository extends JpaRepository<UserAllergies, UserAllergies.UserAllergiesId> {}
