package com.csvideo.pojo;

import java.io.Serializable;

public class VideosReport implements Serializable{
    private String videoReportId;

    private String dealVedeoId;

    private String userId;

    private String date;

    private String cause;

    public String getVideoReportId() {
        return videoReportId;
    }

    public void setVideoReportId(String videoReportId) {
        this.videoReportId = videoReportId == null ? null : videoReportId.trim();
    }

    public String getDealVedeoId() {
        return dealVedeoId;
    }

    public void setDealVedeoId(String dealVedeoId) {
        this.dealVedeoId = dealVedeoId == null ? null : dealVedeoId.trim();
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