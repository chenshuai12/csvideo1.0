//服务层
app.service('MoviesService',function ($http) {
    //上传电影
    this.add=function (entity,userId) {
        var formData = new FormData();
        formData.append("file",file.files[0]);
        formData.append("movies",entity);
        formData.append("userId",userId)
        return $http({
            method:'POST',
            url:'../movies/add',
            data:formData,
            headers: {'Content-Type':undefined},
            transformRequest: angular.identity
        });
    }
    //根据状态查询所有电影
    this.findAllByStatus=function (page,rows,moviesStatu) {
        return $http.get('../movies/getAll?page='+page+'&rows='+rows+'&moviesStatu'+moviesStatu);
    }
    //根据电影id查询电影
    this.findByMoviesId=function (moviesId) {
        return $http.get('../movies/getByMoviesId?moviesId='+moviesId);
    }
    //根据状态，类别，用户id等条件查询电影
    this.findByCondition=function (entity,page,rows) {
        return $http.post('../movies/getByStatu',entity,page,rows);
    }
    //删除电影
    this.dele=function (moviesId) {
        return $http.get('../movies/deleteById?moviesId='+moviesId);
    }
});