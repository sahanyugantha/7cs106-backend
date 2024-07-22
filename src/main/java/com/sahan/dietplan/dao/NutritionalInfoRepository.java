package com.sahan.dietplan.dao;

import com.sahan.dietplan.model.NutritionalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionalInfoRepository extends JpaRepository<NutritionalInfo, Integer> {
}
