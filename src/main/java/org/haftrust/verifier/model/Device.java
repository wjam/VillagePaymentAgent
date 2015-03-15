package org.haftrust.verifier.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "HT_DEVICE", schema = "kj905")
public class Device {

    @Id
    @Column(name = "IMEI", nullable = false)
    @GeneratedValue
    private Long imei;

    @Column(nullable = false, length = 45)
    private String productNumber;

    @Column(nullable = false, length = 45)
    private String modelNumber;

    @Column(nullable = false, length = 25)
    private String htMobileNumber;

    @Column(nullable = false, length = 4)
    private String allocation;

    @Column(nullable = false)
    private Date allocationDate;

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getHtMobileNumber() {
        return htMobileNumber;
    }

    public void setHtMobileNumber(String htMobileNumber) {
        this.htMobileNumber = htMobileNumber;
    }

    public String getAllocation() {
        return allocation;
    }

    public void setAllocation(String allocation) {
        this.allocation = allocation;
    }

    public Date getAllocationDate() {
        return allocationDate;
    }

    public void setAllocationDate(Date allocationDate) {
        this.allocationDate = allocationDate;
    }

    @Override
    public String toString() {
        return "Device{" + "imei=" + imei + ", productNumber=" + productNumber + ", modelNumber=" + modelNumber + ", htMobileNumber=" + htMobileNumber + ", allocation=" + allocation + ", allocationDate=" + allocationDate + '}';
    }

}
