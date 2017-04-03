var app = angular.module('app', ['ngRoute', 'ui.bootstrap']);
console.log("start");

app.config(['$httpProvider', function ($httpProvider) {
    $httpProvider.defaults.useXDomain = true;
    $httpProvider.defaults.headers.put["Content-Type"] = "application/json";
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
}]);

app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/index', {
            templateUrl: 'resources/templates/index.html',
            controller: 'indexController'
        })
        .when('/post', {
            templateUrl: 'resources/templates/post.html',
            controller: 'postController'
        })
        .otherwise({
            redirectTo: '/index'
        });
}]);

angular.element(function() {
    angular.bootstrap(document, ['app']);
});