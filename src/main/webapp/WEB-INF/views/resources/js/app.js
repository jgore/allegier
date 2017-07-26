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
        .otherwise({
            redirectTo: '/index'
        });
}]);


app.factory("httpService", function ($http) {

    var httpService = {};

    httpService.genericGet = function (url, container, args, successFn, failFn) {
        var responsePromise = $http.get(url);
        console.log( url );
        responsePromise.success(function (data, status, headers, config) {
            if (!successFn) {
                container.data = data['data'];
            } else {
                successFn(data, container, args);
            }
        });
        responsePromise.error(function (data, status, headers, config) {
            if (failFn) {
                failFn(data, args);
            }
            console.log("GET request failure " + url);
        });
    };

    httpService.genericPost = function (url, container, data, args, successFn, failFn) {
        var responsePromise = $http.post(url, data);
        responsePromise.success(function (data, status, headers, config) {
            console.log("POST response : " + JSON.stringify(data));
            if (successFn) {
                successFn(data, container, args);
            }
        });
        responsePromise.error(function (data, status, headers, config) {
            console.log("POST request failure " + url);
            if (failFn) {
                failFn(data, args);
            }
        });
    };

    httpService.genericPut = function (url, container, data, args, successFn, failFn) {
        var responsePromise = $http.put(url, data);
        responsePromise.success(function (data, status, headers, config) {
            console.log("PUT response : " + JSON.stringify(data));
            if (successFn) {
                successFn(data, container, args);
            }
        });
        responsePromise.error(function (data, status, headers, config) {
            console.log("PUT request failure " + url);
            if (failFn) {
                failFn(data, args);
            }
        });
    };

    httpService.genericDelete = function (url, urlGet, container, args, successFn, failFn) {
        var responsePromise = $http.delete(url);
        responsePromise.success(function (data, status, headers, config) {
            console.log("DELETE response : " + JSON.stringify(data));
            if (successFn) {
                successFn(data, container, args);
            }
        });
        responsePromise.error(function (data, status, headers, config) {
            console.log("DELETE request failure " + url);
            if (failFn) {
                failFn(data, args);
            }
        });
    };

    httpService.genericPostAndRefresh = function (url, urlGet, scope, data, args, success, fail) {
        httpService.genericPost(url, scope, data, args, function (data, container, args) {
                httpService.genericGet(urlGet, scope);
                success(data, container, args);
            }, fail
        );
    };

    httpService.genericPutAndRefresh = function (url, urlGet, scope, data, args, success, fail) {
        httpService.genericPut(url, scope, data, args, function (data, container, args) {
                httpService.genericGet(urlGet, scope);
                success(data, container, args);
            }, fail
        );
    };

    httpService.genericDeleteAndRefresh = function (url, urlGet, scope, args, success, fail) {
        httpService.genericDelete(url, urlGet, scope, args, function (data, container, args) {
                httpService.genericGet(urlGet, scope);
                success(data, container, args);
            }, fail
        );
    };

    return httpService;
});

angular.element(function() {
    angular.bootstrap(document, ['app']);
});