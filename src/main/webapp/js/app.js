var app = angular.module('app', []);
app.controller('MainController', function($scope, $http){
    $scope.items = [];
	$http.get('http://localhost:8080/SimpleREST/rest/listener/getRecordByRequest/').success(function(response){
        console.log(response);
        $scope.items = response;
    }, function(response){
        
    });
});