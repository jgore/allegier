app.controller("categoryController", function($scope, $http,Product,$location){
    console.log("category Controller started");

    $scope.link = '/#products/';

    this.getAll = function () {
        Product.query().$promise.then(function (data) {
            $scope.products = data;
        });
    };

    this.getAll();



});