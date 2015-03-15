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
@Table(name = "HT_REFERENCE", schema = "kj905")
public class Reference {

    @Id
    @Column(name = "IDREFERENCE", nullable = false)
    @GeneratedValue
    private Integer id;

    @Column(name = "ORGANISATION_NAME", nullable = false, length = 45)
    private String organisationName;

    @Column(name = "CONTACT_NUMBER", nullable = false, length = 25)
    private String contactNumber;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(length = 10)
    private String title;

    @Column(name = "FULL_NAME", length = 45)
    private String fullName;

    @Column(length = 45)
    private String designation;

    @Column(length = 45)
    private String email;

    @Column(name = "VERIFICATION_STATUS", length = 45)
    private String verificationStatus;

    @Column(name = "VERIFICATION_DATE")
    private Date verificationDate;

    @Column(name = "VERIFICATION_COMMENT", length = 100)
    private String verificationComment;

    @Column(name = "EMPLOYEE_TYPE", length = 25, nullable = false)
    private String employeeType;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "EMP_ID", nullable = false)
    private Verifier verifier;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
