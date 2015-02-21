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
public class Device implements java.io.Serializable {

    private long imei;
    private String productNumber;
    private String modelNumber;
    private String htMobileNumber;
    private String allocation;
    private Date allocationDate;

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

    public String getHtMobileNumber() {
        return htMobileNumber;
    }

    public void setHtMobileNumber(String htMobileNumber) {
        this.htMobileNumber = htMobileNumber;
    }

    public long getImei() {
        return imei;
    }

    public void setImei(long imei) {
        this.imei = imei;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

}
