<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--
  Created by IntelliJ IDEA.
  User: autumn
  Date: 5/11/2023
  Time: 11:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>考试结果</h3>
<%--    获取分数如果分数>=60在页面显示结果为通过--%>
<%--    test为true就显示里面的标签--%>
    <c:if test="${score >= 60}">
        <label style="color: green">通过</label>
    </c:if>
    <c:if test="${score < 60}">
        <label style="color: red">不通过</label>
    </c:if>
    <hr/>
    <%--        如果分数>=90显示优秀，如果<90>=80则显示良好，如果分数<80>=70显示中等，如果分数<70>=60显示及格
，如果分数<60显示不及格--%>
<%--    c:choose为多分支语句，可以包含多个c:when和一个c:otherwise
寻找并执行一个c:when，没有就执行c:otherwise--%>
    <c:choose>
        <c:when test="${score >= 90}">
            <label style="color:green">优秀</label>
        </c:when>
        <c:when test="${score >= 80}">
            <label style="color:green">良好</label>
        </c:when>
        <c:when test="${score >= 70}">
            <label style="color:green">中等</label>
        </c:when>
        <c:when test="${score >= 60}">
            <label style="color:green">及格</label>
        </c:when>
        <c:otherwise>
                <label style="color:red">不及格</label>
        </c:otherwise>
    </c:choose>
<%--    遍历传递的图书信息显示在表格中--%>
    <table align="center" border="1" cellspacing="0">
        <tr>
            <th>图书编号</th>
            <th>图书名称</th>
            <th>图书作者</th>
            <th>图书价格</th>
        </tr>
<%--        获取传递的集合有几个图书信息就显示几行--%>
<%--        items指定遍历的集合
            var指定集合每次循环的对象
            begin指定从集合中的哪个元素开始显示0表示第一个元素
            end指定取到哪个索引对应集合元素
            step指定元素的间隔个数默认为1--%>
        <c:forEach items="${bookList}" var="book">
            <tr>
                <td>${book.bookId}</td>
                <td>${book.bookName}</td>
                <td>${book.bookAuthor}</td>
                <td>${book.bookPrice}</td>
            </tr>
        </c:forEach>
    </table>
<%--    显示数字--%>
    <fmt:formatNumber value="${num}" pattern="#.00"></fmt:formatNumber><br/>
    <fmt:formatNumber value="${num}" type="number"></fmt:formatNumber><br/>
    <fmt:formatNumber value="${num}" type="currency"></fmt:formatNumber><br/>
    <fmt:formatNumber value="${num}" type="percent"></fmt:formatNumber><br/>

<%--    格式化日期输出--%>
    <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"></fmt:formatDate>
    <fmt:formatDate value="${date}" pattern="hh:mm:ss"></fmt:formatDate>
    <fmt:formatDate value="${date}" pattern="HH:mm:ss"></fmt:formatDate>
</body>
</html>
