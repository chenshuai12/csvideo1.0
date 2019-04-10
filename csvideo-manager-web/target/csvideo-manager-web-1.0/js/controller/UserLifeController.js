app.controller('UserLifeController',function ($scope,$controller,UserLifeService) {
    $controller('baseController',{$scope:$scope});

    //封禁用户
    $scope.close=function () {
        UserLifeService.close($scope.entity).success(
            function(response){
                alert(response.message);
            }
        );
    }

    //查找单个用户
    $scope.findOne=function (userId) {
        UserLifeService.findOne(userId).success(
            function (response) {
                $scope.entity = response;
            }
        )
    }

    $scope.getAll=function (page,rows,userStatu) {
        UserLifeService.getAll(page,rows,userStatu).success(
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
            $scope.getAll( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage,1);
        }
    };

});