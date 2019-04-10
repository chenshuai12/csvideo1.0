//视频举报控制层
app.controller('VideosReportController',function ($scope,$http,$controller,VideosReportService){
    $controller('baseController',{$scope:$scope});
    //举报用户
    $scope.add=function (entity) {
        VideosReportService.add(entity).success(
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