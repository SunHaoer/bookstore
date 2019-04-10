angular.
module('manageProduct').
component('manageProduct', {
	templateUrl: 'manage-product/manage-product.template.html',
	controller: ['$scope', '$http', '$location', function($scope, $http, $location) {
		var uri1 = 'http://localhost:8080';
		var uri = uri1;

		$scope.getProductListModelMessage = '';
		$scope.getProductListModel = function() {
			var productKind = $location.search()['productKind'];
			$http({
					withCredentials: true,
					method: 'GET',
					url: uri + '/manageProduct/getManageProductViewModel',
					params: ({}),
				}).then(function success(response) {
					var data = response.data;
					if (data.success) {
						var product = data.productList;
						$scope.productKindList = data.productKindList;
						$scope.productList = data.productList;
						//console.log($scope.productList);
					} else {
						$scope.getProductListModelMessage = 'not success';
					}
				}),
				function error(response) {
					$scope.getProductListModelMessage = 'network error';
				}
		}
		$scope.getProductListModel();

		$scope.updateProductByIdMessage = '';
		$scope.updateProductById = function(productId, productName, productKind, productPrice, productCount, productDesc) {
			//console.log(productId, productName, productKind, productPrice, productCount, productDesc)
			$http({
					withCredentials: true,
					method: 'PUT',
					url: uri + '/manageProduct/updateProductById',
					params: ({
						productId: productId,
						productName: productName,
						productKind: productCount,
						productPrice: productPrice,
						productCount: productCount,
						productDesc: productDesc
					}),
				}).then(function success(response) {
					var data = response.data;
					if (data.success) {
						alert('success');
						$scope.getProductListModel();
					} else {
						$scope.updateProductByIdMessage = 'not success';
					}
				}),
				function error(response) {
					alert('error');
					$scope.updateProductByIdMessage = 'network error';
				}
		}

		$scope.deleteProductByIdMessage = '';
		$scope.deleteProductById = function(productId) {
			//console.log(productId, productName, productKind, productPrice, productCount, productDesc)
			$http({
					withCredentials: true,
					method: 'PUT',
					url: uri + '/manageProduct/deleteProductById',
					params: ({
						productId: productId
					}),
				}).then(function success(response) {
					var data = response.data;
					if (data.success) {
						alert('success');
						$scope.getProductListModel();
					} else {
						$scope.deleteProductByIdMessage = 'not success';
					}
				}),
				function error(response) {
					$scope.deleteProductByIdMessage = 'network error';
				}
		}

	}]
})
