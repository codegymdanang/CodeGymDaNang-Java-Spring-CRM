package com.smartdev.user.entity;

import java.sql.Timestamp;

public class HistoryTest {
    private Timestamp date;

    public Timestamp getDate() {
        return date;
    }

    public HistoryTest(Timestamp date, String comment, Integer status, Integer customerId) {
        this.date = date;
        this.comment = comment;
        this.status = status;
        this.customerId = customerId;
    }

    public void setDate(Timestamp date) {

        this.date = date;

    }

    public HistoryTest() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    private String comment;
    private Integer status;
    private  Integer customerId;
}
