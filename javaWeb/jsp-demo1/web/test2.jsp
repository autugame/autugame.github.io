<%--
  Created by IntelliJ IDEA.
  User: autumn
  Date: 5/6/2023
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    This is test2
    <hr/>
    <jsp:useBean id="book" class="com.qfedu.jsp.dto.Book"></jsp:useBean>
    <jsp:setProperty name="book" property="bookId" value="100001"></jsp:setProperty>
    <jsp:getProperty name="book" property="bookId"></jsp:getProperty>
    <%
        String name = request.getParameter("name");
        Object sex = request.getParameter("sex");
    %>
    <%=name + " and " + sex%>
</body>
</html>
