package com.sahan.dietplan.model;

import java.math.BigDecimal;
import java.util.List;

public class RecommendationResponse {
    private List<NutritionalInfo> recommendedFoods;
    private BigDecimal caloriesConsumed;
    private BigDecimal caloriesLeft;
    private BigDecimal waterConsumed;
    private BigDecimal waterLeft;
    private BigDecimal caloriesToBurn;
    private BigDecimal caloriesGoal;
    private BigDecimal waterGoal;
    private String username;
    private float height;
    private float weight;
    private BigDecimal breakfastCalories;
    private BigDecimal lunchCalories;
    private BigDecimal dinnerCalories;
    private BigDecimal otherCalories;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
// Getters and Setters

    public List<NutritionalInfo> getRecommendedFoods() {
        return recommendedFoods;
    }

    public void setRecommendedFoods(List<NutritionalInfo> recommendedFoods) {
        this.recommendedFoods = recommendedFoods;
    }

    public BigDecimal getCaloriesConsumed() {
        return caloriesConsumed;
    }

    public void setCaloriesConsumed(BigDecimal caloriesConsumed) {
        this.caloriesConsumed = caloriesConsumed;
    }

    public BigDecimal getCaloriesLeft() {
        return caloriesLeft;
    }

    public void setCaloriesLeft(BigDecimal caloriesLeft) {
        this.caloriesLeft = caloriesLeft;
    }

    public BigDecimal getWaterConsumed() {
        return waterConsumed;
    }

    public void setWaterConsumed(BigDecimal waterConsumed) {
        this.waterConsumed = waterConsumed;
    }

    public BigDecimal getWaterLeft() {
        return waterLeft;
    }

    public void setWaterLeft(BigDecimal waterLeft) {
        this.waterLeft = waterLeft;
    }

    public BigDecimal getCaloriesToBurn() {
        return caloriesToBurn;
    }

    public void setCaloriesToBurn(BigDecimal caloriesToBurn) {
        this.caloriesToBurn = caloriesToBurn;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public BigDecimal getCaloriesGoal() {
        return caloriesGoal;
    }

    public void setCaloriesGoal(BigDecimal caloriesGoal) {
        this.caloriesGoal = caloriesGoal;
    }

    public BigDecimal getWaterGoal() {
        return waterGoal;
    }

    public void setWaterGoal(BigDecimal waterGoal) {
        this.waterGoal = waterGoal;
    }

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
