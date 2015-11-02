angular.module('org.csouchet.gbsmith.features.user.controller', [])
    .controller('UserCtrl', ['$scope', 'UserService', function ($scope, UserService) {
        $scope.user;

        $scope.createUser = function () {
            UserService.save($scope.user);
        }

        $scope.removeUser = function (user) {
            UserService.delete({id: user.id});
        }


        $scope.getUser = function (id) {
            UserService.get({id: id}).$promise.then(function (data) {
                $scope.user = data;
            }, function (error) {
                console.log("Can't find the user : " + error);
            });
        }

    }]);