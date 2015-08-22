/**
 * Created by S2D on 6/5/15.
 */

/*
 Credits Module:
 This takes care of the Credits page view through the Credits Controller.
 */
var creditsModule = angular.module('CreditsModule',[]);

/*
 Inject appropriate dependencies (services) based on the needs of the controller
 */
creditsModule.controller('CreditsController',['$scope', function($scope){
    resetInactive();
    $('#left_menu > a[id=credits]').addClass('active');
}]);