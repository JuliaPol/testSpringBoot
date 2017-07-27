var app = angular.module("springBootDemo", []);
app.controller("AppCtrl", function ($scope, $http) {
    $scope.websites = [];

    $http({
        method : "GET",
        url : "api/websites"
    }).then(function success(response) {
        $scope.websites = response.data;
    });
});