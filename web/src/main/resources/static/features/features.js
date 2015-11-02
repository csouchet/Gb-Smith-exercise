/**
 * Copyright 2015 Souchet Céline
 */

angular.module('org.csouchet.gbsmith.features', ['org.csouchet.gbsmith.features.user'])

    .config(function ($stateProvider, $urlRouterProvider) {

        // Ionic uses AngularUI Router which uses the concept of states
        // Learn more here: https://github.com/angular-ui/ui-router
        // Set up the various states which the app can be in.
        // Each state's controller can be found in controllers.js
        $stateProvider

            // setup an abstract state for the tabs directive
            .state('tabs', {
                url: "/tab",
                abstract: true,
                templateUrl: "features/tabs.html"
            })

            // Each tab has its own nav history stack:
            .state('tabs.addUser', {
                url: '/user/new',
                templateUrl: "features/user/new.html",
                controller: 'UserCtrl'
            })
            .state('tabs.findUser', {
                url: '/user/find?:id',
                templateUrl: "features/user/find.html",
                controller: 'UserCtrl'
            })
            .state('tabs.deleteUser', {
                            url: '/user/delete?:id',
                            templateUrl: "features/user/delete.html",
                            controller: 'UserCtrl'
                        });

        // if none of the above states are matched, use this as the fallback
        $urlRouterProvider.otherwise('/tab/user');

    });