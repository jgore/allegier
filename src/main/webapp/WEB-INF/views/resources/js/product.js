app.controller("productController", function($scope, $http, $routeParams,$location){
    console.log("productController Controller started");

    $scope.container = {};
    $scope.error_message_rest = "cannot load data from server";

    var path = "rest"+ $location.url();

    $http.get(path).then(function success(response) {
        console.log("get "+path);
        $scope.product = response.data['data'];
    }, function error(response) {
        $scope.product = [];
    });

});