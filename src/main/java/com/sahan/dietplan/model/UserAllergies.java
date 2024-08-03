package com.sahan.dietplan.model;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

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
}
