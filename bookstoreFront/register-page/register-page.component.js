angular.
module('registerPage').
component('registerPage', {
	templateUrl: 'register-page/register-page.template.html',
	controller: ['$scope', '$http', function ($scope, $http, $location) {
		var uri1 = 'http://localhost:8080';
		var uri = uri1;
		
		function initAugularObject() {
			$scope.user = {
				"username": "",
				"password": "",
				"phone": "",
				"gender": ""
			};
		}
		initAugularObject();

		$scope.validateUsername = function() {
			console.log("校验username");
			alert($scope.user.username);
			$http({
				withCredentials: true,
				method: 'GET',
				url: uri + '/register/validateUsername',
				params: ({
					userUsername: $scope.user.username
				}),
			}).then(function success(response) {
				var data = response.data;
				if(data.success) {
					if(data.isLegal) {
						$scope.usernameOK = true;
					} else {
						$scope.usernameOK = false;
					}
				} else {
					$scope.usernameOK = 'error';
				}
			}), function error(response) {
				$scope.usernameOK = 'error';
			}
		}
		
	}]
})
