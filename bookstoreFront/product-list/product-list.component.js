angular.
    module('productList').
    component('productList', {
        templateUrl: 'product-list/product-list.template.html',
        controller: ['$scope', '$http', '$location', function RegisterPageCtrl($scope, $http, $location) {
           var uri1 = 'http://localhost:8080';
           var uri = uri1;
					 
					 $scope.getProductListModelMessage = '';
					 $scope.getProductListModel = function () {
					 	$http({
					 		withCredentials: true,
					 		method: 'GET',
					 		url: uri + '/productList/getProductListPageViewModel',
					 		params: ({
					 			
					 		}),
					 	}).then(function success(response) {
					 		var data = response.data;
					 		if(data.success) {
					 			var product = data.productList;
					 			$scope.productKindList = data.productKindList;
					 			$scope.productList = data.productList;
								console.log($scope.productList);
					 		} else {
					 			$scope.getProductListModelMessage = 'not success';
					 		}
					 	}), function error(response) {
					 		$scope.getProductListModelMessage = 'network error';
					 	}
					 }
					 $scope.getProductListModel();
            
        }]
    })