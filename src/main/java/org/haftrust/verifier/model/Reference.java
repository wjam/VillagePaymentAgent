/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.model;

import java.sql.Date;

/**
 *
 * @author LabClass
 */
public class Reference implements java.io.Serializable {

    private int id;
    private String organisationName;
    private String contactNumber;
    private String address;
    private String title;
    private String fullName;
    private String designation;
    private String email;
    private String verificationStatus;
    private Date verificationDate;
    private String verificationComment;
    private String employeeType;
    private Verifier verifier;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Reference{" + "id=" + id + ", organisationName=" + organisationName + ", contactNumber=" + contactNumber + ", address=" + address + ", title=" + title + ", fullName=" + fullName + ", designation=" + designation + ", email=" + email + ", verificationStatus=" + verificationStatus + ", verificationDate=" + verificationDate + ", verificationComment=" + verificationComment + ", employeeType=" + employeeType + ", verifier=" + verifier + '}';
    }
    
}
