/**
 * Created by S2D on 6/5/15.
 */

/*
 Sent Module:
 This takes care of the Sent page view through the Sent Controller.
 */
var sentModule = angular.module('SentModule',[]);

/*
 Inject appropriate dependencies (services) based on the needs of the controller
 */
sentModule.controller('SentController',['$scope', function($scope){
    resetInactive();
    $('#left_menu > a[id=sent]').addClass('active');
}]);