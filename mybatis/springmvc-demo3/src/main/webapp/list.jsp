<%--
  Created by IntelliJ IDEA.
  User: A3452
  Date: 9/13/2023
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</head>
<body>
    <h4>List of images</h4>

    <div class="row" id="container"></div>

    <script type="text/javascript">
        $.get("book/list",function(res){
            for (var i = 0; i < res.length; i++){
                var fn = res[i];
                var htmlStr = "<div class=\".h-25 col-lg-2 col-md-3 col-sm-4 col-xs-6\">\n" +
                "            <div class=\"thumbnail\">\n" +
                "                <img src=\"images/"+fn+"\" alt=\"...\">\n" +
                "                <div class=\"caption\">\n" +
                "                    <p><a href=\"book/download?fileName="+fn+"\" class=\"btn btn-primary\" role=\"button\">Download</a></p>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>";
                $("#container").append(htmlStr);
            }
        },"json");
    </script>
</body>
</html>
