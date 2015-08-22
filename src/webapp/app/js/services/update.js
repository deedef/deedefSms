/**
 * Created by S2D on 6/5/15.
 */

/*
 Create Service:
 This service takes care of the update of data to a database.
 */
var updateService = angular.module('UpdateService',['ngResource']);

updateService.factory('Update',['$resource',function($resource){

    var update = $resource(
        '{api link to update item}',
        {},
        {
            query: {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                params:{

                },
                isArray: true
            }
        });

    return update;

}]);