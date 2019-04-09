angular.
module('cartPage').
component('cartPage', {
	templateUrl: 'cart-page/cart-page.template.html',
	controller: ['$scope', '$http', '$location', function($scope, $http, $location) {
		var uri1 = 'http://localhost:8080';
		var uri = uri1;

		$scope.getCartModelMessage = '';
		$scope.getCartModel = function() {
			$http({
					withCredentials: true,
					method: 'GET',
					url: uri + '/cart/getCartPageViewModel',
					params: ({}),
				}).then(function success(response) {
					var data = response.data;
					if (data.success) {
						$scope.cartList = data.cartList;
						$scope.priceCount = data.priceCount.toFixed(2);
						console.log(data);
					} else {
						$scope.getCartModelMessage = 'not success';
					}
				}),
				function error(response) {
					$scope.getCartModelMessage = 'network error';
				}
		}
		$scope.getCartModel();

		$scope.addProductToCart = function(productId) {
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
						$scope.getCartModel();
					} else {
						alert(data.message);
					}
				}),
				function error(response) {
					alert('net work error');
				}
		}

		$scope.subProductToCart = function(productId) {
			$http({
					withCredentials: true,
					method: 'POST',
					url: uri + '/cart/subProductToCartById',
					params: ({
						productId: productId,
					}),
				}).then(function success(response) {
					var data = response.data;
					if (data.success) {
						$scope.getCartModel();
					} else {
						alert(data.message);
					}
				}),
				function error(response) {
					alert('net work error');
				}
		}
		
		$scope.deleteProductToCart = function(productId) {
			$http({
					withCredentials: true,
					method: 'POST',
					url: uri + '/cart/deleteProductToCartById',
					params: ({
						productId: productId,
					}),
				}).then(function success(response) {
					var data = response.data;
					if (data.success) {
						$scope.getCartModel();
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
