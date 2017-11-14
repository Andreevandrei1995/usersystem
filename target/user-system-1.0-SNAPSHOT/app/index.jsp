<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/resources/angular.min.js"></script>


<html ng-app="myApp">
<head>
<meta charset="utf-8">
</head>
<body>
<div ng-controller="TextController">
<form>
    <input ng-model="text.text">
    <button ng-click="save(text)">Ввод</button>
</form>
<ul>
    <li ng-repeat="text1 in text_show">{{text1.text}}</li>
</ul>

<ul id="1"></ul>
<script ng-init="init(text)"></script>
</div>
</body>
</html>

<script type="text/javascript">

function addElement_(text) {
var elem1 = document.createElement('li');
elem1.appendChild(document.createTextNode(text));
document.getElementById('1').appendChild(elem1);
}


var myApp = angular.module("myApp", []);
myApp.controller('TextController',
function($scope,$http) {


$scope.text = {
text: ""
};

$scope.text_show = {
    y:"34"
};



$scope.save = function (request) {
    $http.post("http://localhost:8081/index2", request).then(function (response) {//обновление всех записей списка
        $scope.text_show = response.data;
        console.log($scope.text_show);
        $scope.text.text = "";
    });
    $http.post("http://localhost:8081/index3", request).then(function (response) {//добавление одной записи в список
        addElement_(response.data.text);
        $scope.text.text = "";
});
};


$scope.init = function(request){
    $http.post("http://localhost:8081/index4",request).then(function(response){
        $scope.text_show=response.data;
    });
}

}
);



</script>