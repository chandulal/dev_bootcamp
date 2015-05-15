'use strict';

angular.module('shoppy').controller('BaseController', function ($scope, $state) {
    $scope.showPage = function(pageName){
        $state.go(pageName,{},{reload: true});
    };
});