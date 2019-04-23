angular.
    module('productList').
    component('productList', {
        templateUrl: 'product-list/product-list.template.html',
        controller: ['$scope', '$http', '$location', function ($scope, $http, $location) {
					 
					 $scope.getProductListModelMessage = '';
					 $scope.getProductListModel = function (pageNum) {
						var productKind = $location.search()['productKind'];
					 	$http({
					 		withCredentials: true,
					 		method: 'GET',
					 		url: uri + '/productList/getProductListPageViewModel',
					 		params: ({
					 			searchStr: $scope.searchStr,
								productKind: $scope.productKind,
								priceLow: $scope.priceLow,
								priceHigh: $scope.priceHigh,
								pageNum: pageNum
					 		}),
					 	}).then(function success(response) {
					 		var data = response.data;
					 		if(data.success) {
					 			var product = data.productList;
					 			$scope.productKindList = data.productKindList;
					 			$scope.productList = data.productList;
								$scope.pageNum = data.pageNum;
								$scope.pagesCount = data.pagesCount;
								//console.log($scope.productList);
					 		} else {
					 			$scope.getProductListModelMessage = 'not success';
					 		}
					 	}), function error(response) {
					 		$scope.getProductListModelMessage = 'network error';
					 	}
					 }
					 $scope.getProductListModel(1);
					 
            
        }]
    })