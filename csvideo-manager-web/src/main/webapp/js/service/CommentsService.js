//评论服务
app.service('CommentsService',function ($http) {
    //根据用户id查询所有评论
    this.findAllByUserId=function (userId) {
        return $http.get('../comment/getByUserId?userId='+userId);
    }
    //删除评论
    this.dele=function (commentId) {
        return $http.get('../comment/delete?commentId='+commentId);
    }
});