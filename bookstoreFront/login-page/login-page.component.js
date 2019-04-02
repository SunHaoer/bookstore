angular.
module('loginPage').
component('loginPage', {
	templateUrl: 'login-page/login-page.template.html',
	controller: ['$scope', '$http', '$location', function($scope, $http, $location) {
		var uri1 = 'http://localhost:8080';
		var uri = uri1;
		
		function initAugularObject() {
			$scope.user = {
				"username": "",
				"password": "",
			};
		}
		initAugularObject();

		$scope.loginMessage = "";
		$scope.login = function() {
			var user = $scope.user;
			if(user.username == "" || user.userpassword == "") {
				$scope.loginMessage = 'paramter is empty';
			} else {
				$http({
						withCredentials: true,
						method: 'POST',
						url: uri + '/login/login',
						params: ({
							userUsername: user.username,
							userPassword: user.password
						}),
					}).then(function success(response) {
						var data = response.data;
						if (data.success) {
							if(data.isLegal) {
								$location.url('/bookstore');
							} else {
								$scope.loginMessage = data.message;
							}
						} else {
							$scope.loginMessage = data.message;
						}
					}),
					function error(response) {
							alert('net work error');
					}				
			}

		}

	}]
})
