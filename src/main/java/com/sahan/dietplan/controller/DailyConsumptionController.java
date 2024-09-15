package com.sahan.dietplan.controller;

import com.sahan.dietplan.dao.UserRepository;
import com.sahan.dietplan.model.DailyConsumption;
import com.sahan.dietplan.model.DailyWaterIntake;
import com.sahan.dietplan.model.MealCaloriesRequest;
import com.sahan.dietplan.model.User;
import com.sahan.dietplan.service.DailyConsumptionService;
import com.sahan.dietplan.service.DailyWaterIntakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/daily-consumption")
public class DailyConsumptionController {

    @Autowired
    private DailyConsumptionService dailyConsumptionService;

    @Autowired
    private DailyWaterIntakeService dailyWaterIntakeService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<DailyConsumption> addDailyConsumption(@RequestBody DailyConsumption dailyConsumption) {
        DailyConsumption savedConsumption = dailyConsumptionService.addDailyConsumption(dailyConsumption);
        return ResponseEntity.ok(savedConsumption);
    }

    @PostMapping("/{userId}/manual-calories")
    public ResponseEntity<String> addManualCalorieEntry(@PathVariable Integer userId, @RequestParam BigDecimal manualCalories) {
        dailyConsumptionService.addManualCalorieEntry(userId, manualCalories);
        return ResponseEntity.ok("Manual calorie entry added successfully.");
    }

    @PostMapping("/{userId}/meal-calories")
    public ResponseEntity<Map<String,String>> addMealCalories(@PathVariable Integer userId,
                                                  @RequestBody MealCaloriesRequest mealCaloriesRequest) {
        dailyConsumptionService.addMealCalories(
                userId,
                mealCaloriesRequest.getBreakfastCalories(),
                mealCaloriesRequest.getLunchCalories(),
                mealCaloriesRequest.getDinnerCalories(),
                mealCaloriesRequest.getOtherCalories()
        );
        Map<String, String> msg = new HashMap<>();
        msg.put("MESSAGE", "Meal calories entry added successfully.");
        return ResponseEntity.ok(msg);
    }

    @PostMapping("/{userId}/water-intake")
    public ResponseEntity<Map<String, String>> addWater(@PathVariable Integer userId,
                                                        @RequestBody Map<String, BigDecimal> requestBody) {
        BigDecimal waterIntake = requestBody.get("waterIntake");

        if (waterIntake == null) {
            Map<String, String> msg = new HashMap<>();
            msg.put("MESSAGE", "Water intake amount is required.");
            return ResponseEntity.badRequest().body(msg);
        }

        LocalDate today = LocalDate.now();
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            // Check if a record for today already exists
            DailyWaterIntake existingRecord = dailyWaterIntakeService.findByUserIdAndDate(userId, today);

            DailyWaterIntake dailyWaterIntake;

            if (existingRecord == null) {
                dailyWaterIntake = new DailyWaterIntake();
                dailyWaterIntake.setDate(today);
                dailyWaterIntake.setUser(user.get());
            } else {
                dailyWaterIntake = existingRecord;
            }

            dailyWaterIntake.setAmount(waterIntake);
            dailyWaterIntakeService.addDailyWaterIntake(dailyWaterIntake);

            Map<String, String> msg = new HashMap<>();
            msg.put("MESSAGE", "Water intake entry updated successfully.");
            return ResponseEntity.ok(msg);
        } else {
            Map<String, String> msg = new HashMap<>();
            msg.put("MESSAGE", "User not found.");
            return ResponseEntity.badRequest().body(msg);
        }
    }



    @GetMapping("/{userId}")
    public ResponseEntity<List<DailyConsumption>> getDailyConsumptionByUser(@PathVariable Integer userId) {
        List<DailyConsumption> dailyConsumptions = dailyConsumptionService.getDailyConsumptionByUser(userId);
        return ResponseEntity.ok(dailyConsumptions);
    }
}
