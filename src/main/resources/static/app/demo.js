var app = angular.module('demo', []);
   
app.controller('TaskCtrl', function($scope, $http){
	$scope.result = "";
	$scope.task = "";
	
	$scope.sendPost = function() {
        
		if(window.localStorage.getItem("escapkey") === null){
			var data = {
					"task" : $scope.task
			}
			
			$http.post("/task", data).then(function(response, status) {
				console.log(response.data);
				$scope.obj = response.data;
				window.localStorage.setItem("escapkey","true");
			}, function errorCallback(response) {
				console.log(response);
			})
		}else{
			$scope.msg = "Call the staff";
		}
		
    }    	
	
});

