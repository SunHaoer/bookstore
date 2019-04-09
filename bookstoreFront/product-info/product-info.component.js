angular.
module('productInfo').
component('productInfo', {
	templateUrl: 'product-info/product-info.template.html',
	controller: ['$scope', '$http', '$location', function RegisterPageCtrl($scope, $http, $location) {
		var uri1 = 'http://localhost:8080';
		var uri = uri1;
		var productId = $location.search()['productId'];

		$scope.getProductInfoModelMessage = '';
		$scope.getProductInfoModel = function() {
			$http({
					withCredentials: true,
					method: 'GET',
					url: uri + '/productInfo/getProductInfoViewModelById',
					params: ({
						productId: productId
					}),
				}).then(function success(response) {
					var data = response.data;
					if (data.success) {
						var product = data.productInfo;
						$scope.productKindList = data.productKindList;
						$scope.productName = product.productName;
						$scope.productPrice = product.productPrice;
						$scope.productDesc = product.productDesc;
						$scope.productCount = product.productCount;
						$scope.productImagePath = product.productImagePath;
					} else {
						$scope.getProductInfoModelMessage = 'not success';
					}
				}),
				function error(response) {
					$scope.getProductInfoModelMessage = 'network error';
				}
		}
		$scope.getProductInfoModel();

		$scope.addProductToCart = function() {
			$http({
					withCredentials: true,
					method: 'POST',
					url: uri + '/cart/addProductToCartById',
					params: ({
						productId: productId,
					}),
				}).then(function success(response) {
					var data = response.data;
					if (data.success) {
						alert('success');
					} else {
						alert(data.message);
					}
				}),
				function error(response) {
					alert('net work error');
				}
		}

	}]
})
