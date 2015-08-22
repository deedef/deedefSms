/**
 * Created by S2D on 6/5/15.
 */

/*
 Settings Module:
 This takes care of the Settings page view through the Settings Controller.
 */
var settingsModule = angular.module('SettingsModule',[]);

/*
 Inject appropriate dependencies (services) based on the needs of the controller
 */
settingsModule.controller('SettingsController',['$scope', function($scope){
    resetInactive();
    $('#left_menu > a[id=settings]').addClass('active');
}]);