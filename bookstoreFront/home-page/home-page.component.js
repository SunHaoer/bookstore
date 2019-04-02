angular.
module('homePage').
component('homePage',{
    templateUrl:'home-page/home-page.template.html',
    controller: ['$scope', '$http', '$location', function ($scope, $http, $location) {
		var uri1 = 'http://localhost:8080';
		var uri = uri1;
		
		$scope.isLogin = false;
		$scope.getProductListModel = function () {
			$http({
				withCredentials: true,
				method: 'GET',
				url: uri + '/index/getHomePageViewModel',
				params: ({
				}),
			}).then(function success(response) {
				var data = response.data;
				if(data.success) {
					$scope.productKindList = data.productKindList;
					$scope.loginUsername = data.loginUsername;
					$scope.isLogin = true;
					//alert($scope.loginUsername);
					//console.log($scope.productKindList);
				} else {
					$scope.message = 'error';
				}
			}), function error(response) {
				$scope.message = 'error';
			}
		}
		$scope.getProductListModel();
        
    }]
});