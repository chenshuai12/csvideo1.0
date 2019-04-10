package com.csvideo.pojo;

import java.io.Serializable;

public class UserLikeMovie implements Serializable{
    private String userLikeMovieId;

    private String userId;

    private String movieId;

    public String getUserLikeMovieId() {
        return userLikeMovieId;
    }

    public void setUserLikeMovieId(String userLikeMovieId) {
        this.userLikeMovieId = userLikeMovieId == null ? null : userLikeMovieId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId == null ? null : movieId.trim();
    }
}