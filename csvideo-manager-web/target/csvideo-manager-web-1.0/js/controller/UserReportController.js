app.controller('UserReportController',function ($scope,$controller,UserReportService){
    $controller('baseController',{$scope:$scope});
    
    $scope.dele=function (userReportId) {
        UserReportService.dele(userReportId).success(
            function (response) {
                if (response.success){
                    alert(response.message);
                    $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
                }else {
                    alert(response.message);
                }
            }
        );
    }
    $scope.getAll = function (page,rows) {
        UserReportService.getAll(page,rows).success(
          function (response) {
              $scope.list = response.rows;
              $scope.paginationConf.totalItems = response.total;
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
            $scope.getAll( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
        }
    };
});