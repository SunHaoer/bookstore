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
        when('/phone/registerPage', {
            template: '<register-page></register-page>'
        }).
        when('/phone/replacePage', {
            template: '<replace-page></replace-page>'
        }).
        when('/phone/deletePage', {
            template: '<delete-page></delete-page>'
        }).
        when('/phone/checkPage', {
            template: '<check-page></check-page>'
        }).
        when('/phone/registerCheckPage', {
            template: '<register-check-page></register-check-page>'
        }).when('/phone/replaceCheckPage', {
            template: '<replace-check-page></replace-check-page>'
        }).when('/phone/successPage', {
            template: '<success-page></success-page>'
        }).
        when('/phone/errorPage', {
            template: '<error-page></error-page>'
         }).
        when('/phone/doubleCheck', {
            template: '<double-check></double-check>'
        }).
        otherwise('/bookstore');
    }
]);