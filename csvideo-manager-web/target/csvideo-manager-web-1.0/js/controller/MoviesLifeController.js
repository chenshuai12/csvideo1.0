//电影管理控制
app.controller('MoviesLifeController',function ($scope,$controller,MoviesLifeService){
    $controller('baseController',{$scope:$scope});
    //根据状态查询电影
    $scope.getAll=function (page,rows,moviesStatu) {
        MoviesLifeService.getAll(page,rows,moviesStatu).success(
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
            $scope.getAll( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage,1);
        }
    };
    //根据用户id查询电影
    $scope.getByUserId=function (userId) {
        MoviesLifeService.getByUserId(userId).success(
            function (response) {
                $scope.list=response;
            }
        );
    }
    //修改电影
    $scope.update=function () {
        MoviesLifeService.update($scope.entity).success(
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
    $scope.getByMoviesId=function (moviesId) {
        MoviesLifeService.getByMoviesId(moviesId).success(
            function (response) {
                $scope.entity=response;
            }
        );
    }
    $scope.getByMoviesIds=function (moviesId) {
        MoviesLifeService.getByMoviesIds(moviesId).success(
            function (response) {
                $scope.list = response;
            }
        )
    }
});