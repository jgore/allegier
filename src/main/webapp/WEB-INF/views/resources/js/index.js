app.controller("indexController", function($scope, $http,Product){
    console.log("index Controller started");

    $scope.container = {};
    $scope.error_message_rest = "cannot load data from server";

    this.getAll = function () {
        Product.query().$promise.then(function (data) {
            $scope.products = data;
        });
    };

    this.getAll();

});