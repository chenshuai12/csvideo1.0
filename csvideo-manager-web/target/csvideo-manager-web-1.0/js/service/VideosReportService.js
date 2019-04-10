app.service('VideosReportService',function ($http) {
    this.dele = function (videosReportId) {
        return $http.get('../videosReport/delete?videosReportId=' + videosReportId);
    }
    this.getAll = function (page,rows) {
        return $http.get('../videosReport/getAll?page='+page+'&rows='+rows);
    }
});