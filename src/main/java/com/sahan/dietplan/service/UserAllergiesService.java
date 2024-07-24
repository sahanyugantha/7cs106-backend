package com.sahan.dietplan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sahan.dietplan.model.UserAllergies;
import com.sahan.dietplan.model.UserAllergies.UserAllergiesId;
import com.sahan.dietplan.dao.UserAllergiesRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserAllergiesService {

    private final UserAllergiesRepository userAllergiesRepository;

    public UserAllergiesService(UserAllergiesRepository userAllergiesRepository) {
        this.userAllergiesRepository = userAllergiesRepository;
    }

    public UserAllergies save(UserAllergies userAllergies) {
        return userAllergiesRepository.save(userAllergies);
    }

    public Optional<UserAllergies> findById(UserAllergiesId id) {
        return userAllergiesRepository.findById(id);
    }

    public List<UserAllergies> findAll() {
        return userAllergiesRepository.findAll();
    }

    public void deleteById(UserAllergiesId id) {
        userAllergiesRepository.deleteById(id);
    }

    public UserAllergies findByProfileIdAndAllergyId(Integer profileId, Integer allergyId) {
        return userAllergiesRepository.findByProfileIdAndAllergiesId(profileId, allergyId);
    }
}

