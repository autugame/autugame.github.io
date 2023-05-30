<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<body>
<h3 vlign="center">添加图书信息</h3>
<form action="BookSaveServlet" method="post" enctype="multipart/form-data">
    <p>图书ID：<input type="text" name="bookId"/></p>
    <p>图书名称：<input type="text" name="bookName"/></p>
    <p>图书作者：<input type="text" name="bookAuthor"/></p>
    <p>图书价格：<input type="text" name="bookPrice"/></p>
    <p>图书封面：<input type="file" name="bookImg"/></p>
    <p>图书描述：<input type="text" name="bookDesc"/></p>
    <p>图书库存：<input type="text" name="bookStock"/></p>
    <p>
        图书类型：
        <input type="radio" name="bookType" value="1"/>原创
        <input type="radio" name="bookType" value="2"/>翻译
    </p>
    <p><input type="submit" value="提交"/></p>
</form>
</body>
</html>