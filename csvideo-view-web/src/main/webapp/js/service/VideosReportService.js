//视频举报服务
app.service('VideosReportService',function ($http) {
    this.add=function (entity) {
        return $http.post('../videosReport/add',entity);
    }
});