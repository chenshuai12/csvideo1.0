app.controller('UserDieController',function ($scope,$controller,UserDieService){
    $controller('baseController',{$scope:$scope});

    //查找单个用户
    $scope.findOne=function (userId) {
        UserDieService.findOne(userId).success(
            function (response) {
                $scope.list = response;
            }
        )
    }

    $scope.getAll=function (page,rows,userStatu) {
        UserDieService.getAll(page,rows,userStatu).success(
            function (response) {
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;
            }
        );
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

    //封禁用户
    $scope.close=function (userStatu,entity) {
        UserDieService.close(entity).success(
            function(response){
                alert(response.message);
                $scope.findAllByUserId(userStatu,$scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
            }
        );
    }

});