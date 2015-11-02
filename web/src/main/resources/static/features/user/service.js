/**
 * Copyright 2015 Souchet Céline
 */
(function () {
    'use strict';
    angular.module('org.csouchet.gbsmith.features.user.service', [])

        .factory('UserService', ['$scope', '$http', function ($scope, $http) {

            var deferred;
            var user;

            return {
                create: function (newUser) {
                                    $rootScope.$apply(function () {
                                       $http.get('user/add', {})
                                        deferred.resolve(contacts);                                    });
                },
                remove: function (id) {
                                  $rootScope.$apply(function () {
                                     $http.get('user/delete', {  })
                                                                       });
                },
                find: function (id) {
                                   $rootScope.$apply(function () {
                                      $http.get('user/find', {  user : user })
                                       deferred.resolve(user);
                                   });
                }
            };
        }])
    ;
})();