package com.sahan.dietplan.dao;

import com.sahan.dietplan.model.DailyConsumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DailyConsumptionRepository extends JpaRepository<DailyConsumption, Integer> {
    List<DailyConsumption> findByUserIdAndDate(Integer userId, LocalDate date);
    List<DailyConsumption> findByUserId(Integer userId);
}
