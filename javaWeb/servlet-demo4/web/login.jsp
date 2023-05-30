<%--
  Created by IntelliJ IDEA.
  User: autumn
  Date: 5/11/2023
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>学生成绩查询系统-登录</title>
</head>
<body>
    <%
        String tips = (String) request.getAttribute("tips");
        if (tips != null){
    %>
            <label style='color: red;'><%=tips%></label>
    <%
        }
    %>
    <form action='CheckServlet' method='post'>
        <h3>学生成绩查询系统-学生登录</h3>
        <p>学号：<input type='text' name='stuNum' placeholder='学生学号'/></p>
        <p>密码：<input type='password' name='stuPwd' placeholder='登录密码'/></p>
        <p><input type='submit' value='登录'/></p>
    </form>
</body>
</html>
