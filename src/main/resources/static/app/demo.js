var app = angular.module('demo', []);
   
app.controller('StatusCtrl', function($scope, $http) {
	$http.get("/status").
        then(function(response) {
        	console.log(response);
            $scope.status = response.data;
        }, function errorCallback(response) {
        	console.log(response);
        });
});

app.controller('TaskCtrl', function($scope, $http){
	$scope.result = "";
	$scope.task = "";
	
	$scope.sendPost = function() {
        var data = {
        		"task" : $scope.task
        }
        
        $http.post("/task", data).then(function(response, status) {
        	
            $scope.result = response.data;
        }, function errorCallback(response) {
        	console.log(response);
        })
    }    	
	
});

