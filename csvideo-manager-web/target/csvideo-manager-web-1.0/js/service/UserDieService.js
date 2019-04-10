app.service('UserDieService',function ($http) {

    this.getAll=function (page,rows,userStatu) {
        return $http.get('../user/getAll?page='+page+'&rows='+rows+'&userStatu='+userStatu);
    }

    this.findOne=function (userId) {
        return $http.get('../user/getByUserId?userId='+userId);
    }
    //封禁用户
    this.close=function (entity) {
        return $http.post('../user/close',entity);
    }

});