<%--
  Created by IntelliJ IDEA.
  User: A3452
  Date: 9/4/2023
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
    <h3>Add books</h3>
    <form action="book/add" method="post">
        <p>Name of book:&emsp;&nbsp;&nbsp;<input type="text" name="bookName"/></p>
        <p>Author of book:&emsp;<input type="text" name="bookAuthor"/></p>
        <p>Price of book:&emsp;&nbsp;&nbsp;&nbsp;<input type="text" name="bookPrice"/></p>
        <p><input type="submit" value="submit"/></p>
    </form>

    <h3>Link submission</h3>
    <a href="book/add?bookName=Java">Link submission</a>

    <h3>AJAX submit</h3>
    <input id="btn1" type="button" value="Ajax submit"/>
    <script type="text/javascript">
        var obj = {};
        obj.bookName = "Java";
        obj.bookAuthor = "zhangsan";
        obj.bookPrice = 3.33;
        $("#btn1").click(function(){
            $.ajax({
                url:"book/add",
                type:"post",
                headers:{},
                contentType:"application/json",
                data:JSON.stringify(obj),
                success:function (res) {
                    console.log(res);
                }
            });
        });
    </script>
</body>
</html>
