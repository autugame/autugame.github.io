<%--
  Created by IntelliJ IDEA.
  User: autumn
  Date: 5/5/2023
  Time: 11:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
test
    <jsp:forward page="test2.jsp">
        <jsp:param name="name" value="zhangsan"></jsp:param>
        <jsp:param name="sex" value="man"></jsp:param>
    </jsp:forward>
</body>
</html>
