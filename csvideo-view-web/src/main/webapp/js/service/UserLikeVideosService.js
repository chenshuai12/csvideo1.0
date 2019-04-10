//点赞短视频服务
app.service('UserLikeVideosService',function ($http) {
    //点赞
    this.add=function (userId,videoId) {
        return $http.get('../userLikeVideos/add?userId='+userId+'&videoId='+videoId);
    }
    //查找所有喜欢的视频
    this.getAll=function (userId,page,rows) {
        return $http.get('../userLikeVideos/getAll?userId='+userId+'&page='+page+'&rows='+rows);
    }
});