package com.sahan.dietplan.service;

import com.sahan.dietplan.dao.DailyConsumptionRepository;
import com.sahan.dietplan.dao.UserRepository;
import com.sahan.dietplan.model.DailyConsumption;
import com.sahan.dietplan.model.NutritionalInfo;
import com.sahan.dietplan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DailyConsumptionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DailyConsumptionRepository dailyConsumptionRepository;

    public DailyConsumption addDailyConsumption(DailyConsumption dailyConsumption) {
        return dailyConsumptionRepository.save(dailyConsumption);
    }

    public void addManualCalorieEntry(Integer userId, BigDecimal manualCalories) {
        LocalDate date = LocalDate.now();
        List<DailyConsumption> dailyConsumptions = dailyConsumptionRepository.findByUserIdAndDate(userId, date);

        Optional<User> user = userRepository.findById(userId);

        if (dailyConsumptions.isEmpty() && user.isPresent()) {
            DailyConsumption dailyConsumption = new DailyConsumption();
            dailyConsumption.setUser(user.get());
            dailyConsumption.setDate(date);
            dailyConsumption.setQuantity(BigDecimal.ZERO);
            dailyConsumption.setManualCalories(manualCalories);
            dailyConsumptionRepository.save(dailyConsumption);
        } else if (!dailyConsumptions.isEmpty()) {
            DailyConsumption dailyConsumption = dailyConsumptions.get(0);
            dailyConsumption.setManualCalories(dailyConsumption.getManualCalories().add(manualCalories));
            dailyConsumptionRepository.save(dailyConsumption);
        }
    }

    public void addMealCalories(Integer userId, BigDecimal breakfastCalories, BigDecimal lunchCalories, BigDecimal dinnerCalories, BigDecimal otherCalories) {
        LocalDate date = LocalDate.now();
        List<DailyConsumption> dailyConsumptions = dailyConsumptionRepository.findByUserIdAndDate(userId, date);

        Optional<User> user = userRepository.findById(userId);

        if (dailyConsumptions.isEmpty() && user.isPresent()) {
            DailyConsumption dailyConsumption = new DailyConsumption();
            dailyConsumption.setUser(user.get());
            dailyConsumption.setDate(date);
            dailyConsumption.setQuantity(BigDecimal.ZERO);
            dailyConsumption.setManualCalories(BigDecimal.ZERO);
            dailyConsumption.setBreakfastCalories(breakfastCalories != null ? breakfastCalories : BigDecimal.ZERO);
            dailyConsumption.setLunchCalories(lunchCalories != null ? lunchCalories : BigDecimal.ZERO);
            dailyConsumption.setDinnerCalories(dinnerCalories != null ? dinnerCalories : BigDecimal.ZERO);
            dailyConsumption.setOtherCalories(otherCalories != null ? otherCalories : BigDecimal.ZERO);

            dailyConsumptionRepository.save(dailyConsumption);
        } else if (!dailyConsumptions.isEmpty()) {
            DailyConsumption dailyConsumption = dailyConsumptions.get(0);
            if (breakfastCalories != null) {
               // dailyConsumption.setBreakfastCalories(dailyConsumption.getBreakfastCalories().add(breakfastCalories));
                dailyConsumption.setBreakfastCalories(breakfastCalories);
            }
            if (lunchCalories != null) {
                //dailyConsumption.setLunchCalories(dailyConsumption.getLunchCalories().add(lunchCalories));
                dailyConsumption.setLunchCalories(lunchCalories);
            }
            if (dinnerCalories != null) {
                //dailyConsumption.setDinnerCalories(dailyConsumption.getDinnerCalories().add(dinnerCalories));
                dailyConsumption.setDinnerCalories(dinnerCalories);
            }
            if (otherCalories != null) {
                //dailyConsumption.setOtherCalories(dailyConsumption.getOtherCalories().add(otherCalories));
                dailyConsumption.setOtherCalories(otherCalories);
            }

            dailyConsumptionRepository.save(dailyConsumption);
        }
    }

    public List<DailyConsumption> getDailyConsumptionByUser(Integer userId) {
        return dailyConsumptionRepository.findByUserId(userId);
    }
}
