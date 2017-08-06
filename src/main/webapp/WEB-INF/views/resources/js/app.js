var app = angular.module('app', ['ngRoute', 'ui.bootstrap','ngResource']);
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
        .when('/category', {
            templateUrl: 'resources/templates/category.html',
            controller: 'categoryController'
        })
        .when('/products/:id', {
            templateUrl: 'resources/templates/product.html',
            controller: 'productController'
        })
        .when('/orders/:accountId', {
            templateUrl: 'resources/templates/order.html',
            controller: 'orderController'
        })
        .otherwise({
            redirectTo: '/index'
        });
}]);

app.factory('Product', ['$resource', function ($resource) {
    return $resource('rest/products/:id', {id: '@id'},
        {
            'get':    {method:'GET'},
            'save':   {method:'POST'},
            'query':  {method:'GET', isArray:true},
            'delete': {method:'DELETE'},
            'update': {method: 'PUT'}
        }
    );
}]);

app.factory('Order', ['$resource', function ($resource) {
    return $resource('rest/orders/:id', {id: '@id'},
        {
            'get':    {method:'GET'},
            'save':   {method:'POST'},
            'query':  {method:'GET', isArray:true},
            'delete': {method:'DELETE'},
            'update': {method: 'PUT'}
        }
    );
}]);
