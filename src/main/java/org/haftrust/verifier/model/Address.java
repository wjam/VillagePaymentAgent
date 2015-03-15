/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "HT_ADDRESS", schema = "kj905")
public class Address {

    @Id
    @Column(name = "IDADDRESS", nullable = false)
    @GeneratedValue
    private Integer id;

    @Column(length = 45)
    private String street;

    @Column(length = 45)
    private String village;

    @Column(nullable = false)
    private String postcode;

    @Column(length = 45)
    private String town;

    @Column(length = 45)
    private String city;

    @Column(name = "VERIFICATION_STATUS", length = 45)
    private String verificationStatus;

    @Column(name = "VERIFICATION_DATE")
    private Date verificationDate;

    @Column(name = "VERIFICATION_COMMENT", length = 100)
    private String verificationComment;

    @Column(name = "EMPLOYEE_TYPE", nullable = false, length = 25)
    private String employeeType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMP_ID", nullable = false)
    private Verifier verifier;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HT_COUNTRY_IDCOUNTRY", nullable = false)
    private Country country;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HT_REGION_IDREGION", nullable = false)
    private Region region;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HT_DISTRICT_IDDISTRICT", nullable = false)
    private District district;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public Date getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(Date verificationDate) {
        this.verificationDate = verificationDate;
    }

    public String getVerificationComment() {
        return verificationComment;
    }

    public void setVerificationComment(String verificationComment) {
        this.verificationComment = verificationComment;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public Verifier getVerifier() {
        return verifier;
    }

    public void setVerifier(Verifier verifier) {
        this.verifier = verifier;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", street=" + street + ", village=" + village + ", postcode=" + postcode + ", town=" + town + ", city=" + city + ", verificationStatus=" + verificationStatus + ", verificationDate=" + verificationDate + ", verificationComment=" + verificationComment + ", employeeType=" + employeeType + ", verifier=" + verifier + ", country=" + country + ", region=" + region + ", district=" + district + '}';
    }
    
}
