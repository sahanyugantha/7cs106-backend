package com.sahan.dietplan.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_dietary_preferences")
public class DietaryPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "preference_name")
    private String preferenceName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPreferenceName() {
        return preferenceName;
    }

    public void setPreferenceName(String preferenceName) {
        this.preferenceName = preferenceName;
    }
}

