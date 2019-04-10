app.controller('CommentsController',function ($scope,$controller,CommentsService){
    $controller('baseController',{$scope:$scope});//继承

    //根据用户id查询所有评论
    $scope.findAllByUserId=function (userId) {
        CommentsService.findAllByUserId(userId).success(
            function (response) {
                $scope.list=response; //显示当前页数据
            }
        );
    }
    //删除评论
    $scope.dele=function (commentId) {
        if (confirm('删除之后将不会再显示此评论！')){
            CommentsService.dele(commentId).success(
                function (response) {
                    if (response.success){
                    }else {
                        alert(response.message);
                    }
                }
            );
        }
    }

});