package com.sahan.dietplan.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_health_impact_suggestions")
public class HealthImpactSuggestions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String impactDescription;
    private String suggestion;

    @ManyToOne
    @JoinColumn(name = "tbl_nutritional_info_id")
    private NutritionalInfo nutritionalInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImpactDescription() {
        return impactDescription;
    }

    public void setImpactDescription(String impactDescription) {
        this.impactDescription = impactDescription;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public NutritionalInfo getNutritionalInfo() {
        return nutritionalInfo;
    }

    public void setNutritionalInfo(NutritionalInfo nutritionalInfo) {
        this.nutritionalInfo = nutritionalInfo;
    }
}

