package com.sahan.dietplan.service;

import com.sahan.dietplan.dao.*;
import com.sahan.dietplan.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<NutritionalInfo> generateDailyRecommendation(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new RuntimeException("User not found");
        }

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

        // Further filter foods based on medical conditions
        List<NutritionalInfo> recommendedFoods = preferredFoods.stream()
                .filter(food -> matchesMedicalConditions(food, medicalConditions))
                .collect(Collectors.toList());

        // Finally, exclude foods that match the user's allergies
        List<NutritionalInfo> finalRecommendations = recommendedFoods.stream()
                .filter(food -> !matchesAllergies(food, allergies))
                .collect(Collectors.toList());

        return finalRecommendations;
        // return null;
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