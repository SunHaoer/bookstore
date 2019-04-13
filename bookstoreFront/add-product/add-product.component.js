angular.
module('addProduct').
component('addProduct', {
	templateUrl: 'add-product/add-product.template.html',
	controller: ['$scope', '$http', '$location', function($scope, $http, $location) {
		var uri1 = 'http://localhost:8080';
		var uri = uri1;
		
		$scope.submit = function () {
			var file = document.getElementById("uploadFile").files[0];
			//console.log(file);
			var form = new FormData(document.getElementById("addProductForm"));
			console.log(form);
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
                    if(data.success) {
						alert('success');
						document.getElementById("addProductForm").reset();
					}
                }, function(response) {
                    // 请求失败执行代码
                    alert("失败")
                });
			
		}
	}]
})
