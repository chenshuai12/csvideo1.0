//电影管理服务
app.service('MoviesDieService',function ($http) {
    //根据状态查询电影
    this.getAll=function (page,rows,moviesStatu) {
        return $http.get('../movies/getAll?page='+page+'&rows='+rows+'&moviesStatu='+moviesStatu);
    }
    //根据用户id查询电影
    this.getByUserId=function (userId, page, rows) {
        return $http.get('../movies/getByUserId?userId='+userId+'&page='+page+'&rows='+rows);
    }
    //修改电影
    this.update=function (entity) {
        return $http.post("../movies/update",entity)
    }
    //根据电影id查找电影
    this.getByMoviesId=function (moviesId) {
        return $http.get('../movies/getByMoviesId?moviesId='+moviesId);
    }
});