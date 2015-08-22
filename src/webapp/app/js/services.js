/**
 * Created by S2D on 5/31/15.
 */

/*
 Main Service:
 It depends on many other services.
 These other services each have a specific functionality or purpose.
 They are separated for better structure of the overall application logic.
 */

var deedefsmsServices = angular.module('deedefsmsServices',[
    'SecurityService',
    'UserService',
    'MessageService',
    'CreateService',
    'RetrieveService',
    'UpdateService',
    'DeleteService',
    'CRUDService'
]);