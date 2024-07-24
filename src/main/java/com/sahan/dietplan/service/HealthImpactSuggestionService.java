package com.sahan.dietplan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sahan.dietplan.model.HealthImpactSuggestions;
import com.sahan.dietplan.dao.HealthImpactSuggestionRepository;
import java.util.List;
import java.util.Optional;

@Service
public class HealthImpactSuggestionService {

    private final HealthImpactSuggestionRepository healthImpactSuggestionRepository;

    public HealthImpactSuggestionService(HealthImpactSuggestionRepository healthImpactSuggestionRepository) {
        this.healthImpactSuggestionRepository = healthImpactSuggestionRepository;
    }

    public HealthImpactSuggestions save(HealthImpactSuggestions healthImpactSuggestions) {
        return healthImpactSuggestionRepository.save(healthImpactSuggestions);
    }

    public Optional<HealthImpactSuggestions> findById(int id) {
        return healthImpactSuggestionRepository.findById(id);
    }

    public List<HealthImpactSuggestions> findAll() {
        return healthImpactSuggestionRepository.findAll();
    }

    public void deleteById(int id) {
        healthImpactSuggestionRepository.deleteById(id);
    }
}

