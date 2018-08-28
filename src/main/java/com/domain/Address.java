package com.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_address", schema = "public")
public class Address implements Serializable {

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq", sequenceName = "address_sequence", allocationSize = 1)
    private Long addressID;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "fullAddress")
    private String fullAddress;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "userID")
    private User user;

    public Long getAddressID() {
        return addressID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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


}
