/**
 * Created by S2D on 6/5/15.
 */

/*
 Delete Service:
 This service takes care of the deletion of data from a database.
 */
var deleteService = angular.module('DeleteService',['ngResource']);

deleteService.factory('Delete',['$resource',function($resource){

    var remove = $resource(
        '{api link to delete item}',
        {},
        {
            query: {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
                params:{

                },
                isArray: true
            }
        });

    return remove;

}]);