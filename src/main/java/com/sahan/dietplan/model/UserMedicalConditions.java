package com.sahan.dietplan.model;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "user_medical_conditions")
public class UserMedicalConditions {
    @EmbeddedId
    private UserMedicalConditionsId id;

    public UserMedicalConditionsId getId() {
        return id;
    }

    public void setId(UserMedicalConditionsId id) {
        this.id = id;
    }

    @Embeddable
    public static class UserMedicalConditionsId implements Serializable {
        private Integer tblProfileId;
        private Integer tblMedicalConditionsId;

        public Integer getTblProfileId() {
            return tblProfileId;
        }

        public void setTblProfileId(int tblProfileId) {
            this.tblProfileId = tblProfileId;
        }

        public Integer getTblMedicalConditionsId() {
            return tblMedicalConditionsId;
        }

        public void setTblMedicalConditionsId(int tblMedicalConditionsId) {
            this.tblMedicalConditionsId = tblMedicalConditionsId;
        }
    }
}

