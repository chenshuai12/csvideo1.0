package com.csvideo.pojo;

import java.io.Serializable;

public class UserFans implements Serializable{
    private String userFansId;

    private String userId;

    private String fansId;

    public String getUserFansId() {
        return userFansId;
    }

    public void setUserFansId(String userFansId) {
        this.userFansId = userFansId == null ? null : userFansId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getFansId() {
        return fansId;
    }

    public void setFansId(String fansId) {
        this.fansId = fansId == null ? null : fansId.trim();
    }
}