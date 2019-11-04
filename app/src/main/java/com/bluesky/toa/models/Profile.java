package com.bluesky.toa.models;

import java.util.Date;
import java.util.UUID;

public class Profile {

    public static final String TYPE_FAN = "FAN";
    public static final String TYPE_PROFESSIONAL = "PROFESSIONAL";

    private String id;
    private Account account;
    private String firstName;
    private String lastName;
    private String aboutMe;
    private Date dateOfBirth;
    private String city;
    private String provinceState;
    private String country;
    private String type;
    private String updatedAt;

    public Profile(Account account, String firstName, String lastName, String type) {
        this.id = UUID.randomUUID().toString();
        this.account = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvinceState() {
        return provinceState;
    }

    public void setProvinceState(String provinceState) {
        this.provinceState = provinceState;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
