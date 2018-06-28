package com.smartdev.user.entity;

import java.sql.Timestamp;

public class HistoryTest {

    private Timestamp date;
    private String comment;
    private Integer status;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    private  Integer customerId;

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "HistoryTest{" +
                "date=" + date +
                ", comment='" + comment + '\'' +
                ", status='" + status + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
