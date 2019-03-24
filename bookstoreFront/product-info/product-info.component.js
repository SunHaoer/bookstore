angular.
    module('productInfo').
    component('productInfo', {
        templateUrl: 'product-info/product-info.template.html',
        controller: ['$scope', '$http', '$location', function RegisterPageCtrl($scope, $http, $location) {
					var uri1 = 'http://localhost:8080';
					var uri = uri1;
					
					$scope.getProductInfoModelMessage = '';
					$scope.getProductInfoModel = function () {
						var productId = $location.search()['productId'];
						$http({
							withCredentials: true,
							method: 'GET',
							url: uri + '/productInfo/getProductInfoViewModelById',
							params: ({
								productId:productId
							}),
						}).then(function success(response) {
							var data = response.data;
							if(data.success) {
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
						}), function error(response) {
							$scope.getProductInfoModelMessage = 'network error';
						}
					}
					$scope.getProductInfoModel();
					
        }]
    })