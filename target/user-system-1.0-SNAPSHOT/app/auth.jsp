<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html ng-app="MyApp">
    <head>
        <meta charset="utf-8">
    </head>

    <body>
        <p text="{message}"></p>
        <div>
            <spring:form modelAttribute="auth" method="post" action="/index">
                <spring:input path="login"/>
                <spring:input path="password"/>
                <spring:button>Ввод</spring:button>
            </spring:form>
        </div>
    </body>


</html>


