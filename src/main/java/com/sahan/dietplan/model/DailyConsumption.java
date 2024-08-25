package com.sahan.dietplan.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_daily_consumption")
public class DailyConsumption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private BigDecimal quantity;

    @Column(name = "manual_calories", nullable = false, columnDefinition = "decimal(10,2) default '0.00'")
    private BigDecimal manualCalories;

    @Column(name = "breakfast_calories", nullable = false, columnDefinition = "decimal(10,2) default '0.00'")
    private BigDecimal breakfastCalories;

    @Column(name = "lunch_calories", nullable = false, columnDefinition = "decimal(10,2) default '0.00'")
    private BigDecimal lunchCalories;

    @Column(name = "dinner_calories", nullable = false, columnDefinition = "decimal(10,2) default '0.00'")
    private BigDecimal dinnerCalories;

    @Column(name = "other_calories", nullable = false, columnDefinition = "decimal(10,2) default '0.00'")
    private BigDecimal otherCalories;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = true)
    private NutritionalInfo nutritionalInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getManualCalories() {
        return manualCalories;
    }

    public void setManualCalories(BigDecimal manualCalories) {
        this.manualCalories = manualCalories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public NutritionalInfo getNutritionalInfo() {
        return nutritionalInfo;
    }

    public void setNutritionalInfo(NutritionalInfo nutritionalInfo) {
        this.nutritionalInfo = nutritionalInfo;
    }

    public BigDecimal getBreakfastCalories() {
        return breakfastCalories;
    }

    public void setBreakfastCalories(BigDecimal breakfastCalories) {
        this.breakfastCalories = breakfastCalories;
    }

    public BigDecimal getLunchCalories() {
        return lunchCalories;
    }

    public void setLunchCalories(BigDecimal lunchCalories) {
        this.lunchCalories = lunchCalories;
    }

    public BigDecimal getDinnerCalories() {
        return dinnerCalories;
    }

    public void setDinnerCalories(BigDecimal dinnerCalories) {
        this.dinnerCalories = dinnerCalories;
    }

    public BigDecimal getOtherCalories() {
        return otherCalories;
    }

    public void setOtherCalories(BigDecimal otherCalories) {
        this.otherCalories = otherCalories;
    }
}
