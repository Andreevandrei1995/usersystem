<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/resources/angular.min.js"></script>


<html ng-app="myApp">
    <head>
        <meta charset="utf-8">
    </head>

    <body ng-controller="AuthController" id="body1">

        <div>
            <form>
                <input ng-model="auth_data.login"/>
                <input ng-model="auth_data.password"/>
                <button ng-click="auth(auth_data)">Input</button>
            </form>
        </div>
        <div>
            <p>{{message}}</p>
        </div>



    </body>



</html>

<script>
    var myApp2 = angular.module("myApp", []);
    myApp2.controller('AuthController',
        function($scope,$http) {
            $scope.message = "";
            $scope.auth_data ={
                login:"",
                password:""
            };
            $scope.auth = function(message){
                $http.post("http://localhost:8081/auth_decision",message).then(function(response){
                    if (response.data == true){
                        var elem1 = document.createElement("form");

                        elem1.setAttribute("name","forma");
                        elem1.setAttribute("action","/index");
                        elem1.setAttribute("method","post");
                        document.getElementById("body1").appendChild(elem1);
                        document.forma.submit();
                    }
                    else{
                        $scope.message = "Input correct login and password";
                    }
                })
            }
        }
    )
</script>


