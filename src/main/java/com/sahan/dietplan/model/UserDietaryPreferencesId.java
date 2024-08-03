package com.sahan.dietplan.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserDietaryPreferencesId implements Serializable {

    private int tblProfileId;
    private int tblDietaryPreferencesId;

    // Getters and setters
    public int getTblProfileId() {
        return tblProfileId;
    }

    public void setTblProfileId(int tblProfileId) {
        this.tblProfileId = tblProfileId;
    }

    public int getTblDietaryPreferencesId() {
        return tblDietaryPreferencesId;
    }

    public void setTblDietaryPreferencesId(Integer tblDietaryPreferencesId) {
        this.tblDietaryPreferencesId = tblDietaryPreferencesId;
    }

    // hashCode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDietaryPreferencesId that = (UserDietaryPreferencesId) o;
        return Objects.equals(tblProfileId, that.tblProfileId) &&
                Objects.equals(tblDietaryPreferencesId, that.tblDietaryPreferencesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tblProfileId, tblDietaryPreferencesId);
    }
}
