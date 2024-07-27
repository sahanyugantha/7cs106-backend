package com.sahan.dietplan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sahan.dietplan.model.UserDietaryPreferences;
import com.sahan.dietplan.model.UserDietaryPreferences.UserDietaryPreferencesId;
import com.sahan.dietplan.dao.UserDietaryPreferencesRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserDietaryPreferencesService {

    private final UserDietaryPreferencesRepository userDietaryPreferencesRepository;

    public UserDietaryPreferencesService(UserDietaryPreferencesRepository userDietaryPreferencesRepository) {
        this.userDietaryPreferencesRepository = userDietaryPreferencesRepository;
    }

    public UserDietaryPreferences save(UserDietaryPreferences userDietaryPreferences) {
        return userDietaryPreferencesRepository.save(userDietaryPreferences);
    }

    public Optional<UserDietaryPreferences> findById(UserDietaryPreferencesId id) {
        return userDietaryPreferencesRepository.findById(id);
    }

    public List<UserDietaryPreferences> findAll() {
        return userDietaryPreferencesRepository.findAll();
    }

    public void deleteById(UserDietaryPreferencesId id) {
        userDietaryPreferencesRepository.deleteById(id);
    }

    public UserDietaryPreferences findByProfileIdAndDietaryPreferencesId(Integer profileId, Integer dietaryPreferencesId) {
        return userDietaryPreferencesRepository.findByIdTblProfileIdAndIdTblDietaryPreferencesId(profileId, dietaryPreferencesId);
    }
}

