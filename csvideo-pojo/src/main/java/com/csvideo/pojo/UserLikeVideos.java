package com.csvideo.pojo;

import java.io.Serializable;

public class UserLikeVideos implements Serializable{
    private String userLikeVideosId;

    private String userId;

    private String videoId;

    public String getUserLikeVideosId() {
        return userLikeVideosId;
    }

    public void setUserLikeVideosId(String userLikeVideosId) {
        this.userLikeVideosId = userLikeVideosId == null ? null : userLikeVideosId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId == null ? null : videoId.trim();
    }
}