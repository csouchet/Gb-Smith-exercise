/**
 * Copyright 2015 Souchet Céline
 */
(function () {
    'use strict';
    angular.module('org.csouchet.gbsmith.features.user.service', ['ngResource'])
        .factory('UserService', ['$resource', function ($resource) {
            return $resource("/user/api/:id");
        }]);
})();
