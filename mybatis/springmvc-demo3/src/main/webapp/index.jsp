<%--
  Created by IntelliJ IDEA.
  User: A3452
  Date: 9/12/2023
  Time: 6:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <table width="100%" height="700">
            <tr>
                <td width="200" style="border-right: deepskyblue 2px solid; background: rgba(255,0,0,0.1)">
                    <ul>
                        <li><a href="book-add.jsp" target="mainFrame">Upload images</a></li>
                        <li><a href="list.jsp" target="mainFrame">List of images</a></li>
                    </ul>
                </td>
                <td>
                    <iframe name="mainFrame" width="100%" height="100%" frameborder="0"></iframe>
                </td>
            </tr>
        </table>
</body>
</html>
