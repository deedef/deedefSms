/**
 * Created by S2D on 6/5/15.
 */

/*
 Send Module:
 This takes care of the Send page view through the Send Controller.
 */
var sendModule = angular.module('SendModule',[]);

/*
 Inject appropriate dependencies (services) based on the needs of the controller
 */
sendModule.controller('SendController',['$scope', function($scope){
    resetInactive();
    $('#left_menu > a[id=send]').addClass('active');
}]);