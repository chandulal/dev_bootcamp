'use strict';

angular.module('shoppy').controller('ActionsController', function ($scope, $state) {
    $scope.productsCount = function(){
        $state.go("base.products");
    };
})
.controller('BaseController', function ($scope, $state) {
    $scope.showPage = function(pageName){
        $state.go(pageName,{},{reload: true});
    };
});;



