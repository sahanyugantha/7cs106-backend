package com.sahan.dietplan.service;

import com.sahan.dietplan.dao.DailyConsumptionRepository;
import com.sahan.dietplan.dao.UserRepository;
import com.sahan.dietplan.model.DailyConsumption;
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
            // If there are no existing records for today, create a new one
            DailyConsumption dailyConsumption = new DailyConsumption();
            dailyConsumption.setUser(user.get());
            dailyConsumption.setDate(date);
            dailyConsumption.setQuantity(BigDecimal.ZERO); // Assuming no food is associated
            dailyConsumption.setManualCalories(manualCalories);
            dailyConsumptionRepository.save(dailyConsumption);
        } else {
            // If there are existing records for today, update the manual calories for the first one
            DailyConsumption dailyConsumption = dailyConsumptions.get(0);
            dailyConsumption.setManualCalories(dailyConsumption.getManualCalories().add(manualCalories));
            dailyConsumptionRepository.save(dailyConsumption);
        }
    }

    public List<DailyConsumption> getDailyConsumptionByUser(Integer userId) {
        return dailyConsumptionRepository.findByUserId(userId);
    }
}
