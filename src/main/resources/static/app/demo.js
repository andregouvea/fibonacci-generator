var app = angular.module('demo', []);
   
app.controller('TaskCtrl', function($scope, $http){
	$scope.result = "";
	$scope.task = "";
	
	$scope.sendPost = function() {
        var data = {
        		"task" : $scope.task
        }
        
        $http.post("/task", data).then(function(response, status) {
        	console.log(response.data);
            $scope.obj = response.data;
        }, function errorCallback(response) {
        	console.log(response);
        })
    }    	
	
});

