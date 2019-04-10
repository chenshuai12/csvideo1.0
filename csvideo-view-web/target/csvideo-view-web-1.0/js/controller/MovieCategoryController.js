//控制层
app.controller('MovieCategoryController',function ($scope,$controller,MovieCategoryService) {
    $controller('baseController',{$scope:$scope});

    //查看所有分类
    $scope.findAll=function () {
        MovieCategoryService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    }
});