package com.sahan.dietplan.model;

import java.math.BigDecimal;

public class MealCaloriesRequest {
    private BigDecimal breakfastCalories;
    private BigDecimal lunchCalories;
    private BigDecimal dinnerCalories;
    private BigDecimal otherCalories;

    // Getters and Setters
    public BigDecimal getBreakfastCalories() {
        return breakfastCalories;
    }

    public void setBreakfastCalories(BigDecimal breakfastCalories) {
        this.breakfastCalories = breakfastCalories;
    }

    public BigDecimal getLunchCalories() {
        return lunchCalories;
    }

    public void setLunchCalories(BigDecimal lunchCalories) {
        this.lunchCalories = lunchCalories;
    }

    public BigDecimal getDinnerCalories() {
        return dinnerCalories;
    }

    public void setDinnerCalories(BigDecimal dinnerCalories) {
        this.dinnerCalories = dinnerCalories;
    }

    public BigDecimal getOtherCalories() {
        return otherCalories;
    }

    public void setOtherCalories(BigDecimal otherCalories) {
        this.otherCalories = otherCalories;
    }
}
