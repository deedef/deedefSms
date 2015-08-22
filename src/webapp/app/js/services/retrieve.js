/**
 * Created by S2D on 6/5/15.
 */

/*
 Create Service:
 This service takes care of the retrieval of data from a database.
 */
var retrieveService = angular.module('RetrieveService',['ngResource']);

retrieveService.factory('Retrieve',['$resource',function($resource){

    var retrieve = $resource(
        '{api link to retrieve item}',
        {},
        {
            query: {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                },
                params:{

                },
                isArray: true
            }
        });

    return retrieve;

}]);