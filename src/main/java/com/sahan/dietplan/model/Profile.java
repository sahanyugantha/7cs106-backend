package com.sahan.dietplan.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_profile", uniqueConstraints = @UniqueConstraint(columnNames = "tbl_user_id"))
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private float height;
    private float weight;
    private int age;
    private String gender;
    @Column(name = "activity_level")
    private String activityLevel;
    @Column(name = "waist_circumference")
    private Float waistCircumference;
    @Column(name = "hip_circumference")
    private Float hipCircumference;
    @Column(name = "profile_picture")
    private String profilePicture;
    @Column(name = "tbl_user_id")
    private int tblUserId;

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTblUserId() {
        return tblUserId;
    }

    public void setTblUserId(Integer tblUserId) {
        this.tblUserId = tblUserId;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public Float getWaistCircumference() {
        return waistCircumference;
    }

    public void setWaistCircumference(Float waistCircumference) {
        this.waistCircumference = waistCircumference;
    }

    public Float getHipCircumference() {
        return hipCircumference;
    }

    public void setHipCircumference(Float hipCircumference) {
        this.hipCircumference = hipCircumference;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTblUserId(int tblUserId) {
        this.tblUserId = tblUserId;
    }
}
