app.service('UserFansService',function ($http) {
   //添加关注
    this.add=function (userId,followId) {
        return $http.get('../userFans/add?userId='+userId+'&followId='+followId);
    }
    //取消关注
    this.dele=function (userId,followId) {
        return $http.get('../userFans/delete?userId='+userId+'&followId='+followId);
    }
    //查找所有关注的人
    this.getAllFollow=function (page,rows,entity) {
        return $http.post('../userFans/getAllFollow?page='+page+'$rows='+rows,entity);
    }
    //查找所有粉丝
    this.getAllFans=function (page,rows,entity) {
        return $http.post('../userFans/getAllFans?page='+page+'$rows='+rows,entity);
    }
});