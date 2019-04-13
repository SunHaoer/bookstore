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
                    // 请求成功执行代码
                    alert("成功")
                }, function(response) {
                    // 请求失败执行代码
                    alert("失败")
                });

					
					
// 					$http({
// 							headers: {'Content-Type': undefined},
// 							withCredentials: true,
// 							method: 'POST',
// 							url: uri + '/222',
// 							data: {
// 								productName: product.name,
// 								productPrice: product.price,
// 								productKind: product.kind,
// 								productCount: product.count,
// 								productImage: file,
// 								productDesc: product.desc
// 							},
// 							//file: file
// 						}).then(function success(response) {
// 							alert('success');
// 						}),
// 						function error(response) {
// 							alert('error');
// 						}
				
			
		}
	}]
})
