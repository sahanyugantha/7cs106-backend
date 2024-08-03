package com.sahan.dietplan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sahan.dietplan.model.UserMedicalConditions;
import com.sahan.dietplan.model.UserMedicalConditionsId;
import com.sahan.dietplan.dao.UserMedicalConditionsRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserMedicalConditionsService {

    private final UserMedicalConditionsRepository userMedicalConditionsRepository;

    public UserMedicalConditionsService(UserMedicalConditionsRepository userMedicalConditionsRepository) {
        this.userMedicalConditionsRepository = userMedicalConditionsRepository;
    }

    public UserMedicalConditions save(UserMedicalConditions userMedicalConditions) {
        return userMedicalConditionsRepository.save(userMedicalConditions);
    }

    public Optional<UserMedicalConditions> findById(UserMedicalConditionsId id) {
        return userMedicalConditionsRepository.findById(id);
    }

    public List<UserMedicalConditions> findAll() {
        return userMedicalConditionsRepository.findAll();
    }

    public void deleteById(UserMedicalConditionsId id) {
        userMedicalConditionsRepository.deleteById(id);
    }

//    public UserMedicalConditions findByProfileIdAndMedicalConditionsId(Integer profileId, Integer conditionId) {
//        return userMedicalConditionsRepository.findByIdTblProfileIdAndIdTblMedicalConditionsId(profileId, conditionId);
//    }
}
