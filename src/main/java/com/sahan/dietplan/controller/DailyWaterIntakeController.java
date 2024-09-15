package com.sahan.dietplan.controller;

import com.sahan.dietplan.model.DailyWaterIntake;
import com.sahan.dietplan.service.DailyWaterIntakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/water-intake")
public class DailyWaterIntakeController {

    @Autowired
    private DailyWaterIntakeService dailyWaterIntakeService;

    @PostMapping
    public ResponseEntity<DailyWaterIntake> addDailyWaterIntake(@RequestBody DailyWaterIntake dailyWaterIntake) {
        DailyWaterIntake savedIntake = dailyWaterIntakeService.addDailyWaterIntake(dailyWaterIntake);
        return ResponseEntity.ok(savedIntake);
    }

    @GetMapping("/{userId}/{date}")
    public ResponseEntity<DailyWaterIntake> getDailyWaterIntake(@PathVariable Integer userId, @PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        DailyWaterIntake intake = dailyWaterIntakeService.getDailyWaterIntake(userId, localDate);
        return intake != null ? ResponseEntity.ok(intake) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<DailyWaterIntake>> getDailyWaterIntakeByUser(@PathVariable Integer userId) {
        List<DailyWaterIntake> intakes = dailyWaterIntakeService.getDailyWaterIntakeByUser(userId);
        return ResponseEntity.ok(intakes);
    }
}
