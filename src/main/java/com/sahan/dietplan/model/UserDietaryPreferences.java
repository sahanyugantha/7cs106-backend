package com.sahan.dietplan.model;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "user_dietary_preferences")
public class UserDietaryPreferences {
    @EmbeddedId
    private UserDietaryPreferencesId id;

    public UserDietaryPreferencesId getId() {
        return id;
    }

    public void setId(UserDietaryPreferencesId id) {
        this.id = id;
    }

    @Embeddable
    public static class UserDietaryPreferencesId implements Serializable {
        private Integer tblProfileId;
        private Integer tblDietaryPreferencesId;

        public Integer getTblProfileId() {
            return tblProfileId;
        }

        public void setTblProfileId(Integer tblProfileId) {
            this.tblProfileId = tblProfileId;
        }

        public Integer getTblDietaryPreferencesId() {
            return tblDietaryPreferencesId;
        }

        public void setTblDietaryPreferencesId(Integer tblDietaryPreferencesId) {
            this.tblDietaryPreferencesId = tblDietaryPreferencesId;
        }
    }
}


