function Hello($scope, $http) {
  $http.get('http://rest-service.guides.spring.io/greeting').
        success(function(data) {
            $scope.greeting = data;
        });
        
      
}

function ItemList($scope, $http) {
      $http.get('http://localhost:8888/item/').
        success(function(data) {
            $scope.itemList = data;
        }); 
}
