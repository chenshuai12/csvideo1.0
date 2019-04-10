//服务层
app.service('MovieCategoryService',function ($http) {
    //查看所有分类
    this.fandAll=function () {
        return $http.get('../MovieCategory/getAll');
    }
});