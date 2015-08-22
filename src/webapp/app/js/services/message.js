/**
 * Created by S2D on 8/16/15.
 */

var messageService = angular.module('MessageService',['ngResource']);

messageService.factory("Contact", function ($resource) {

    var API_ROOT_URL = "/server/api/:item/:id/:subitem";

    var Contacts = $resource(API_ROOT_URL, {item : 'contacts', id : '@id'},
        {
            query : {method : 'GET',isArray:true,params:{category :'sms'}},
            update : {method : 'PUT'},  // PUT /server/api/movies
            queryByCategory : {method : 'GET', params : {category : 'Horreur'}}, // GET /server/api/movies?category=Horreur
            getActors : {method: 'GET', params : {subitem : 'actors'}}  // GET /server/api/movies/{id}/actors
        });

    return Contacts;

});

messageService.factory("Message", function ($resource) {

    var API_ROOT_URL = "/server/api/:item/:id/:subitem";

    var Messages = $resource(API_ROOT_URL, {item : 'messages', id : '@id'},
        {

            //ici on mets les services traitant les messages
            update : {method : 'PUT'},  // PUT /server/api/movies
            queryByCategory : {method : 'GET', params : {category : 'Horreur'}}, // GET /server/api/movies?category=Horreur
            getActors : {method: 'GET', params : {subitem : 'actors'}}  // GET /server/api/movies/{id}/actors
        });

    return Messages;

});

messageService.factory('MessageActionsService', function($http) {
    return {
        findAllPublished: function() {
            return $http.get(options.api.base_url + '/post');
        },

        findByTag: function(tag) {
            return $http.get(options.api.base_url + '/tag/' + tag);
        },

        read: function(id) {
            return $http.get(options.api.base_url + '/post/' + id);
        },

        findAll: function() {
            return $http.get(options.api.base_url + '/post/all');
        },

        changePublishState: function(id, newPublishState) {
            return $http.put(options.api.base_url + '/post', {'post': {_id: id, is_published: newPublishState}});
        },

        delete: function(id) {
            return $http.delete(options.api.base_url + '/post/' + id);
        },

        create: function(post) {
            return $http.post(options.api.base_url + '/post', {'post': post});
        },

        update: function(post) {
            return $http.put(options.api.base_url + '/post', {'post': post});
        },

        like: function(id) {
            return $http.post(options.api.base_url  + '/post/like', {'id': id});
        },

        unlike: function(id) {
            return $http.post(options.api.base_url  + '/post/unlike', {'id': id});
        }
    };
});