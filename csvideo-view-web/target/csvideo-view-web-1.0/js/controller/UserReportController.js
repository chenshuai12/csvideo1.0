//用户举报控制层
app.controller('UserReportController',function ($scope,$http,$controller,UserReportService){
    $controller('baseController',{$scope:$scope});
    //举报用户
    $scope.add=function (entity) {
        UserReportService.add(entity).success(
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