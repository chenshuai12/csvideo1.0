app.controller('VideosReportController',function ($scope,$controller,VideosReportService){
    $controller('baseController',{$scope:$scope});

    $scope.dele=function (videosReportId) {
        VideosReportService.dele(videosReportId).success(
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
        VideosReportService.getAll(page,rows).success(
          function (response) {
              $scope.list=response.rows;
              $scope.$scope.paginationConf.totalItems = response.total;
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