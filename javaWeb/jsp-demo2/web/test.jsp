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
    <div>
        ${key1+1}
        <hr/>
        ${key2}
        <hr/>
        ${key3}<br/>
        ${key3.bookId}<br/>
        ${key3.bookName}<br/>
        ${key3.bookAuthor}<br/>
        ${key3.bookPrice}<br/>
        <hr/>
        ${key4}<br/>
        ${key4[0]}<br/>
        ${key4[1]}<br/>
        ${key4[2]}<br/>
        <hr/>
        ${key5}<br/>
        ${key5[0].bookName}<br/>
        <hr/>
        ${key6['1001']}
        ${key6.a1002}
    </div>

</body>
</html>
