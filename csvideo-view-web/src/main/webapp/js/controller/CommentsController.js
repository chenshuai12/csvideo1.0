app.controller('CommentsController',function ($scope,$http,$controller,CommentsService){
    $controller('baseController',{$scope:$scope});//继承


    //查看该短视频下的父评论
    $scope.findFatherCommentByVideosId=function (videosId,page,rows) {
        CommentsService.findFatherCommentByVideosId(videosId,page,rows).success(
            function (response) {
                $scope.list=response.rows;
                $scope.paginationConf.totalItems = response.total;
            }
        );
    }
    //查看该电影下的父评论
    $scope.findFatherCommentByMoviesId=function (moviesId,page,rows) {
        CommentsService.findFatherCommentByMoviesId(moviesId,page,rows).success(
            function (response) {
                $scope.list=response.rows;
                $scope.paginationConf.totalItems = response.total;
            }
        );
    }
    //添加评论
    $scope.save=function (entity) {
        CommentsService.add(entity).success(
            function (response) {
                if (response.success){
                    alert(response.message)
                }else {
                    alert(response.message);
                }
            }
        );
    }
    //查看子评论
    $scope.findCommentByFatherComment=function (fatherCommentId,page,rows) {
        CommentsService.findCommentByFatherComment(fatherCommentId,page,rows).success(
            function (response) {
                $scope.list=response.rows;
                $scope.paginationConf.totalItems = response.total;
            }
        );
    }
});