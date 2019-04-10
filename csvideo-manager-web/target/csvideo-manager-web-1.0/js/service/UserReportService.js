app.service('UserReportService',function ($http) {
    this.dele = function (userReportId) {
        return $http.get('../userReport/delete?userReportId=' + userReportId);

    }
    this.getAll = function (page,rows) {
        return $http.get('../userReport/findAll?page='+page+'&rows='+rows);

    }
});