package com.sahan.dietplan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sahan.dietplan.model.NutritionalInfo;
import com.sahan.dietplan.dao.NutritionalInfoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class NutritionalInfoService {

    private final NutritionalInfoRepository nutritionalInfoRepository;

    public NutritionalInfoService(NutritionalInfoRepository nutritionalInfoRepository) {
        this.nutritionalInfoRepository = nutritionalInfoRepository;
    }

    public NutritionalInfo save(NutritionalInfo nutritionalInfo) {
        return nutritionalInfoRepository.save(nutritionalInfo);
    }

    public Optional<NutritionalInfo> findById(int id) {
        return nutritionalInfoRepository.findById(id);
    }

    public List<NutritionalInfo> findAll() {
        return nutritionalInfoRepository.findAll();
    }

    public void deleteById(int id) {
        nutritionalInfoRepository.deleteById(id);
    }
}

