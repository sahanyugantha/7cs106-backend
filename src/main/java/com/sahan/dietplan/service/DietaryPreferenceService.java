package com.sahan.dietplan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sahan.dietplan.model.DietaryPreference;
import com.sahan.dietplan.dao.DietaryPreferenceRepository;
import java.util.List;
import java.util.Optional;

@Service
public class DietaryPreferenceService {

    @Autowired
    private DietaryPreferenceRepository dietaryPreferenceRepository;

    public DietaryPreference save(DietaryPreference dietaryPreference) {
        return dietaryPreferenceRepository.save(dietaryPreference);
    }

    public Optional<DietaryPreference> findById(int id) {
        return dietaryPreferenceRepository.findById(id);
    }

    public List<DietaryPreference> findAll() {
        return dietaryPreferenceRepository.findAll();
    }

    public void deleteById(int id) {
        dietaryPreferenceRepository.deleteById(id);
    }
}
