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
@Table(name = "HT_INTERVIEW", schema = "kj905")
public class Interview {

    @Id
    @Column(name = "IDINTERVIEW", nullable = false)
    @GeneratedValue
    private Integer id;
    private Date date;

    @Column(length = 100)
    private String address;

    @Column(nullable = false, length = 45)
    private String status;

    @Column(length = 100)
    private String comment;

    @Column(nullable = false, length = 25)
    private String employeeType;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "EMP_ID", nullable = false)
    private Verifier verifier;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "HT_FOM_IDFOM", nullable = false)
    private Fom fom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public Fom getFom() {
        return fom;
    }

    public void setFom(Fom fom) {
        this.fom = fom;
    }

    @Override
    public String toString() {
        return "Interview{" + "id=" + id + ", date=" + date + ", address=" + address + ", status=" + status + ", comment=" + comment + ", employeeType=" + employeeType + ", verifier=" + verifier + ", fom=" + fom + '}';
    }

}
