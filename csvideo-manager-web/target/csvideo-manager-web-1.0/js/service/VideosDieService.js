//短视频管理服务
app.service('VideosDieService',function ($http) {
    //根据状态查询短视频
    this.getAll=function (page,rows,videosStatu) {
        return $http.get('../videos/getAll?page='+page+'&rows='+rows+'&videosStatu='+videosStatu);
    }
    //根据用户id查询短视频
    this.getByUserId=function (userId,page,rows,videosStatu) {
        return $http.get('../videos/getByStatu?userId='+userId+'&page='+page+'&rows='+rows+'&videosStatu='+videosStatu);
    }
    //修改短视频
    this.update=function (entity) {
        return $http.post("../videos/update",entity)
    }
    //根据电影id查找短视频
    this.getByVideosId=function (videosId) {
        return $http.get('../videos/getByVideosId?videosId='+videosId);
    }
});