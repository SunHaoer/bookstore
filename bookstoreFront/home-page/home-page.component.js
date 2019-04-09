angular.
module('homePage').
component('homePage', {
	templateUrl: 'home-page/home-page.template.html',
	controller: ['$scope', '$http', '$location', function($scope, $http, $location) {
		var uri1 = 'http://localhost:8080';
		var uri = uri1;

		$scope.isLogin = false;
		$scope.getProductListModel = function() {
			$http({
					withCredentials: true,
					method: 'GET',
					url: uri + '/index/getHomePageViewModel',
					params: ({}),
				}).then(function success(response) {
					var data = response.data;
					if (data.success) {
						$scope.productKindList = data.productKindList;
						if (data.loginUsername != null) {
							$scope.loginUsername = data.loginUsername;
							$scope.isLogin = true;
						} 
					} else {
						$scope.message = 'error';
					}
				}),
				function error(response) {
					$scope.message = 'error';
				}
		}
		$scope.getProductListModel();

		$scope.logout = function() {
			$http({
					withCredentials: true,
					method: 'GET',
					url: uri + '/login/logout',
					params: ({}),
				}).then(function success(response) {
					var data = response.data;
					if (data.success) {
						//$scope.getProductListModel();
						location.reload();
					} else {
						alert('network error');
					}
				}),
				function error(response) {
					alert('network error');
				}
		}

	}]
});
