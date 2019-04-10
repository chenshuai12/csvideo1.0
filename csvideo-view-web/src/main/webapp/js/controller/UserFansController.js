//控制层
app.controller('UserFansController',function ($scope,$http,$controller,UserFansService) {
    $controller('baseController',{$scope:$scope});
    //添加关注
    $scope.add=function (userId,followId) {
        UserFansService.add(userId,followId).success(
          function (response) {
              alert(response.message);
          }
        );
    }
    //取消关注
    $scope.dele=function (userId,followId) {
        UserFansService.dele(userId,followId).success(
          function (response) {
              alert(response.message);
          }
        );
    }
    //查找所有关注的人
    $scope.getAllFollow=function (page,rows,entity) {
        UserFansService.getAllFollow(page,rows,entity).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems=response.total;
            }
        );
    }
    //查找所有粉丝
    $scope.getAllFans=function (page,rows,entity) {
        UserFansService.getAllFans(page,rows,entity).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems.total;
            }
        );
    }
});