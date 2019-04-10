//点赞短视频控制层
app.controller('UserLikeVideosController',function ($scope,$http,$controller,UserLikeVideosService) {
    $controller('baseController',{$scope:$scope});
    //点赞
    $scope.add=function (userId,videoId) {
        UserLikeVideosService.add(userId,videoId).success(
            function (response) {
                alert(response.message);
            }
        );
    }
    //查询所有喜欢的视频
    $scope.getAll=function (userId,page,rows) {
        UserLikeVideosService.getAll(userId,page,rows).success(
            function (response) {
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;
            }
        );
    }
});