
var app = angular.module("app", ["ngRoute", "ActualUser"])
    .config(function ($routeProvider) {
        $routeProvider.when("/login", {
            templateUrl: "views/login.html"
        });
        $routeProvider.when("/register", {
            templateUrl: "/views/register.html"
        });
        $routeProvider.when("/manager", {
            templateUrl: "/views/page-manager.html"
        });
        $routeProvider.when("/supervisor", {
            templateUrl: "/views/page-supervisor.html"
        });
        $routeProvider.otherwise({
            templateUrl: "/views/register.html"
        });
    });