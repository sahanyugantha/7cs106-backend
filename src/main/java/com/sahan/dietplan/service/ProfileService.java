package com.sahan.dietplan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sahan.dietplan.model.Profile;
import com.sahan.dietplan.dao.ProfileRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    public Optional<Profile> findById(Integer id) {
        return profileRepository.findById(id);
    }

    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    public boolean deleteById(Integer id) {
        if (profileRepository.existsById(id)) {
            profileRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Profile findByTblUserId(Integer userId) {
        return profileRepository.findByTblUserId(userId);
    }
}

