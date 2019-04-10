//电影管理控制
app.controller('VideosDieController',function ($scope,$controller,VideosDieService){
    $controller('baseController',{$scope:$scope});
    //根据状态查询电影
    $scope.getAll=function (page,rows,videosStatu) {
        VideosDieService.getAll(page,rows,videosStatu).success(
            function (response) {
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;
            }
        )
    }
    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function(){
            $scope.getAll( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage,2);
        }
    };
    //根据用户id查询电影
    $scope.getByUserId=function (userId,page,rows,videosStatu) {
        VideosDieService.getByUserId(userId, page, rows,videosStatu).success(
            function (response) {
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;
            }
        );
    }
    //修改电影
    $scope.update=function (entity) {
        VideosDieService.update(entity).success(
            function (response) {
                if (response.success){
                    alert(response.message);
                }else {
                    alert(response.message);
                }
            }
        );
    }
    //根据电影id查找电影
    $scope.getByVideosId=function (videosId) {
        VideosDieService.getByVideosId(videosId).success(
            function (response) {
                $scope.list=response.rows;
            }
        );
    }
});