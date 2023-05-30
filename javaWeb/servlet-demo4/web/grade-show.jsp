<%@ page import="com.qfedu.sgms.dto.GradeDTO" %><%--
  Created by IntelliJ IDEA.
  User: autumn
  Date: 5/11/2023
  Time: 6:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border='1' width='100%' height='700'>
    <tr height='100'>
        <td colspan='2' align=center>
            <label style='font-size: 40px;'>学生成绩查询系统欢迎您</label>
        </td>
    </tr>
    <tr>
        <td width='200'>2-1</td>
        <td align=center>
                <h3>查询结果</h3>
                    <%
                        GradeDTO grade = (GradeDTO) request.getAttribute("grade");
                        if (grade != null) {
                    %>
                <table width='200' border='1' cellspacing='0'>
                    <tr><td>学号</td><td><%=grade.getsNum()%></td></tr>
                    <tr><td>姓名</td><td><%=grade.getsName()%></td></tr>
                    <tr><td>课程ID</td><td><%=grade.getCid()%></td></tr>
                    <tr><td>课程名</td><td><%=grade.getcName()%></td></tr>
                    <tr>
                        <td>成绩</td>
                        <td>
                            <label style='color: red; font-weight: bold;'><%=grade.getScore()%></label>
                        </td>
                    </tr>
                </table>
                <%
                } else {
                %>
                <label style='color: red; font-weight: bold; font-size: 50px;'>学号或课程号有误!</label>
                <%
                }
                %>
                <a href='index.jsp'>继续查询</a>
        </td>
    </tr>
</table>
</body>
</html>