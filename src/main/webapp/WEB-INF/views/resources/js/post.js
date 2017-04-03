app.controller("postController", function ($scope, $http) {
    console.log("postController started1234");

    $scope.posts = [];

    $scope.init = function () {
        //TODO change hardcoded 999 to logged account
        $http.get("/bemaster/posts/?accountId=999")
            .then(function (response) {
                $scope.posts = response.data.data;
                }
            );
    };

});
