package com.excelian.diginexserver.domain;

import com.google.common.base.Objects;

public class UserDetails {

    private String email;
    private String givenName;
    private String familyName;
    private String address;
    private String birthdate; // dd/mm/yyyy

    public UserDetails(String email, String givenName, String familyName, String address, String birthdate) {
        this.email = email;
        this.givenName = givenName;
        this.familyName = familyName;
        this.address = address;
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        address = address;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetails that = (UserDetails) o;
        return Objects.equal(email, that.email) &&
                Objects.equal(givenName, that.givenName) &&
                Objects.equal(familyName, that.familyName) &&
                Objects.equal(address, that.address) &&
                Objects.equal(birthdate, that.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email, givenName, familyName, address, birthdate);
    }
}
