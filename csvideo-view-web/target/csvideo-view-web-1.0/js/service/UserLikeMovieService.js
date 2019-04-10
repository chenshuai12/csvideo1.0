//点赞电影服务
app.service('UserLikeMovieService',function ($http) {
    //点赞
    this.add=function (userId,moviesId) {
        return $http.get('../userLikeMovies/add?userId='+userId+'&moviesId='+moviesId);
    }
    //查找所有喜欢的视频
    this.getAll=function (userId,page,rows) {
        return $http.get('../userLikeMovies/getAll?userId='+userId+'&page='+page+'&rows='+rows);
    }
});