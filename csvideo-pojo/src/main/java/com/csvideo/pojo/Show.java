package com.csvideo.pojo;

import java.io.Serializable;

/**
 * Created by asus on 2019/4/26.
 */
public class Show implements Serializable{
    private int userCount;
    private int videosCount;
    private int moviesCount;
    private int commentsCount;

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public int getVideosCount() {
        return videosCount;
    }

    public void setVideosCount(int videosCount) {
        this.videosCount = videosCount;
    }

    public int getMoviesCount() {
        return moviesCount;
    }

    public void setMoviesCount(int moviesCount) {
        this.moviesCount = moviesCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

}
