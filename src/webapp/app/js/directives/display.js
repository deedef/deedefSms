/**
 * Created by S2D on 8/16/15.
 */

var displayDirective = angular.module('DisplayDirective', []);

displayDirective.directive('DisplayMessage', function() {
    return {
        restrict: 'E',
        scope: {
            messageType: '=type',
            message: '=data'
        },
        template: '<div class="alert {{messageType}}">{{message}}</div>',
        link: function (scope, element, attributes) {
            scope.$watch(attributes, function (value) {
                console.log(attributes);
                console.log(value);
                console.log(element[0]);
                element[0].children.hide();
            });
        }
    }
});