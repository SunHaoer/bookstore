angular.
module('addProduct').
component('addProduct', {
	templateUrl: 'add-product/add-product.template.html',
	controller: ['$scope', '$http', '$location', function($scope, $http, $location) {

		$scope.submit = function() {
			var file = document.getElementById("uploadFile").files[0];
			var form = new FormData(document.getElementById("addProductForm"));
			$http({
				url: uri + "/addProduct/addProduct",
				method: "post",
				data: form,
				transformRequest: angular.identity,
				headers: {
					'Content-Type': undefined
				}
			}).then(function(response) {
				var data = response.data;
				if (data.success) {
					alert('success');
					document.getElementById("addProductForm").reset();
				} else {
					alert('not limit');
				}
			}, function(response) {
				alert('error')
			});

		}
	}]
})
