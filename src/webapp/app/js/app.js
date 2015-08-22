/**
 * Created by S2D on 5/31/15.
 */

'use strict';

/**
 * Application Module - Main
 */
var deedefsms = angular.module('deedefsms',[
    'deedefsmsControllers',
    'deedefsmsServices',
    'deedefsmsDirectives',
    'deedefsmsFilters',
    'ngRoute'
]);

/*
Configure the routes for the different page views
 */
deedefsms.config(['$routeProvider', function($routeProvider){
    $routeProvider.
        when('/dashboard',{
            templateUrl:'partials/dashboard.html',
            controller:'DashboardController'
        }).
        when('/send',{
            templateUrl:'partials/send.html',
            controller:'SendController'
        }).
        when('/sent',{
            templateUrl:'partials/sent.html',
            controller:'SentController'
        }).
        when('/contacts',{
            templateUrl:'partials/contacts.html',
            controller:'ContactsController'
        }).
        when('/credits',{
            templateUrl:'partials/credits.html',
            controller:'CreditsController'
        }).
        when('/settings',{
            templateUrl:'partials/settings.html',
            controller:'SettingsController'
        }).
        otherwise({
            redirectTo:'/dashboard'
        });
}]);

// Application options
var options = {};
options.api = {};
options.api.base_url = "http://localhost:8081/api";

// Add interceptor
deedefsms.config(function ($httpProvider) {
    $httpProvider.interceptors.push('TokenInterceptor');
});

// Re-route if no authentication and no token
deedefsms.run(function($rootScope, $location, $window, AuthenticationService) {
    $rootScope.$on("$routeChangeStart", function(event, nextRoute, currentRoute) {
        //redirect only if both isAuthenticated is false and no token is set
        if (nextRoute != null && nextRoute.access != null && nextRoute.access.requiredAuthentication
            && !AuthenticationService.isAuthenticated && !$window.sessionStorage.token) {
            $location.path("/login");
        }
    });
});