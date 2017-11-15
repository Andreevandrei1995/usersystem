<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/resources/angular.min.js"></script>


<html ng-app="myApp">
<head>
<meta charset="utf-8">
</head>
<body id="body">
<div ng-controller="TextController">
<form>
    <input ng-model="text.text">
    <button ng-click="save(text)">Ввод</button>
    <button ng-click="exit()">Сменить пользователя</button>
</form>

<ul id="ul">
    <li ng-repeat="text1 in text_show">{{text1.text}}</li>
</ul>
<p>{{input_response}}</p>

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

$scope.input_response= "";




$scope.save = function (request) {
    $http.post("http://localhost:8081/index2", request).then(function (response) {//обновление всех записей списка
        //проверка на то, что последнее значение было введено корректно. Признаком некорректности будет, что в последнем элементе response будет введено "incorrect input"
        var response_data = response.data;
        var length = 0;
        for(var s in response_data){
            length++;
        }

        if(response_data[length-1].text==="incorrect input"){
            $scope.input_response="Input was incorrect. Please, input message without \;\:\"\'\/\\";
            delete response_data[length-1];
            if (length-1 in response_data){}
//            console.log(response.data);
//            console.log(response_data);
        }
        else{
            $scope.input_response="Message "+response_data[length-1].text+" succesfully added";
        }
        $scope.text_show = response_data;
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
};

$scope.exit = function(){
    $http.post("http://localhost:8081/change",[]).then(function(response){
        var elem1 = document.createElement("form");
        elem1.setAttribute("name","forma");
        elem1.setAttribute("action","/auth");
        elem1.setAttribute("method","post");
        document.getElementById("body").appendChild(elem1);
        document.forma.submit();
    })
}

}
);



</script>