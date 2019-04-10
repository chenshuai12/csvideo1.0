//用户举报服务
app.service('UserReportService',function ($http) {
   this.add=function (entity) {
       return $http.post('../userReport/add',entity);
   }
});