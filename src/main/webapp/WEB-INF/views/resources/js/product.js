app.controller("productController", function($scope, $http, $routeParams,$location,Product){
    console.log("productController Controller started");

    this.product = null;
    var id = $routeParams.id;

    this.get = function (id) {
        Product.get({ id: id}).$promise.then(function (data) {
            $scope.product = data;
        });
    };

    this.get(id);



});