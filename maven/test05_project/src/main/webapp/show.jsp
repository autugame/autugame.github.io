<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<body>
    <table border="1px", cellspacing="0" width="50%" align="center">
        <tr align="center">
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr align="center">
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
