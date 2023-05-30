<%--
  Created by IntelliJ IDEA.
  User: autumn
  Date: 5/9/2023
  Time: 11:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Test3
    <hr/>
    <%
        String s1 = (String) request.getAttribute("key1");
        String s2 = (String) session.getAttribute("key2");
        String s3 = (String) application.getAttribute("key3");
    %>
    request取出的数据：<%=s1%><br/>
    session：<%=s2%><br/>
    application取出的数据：<%=s3%>
</body>
</html>
