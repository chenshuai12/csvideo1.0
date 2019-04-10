package com.csvideo.pojo;

import java.io.Serializable;

public class UserReport implements Serializable{
    private String userReportId;

    private String dealUserId;

    private String userId;

    private String date;

    private String cause;

    public String getUserReportId() {
        return userReportId;
    }

    public void setUserReportId(String userReportId) {
        this.userReportId = userReportId == null ? null : userReportId.trim();
    }

    public String getDealUserId() {
        return dealUserId;
    }

    public void setDealUserId(String dealUserId) {
        this.dealUserId = dealUserId == null ? null : dealUserId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause == null ? null : cause.trim();
    }
}