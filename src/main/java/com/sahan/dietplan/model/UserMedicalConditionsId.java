package com.sahan.dietplan.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserMedicalConditionsId implements Serializable {
    private int tblProfileId;
    private int tblMedicalConditionsId;

    public int getTblProfileId() {
        return tblProfileId;
    }

    public void setTblProfileId(int tblProfileId) {
        this.tblProfileId = tblProfileId;
    }

    public int getTblMedicalConditionsId() {
        return tblMedicalConditionsId;
    }

    public void setTblMedicalConditionsId(int tblMedicalConditionsId) {
        this.tblMedicalConditionsId = tblMedicalConditionsId;
    }
}
