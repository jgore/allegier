app.controller("orderController", function ($scope, $routeParams, $http) {
    console.log("order  Controller started");

    $scope.orders = null;
    var accountId = $routeParams.accountId;

    this.getAll = function () {
        console.log("rest/orders?accountId=" + accountId);
        $http.get("rest/orders?accountId=" + accountId).then(function (response) {
            $scope.orders = response.data;
        });
    };
    this.getAll();

});