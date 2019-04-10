//控制层
app.controller('UserController',function ($scope,$controller,UserService) {
    $controller('baseController',{$scope:$scope});
    //登录
    $scope.getByIdCard=function (entity) {
        UserService.getByIdCard(entity).success(
            function (response) {
                $scope.list=response;
            }
        );
    }
    //修改头像
    $scope.updateFace=function (userId) {
        UserService.updateFace(userId).success(
            function (response) {
                if (response.success){
                    $scope.reload();
                }else {
                    alert(response.message);
                }
            }
        );
    }
    //修改普通信息
    $scope.update=function (entity) {
        UserService.update(entity).success(
          function (response) {
              if (response.success){
                  alert(response.message);
              }else {
                  alert(response.message);
              }
          }
        );
    }
    //注册
    $scope.add=function (entity) {
        UserService.add(entity).success(
          function (response) {
              $scope.list=response;
          }
        );
    }
    //查找
    $scope.getByUserId=function (userId) {
        UserService.getByUserId(userId).success(
          function (response) {
              $scope.list=response;
          }
        );
    }
});