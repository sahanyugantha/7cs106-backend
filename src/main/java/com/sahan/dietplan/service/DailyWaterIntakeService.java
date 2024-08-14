package com.sahan.dietplan.service;

import com.sahan.dietplan.dao.DailyWaterIntakeRepository;
import com.sahan.dietplan.dao.UserRepository;
import com.sahan.dietplan.model.DailyWaterIntake;
import com.sahan.dietplan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class DailyWaterIntakeService {

    @Autowired
    private DailyWaterIntakeRepository dailyWaterIntakeRepository;

    @Autowired
    private UserRepository userRepository;

    public DailyWaterIntake addDailyWaterIntake(DailyWaterIntake dailyWaterIntake) {
        return dailyWaterIntakeRepository.save(dailyWaterIntake);
    }

    public DailyWaterIntake getDailyWaterIntake(Integer userId, LocalDate date) {
        return dailyWaterIntakeRepository.findByUserIdAndDate(userId, date);
    }

    public List<DailyWaterIntake> getDailyWaterIntakeByUser(Integer userId) {
        return dailyWaterIntakeRepository.findByUserId(userId);
    }
}
