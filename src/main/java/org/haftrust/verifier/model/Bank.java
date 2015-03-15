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
@Table(name = "HT_BANK", schema = "kj905")
public class Bank {

    @Id
    @Column(name = "IDBANK", nullable = false)
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, length = 15)
    private String accountNumber;

    @Column(name = "BANK_NAME", nullable = false, length = 45)
    private String bankName;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(name = "SORT_CODE", length = 10)
    private String sortcode;

    @Column(length = 45)
    private String iban;

    @Column(name = "CONTACT_NUMBER", length = 25)
    private String contactNumber;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSortcode() {
        return sortcode;
    }

    public void setSortcode(String sortcode) {
        this.sortcode = sortcode;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
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
        return "Bank{" + "id=" + id + ", accountNumber=" + accountNumber + ", bankName=" + bankName + ", address=" + address + ", sortcode=" + sortcode + ", iban=" + iban + ", contactNumber=" + contactNumber + ", verificationStatus=" + verificationStatus + ", verificationDate=" + verificationDate + ", verificationComment=" + verificationComment + ", employeeType=" + employeeType + ", verifier=" + verifier + '}';
    }


}
