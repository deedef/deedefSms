/**
 * Created by S2D on 6/5/15.
 */

/*
 Dashboard Module:
 This takes care of the Dashboard page view through the Dashboard Controller.
 */
var dashboardModule = angular.module('DashboardModule',[]);

/*
 Inject appropriate dependencies (services) based on the needs of the controller
 */
dashboardModule.controller('DashboardController',['$scope', function($scope){
    resetInactive();
    $('#left_menu > a[id=dashboard]').addClass('active');

}]);