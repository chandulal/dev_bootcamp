'use strict';

angular.module('shoppy').service('resolvers', function (ShoppyService) {
    return {
        allProducts: function () {
            return ShoppyService.one("products").get()
        }
    };
});