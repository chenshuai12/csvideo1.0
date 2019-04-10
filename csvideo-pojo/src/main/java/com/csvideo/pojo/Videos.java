package com.csvideo.pojo;

import java.io.Serializable;

public class Videos implements Serializable{
    private String videosId;

    private String userId;

    private String videosPath;

    private String videosPhotoPath;

    private Integer videosPraise;

    private String videosStatu;

    private String videosDescript;

    public String getVideosId() {
        return videosId;
    }

    public void setVideosId(String videosId) {
        this.videosId = videosId == null ? null : videosId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getVideosPath() {
        return videosPath;
    }

    public void setVideosPath(String videosPath) {
        this.videosPath = videosPath == null ? null : videosPath.trim();
    }

    public String getVideosPhotoPath() {
        return videosPhotoPath;
    }

    public void setVideosPhotoPath(String videosPhotoPath) {
        this.videosPhotoPath = videosPhotoPath == null ? null : videosPhotoPath.trim();
    }

    public Integer getVideosPraise() {
        return videosPraise;
    }

    public void setVideosPraise(Integer videosPraise) {
        this.videosPraise = videosPraise;
    }

    public String getVideosStatu() {
        return videosStatu;
    }

    public void setVideosStatu(String videosStatu) {
        this.videosStatu = videosStatu == null ? null : videosStatu.trim();
    }

    public String getVideosDescript() {
        return videosDescript;
    }

    public void setVideosDescript(String videosDescript) {
        this.videosDescript = videosDescript == null ? null : videosDescript.trim();
    }
}