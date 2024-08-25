package com.sahan.dietplan.service;

import com.sahan.dietplan.dao.*;
import com.sahan.dietplan.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserDietaryPreferencesRepository userDietaryPreferencesRepository;

    @Autowired
    private UserMedicalConditionsRepository userMedicalConditionsRepository;

    @Autowired
    private UserAllergiesRepository userAllergiesRepository;

    @Autowired
    private NutritionalInfoRepository nutritionalInfoRepository;

    @Autowired
    private DailyConsumptionRepository dailyConsumptionRepository;

    @Autowired
    private DailyWaterIntakeRepository dailyWaterIntakeRepository;

    public RecommendationResponse generateDailyRecommendation(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new RuntimeException("User not found");
        }

        User userEntity = user.get(); // Get the User object
        Profile profile = profileRepository.findByTblUserId(userId);
        if (profile == null) {
            throw new RuntimeException("Profile not found for user id " + userId);
        }


        List<UserDietaryPreferences> dietaryPreferences = userDietaryPreferencesRepository.findByIdTblProfileId(profile.getId());
        List<UserMedicalConditions> medicalConditions = userMedicalConditionsRepository.findByIdTblProfileId(profile.getId());
        List<UserAllergies> allergies = userAllergiesRepository.findByIdTblProfileId(profile.getId());

        List<NutritionalInfo> allFoods = nutritionalInfoRepository.findAll();

        // Filter foods based on dietary preferences
        List<NutritionalInfo> preferredFoods = allFoods.stream()
                .filter(food -> matchesPreferences(food, dietaryPreferences))
                .collect(Collectors.toList());

        // Filter foods based on medical conditions
        List<NutritionalInfo> recommendedFoods = preferredFoods.stream()
                .filter(food -> matchesMedicalConditions(food, medicalConditions))
                .collect(Collectors.toList());

        // Exclude foods that match the user's allergies
        List<NutritionalInfo> finalRecommendations = recommendedFoods.stream()
                .filter(food -> !matchesAllergies(food, allergies))
                .collect(Collectors.toList());

        // Calculate the total calories consumed and left
        BigDecimal totalCaloriesConsumed = calculateTotalCaloriesConsumed(userId, LocalDate.now());
        BigDecimal dailyCaloricIntake = profile.getDailyCalorieGoal(); // Assume this is the user's daily caloric intake
        BigDecimal caloriesLeft = dailyCaloricIntake.subtract(totalCaloriesConsumed);
        BigDecimal caloriesToBurn = caloriesLeft.compareTo(BigDecimal.ZERO) < 0 ? caloriesLeft.negate() : BigDecimal.ZERO;

        // Calculate the total water consumed and left
        BigDecimal totalWaterConsumed = calculateTotalWaterConsumed(userId, LocalDate.now());
        BigDecimal dailyWaterIntake = profile.getDailyWaterGoal(); // Assume this is the user's daily water intake
        BigDecimal waterLeft = dailyWaterIntake.subtract(totalWaterConsumed);

        List<DailyConsumption> dailyConsumptions = dailyConsumptionRepository.findByUserIdAndDate(userId, LocalDate.now());

        BigDecimal breakfastCalories = BigDecimal.ZERO;
        BigDecimal lunchCalories = BigDecimal.ZERO;
        BigDecimal dinnerCalories = BigDecimal.ZERO;
        BigDecimal otherCalories = BigDecimal.ZERO;

        if (!dailyConsumptions.isEmpty()) {
            for (DailyConsumption consumption : dailyConsumptions) {
                breakfastCalories = breakfastCalories.add(consumption.getBreakfastCalories());
                lunchCalories = lunchCalories.add(consumption.getLunchCalories());
                dinnerCalories = dinnerCalories.add(consumption.getDinnerCalories());
                otherCalories = otherCalories.add(consumption.getOtherCalories());
            }
        }


        RecommendationResponse response = new RecommendationResponse();

        response.setCaloriesConsumed(totalCaloriesConsumed);
        response.setCaloriesLeft(caloriesLeft);
        response.setWaterConsumed(totalWaterConsumed);
        response.setWaterLeft(waterLeft);
        response.setCaloriesToBurn(caloriesToBurn);
        response.setUsername(userEntity.getName());

        response.setHeight(profile.getHeight());
        response.setWeight(profile.getWeight());
        response.setCaloriesGoal(profile.getDailyCalorieGoal());
        response.setWaterGoal(profile.getDailyWaterGoal());

        response.setBreakfastCalories(breakfastCalories);
        response.setLunchCalories(lunchCalories);
        response.setDinnerCalories(dinnerCalories);
        response.setOtherCalories(otherCalories);

        response.setRecommendedFoods(finalRecommendations);

        return response;
    }


//    private BigDecimal calculateTotalCaloriesConsumed(Integer userId, LocalDate date) {
//        List<DailyConsumption> dailyConsumptions = dailyConsumptionRepository.findByUserIdAndDate(userId, date);
//        BigDecimal totalCalories = dailyConsumptions.stream()
//                .map(consumption -> {
//                    BigDecimal foodCalories = consumption.getNutritionalInfo().getCalories().multiply(consumption.getQuantity());
//                    return foodCalories.add(consumption.getManualCalories());
//                })
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//        return totalCalories;
//    }

    private BigDecimal calculateTotalCaloriesConsumed(Integer userId, LocalDate date) {
        // Fetch the daily consumption record for the given user and date
        List<DailyConsumption> dailyConsumptions = dailyConsumptionRepository.findByUserIdAndDate(userId, date);

        if (dailyConsumptions.isEmpty()) {
            System.out.println("No daily consumptions found for user ID: " + userId + " and date: " + date);
            return BigDecimal.ZERO;
        }

        BigDecimal totalCalories = dailyConsumptions.stream()
                .map(consumption -> {
                    if (consumption.getNutritionalInfo() == null) {
                        // If no nutritional info, sum up the meal-specific calorie fields
                        return consumption.getBreakfastCalories()
                                .add(consumption.getLunchCalories())
                                .add(consumption.getDinnerCalories())
                                .add(consumption.getOtherCalories());
                    } else {
                        // If nutritional info exists, calculate based on quantity and add manual calories
                        BigDecimal foodCalories = consumption.getNutritionalInfo().getCalories().multiply(consumption.getQuantity());
                        System.out.println("Food Calories: " + foodCalories + " for consumption: " + consumption);
                        return foodCalories.add(consumption.getManualCalories());
                    }
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total Calories Consumed: " + totalCalories);
        return totalCalories;
    }



    private BigDecimal calculateTotalWaterConsumed(Integer userId, LocalDate date) {
        DailyWaterIntake dailyWaterIntake = dailyWaterIntakeRepository.findByUserIdAndDate(userId, date);
        return dailyWaterIntake != null ? dailyWaterIntake.getAmount() : BigDecimal.ZERO;
    }

    private boolean matchesPreferences(NutritionalInfo food, List<UserDietaryPreferences> preferences) {
        for (UserDietaryPreferences preference : preferences) {
            // Assuming dietary preferences are stored as IDs that correspond to certain food properties
            if (preference.getId().getTblDietaryPreferencesId() == 1 && food.getFoodName().toLowerCase().contains("meat")) {
                return false; // Example: preference ID 1 might represent vegetarian
            }
            // Add more conditions based on dietary preferences
        }
        return true;
    }

    private boolean matchesMedicalConditions(NutritionalInfo food, List<UserMedicalConditions> conditions) {
        for (UserMedicalConditions condition : conditions) {
            // Assuming medical conditions are stored as IDs that correspond to certain food properties
            if (condition.getId().getTblMedicalConditionsId() == 1 && food.getFoodName().toLowerCase().contains("sugar")) {
                return false; // Example: condition ID 1 might represent diabetes
            }
            // Add more conditions based on medical conditions
        }
        return true;
    }

    private boolean matchesAllergies(NutritionalInfo food, List<UserAllergies> allergies) {
        for (UserAllergies allergy : allergies) {
            // Assuming allergies are stored as IDs that correspond to certain food properties
            if (allergy.getId().getTblAllergiesId() == 1 && food.getFoodName().toLowerCase().contains("peanut")) {
                return true; // Example: allergy ID 1 might represent peanut allergy
            }
            // Add more conditions based on allergies
        }
        return false;
    }
}
