app.controller("indexController", function($scope, $http){
    console.log("index Controller started");

    $scope.container = {};
    $scope.error_message_rest = "cannot load data from server";

    $http.get("rest/products").then(function success(response) {
        $scope.products = response.data['data'];
    }, function error(response) {
        $scope.products = [];
    });

});