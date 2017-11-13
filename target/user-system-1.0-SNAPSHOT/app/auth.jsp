<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
    <head>
        <meta charset="utf-8">
    </head>
    <body>
        <div>
            <spring:form modelAttribute="auth" method="post" action="/index">
                <spring:input path="login"/>
                <spring:input path="password"/>
                <spring:button>Ввод</spring:button>
            </spring:form>
        </div>
    </body>
</html>