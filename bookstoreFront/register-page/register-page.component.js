angular.
module('registerPage').
component('registerPage', {
	templateUrl: 'register-page/register-page.template.html',
	controller: ['$scope', '$http', function($scope, $http, $location) {

		function initAugularObject() {
			$scope.user = {
				"username": "",
				"password": "",
				"phone": "",
				"gender": ""
			};
			$scope.usernameOK = false;
			$scope.passwordOK = false;
			$scope.password2OK = false;
			$scope.phoneCodeOK = false;
		}
		initAugularObject();
		
		$scope.validateUsernameMessage = '';
		$scope.validateUsername = function() {
			$scope.usernameOK = false;
			$http({
					withCredentials: true,
					method: 'GET',
					url: uri + '/register/validateUsername',
					params: ({
						userUsername: $scope.user.username
					}),
				}).then(function success(response) {
					var data = response.data;
					if (data.success) {
						if (data.isLegal) {
							$scope.usernameOK = true;
							$scope.validateUsernameMessage = '';
						} else {
							$scope.validateUsernameMessage = 'username is exsited';
						}
					} else {
						$scope.validateUsernameMessage = data.message;
					}
				}),
				function error(response) {
					$scope.validateUsernameMessage = 'error';
				}
		}
		
		$scope.validatePasswordMessage = '';
		$scope.validatePassword = function() {
			$scope.passwordOK = false;
			if($scope.user.password.length >= 6) {
				$scope.passwordOK = true;
				$scope.validatePasswordMessage = '';
			} else {
				$scope.validatePasswordMessage = 'password is too short';
			}
		}
		
		$scope.validatePassword2Message = '';
		$scope.validatePassword2 = function() {
			$scope.password2OK = false;
			if($scope.user.password == $scope.password2) {
				$scope.password2OK = true;
				$scope.validatePassword2Message = '';
			} else {
				$scope.validatePassword2Message = 'two password are not equals';
			}
		}

		$scope.getPhoneCodeMessage = '';
		$scope.getPhoneCode = function() {
			$scope.phoneCodeOK = false;
			var phone = $scope.user.phone;
			if (!(/^1(3|4|5|7|8)\d{9}$/.test(phone))) {
				$scope.getPhoneCodeMessage = 'phone is not legal';
				alert('phone is not legal');
			} else {
				$http({
						withCredentials: true,
						method: 'GET',
						url: uri + '/register/getPhoneCode',
						params: ({
							userPhone: phone
						}),
					}).then(function success(response) {
						var data = response.data;
						if (data.success) {
							if (data.isLegal) {
								$scope.phoneCodeOK = true;
								$scope.getPhoneCodeMessage = '';
							} else {
								$scope.getPhoneCodeMessage = 'error';
							}
						} else {
							$scope.getPhoneCodeMessage = data.message;
						}
					}),
					function error(response) {
						$scope.getPhoneCodeMessage = 'error';
					}
			}
		}
		
		$scope.submit = function() {
			var user = $scope.user;
			if($scope.usernameOK && $scope.passwordOK && $scope.password2OK && $scope.phoneCodeOK) {
				alert('submit');
				$http({
						withCredentials: true,
						method: 'POST',
						url: uri + '/register/saveUser',
						params: ({
							userUsername: user.username,
							userPassword: user.password,
							userPhone: user.phone,
							userGender: user.gender,
							password2: $scope.password2,
							phoneCode: $scope.phoneCode
						}),
					}).then(function success(response) {
						alert('success');
					}),
					function error(response) {
						alert('error');
					}
			} else {
				alert('parameter error');
			}
		}

	}]
})
