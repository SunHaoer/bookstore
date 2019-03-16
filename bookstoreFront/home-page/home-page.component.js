angular.
module('homePage').
component('homePage',{
    templateUrl:'home-page/home-page.template.html',
    controller: ['$scope', '$http', '$location', function ProductListCtrl($scope, $http, $location) {
		var uri1 = 'http://localhost:8080';
		var uri = uri1;
		/*
		$scope.getProductListModel = function () {
			$http({
				method: 'GET',
				url: uri + '/index/getProductListViewModel',
				params: ({
				}),
			}).then(function success(response) {
				var data = response.data;
				if(data.success) {
					$scope.productKindList = data.productKindList;
					console.log($scope.productKindList);
				} else {
					$scope.message = 'error';
				}
			}), function error(response) {
				$scope.message = 'error';
			}
		}
		$scope.getProductListModel();
*/
        
    }]
});