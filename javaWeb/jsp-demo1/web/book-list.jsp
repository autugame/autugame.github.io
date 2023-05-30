<%@ page import="com.qfedu.jsp.dto.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: autumn
  Date: 5/4/2023
  Time: 10:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--在jsp中可以写java代码但是代码必须写在<%%>符号中--%>
    <%
        //通过JAVA代码获取所有图书数据
        List<Book> bookList = (List<Book>) request.getAttribute("bookList");
    %>
    <table width="80%" align="center" border="1" cellspacing="0">
        <caption>图书信息列表</caption>
        <tr>
            <th>图书ID</th>
            <th>图书名称</th>
            <th>作者</th>
            <th>价格</th>
            <th>封面</th>
            <th>描述</th>
            <th>类型</th>
        </tr>
        <%
            for (int i=0; i<bookList.size(); i++){
                //book是java中的变量
                Book book = bookList.get(i);
        %>
                <tr>
<%--                    <%=book.getBookId()%>显示变量到html中--%>
                    <td><%=book.getBookId()%></td>
                    <td><%=book.getBookName()%></td>
                    <td><%=book.getBookAuthor()%></td>
                    <td><%=book.getBookPrice()%></td>
                    <td><%=book.getBookImgPath()%></td>
                    <td><%=book.getBookDesc()%></td>
                    <td><%=book.getBookType()==1?"中文":"英文"%></td>
                </tr>
        <%
            }
        %>
    </table>
</body>
</html>
