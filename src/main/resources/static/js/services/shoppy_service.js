'use strict';

angular.module('shoppy').factory('ShoppyService', function (Restangular, $window) {
    return Restangular.withConfig(function (RestangularConfigurer) {
        RestangularConfigurer.setBaseUrl($window.location.pathname);
    });
});