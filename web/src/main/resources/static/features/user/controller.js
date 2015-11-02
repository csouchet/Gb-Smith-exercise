angular.module('org.csouchet.gbsmith.features.user.controller', ['ionic'])

.controller('UserCtrl', ['$scope', 'UserFactory', function ($scope, UserFactory ) {

	$scope.createUser = function () {
	var newUser = { 'id':$scope.id , 'firstname':$scope.firstname, 'lastname': $scope.lastname };
		UserService.create(newUser);
	}

	$scope.removeUser = function (id) {
    		UserService.remove(user);
    	}


    	$scope.find = function (id) {
        		     		UserService.find(id).then(function (user) {
                			$scope.user = user;
                		}, function (error) {
                			console.log("Can't find the user : " + error);
                		});
        	}

}]);