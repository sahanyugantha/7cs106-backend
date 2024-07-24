package com.sahan.dietplan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sahan.dietplan.model.MedicalConditions;
import com.sahan.dietplan.dao.MedicalConditionsRepository;
import java.util.List;
import java.util.Optional;

@Service
public class MedicalConditionService {

    @Autowired
    private MedicalConditionsRepository medicalConditionsRepository;

    public MedicalConditions save(MedicalConditions medicalCondition) {
        return medicalConditionsRepository.save(medicalCondition);
    }

    public Optional<MedicalConditions> findById(int id) {
        return medicalConditionsRepository.findById(id);
    }

    public List<MedicalConditions> findAll() {
        return medicalConditionsRepository.findAll();
    }

    public void deleteById(int id) {
        medicalConditionsRepository.deleteById(id);
    }
}

