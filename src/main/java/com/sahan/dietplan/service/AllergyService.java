package com.sahan.dietplan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sahan.dietplan.model.Allergies;
import com.sahan.dietplan.dao.AllergiesRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AllergyService {

    private final AllergiesRepository allergiesRepository;

    public AllergyService(AllergiesRepository allergiesRepository) {
        this.allergiesRepository = allergiesRepository;
    }

    public Allergies save(Allergies allergies) {
        return allergiesRepository.save(allergies);
    }

    public Optional<Allergies> findById(int id) {
        return allergiesRepository.findById(id);
    }

    public List<Allergies> findAll() {
        return allergiesRepository.findAll();
    }

    public void deleteById(int id) {
        allergiesRepository.deleteById(id);
    }
}

