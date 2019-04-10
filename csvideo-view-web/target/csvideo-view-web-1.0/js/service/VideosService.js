//服务层
app.service('VideosService',function ($http) {
    //上传短视频
    this.add=function (entity,userId) {
        var formData = new FormData();
        formData.append("file",file.files[0]);
        formData.append("videos",entity);
        formData.append("userId",userId)
        return $http({
            method:'POST',
            url:'../videos/add',
            data:formData,
            headers: {'Content-Type':undefined},
            transformRequest: angular.identity
        });
    }
    //根据状态查询所有短视频
    this.findAllByStatus=function (page,rows,videosStatu) {
        return $http.get('../videos/getAll?page='+page+'&rows='+rows+'&videossStatu'+videosStatu);
    }
    //根据视频id查询视频
    this.findByVideosId=function (videosId) {
        return $http.get('../videos/getByVideosId?videosId='+videosId);
    }
    //根据状态，类别，用户id等条件查询电影
    this.findByCondition=function (userId,page,rows,videosStatu) {
        return $http.get('../videos/getByStatu?userId='+userId+'&page='+page+'&rows='+rows+'&videosStatu='+videosStatu);
    }
    //删除视频
    this.dele=function (videosId) {
        return $http.get('../videos/deleteById?videosId='+videosId);
    }
});