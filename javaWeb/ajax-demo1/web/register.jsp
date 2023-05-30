
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="js/test.js"></script>
</head>
<body>
    <h3>用户注册</h3>
    <form action="TestJsonServlet" method="post">
        <p>账号：
            <input type="text" id="userName"/><label id="tipsLabel"></label>
            <input type="button" value="检测" onclick="checkUserName()"/></p>
        <p>密码：<input type="password" name="password"/></p>
        <p>确认密码：<input type="password"/></p>
        <p>姓名：<input type="text"/></p>
        <p>电话：<input type="text"/></p>
        <p><input type="submit" value="提交注册"/></p>
    </form>
</body>
</html>
