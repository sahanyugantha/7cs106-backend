package com.sahan.dietplan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "user_medical_conditions")
public class UserMedicalConditions {
    @EmbeddedId
    private UserMedicalConditionsId id;

    @ManyToOne
    @MapsId("tblProfileId")
    @JoinColumn(name = "tbl_profile_id")
    @JsonIgnore
    private Profile profile;

    @ManyToOne
    @MapsId("tblMedicalConditionsId")
    @JoinColumn(name = "tbl_medical_conditions_id")
    @JsonUnwrapped
    private DietaryPreference dietaryPreference;

    public UserMedicalConditionsId getId() {
        return id;
    }

    public void setId(UserMedicalConditionsId id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public DietaryPreference getDietaryPreference() {
        return dietaryPreference;
    }

    public void setDietaryPreference(DietaryPreference dietaryPreference) {
        this.dietaryPreference = dietaryPreference;
    }
}