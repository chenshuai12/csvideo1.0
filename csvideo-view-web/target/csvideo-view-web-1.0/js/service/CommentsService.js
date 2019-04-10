//评论服务
app.service('CommentsService',function ($http) {
    //根据用户id查询所有评论
    this.findAllByUserId=function (userId,page,rows) {
        return $http.get('../comment/getByUserId?userId='+userId+'&page='+page+'&rows='+rows);
    }
    //删除评论
    this.dele=function (commentId) {
        return $http.get('../comment/delete?commentId='+commentId);
    }
    //查看该短视频下的父评论
    this.findFatherCommentByVideosId=function (videosId,page,rows) {
        return $http.get('../comment/getByVideosId?videosId='+videosId+'&page='+page+'&rows='+rows);
    }
    //查看该电影下的父评论
    this.findFatherCommentByMoviesId=function (moviesId,page,rows) {
        return $http.get('../comment/getByMoviesId?moviesId='+moviesId+'&page='+page+'&rows='+rows);
    }
    //添加评论
    this.add=function (entity) {
        return $http.post('../comment/add',entity);
    }
    //查看子评论
    this.findCommentByFatherComment=function (fatherCommentId,page,rows) {
        return $http.get('../comment/getByFatherCommentId?fatherCommentId='+fatherCommentId+'&page='+page+'&rows'+rows);
    }
});