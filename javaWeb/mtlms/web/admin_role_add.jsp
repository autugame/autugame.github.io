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
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
    <![endif]-->
    <script src="js/jquery-1.9.1.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/typeahead-bs2.min.js"></script>
    <script src="assets/js/jquery.dataTables.min.js"></script>
    <script src="assets/js/jquery.dataTables.bootstrap.js"></script>
    <script src="assets/layer/layer.js" type="text/javascript" ></script>
    <script src="assets/laydate/laydate.js" type="text/javascript"></script>
    <script src="js/dragDivResize.js" type="text/javascript"></script>
    <title>添加权限</title>
</head>

<body>
<form action="RoleAddServlet" method="post">
    <div class="Competence_add_style clearfix">
        <div class="left_Competence_add">
            <div class="title_name">添加角色</div>
            <div class="Competence_add">
                <div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="form-field-1"> 角色名称 </label>
                    <div class="col-sm-9"><input type="text" id="form-field-1" placeholder=""  name="roleName" class="col-xs-10 col-sm-5"></div>
                </div>
                <div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="form-field-1"> 角色描述 </label>
                    <div class="col-sm-9"><textarea name="roleDesc" class="form-control" id="form_textarea" placeholder="" onkeyup="checkLength(this);"></textarea><span class="wordage">剩余字数：<span id="sy" style="color:Red;">200</span>字</span></div>
                </div>
                <!--按钮操作-->
                <div class="Button_operation">
                    <button onclick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="fa fa-save "></i>提交</button>
                    <a href="RoleListServlet" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</a>
                </div>
            </div>
        </div>
        <!--权限分配-->
        <div class="Assign_style">
            <div class="title_name">权限/菜单分配</div>
            <div class="Select_Competence">
                <dl class="permission-list">
                    <dt><label class="middle"><input name="user-Character-0" class="ace" type="checkbox" id="id-disable-check"><span class="lbl">所有权限</span></label></dt>
                    <dd>
                        <c:forEach items="${menu1List}" var="menu1">
                            <c:if test="${!empty menu1.childMenus}">
                                <dl class="cl permission-list2">
                                    <dt><label class="middle"><input type="checkbox" value="${menu1.menuId}" class="ace"  name="menuId" id="id-disable-check1"><span class="lbl">${menu1.menuName}</span></label></dt>
                                    <dd>
                                    <c:forEach items="${menu1.childMenus}" var="menu2">
                                        <label class="middle"><input type="checkbox" value="${menu2.menuId}" class="ace" name="menuId" id="user-Character-0-0-0"><span class="lbl">${menu2.menuName}</span></label>
                                    </c:forEach>
                                    </dd>
                                </dl>
                            </c:if>
                        </c:forEach>
                    </dd>
                </dl>
            </div>
        </div>
    </div>
</form>
</body>
</html>
<script type="text/javascript">
    //初始化宽度、高度
    $(".left_Competence_add,.Competence_add_style").height($(window).height()).val();;
    $(".Assign_style").width($(window).width()-500).height($(window).height()).val();
    $(".Select_Competence").width($(window).width()-500).height($(window).height()-40).val();
    //当文档窗口发生改变时 触发
    $(window).resize(function(){

        $(".Assign_style").width($(window).width()-500).height($(window).height()).val();
        $(".Select_Competence").width($(window).width()-500).height($(window).height()-40).val();
        $(".left_Competence_add,.Competence_add_style").height($(window).height()).val();;
    });
    /*字数限制*/
    function checkLength(which) {
        var maxChars = 200; //
        if(which.value.length > maxChars){
            layer.open({
                icon:2,
                title:'提示框',
                content:'您出入的字数超多限制!',
            });
            // 超过限制的字数了就将 文本框中的内容按规定的字数 截取
            which.value = which.value.substring(0,maxChars);
            return false;
        }else{
            var curr = maxChars - which.value.length; //250 减去 当前输入的
            document.getElementById("sy").innerHTML = curr.toString();
            return true;
        }
    };
    /*按钮选择*/
    $(function(){
        $(".permission-list dt input:checkbox").click(function(){
            $(this).closest("dl").find("dd input:checkbox").prop("checked",$(this).prop("checked"));
        });
        $(".permission-list2 dd input:checkbox").click(function(){
            var l =$(this).parent().parent().find("input:checked").length;
            var l2=$(this).parents(".permission-list").find(".permission-list2 dd").find("input:checked").length;
            if($(this).prop("checked")){
                $(this).closest("dl").find("dt input:checkbox").prop("checked",true);
                $(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked",true);
            }
            else{
                if(l==0){
                    $(this).closest("dl").find("dt input:checkbox").prop("checked",false);
                }
                if(l2==0){
                    $(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked",false);
                }
            }

        });
    });

</script>
