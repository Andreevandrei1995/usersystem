
<%--suppress JSUnresolvedVariable --%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
</head>
<body>
<spring:form modelAttribute="Strochka1" method="get" action="/validate/addText">
    <spring:input path="strochka" value="10"/>
    <spring:button>check_user</spring:button>

</spring:form>


<p>
    ${textArea12}
</p>


</body>
</html>