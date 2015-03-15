package org.haftrust.verifier.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "HT_IMAGE", schema = "kj905")
public class Image {

    @Id
    @Column(name = "IDIMAGE", nullable = false)
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private byte[] photo;

    @Column(name = "VERIFICATION_STATUS", length = 45)
    private String verificationStatus;

    @Column(name = "VERIFICATION_DATE")
    private Date verificationDate;

    @Column(name = "VERIFICATION_COMMENT", length = 100)
    private String verificationComment;

    @Column(name = "EMPLOYEE_TYPE", length = 25, nullable = false)
    private String employeeType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
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

    @Override
    public String toString() {
        return "Image{" + "id=" + id + ", date=" + date + ", photo=" + photo + ", verificationStatus=" + verificationStatus + ", verificationDate=" + verificationDate + ", verificationComment=" + verificationComment + ", employeeType=" + employeeType + '}';
    }    
}
