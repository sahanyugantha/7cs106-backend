package com.sahan.dietplan.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserAllergiesId implements Serializable {
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
