//点赞电影控制层
app.controller('UserLikeMovieController',function ($scope,$http,$controller,UserLikeMovieService) {
    $controller('baseController',{$scope:$scope});
    //点赞
    $scope.add=function (userId,moviesId) {
        UserLikeMovieService.add(userId,moviesId).success(
            function (response) {
                alert(response.message);
            }
        );
    }
    //查询所有喜欢的视频
    $scope.getAll=function (userId,page,rows) {
        UserLikeMovieService.getAll(userId,page,rows).success(
            function (response) {
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;
            }
        );
    }
});