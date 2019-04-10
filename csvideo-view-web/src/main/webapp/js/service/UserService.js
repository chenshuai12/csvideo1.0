//服务层
app.service('UserService',function ($http) {
    //登录
    this.getByIdCard=function (entity) {
        return $http.post('../user/getByIdCard',entity)
    }
    //修改头像
    this.updateFace=function (userId) {
        var formData = new FormData();
        formData.append("file",file.files[0]);
        formData.append("userId",userId);
        return $http({
            method:'POST',
            url:'../user/updateFace',
            data:formData,
            headers: {'Content-Type':undefined},
            transformRequest: angular.identity
        });
    }
    //修改普通信息
    this.update=function (entity) {
        return $http.post('../user/update',entity);
    }
    //注册
    this.add=function (entity) {
        return $http.post('../user/add',entity);
    }
    //查找
    this.getByUserId=function (userId) {
        return $http.get('../user/getByUserId?userId='+userId);
    }
});