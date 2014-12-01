<!doctype html>
<html ng-app>
<head>
<meta charset="utf-8" />
<meta name="author" content="Martin Bean" />
<title>Twitter&rsquo;s Bootstrap with Ryan Fait&rsquo;s Sticky Footer</title>
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../js/angular.min.js" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0/angular-resource.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0/angular-route.min.js"></script>

<style>
html, body {
height: 100%;
}
footer {
color: #666;
background: #222;
padding: 17px 0 18px 0;
border-top: 1px solid #000;
}
footer a {
color: #999;
}
footer a:hover {
color: #efefef;
}
.wrapper {
min-height: 100%;
height: auto !important;
height: 100%;
margin: 0 auto -63px;
}
.push {
height: 63px;
}
/* not required for sticky footer; just pushes hero down a bit */
.wrapper > .container {
padding-top: 60px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
<script src="https://code.angularjs.org/1.3.4/angular-resource.js"></script>
<script src="https://code.angularjs.org/1.3.4/angular-resource.min.js"></script>
<script src="https://code.angularjs.org/1.3.4/angular-resource.js"></script>

<script src="/js/angular-resource.js"> </script>
<script>
    
    
    var itemApp = angular.module('itemApp', []);

itemApp.factory('Item', function() {
  return {
    getItems: function() {
      return  [{"id": "1","price": 0.99}];
    }
  };
});

itemApp.controller('itemController', function($scope, Item) {

});
    function Hello($scope, $http) {
  $http.get('http://rest-service.guides.spring.io/greeting').
        success(function(data) {
            $scope.greeting = data;
        });
        
      
}

function Hello2($scope, $http) {
    
var item = new Object();
item.id = "testAgent2";


alert('step2');

$http.post("/item", item).success(function(data){
    //Callback function here.
    //"data" is the response from the server.
});

    alert('secure');
            $http.get('/item').
                success(function(data) {
                    alert('alper');
                    $scope.json = data;
                });
        }




    
    
</script>


</head>
<body>
<div class="wrapper">
<div class="container">
<header class="hero-unit">
<h1>Twitter&rsquo;s Bootstrap Answer King Sample Page</h1>
</header>
    <button class="btn btn-lg btn-primary" type="button" onclick="Hello();">Answer King Services</button>
</div>
<div class="push"><!--//--></div>
 
 


<div ng-controller="Hello">
			<p>The ID is {{greeting.id}}</p>
			<p>The content is {{greeting.content}}</p>
		</div>


  <div ng-controller="item">
            <p>The ID is {{item}}</p>
            <p>The content is {{item.id}}</p>
        </div>

</div>

<footer>
<div class="container">
<p>Put together in less than five minutes by <a href="http://www.martinbean.co.uk/" rel="author">Martin Bean</a>. Uses <a href="http://twitter.github.com/bootstrap/" rel="external">Twitter Bootstrap</a> and <a href="http://ryanfait.com/sticky-footer/" rel="external">Ryan Fait&rsquo;s Sticky Footer</a>.</p>
</div>
</footer>
</body>
</html> 