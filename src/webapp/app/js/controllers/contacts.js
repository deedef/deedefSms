/**
 * Created by S2D on 6/5/15.
 */

/*
 Contacts Module:
 This takes care of the Contacts page view through the Contacts Controller.
 */
var contactsModule = angular.module('ContactsModule',[]);

/*
 Inject appropriate dependencies (services) based on the needs of the controller
 */
contactsModule.controller('ContactsController',['$scope', function($scope){
    resetInactive();
    $('#left_menu > a[id=contacts]').addClass('active');
}]);