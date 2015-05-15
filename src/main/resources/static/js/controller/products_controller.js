'use strict';

angular.module('shoppy').controller('ProductsController', function ($scope, $http) {
    $http.get("http://localhost:8080/products")
        .success(function(response) {
            $scope.allProducts = response;
        });
    });