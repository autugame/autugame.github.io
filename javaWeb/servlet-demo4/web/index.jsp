<%--
  Created by IntelliJ IDEA.
  User: autumn
  Date: 5/11/2023
  Time: 6:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生成绩查询系统-主页面</title>
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
                    <form action='GradeQueryServlet' method='post'>
                        <h3>成绩查询</h3>
                        <p>学号：<input type='text' name='stuNum' placeholder='学生学号'/></p>
                        <p>课程：<input type='text' name='courseId' placeholder='课程编号'/></p>
                        <p><input type='submit' value='查询'/></p>
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
