function checkUserName(){
    //发送ajax请求到checkUserNameServlet并传递用户名
    //创建ajax请求对象
    let ajaxReq;
    if (window.XMLHttpRequest){
        ajaxReq = new XMLHttpRequest();
    } else {
        ajaxReq = new ActiveXObject("Microsoft.XMLHTTP");
    }

    //封装ajax请求数据（初始化）
    const userName = document.getElementById("userName").value;
    ajaxReq.open("GET", "CheckUserNameServlet?userName="+userName, true);

    //指定ajax请求的回调函数
    //ajaxq请求对象是有状态的    ajaxReq.readystate获取状态值
    //ajaxReq.readystate == 0表示ajax对象完成创建但是没有初始化
    //ajaxReq.readystate == 1表示对象完成初始化但并未完成发动
    //ajaxReq.readystate == 2表示请求已经发送并到达服务器
    //ajaxReq.readystate == 3表示请求服务器正在处理ajax请求
    //ajaxReq.readystate == 4表示请求服务器处理完成ajax对象已经成功获取响应结果
    //只要ajax请求状态发生变化就会触发这个回调函数的执行
    //回调函数
    ajaxReq.onreadystatechange = function(){
        //获取服务器响应结果的两个条件
        //异步请求完成ajaxReq.readyState === 4
        //http状态为200    ajaxReq.status == 200
        if (ajaxReq.readyState === 4 && ajaxReq.status === 200){
            //获取结果
            //如果服务器响应的是文本数据(字符串)responseText属性接收
            const result = ajaxReq.responseText;
            //如果服务器响应的是XML文件，使用
            // const doc = ajaxReq.responseXML;
            //将响应结果显示到网页的标签中
            document.getElementById("tipsLabel").innerHTML = result;
        }
    }
    //发送请求
    ajaxReq.send(null);
}