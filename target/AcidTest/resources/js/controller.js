angularRoutingApp.controller('mainController', function($scope, $http) {
	$scope.message = 'Servicio de autenticacion';
	$scope.loadedImage = undefined;
    
    $scope.submit = function() {
        var req = $scope.prepareRequest($scope.user.username, 
        		$scope.loadedImage.base64);
        
        $http(req).then(function(response) {
        	console.log(response.data);
        });
    };
    
	$scope.prepareRequest = function(username, imageBase64) {	
		var req = {
			method : 'POST',
			url : 'http://localhost:8080/AcidTest/rest/login',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : {"username": username, "image": imageBase64}
		}
		return req;
	}
     
});