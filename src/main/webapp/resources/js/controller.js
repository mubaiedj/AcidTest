angularRoutingApp.controller('mainController', function($scope, $http, $window) {
	$scope.message = 'Basic Authentication Service';
	$scope.loadedImage = undefined;
	$scope.error = false;
	$scope.errorMessage = undefined;
    
    $scope.submit = function() {
    	if($scope.validateInputs()){
	        var req = $scope.prepareRequest($scope.user.username, 
	        		$scope.loadedImage.base64);
	        
	        $http(req).then(function(response) {
	        	console.log(response.data);
	        	$window.location.href = '#/welcome';
	        }).catch(function(response) {
		        $scope.error = true;
		        $scope.errorMessage = response.status + " - "+ response.statusText;
	        });
    	}
    };
    
	$scope.prepareRequest = function(username, imageBase64) {	
		var req = {
			method : 'POST',
			url : '/AcidTest/rest/login',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : {"username": username, "image": imageBase64}
		}
		return req;
	}
	
	$scope.validateInputs = function() {
		$scope.error = false;
		if(!($scope.user && $scope.user.username)){
			$scope.error = true;
			$scope.errorMessage = "Username cannot be empty";
			return false;
		}
		
		if(!$scope.loadedImage){
			$scope.error = true;
			$scope.errorMessage = "Image cannot be empty";
			return false;
		}
		
		return true;
	};
     
});

angularRoutingApp.controller('welcomeController', function($scope, $http, $window) {
	$scope.message = 'Welcome. You are in..!';
	$scope.back = function() {
		$window.location.href = '#/';
	};
});