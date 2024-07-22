package com.sahan.dietplan.dao;

import com.sahan.dietplan.model.HealthImpactSuggestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthImpactSuggestionRepository extends JpaRepository<HealthImpactSuggestions, Integer> {
}
