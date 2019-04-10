angular.
module('bookstore').
config(['$routeProvider',
	function config($routeProvider) {
		$routeProvider.
		when('/bookstore', {
			template: '<home-page></home-page>'
		}).
		when('/bookstore/homePage', {
			template: '<home-page></home-page>'
		}).
		when('/bookstore/registerPage', {
			template: '<register-page></register-page>'
		}).
		when('/bookstore/loginPage', {
			template: '<login-page></login-page>'
		}).
		when('/bookstore/productList', {
			template: '<product-list></product-list>'
		}).
		when('/bookstore/productInfo', {
			template: '<product-info></product-info>'
		}).
		when('/bookstore/cartPage', {
			template: '<cart-page></cart-page>'
		}).
		when('/bookstore/manageProduct', {
			template: '<manage-product></manage-product>'
		}).
		when('/bookstore/addProduct', {
			template: '<add-product></add-product>'
		}).
		otherwise('/bookstore');
	}
]);
