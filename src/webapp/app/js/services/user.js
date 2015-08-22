/**
 * Created by S2D on 8/16/15.
 */

var userService = angular.module('UserService',['ngResource']);

userService.factory('UserActionsService', function ($http) {
    return {
        signIn: function(username, password) {
            return $http.post(options.api.base_url + '/authenticate', {username: username, password: password});
        },

        logOut: function() {
            return $http.get(options.api.base_url + '/logout');
        },

        register: function(username, password, passwordConfirmation) {
            return $http.post(options.api.base_url + '/signup', {username: username, password: password, passwordConfirmation: passwordConfirmation });
        }
    }
});