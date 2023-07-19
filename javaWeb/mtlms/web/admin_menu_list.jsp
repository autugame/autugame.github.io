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
    <script type="text/javascript" src="Widget/Validform/5.3.2/Validform.min.js"></script>
    <script src="assets/js/typeahead-bs2.min.js"></script>
    <script src="assets/js/jquery.dataTables.min.js"></script>
    <script src="assets/js/jquery.dataTables.bootstrap.js"></script>
    <script src="assets/layer/layer.js" type="text/javascript" ></script>
    <script src="js/lrtk.js" type="text/javascript" ></script>
    <script src="assets/layer/layer.js" type="text/javascript"></script>
    <script src="assets/laydate/laydate.js" type="text/javascript"></script>
    <title>管理员</title>
</head>

<body>
<div class="page-content clearfix">
    <div class="administrator">
        <div class="d_Confirm_Order_style">

            <!--menu list-->
            <div class="clearfix administrator_style" id="administrator">
                <div class="left_style">
                    <div id="scrollsidebar" class="left_Treeview">
                        <div class="show_btn" id="rightArrow"><span></span></div>
                        <div class="widget-box side_content" >
                            <div class="side_title"><a title="隐藏" class="close_btn"><span></span></a></div>
                            <div class="side_list"><div class="widget-header header-color-green2"><h4 class="lighter smaller">一级菜单列表</h4></div>
                                <div class="widget-body">
                                    <ul class="b_P_Sort_list">
                                        <li><i class="fa fa-users green"></i> <a href="MenuListServlet">全部</a></li>

                                        <c:forEach items="${menu1List}" var="menu">
                                            <li>
                                                <i class="fa fa-users orange"></i>
                                                <a href="#" onclick="return requestMenu2List('${menu.menuCode}')">${menu.menuName}</a>
                                            </li>
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
                            <th width="80px">菜单编号</th>
                            <th width="250px">菜单名称</th>
                            <th width="100px">菜单排序</th>
                            <th width="100px">菜单级别</th>
                            <th width="100px">父菜单编号</th>
                            <th width="180px">菜单URL</th>
                            <th width="70px">状态</th>
                            <th width="200px">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${menu2List}" var="menu">
                            <tr>
                                <td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>
                                <td>${menu.menuCode}</td>
                                <td>${menu.menuName}</td>
                                <td>${menu.menuOrder}</td>
                                <td>${menu.menuLevel}</td>
                                <td>${menu.parentMenuCode}</td>
                                <td>${menu.menuUrl}</td>
                                <td class="td-status">
                                    <c:choose>
                                       <c:when test="${menu.menuState == 1}">
                                           <span class="label label-success radius">已启用</span>
                                       </c:when>
                                        <c:otherwise>
                                            <span class="label label-defaunt radius">已停用</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td class="td-manage">
                                    <c:choose>
                                        <c:when test="${menu.menuState == 1}">
                                            <a onClick="member_stop(this,'${menu.menuCode}')"  href="javascript:;" title="停用"  class="btn btn-xs btn-success">
                                                <i class="fa fa-close  bigger-120">
                                                </i>
                                            </a>
                                        </c:when>
                                        <c:otherwise>
                                            <a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this, '${menu.menuCode}')" href="javascript:;" title="启用">
                                                <i class="fa fa-check bigger-120">
                                                </i>
                                            </a>
                                        </c:otherwise>
                                    </c:choose>
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
        <form action="" method="post" id="form-admin-add">
            <div class="form-group">
                <label class="form-label"><span class="c-red">*</span>管理员：</label>
                <div class="formControls">
                    <input type="text" class="input-text" value="" placeholder="" id="user-name" name="user-name" datatype="*2-16" nullmsg="用户名不能为空">
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div class="form-group">
                <label class="form-label"><span class="c-red">*</span>初始密码：</label>
                <div class="formControls">
                    <input type="password" placeholder="密码" name="userpassword" autocomplete="off" value="" class="input-text" datatype="*6-20" nullmsg="密码不能为空">
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div class="form-group">
                <label class="form-label "><span class="c-red">*</span>确认密码：</label>
                <div class="formControls ">
                    <input type="password" placeholder="确认新密码" autocomplete="off" class="input-text Validform_error" errormsg="您两次输入的新密码不一致！" datatype="*" nullmsg="请再输入一次新密码！" recheck="userpassword" id="newpassword2" name="newpassword2">
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div class="form-group">
                <label class="form-label "><span class="c-red">*</span>性别：</label>
                <div class="formControls  skin-minimal">
                    <label><input name="form-field-radio" type="radio" class="ace" checked="checked"><span class="lbl">保密</span></label>&nbsp;&nbsp;
                    <label><input name="form-field-radio" type="radio" class="ace"><span class="lbl">男</span></label>&nbsp;&nbsp;
                    <label><input name="form-field-radio" type="radio" class="ace"><span class="lbl">女</span></label>
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div class="form-group">
                <label class="form-label "><span class="c-red">*</span>手机：</label>
                <div class="formControls ">
                    <input type="text" class="input-text" value="" placeholder="" id="user-tel" name="user-tel" datatype="m" nullmsg="手机不能为空">
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div class="form-group">
                <label class="form-label"><span class="c-red">*</span>邮箱：</label>
                <div class="formControls ">
                    <input type="text" class="input-text" placeholder="@" name="email" id="email" datatype="e" nullmsg="请输入邮箱！">
                </div>
                <div class="col-4"> <span class="Validform_checktip"></span></div>
            </div>
            <div class="form-group">
                <label class="form-label">角色：</label>
                <div class="formControls "> <span class="select-box" style="width:150px;">
				<select class="select" name="admin-role" size="1">
					<option value="0">超级管理员</option>
					<option value="1">管理员</option>
					<option value="2">栏目主辑</option>
					<option value="3">栏目编辑</option>
				</select>
				</span> </div>
            </div>
            <div class="form-group">
                <label class="form-label">备注：</label>
                <div class="formControls">
                    <textarea name="" cols="" rows="" class="textarea" placeholder="说点什么...100个字符以内" dragonfly="true" onkeyup="checkLength(this);"></textarea>
                    <span class="wordage">剩余字数：<span id="sy" style="color:Red;">100</span>字</span>
                </div>
                <div class="col-4"> </div>
            </div>
            <div>
                <input class="btn btn-primary radius" type="submit" id="Add_Administrator" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </form>
    </div>
</div>
</body>
</html>

<script type="text/javascript">
    function requestMenu2List(menu1Code){
        //Sending ajax requests.
        $.post(
            "Menu2ListByMenu1Servlet",
            {parentCode:menu1Code},
            function(res){
                $("#testIframe").html("<table class=\"table table-striped table-bordered table-hover\" id=\"sample_table\">\n" +
                    "                        <thead>\n" +
                    "                        <tr>\n" +
                    "                            <th width=\"25px\"><label><input type=\"checkbox\" class=\"ace\"><span class=\"lbl\"></span></label></th>\n" +
                    "                            <th width=\"80px\">菜单编号</th>\n" +
                    "                            <th width=\"250px\">菜单名称</th>\n" +
                    "                            <th width=\"100px\">菜单排序</th>\n" +
                    "                            <th width=\"100px\">菜单级别</th>\n" +
                    "                            <th width=\"100px\">父菜单编号</th>\n" +
                    "                            <th width=\"180px\">菜单URL</th>\n" +
                    "                            <th width=\"70px\">状态</th>\n" +
                    "                            <th width=\"200px\">操作</th>\n" +
                    "                        </tr>\n" +
                    "                        </thead><tbody></tbody></table>");
                //The secondary menu is displayed in the table through DOM manipulation.
                //Display secondary menu.
                for (let i=0; i < res.length; i++) {
                    let menu = res[i];
                    let str1 = menu.menuState==1?"<span class=\"label label-success radius\">已启用</span></td>":"<span class=\"label label-defaunt radius\">已停用</span></td>";
                    let str2 = menu.menuState==1?"<a style=\"text-decoration:none\" class=\"btn btn-xs btn-success\" onClick=\"member_stop(this,'" + menu.menuCode + "')\" href=\"javascript:;\" title=\"停用\"><i class=\"fa fa-close  bigger-120\"></i></a>":"<a style=\"text-decoration:none\" class=\"btn btn-xs \" onClick=\"member_start(this,'" + menu.menuCode + "')\" href=\"javascript:;\" title=\"启用\"><i class=\"fa fa-check bigger-120\"></i></a>";
                    let trTag = "<tr>\n" +
                        "<td><label><input type=\"checkbox\" class=\"ace\"><span class=\"lbl\"></span></label></td>\n" +
                        "<td>" + menu.menuCode + "</td>\n" +
                        "<td>" + menu.menuName + "</td>\n" +
                        "<td>" + menu.menuOrder + "</td>\n" +
                        "<td>" + menu.menuLevel + "</td>\n" +
                        "<td>" + menu.parentMenuCode + "</td>\n" +
                        "<td>" + menu.menuUrl + "</td>\n" +
                        "<td class=\"td-status\">" + str1 + "\n" +
                        "<td class=\"td-manage\">\n" + str2 + "</td>\n" +
                        "</tr>";
                    $("#sample_table tbody").append(trTag);
                }
                //Reinitialize the data.
                $('#sample_table').dataTable( {
                    "aaSorting": [[ 1, "desc" ]],//默认第几个排序
                    "bStateSave": true,//状态保存
                    "aoColumnDefs": [
                        //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
                        {"orderable":false,"aTargets":[0,2,3,4,5,7,8,]}// 制定列不参与排序
                    ] }
                );
            },
            "json"
        );
        return false;
    }
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
    $(".table_menu_list").height($(window).height()-15);
    //当文档窗口发生改变时 触发
    $(window).resize(function(){
        $(".widget-box").height($(window).height()-215);
        $(".table_menu_list").width($(window).width()-260);
        $(".table_menu_list").height($(window).height()-15);
    })
    laydate({
        elem: '#start',
        event: 'focus'
    });

    /*用户-停用*/
    function member_stop(obj,id){
        //Prompt whether to disable.
        layer.confirm('确认要停用吗？',function(index){
            //send ajax request to menuStateServlet.
            $.post(
                "MenuStateChangeServlet",
                {menuCode:id, oper:"stop"},
                function(res){
                    if (res.code === 1){
                        //Change the status of the button to enable.
                        $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this,\'' + id + '\')" href="javascript:;" title="启用"><i class="fa fa-check bigger-120"></i></a>');
                        //Change the status of the menu to disable.
                        $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
                        //Remove current button.
                        $(obj).remove();
                        layer.msg('已停用!',{icon: 5,time:1000});
                    } else {
                        layer.msg("操作失败!",{icon: 5,time:1000});
                    }
                },
                "json"
            );
        });
    }
    /*用户-启用*/
    function member_start(obj,id){
        layer.confirm('确认要启用吗？',function(index){
            //send ajax request to menuStateServlet.
            $.post(
                "MenuStateChangeServlet",
                {menuCode:id, oper:"start"},
                function(res){
                    if (res.code === 1){
                        //Successfully enable menu.
                        $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this,\'' + id + '\')" href="javascript:;" title="停用"><i class="fa fa-close  bigger-120"></i></a>');
                        $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
                        $(obj).remove();
                        layer.msg('已启用!',{icon: 6,time:1000});
                    } else {
                        layer.msg("操作失败!",{icon: 5,time:1000});
                    }
                },
                "json"
            );
        });
    }
    /*产品-编辑*/
    function member_edit(title,url,id,w,h){
        layer_show(title,url,w,h);
    }

    /*产品-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
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

