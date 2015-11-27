/*
var app = angular.module('app', []);
app.controller('MainController', function($scope, $http){
    $scope.items = [];
	$http.get('http://localhost:8080/SimpleREST/rest/listener/getRecordByRequest/').success(function(response){
        console.log(response);
        $scope.items = response;
    }, function(response){
        
    });
});
*/

var app = angular.module('app', []);
app.controller('MainController', function($scope, $http){
    $scope.items = [];
	$http.get('http://localhost:8080/SimpleREST/rest/listener/getRecordByRequest/').success(function(response){
        console.log(response);
        $scope.items = response;
    }, function(response){

    });

    $scope.addRowAsyncAsJSON = function(){
		//$scope.items.push({ 'title':$scope.title, 'year': $scope.year, 'favorite':$scope.favorite });
		// Writing it to the server
		//
		var dataObj = {
				title : $scope.title,
				year : $scope.year,
				favorite : $scope.favorite
		};
		$scope.jsonObj = angular.toJson(dataObj, false);
		//Hanya utk menarik data dari server side
		//var res = $http.get('http://localhost:8080/SimpleREST/rest/listener/save/', dataObj);
		//
		var res = $http({
			method: 'POST',
  			data: $scope.jsonObj,
  			url:'http://localhost:8080/SimpleREST/rest/listener/save_/',
			headers: {'Content-Type':'application/json'}
  		});
		res.success(function(data, status, headers, config) {
			console.log(data);
			$scope.items = data;
		});
		res.error(function(data, status, headers, config) {
			alert( "failure message: " + JSON.stringify({data: data}));
		});
		// Making the fields empty
		//
		$scope.title='';
		$scope.year='';
		$scope.favorite='';
	};
});