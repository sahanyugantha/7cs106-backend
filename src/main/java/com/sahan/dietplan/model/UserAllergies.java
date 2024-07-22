package com.sahan.dietplan.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "user_allergies")
public class UserAllergies {
    @EmbeddedId
    private UserAllergiesId id;

    public UserAllergiesId getId() {
        return id;
    }

    public void setId(UserAllergiesId id) {
        this.id = id;
    }

    @Embeddable
    public static class UserAllergiesId implements Serializable {
        private Integer tblProfileId;
        private Integer tblAllergiesId;

        public Integer getTblProfileId() {
            return tblProfileId;
        }

        public void setTblProfileId(Integer tblProfileId) {
            this.tblProfileId = tblProfileId;
        }

        public Integer getTblAllergiesId() {
            return tblAllergiesId;
        }

        public void setTblAllergiesId(Integer tblAllergiesId) {
            this.tblAllergiesId = tblAllergiesId;
        }
    }
}
