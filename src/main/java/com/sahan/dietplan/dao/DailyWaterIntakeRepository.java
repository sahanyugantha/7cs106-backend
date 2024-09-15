package com.sahan.dietplan.dao;

import com.sahan.dietplan.model.DailyWaterIntake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DailyWaterIntakeRepository extends JpaRepository<DailyWaterIntake, Integer> {
    DailyWaterIntake findByUserIdAndDate(Integer userId, LocalDate date);
    List<DailyWaterIntake> findByUserId(Integer userId);
   // List<DailyWaterIntake> findByUserIdAndDate(Integer userId, LocalDate date);
}
