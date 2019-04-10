//控制层
app.controller('VideosController',function ($scope,$controller,VideosService) {
    $controller('baseController',{$scope:$scope});
    //上传短视频
    $scope.add=function (entity,userId) {
        VideosService.add(entity,userId).success(
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
    $scope.findAllByStatus=function (page,rows,videosStatu) {
        VideosService.findAllByStatus(page,rows,videosStatu).success(
            function (response) {
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total
            }
        );
    }
    //根据电影id查询电影
    $scope.findByVideosId=function (videosId) {
        VideosService.findByVideosId(videosId).success(
            function (response) {
                $scope.list = response;
            }
        );
    }
    //根据状态，类别，用户id等条件查询电影
    $scope.findByCondition=function (userId,page,rows,videosStatu) {
        VideosService.findByCondition(userId,page,rows,videosStatu).success(
            function (response) {
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;
            }
        );
    }
    //删除视频
    $scope.dele=function (videosId) {
        VideosService.dele(videosId).success(
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