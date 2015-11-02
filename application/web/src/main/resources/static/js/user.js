angular.module('UserModule', [])
.service('UserService', ['$http','$q', function($http, $q) {
    return {
        getUser: function() {
            var deferred = $q.defer();

            $http.get('/user')
                .then(function (response) {
                    if (response.status == 200) {
                        deferred.resolve(response.data);
                    }
                    else {
                        deferred.reject('Error retrieving user');
                    }
            });

            return deferred.promise;
        }

.controller('UserController', function($scope) {
	$scope.greeting = {
		id : 'xxx',
		content : 'Hello World!'
	}

	function Hello($scope, $http) {
		$http.get('/user').success(function(data) {
			$scope.user = data;
		});
	}
});