/**
 * Created by S2D on 6/5/15.
 */

/*
 Create Service:
 This service takes care of the creation/insertion of data into a database.
 */
var createService = angular.module('CreateService',['ngResource']);

createService.factory('Create',['$resource',function($resource){

    var create = $resource(
        '{api link to create item}',
        {},
        {
            query: {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                params:{

                },
                isArray: true
            }
        });

    return create;

}]);