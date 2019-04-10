//短视频管理服务
app.service('VideosLifeService',function ($http) {
    //根据状态查询短视频
    this.getAll=function (page,rows,videosStatu) {
        return $http.get('../videos/getAll?page='+page+'&rows='+rows+'&videosStatu='+videosStatu);
    }

    //根据用户id查询短视频
    this.getByUserId=function (userId) {
        return $http.get('../videos/getByStatu?userId='+userId);
    }
    //修改短视频
    this.update=function (entity) {
        return $http.post("../videos/update",entity)
    }
    //根据视频id查找短视频
    this.getByVideosId=function (videosId) {
        return $http.get('../videos/getByVideosId?videosId='+videosId);
    }
    this.getByVideosIds = function (videosId) {
        return $http.get('../videos/getByVideosIds?videosId='+videosId);
    }
});