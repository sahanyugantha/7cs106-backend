package com.sahan.dietplan.controller;

import com.sahan.dietplan.model.DailyConsumption;
import com.sahan.dietplan.model.MealCaloriesRequest;
import com.sahan.dietplan.service.DailyConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/daily-consumption")
public class DailyConsumptionController {

    @Autowired
    private DailyConsumptionService dailyConsumptionService;

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

    @GetMapping("/{userId}")
    public ResponseEntity<List<DailyConsumption>> getDailyConsumptionByUser(@PathVariable Integer userId) {
        List<DailyConsumption> dailyConsumptions = dailyConsumptionService.getDailyConsumptionByUser(userId);
        return ResponseEntity.ok(dailyConsumptions);
    }
}
