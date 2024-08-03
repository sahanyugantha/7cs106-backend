package com.sahan.dietplan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "user_dietary_preferences")
public class UserDietaryPreferences {
    @EmbeddedId
    private UserDietaryPreferencesId id;

    @ManyToOne
    @MapsId("tblProfileId")
    @JoinColumn(name = "tbl_profile_id")
    @JsonIgnore
    private Profile profile;

    @ManyToOne
    @MapsId("tblDietaryPreferencesId")
    @JoinColumn(name = "tbl_dietary_preferences_id")
    @JsonUnwrapped
    private DietaryPreference dietaryPreference;

    public UserDietaryPreferencesId getId() {
        return id;
    }

    public void setId(UserDietaryPreferencesId id) {
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


