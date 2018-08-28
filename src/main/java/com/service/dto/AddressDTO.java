package com.service.dto;

import com.domain.User;

import java.io.Serializable;

public class AddressDTO implements Serializable {

    private Long addressID;

    private String city;

    private String district;

    private String zipCode;

    private String phoneNumber;

    private String fullAddress;

    private Long userID;

    public AddressDTO(){}


    public AddressDTO(Long addressID, String city, String district, String zipCode, String phoneNumber, String fullAddress, Long userID) {
        this.addressID = addressID;
        this.city = city;
        this.district = district;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.fullAddress = fullAddress;
        this.userID = userID;
    }

    public Long getAddressID() {
        return addressID;
    }

    public void setAddressID(Long addressID) {
        this.addressID = addressID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}
