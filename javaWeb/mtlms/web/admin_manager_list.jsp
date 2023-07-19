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
    <link rel="stylesheet" href="css/message_box.css"/>
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
    <![endif]-->
    <script src="js/jquery-1.9.1.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="Widget/Validform/5.3.2/Validform.min.js"></script>
    <script src="assets/js/typeahead-bs2.min.js"></script>
    <script src="assets/js/jquery.dataTables.min.js"></script>
    <script src="assets/js/jquery.dataTables.bootstrap.js"></script>
    <script src="assets/layer/layer.js" type="text/javascript" ></script>
    <script src="js/lrtk.js" type="text/javascript" ></script>
    <script src="assets/layer/layer.js" type="text/javascript"></script>
    <script src="assets/laydate/laydate.js" type="text/javascript"></script>
    <script src="js/message_box.js"></script>
    <title>管理员</title>
</head>

<body>
<div class="page-content clearfix">
    <div class="administrator">
        <div class="d_Confirm_Order_style">
            <!--操作-->
            <div class="border clearfix">
       <span class="l_f">
        <a href="javascript:ovid()" id="administrator_add" class="btn btn-warning"><i class="fa fa-plus"></i> 添加管理员</a>
        <a href="javascript:ovid()" class="btn btn-danger"><i class="fa fa-trash"></i> 批量删除</a>
       </span>
                <span class="r_f"></span>
            </div>
            <!--管理员列表-->
            <div class="clearfix administrator_style" id="administrator">
                <div class="left_style">
                    <div id="scrollsidebar" class="left_Treeview">
                        <div class="show_btn" id="rightArrow"><span></span></div>
                        <div class="widget-box side_content" >
                            <div class="side_title"><a title="隐藏" class="close_btn"><span></span></a></div>
                            <div class="side_list"><div class="widget-header header-color-green2"><h4 class="lighter smaller">管理员角色列表</h4></div>
                                <div class="widget-body">
                                    <ul class="b_P_Sort_list">
                                        <li><i class="fa fa-users green"></i> <a href="#">全部管理员</a></li>
                                        <c:forEach items="${roleList}" var="role">
                                        <li><i class="fa fa-users orange"></i> <a href="#">${role.roleName}</a></li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="table_menu_list"  id="testIframe">
                    <table class="table table-striped table-bordered table-hover" id="sample_table">
                        <thead>
                        <tr>
                            <th width="25px"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
                            <th width="80px">编号</th>
                            <th width="120px">登录名</th>
                            <th width="100px">姓名</th>
                            <th width="100px">性别</th>
                            <th width="100px">手机</th>
                            <th width="180px">邮箱</th>
                            <th width="90px">QQ</th>
                            <th width="170px">创建时间</th>
                            <th width="150px">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${managerList}" var="manager">
                        <tr>
                            <td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>
                            <td>${manager.mgrId}</td>
                            <td>${manager.loginName}</td>
                            <td>${manager.mgrName}</td>
                            <td>${manager.mgrGender}</td>
                            <td>${manager.mgrTel}</td>
                            <td>${manager.mgrEmail}</td>
                            <td>${manager.mgrQQ}</td>
                            <td>${manager.createTime}</td>
                            <td class="td-manage">
                                <a title="编辑" onclick="manager_edit('${manager.mgrId}')" href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a>
                                <a title="删除" href="javascript:;"  onclick="manager_del(this,'${manager.mgrId}')" class="btn btn-xs btn-warning" ><i class="fa fa-trash  bigger-120"></i></a>
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!--添加管理员-->
    <div id="add_administrator_style" class="add_menber" style="display:none">
        <form action="ManagerAddServlet" method="post" id="form-admin-add">
            <div class="form-group">
                <label class="form-label"><span class="c-red">*</span>编号：</label>
                <div class="formControls">
                    <input type="text" class="input-text" value="" name="mgrId" datatype="*8-8" nullmsg="管理员ID不能为空">
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div class="form-group">
                <label class="form-label"><span class="c-red">*</span>登录名：</label>
                <div class="formControls">
                    <input type="text" class="input-text" value="" placeholder="" id="user-name" name="loginName" datatype="*2-16" nullmsg="用户名不能为空">
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div class="form-group">
                <label class="form-label"><span class="c-red">*</span>初始密码：</label>
                <div class="formControls">
                    <input type="password" placeholder="密码" name="loginPwd" autocomplete="off" value="" class="input-text" datatype="*6-20" nullmsg="密码不能为空">
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div class="form-group">
                <label class="form-label "><span class="c-red">*</span>确认密码：</label>
                <div class="formControls ">
                    <input type="password" placeholder="确认新密码" autocomplete="off" class="input-text Validform_error" errormsg="您两次输入的新密码不一致！" datatype="*" nullmsg="请再输入一次新密码！" recheck="loginPwd" id="newpassword2" name="loginPwd2">
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div class="form-group">
                <label class="form-label"><span class="c-red">*</span>姓名：</label>
                <div class="formControls">
                    <input type="text" class="input-text" value="" placeholder="" name="mgrName" datatype="*2-10" nullmsg="真实姓名不能为空">
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div class="form-group">
                <label class="form-label "><span class="c-red">*</span>性别：</label>
                <div class="formControls  skin-minimal">
                    <label><input value="男" name="mgrGender" type="radio" class="ace" checked="checked"><span class="lbl">男</span></label>&nbsp;&nbsp;
                    <label><input value="女" name="mgrGender" type="radio" class="ace"><span class="lbl">女</span></label>
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div class="form-group">
                <label class="form-label "><span class="c-red">*</span>手机：</label>
                <div class="formControls ">
                    <input type="text" class="input-text" value="" placeholder="" id="user-tel" name="mgrTel" datatype="m" nullmsg="手机不能为空">
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div class="form-group">
                <label class="form-label"><span class="c-red">*</span>邮箱：</label>
                <div class="formControls ">
                    <input type="text" class="input-text" placeholder="@" name="mgrEmail" id="email" datatype="e" nullmsg="请输入邮箱！">
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div class="form-group">
                <label class="form-label">角色：</label>
                <div class="formControls "> <span class="select-box" style="width:150px;">
				<select class="select" name="roleId" size="1">
                    <c:forEach items="${roleList}" var="role">
					<option value="${role.roleId}">${role.roleName}</option>
                    </c:forEach>
				</select>
				</span> </div>
            </div>
            <div class="form-group">
                <label class="form-label"><span class="c-red">*</span>QQ：</label>
                <div class="formControls">
                    <input type="text" class="input-text" value="" name="mgrQQ" datatype="*5-11" nullmsg="管理员QQ不能为空">
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div>
                <input class="btn btn-primary radius" type="submit" id="Add_Administrator" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </form>
    </div>
    <div id="update_administrator_style" class="add_menber" style="display:none; padding: 20px 10px">
        <form action="ManagerUpdateServlet" method="post" id="form-admin-update">
            <div class="form-group">
                <label class="form-label"><span class="c-red">*</span>编号：</label>
                <div class="formControls">
                    <input type="text" class="input-text" value="" name="mgrId" id="mgrId" readonly>
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div class="form-group">
                <label class="form-label"><span class="c-red">*</span>登录名：</label>
                <div class="formControls">
                    <input type="text" class="input-text" id="loginName" name="loginName">
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div class="form-group">
                <label class="form-label"><span class="c-red">*</span>修改密码：</label>
                <div class="formControls">
                    <input type="password" placeholder="无需修改不用输入" name="loginPwd" autocomplete="off" value="" class="input-text" datatype="*6-20" nullmsg="密码不能为空">
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div class="form-group">
                <label class="form-label"><span class="c-red">*</span>姓名：</label>
                <div class="formControls">
                    <input type="text" class="input-text" name="mgrName" id="mgrName">
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div class="form-group">
                <label class="form-label "><span class="c-red">*</span>性别：</label>
                <div class="formControls  skin-minimal">
                    <label><input value="男" name="mgrGender" id="radio1" type="radio" class="ace"><span class="lbl">男</span></label>&nbsp;&nbsp;
                    <label><input value="女" name="mgrGender" id="radio2" type="radio" class="ace"><span class="lbl">女</span></label>
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div class="form-group">
                <label class="form-label "><span class="c-red">*</span>手机：</label>
                <div class="formControls ">
                    <input type="text" class="input-text" id="mgrTel" name="mgrTel" datatype="m">
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div class="form-group">
                <label class="form-label"><span class="c-red">*</span>邮箱：</label>
                <div class="formControls ">
                    <input type="text" class="input-text" id="mgrEmail" name="mgrEmail" datatype="e">
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div class="form-group">
                <label class="form-label">角色：</label>
                <div class="formControls "> <span class="select-box" style="width:150px;">
				<select class="select" name="roleId" size="1">
                    <c:forEach items="${roleList}" var="role">
                        <option value="${role.roleId}">${role.roleName}</option>
                    </c:forEach>
				</select>
				</span> </div>
            </div>
            <div class="form-group">
                <label class="form-label"><span class="c-red">*</span>QQ：</label>
                <div class="formControls">
                    <input type="text" class="input-text" name="mgrQQ" id="mgrQQ">
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div>
                <input class="btn btn-primary radius" type="submit" id="update_Administrator" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </form>
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    history.replaceState(null, null, window.location.href);
    <c:if test="${!empty tips}">
    $message({type: "${type}",closeTime: 600,center: false,showClose: true,content: "${tips}"});
    </c:if>
</script>
<script type="text/javascript">
    jQuery(function($) {
        var oTable1 = $('#sample_table').dataTable( {
            "aaSorting": [[ 1, "desc" ]],//默认第几个排序
            "bStateSave": true,//状态保存
            "aoColumnDefs": [
                //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
                {"orderable":false,"aTargets":[0,2,3,4,5,7,8,]}// 制定列不参与排序
            ] } );


        $('table th input:checkbox').on('click' , function(){
            var that = this;
            $(this).closest('table').find('tr > td:first-child input:checkbox')
                .each(function(){
                    this.checked = that.checked;
                    $(this).closest('tr').toggleClass('selected');
                });

        });


        $('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
        function tooltip_placement(context, source) {
            var $source = $(source);
            var $parent = $source.closest('table')
            var off1 = $parent.offset();
            var w1 = $parent.width();

            var off2 = $source.offset();
            var w2 = $source.width();

            if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
            return 'left';
        }
    });

</script>
<script type="text/javascript">
    $(function() {
        $("#administrator").fix({
            float : 'left',
            //minStatue : true,
            skin : 'green',
            durationTime :false,
            spacingw:50,//设置隐藏时的距离
            spacingh:270,//设置显示时间距
        });
    });
    //字数限制
    function checkLength(which) {
        var maxChars = 100; //
        if(which.value.length > maxChars){
            layer.open({
                icon:2,
                title:'提示框',
                content:'您输入的字数超过限制!',
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
    //初始化宽度、高度
    $(".widget-box").height($(window).height()-215);
    $(".table_menu_list").width($(window).width()-260);
    $(".table_menu_list").height($(window).height()-215);
    //当文档窗口发生改变时 触发
    $(window).resize(function(){
        $(".widget-box").height($(window).height()-215);
        $(".table_menu_list").width($(window).width()-260);
        $(".table_menu_list").height($(window).height()-215);
    })

    /*用户-停用*/
    function member_stop(obj,id){
        layer.confirm('确认要停用吗？',function(index){
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="fa fa-close bigger-120"></i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
            $(obj).remove();
            layer.msg('已停用!',{icon: 5,time:1000});
        });
    }
    /*用户-启用*/
    function member_start(obj,id){
        layer.confirm('确认要启用吗？',function(index){
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="fa fa-check  bigger-120"></i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
            $(obj).remove();
            layer.msg('已启用!',{icon: 6,time:1000});
        });
    }
    /*产品-编辑*/
    function manager_edit(id){
        //Example Query the original information about the current administrator.
        $.post(
            "ManagerQueryServlet",
            {managerId:id},
            function(res){
                $("#mgrId").val(res.mgrId);
                $("#loginName").val(res.loginName);
                $("#mgrName").val(res.mgrName);
                if (res.mgrGender === "男"){
                    $("#radio1").attr("checked", true);
                } else {
                    $("#radio2").attr("checked", true);
                }
                $("#mgrTel").val(res.mgrTel);
                $("#mgrEmail").val(res.mgrEmail);
                $("#mgrQQ").val(res.mgrQQ);
            },
            "json"
        );

        layer.open({
            type: 1,
            title:'修改管理员',
            area: ['700px',''],
            shadeClose: false,
            content: $('#update_administrator_style'),
        });
    }

    /*产品-删除*/
    function manager_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            //Send ajax requests.
            $.post(
                "ManagerDeleteServlet",
                {mgrId:id},
                function(res){
                    if (res.code === 1){
                        $(obj).parents("tr").remove();
                        layer.msg('已删除!',{icon:1,time:1000});
                    } else {
                        layer.msg('删除失败!',{icon:5,time:1000});
                    }
                },
                "json"
            );
        });
    }
    /*添加管理员*/
    $('#administrator_add').on('click', function(){
        layer.open({
            type: 1,
            title:'添加管理员',
            area: ['700px',''],
            shadeClose: false,
            content: $('#add_administrator_style'),

        });
    })
    //表单验证提交
    $("#form-admin-add").Validform({

        tiptype:2,

        callback:function(data){
            //form[0].submit();
            if(data.status==1){
                layer.msg(data.info, {icon: data.status,time: 1000}, function(){
                    location.reload();//刷新页面
                });
            }
            else{
                layer.msg(data.info, {icon: data.status,time: 3000});
            }
            var index =parent.$("#iframe").attr("src");
            parent.layer.close(index);
            //
        }


    });
</script>

