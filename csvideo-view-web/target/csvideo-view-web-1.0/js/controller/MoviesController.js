//控制层
app.controller('MoviesController',function ($scope,$controller,MoviesService) {
   $controller('baseController',{$scope:$scope});
   //上传电影
    $scope.add=function (entity,userId) {
        MoviesService.add(entity,userId).success(
            function (response) {
                if (response.success){
                    alert("上传成功");
                    $scope.reloadLsit();
                }else {
                    alert(response.message);
                }
            }).error(function () {
                alert("上传文件发生错误");
        });
    }
    //根据电影状态查询所有电影
    $scope.findAllByStatus=function (page,rows,moviesStatu) {
        MoviesService.findAllByStatus(page,rows,moviesStatu).success(
            function (response) {
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total
            }
        );
    }
    //根据电影id查询电影
    $scope.findByMoviesId=function (moviesId) {
        MoviesService.findByMoviesId(moviesId).success(
          function (response) {
              $scope.list = response;
          }
        );
    }
    //根据状态，类别，用户id等条件查询电影
    $scope.findByCondition=function (entity,page,rows) {
        MoviesService.findByCondition(entity,page,rows).success(
            function (response) {
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;
            }
        );
    }
    //删除视频
    $scope.dele=function (moviesId) {
        MoviesService.dele(moviesId).success(
          function (response) {
              if (response.success){
                  alert(response.message);
              }else {
                  alert(response.message);
              }
          }
        );
    }

});