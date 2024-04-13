package com.example.mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "QUERY_STATUS_MASTER")
public class QueryStatusMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String STATUS;
    private String ALLOWED_STATUSES_ID;
    private String BUSINESS_STATUS;
    private String CREATED_ON;
    private String MODIFIED_ON;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getALLOWED_STATUSES_ID() {
        return ALLOWED_STATUSES_ID;
    }

    public void setALLOWED_STATUSES_ID(String ALLOWED_STATUSES_ID) {
        this.ALLOWED_STATUSES_ID = ALLOWED_STATUSES_ID;
    }

    public String getBUSINESS_STATUS() {
        return BUSINESS_STATUS;
    }

    public void setBUSINESS_STATUS(String BUSINESS_STATUS) {
        this.BUSINESS_STATUS = BUSINESS_STATUS;
    }

    public String getCREATED_ON() {
        return CREATED_ON;
    }

    public void setCREATED_ON(String CREATED_ON) {
        this.CREATED_ON = CREATED_ON;
    }

    public String getMODIFIED_ON() {
        return MODIFIED_ON;
    }

    public void setMODIFIED_ON(String MODIFIED_ON) {
        this.MODIFIED_ON = MODIFIED_ON;
    }
}
