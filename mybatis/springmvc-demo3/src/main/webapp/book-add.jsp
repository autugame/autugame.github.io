<%--
  Created by IntelliJ IDEA.
  User: A3452
  Date: 9/12/2023
  Time: 6:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>Add book information</h4>
    <form action="book/add" enctype="multipart/form-data" method="post">
        <p>Name of book:<input type="text" name="bookName"/></p>
        <p>Author of book:<input type="text" name="bookAuthor"/></p>
        <p>price of book:<input type="text" name="bookPrice"/></p>
        <p>cover of book:<input type="file" name="imgFile"/></p>
        <p><input type="submit" value="submit"/></p>
    </form>
</body>
</html>
