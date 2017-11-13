
<%--suppress JSUnresolvedVariable --%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<spring:form modelAttribute="auth" method="post" action="/auth/result">
    <spring:input path="login"/>
    <spring:input path="password"/>
    <spring:button>check_user</spring:button>
</spring:form>

<p>
    ${cookie.lgn.value}
</p>
</body>
</html>