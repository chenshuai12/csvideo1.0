package com.csvideo.pojo;

import java.io.Serializable;

public class Movies implements Serializable{
    private String moviesId;

    private String userId;

    private String moviesPath;

    private String moviesPhotoPath;

    private Integer moviesPraise;

    private String moviesStatu;

    private String categoryId;

    private String moviesDescript;

    public String getMoviesId() {
        return moviesId;
    }

    public void setMoviesId(String moviesId) {
        this.moviesId = moviesId == null ? null : moviesId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getMoviesPath() {
        return moviesPath;
    }

    public void setMoviesPath(String moviesPath) {
        this.moviesPath = moviesPath == null ? null : moviesPath.trim();
    }

    public String getMoviesPhotoPath() {
        return moviesPhotoPath;
    }

    public void setMoviesPhotoPath(String moviesPhotoPath) {
        this.moviesPhotoPath = moviesPhotoPath == null ? null : moviesPhotoPath.trim();
    }

    public Integer getMoviesPraise() {
        return moviesPraise;
    }

    public void setMoviesPraise(Integer moviesPraise) {
        this.moviesPraise = moviesPraise;
    }

    public String getMoviesStatu() {
        return moviesStatu;
    }

    public void setMoviesStatu(String moviesStatu) {
        this.moviesStatu = moviesStatu == null ? null : moviesStatu.trim();
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public String getMoviesDescript() {
        return moviesDescript;
    }

    public void setMoviesDescript(String moviesDescript) {
        this.moviesDescript = moviesDescript == null ? null : moviesDescript.trim();
    }
}