<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <h3>测试前段json格式转换</h3>
    <input type="button" onclick="testJson()" value="测试"/>
    <script type="text/javascript">
        function testJson(){
            //1.将JS对象转换成json格式字符串
            const obj = {stuNum: "10001", stuName: "张三"};
            obj.stuGender = "男";

            const jsonStr = JSON.stringify(obj);

            //发送异步请求将json字符串提交到testJsonServlet
            let ajaxReq;
            if (window.XMLHttpRequest){
                ajaxReq = new XMLHttpRequest();
            } else {
                ajaxReq = new ActiveXObject("Microsoft.XMLHTTP");
            }
            ajaxReq.open("POST", "TestJsonServlet", true);
            ajaxReq.onreadystatechange = function(){
                if (ajaxReq.readyState === 4 && ajaxReq.status === 200){
                    const s = ajaxReq.responseText;
                    //将接收的json格式字符串转换成js格式对象
                    const stu = JSON.parse(s);
                    console.log(stu);
                }
            };
            //ajax采用的是post请求通过请求正文提交
            ajaxReq.send(jsonStr);
        }
    </script>
</body>
</html>
