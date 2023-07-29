<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="css/style.css"/>
    <link href="assets/css/codemirror.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/ace.min.css" />
    <link rel="stylesheet" href="font/css/font-awesome.min.css" />
    <script src="js/jquery-1.9.1.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/typeahead-bs2.min.js"></script>
    <script src="assets/layer/layer.js" type="text/javascript" ></script>
    <script src="assets/laydate/laydate.js" type="text/javascript"></script>
    <script src="js/H-ui.js" type="text/javascript"></script>
    <title>添加评估选项</title>
</head>

<body>
<div class="margin clearfix">
    <div class="article_style" style="width: 60%; margin: auto;">
        <form action="" method="post">
            <div class="add_content" id="form-article-add">
                <ul>

                    <li class="clearfix"><label class="label_name"><i>*</i>所属类目</label>
                        <span class="formControls col-4">
		 		    <select class="form-control" id="form-field-select-1">
		 			  <option value="0">--选择所属类目--</option>
		 		    </select>
                        </span>
                    </li>

                    <li class="clearfix Mandatory">
                        <label class="label_name"><i>*</i>选项名称</label>
                        <span class="formControls col-10">
                              <input name="" type="text" id="form-field-1" class="col-xs-10 col-sm-12 ">
                        </span>
                    </li>

                    <li class="clearfix Mandatory">
                        <label class="label_name"><i>*</i>选项描述</label>
                        <span class="formControls col-10">
                            <input name="" type="text" id="form-field-2" class="col-xs-10 col-sm-12 ">
                        </span>
                    </li>

                    <li class="clearfix"><label class="label_name">是否显示</label>
                        <span class="formControls col-10">
                        <span class="add_date l_f">
                            <label><input name="radio" type="radio" class="ace" checked="checked"><span class="lbl">显示</span></label>&nbsp;
                            <label><input name="radio" type="radio" class="ace" ><span class="lbl">不显示</span></label></span>
                        </span>
                    </li>

                    </ul>
                    <div class="Button_operation">
                        <button  class="btn btn-primary radius" type="button" id="submitBtn">提交</button>
                        <button  class="btn btn-default radius" type="button">取消</button>
                    </div>
                </div>
            </form>
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    $(function(){
        $.post(
            "BasicInfoLoadServlet",
            function(res){
                //Display evaluation category list.
                if (res.code === 1){
                    var basicInfoArr = res.data;
                    for(var i=0; i<basicInfoArr.length; i++){
                        var basicInfo = basicInfoArr[i];
                        var optionStr = "<option value='"+basicInfo.basicInfoId+"'>"+basicInfo.basicInfoName+"</option>";
                        $("#form-field-select-1").append(optionStr);
                    }
                }
            },
            "json"
        );
    });
    $("#submitBtn").click(function(){
        //Submitting data using ajax.
        var params = {};
        params.basicInfoId = $("#form-field-select-1").val();
        params.infoDetailName = $("#form-field-1").val();
        params.infoDetailDesc = $("#form-field-2").val();
        //Send ajax request.
        $.post(
            "InfoDetailAddServlet",
            params,
            function(res){
                if (res.code === 1){
                    layer.msg('添加成功!',{icon: 1,time:1000});
                    setTimeout(function(){
                        window.location.href="basic_info_detail.jsp";
                    }, 1000);
                } else {
                    layer.msg('添加失败!',{icon: 5,time:1000});
                }
            },
            "json"
        );
    });
</script>
<script type="text/javascript" src="Widget/ueditor/1.4.3/ueditor.config.js"></script>
<script type="text/javascript" src="Widget/ueditor/1.4.3/ueditor.all.min.js"> </script>
<script type="text/javascript" src="Widget/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>

