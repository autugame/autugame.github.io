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
    <script src="js/lrtk.js" type="text/javascript" ></script>
    <script src="assets/js/jquery.dataTables.min.js"></script>
    <script src="assets/js/jquery.dataTables.bootstrap.js"></script>
    <script src="assets/layer/layer.js" type="text/javascript" ></script>
    <script src="assets/laydate/laydate.js" type="text/javascript"></script>
    <script src="js/H-ui.js" type="text/javascript"></script>
    <script src="js/displayPart.js" type="text/javascript"></script>
    <title>评估选项</title>
</head>

<body>
<div class="clearfix">
    <div class="article_style" id="article_style">
        <div id="scrollsidebar" class="left_Treeview">
            <div class="show_btn" id="rightArrow"><span></span></div>
            <div class="widget-box side_content" >
                <div class="side_title"><a title="隐藏" class="close_btn"><span></span></a></div>
                <div class="side_list">
                    <div class="widget-header header-color-green2">
                        <h4 class="lighter smaller">评估类目列表</h4>
                    </div>
                    <div class="widget-body">
                        <ul class="b_P_Sort_list" id="basicInfoList">
<%--                            <li><i class="fa fa-newspaper-o pink "></i> <a href="#">型号</a></li>--%>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!--文章列表-->
        <div class="Ads_list">
            <div class="border clearfix" style="width: 100%;">
       <span class="l_f">
        <a href="basic_info_detail_add.jsp"  title="添加评估选项" id="add_page" class="btn btn-warning"><i class="fa fa-plus"></i> 添加评估选项</a>
        <a href="javascript:ovid()" class="btn btn-danger"><i class="fa fa-trash"></i> 批量删除</a>
       </span>
            </div>
            <div class="article_list">
                <table class="table table-striped table-bordered table-hover" id="sample-table">
                    <thead>
                    <tr>
                        <th width="25"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
                        <th width="80px">ID</th>
                        <th  width="120px">选项名称</th>
                        <th width="260">选项描述</th>
                        <th width="150px">操作</th>
                    </tr>
                    </thead>
                    <tbody id="infoDetailTbody">
<%--                    <tr>--%>
<%--                        <td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>--%>
<%--                        <td>12</td>--%>
<%--                        <td>2</td>--%>
<%--                        <td>帮助中心</td>--%>
<%--                        <td class="td-manage">--%>
<%--                            <a title="编辑" onclick="member_edit('编辑','member-add.html','4','','510')" href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a>--%>
<%--                            <a title="删除" href="javascript:;"  onclick="member_del(this,'1')" class="btn btn-xs btn-danger" ><i class="fa fa-trash  bigger-120"></i></a>--%>
<%--                        </td>--%>
<%--                    </tr>--%>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    $(function(){
        //Send Ajax to obtain evaluation categories.
        $.post(
            "BasicInfoLoadServlet",
            function(res){
                //Processing return results.
                if (res.code === 1){
                    var arr = res.data;
                    //Display data in a table through javaScript.
                    for (var i = 0; i < arr.length; i++){
                        var liStr = "<li><i class='fa fa-newspaper-o pink '></i> <a href='javascript:;' onclick='loadInfoDetail(this, "+arr[i].basicInfoId+")'>"+ arr[i].basicInfoName +"</a></li>";
                        $("#basicInfoList").append(liStr);
                    }
                    $("#basicInfoList li i:first").removeClass("pink");
                    $("#basicInfoList li i:first").addClass("green");
                    //Default loading options under the first category.
                    $.post(
                        "InfoDetailListByBasicServlet",
                        {basicInfoId:arr[0].basicInfoId},
                        function(res){
                            showInfoDetail(res);
                        },
                        "json"
                    );
                }
            },
            "json"
        );
    });
    function showInfoDetail(res){
        if (res.code === 1){
            var detailList = res.data;
            $("#infoDetailTbody").html("");
            //Display data in a table through javaScript.
            for (var j = 0; j < detailList.length; j++){
                var trStr = "<tr>\n" +
                    "                        <td><label><input type=\"checkbox\" class=\"ace\"><span class=\"lbl\"></span></label></td>\n" +
                    "                        <td>"+detailList[j].infoDetailId+"</td>\n" +
                    "                        <td>"+detailList[j].infoDetailName+"</td>\n" +
                    "                        <td>"+detailList[j].infoDetailDesc+"</td>\n" +
                    "                        <td class=\"td-manage\">\n" +
                    "                            <a title=\"编辑\" onclick=\"member_edit('编辑','member-add.html','4','','510')\" href=\"javascript:;\"  class=\"btn btn-xs btn-info\" ><i class=\"fa fa-edit bigger-120\"></i></a>\n" +
                    "                            <a title=\"删除\" href=\"javascript:;\"  onclick=\"member_del(this,'1')\" class=\"btn btn-xs btn-danger\" ><i class=\"fa fa-trash  bigger-120\"></i></a>\n" +
                    "                        </td>\n" +
                    "                    </tr>";
                $("#infoDetailTbody").append(trStr);
            }
        }
    }

    function loadInfoDetail(obj, id){
        //Obj category label.
        //Id category id.
        $("#basicInfoList li i").removeClass("green");
        $("#basicInfoList li i").addClass("pink");
        $(obj).parent("li").children("i").removeClass("pink");
        $(obj).parent("li").children("i").addClass("green");
        //Options for reloading categories.
        $.post(
            "InfoDetailListByBasicServlet",
            {basicInfoId:id},
            function(res){
                showInfoDetail(res);
            },
            "json"
        );
    }
</script>
<script>
    $(function () {
        $(".displayPart").displayPart();
    });
    //面包屑返回值
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.iframeAuto(index);
    $('#add_page').on('click', function(){
        var cname = $(this).attr("title");
        var chref = $(this).attr("href");
        var cnames = parent.$('.Current_page').html();
        var herf = parent.$("#iframe").attr("src");
        parent.$('#parentIframe').html(cname);
        parent.$('#iframe').attr("src",chref).ready();;
        parent.$('#parentIframe').css("display","inline-block");
        parent.$('.Current_page').attr({"name":herf,"href":"javascript:void(0)"}).css({"color":"#4c8fbd","cursor":"pointer"});
        //parent.$('.Current_page').html("<a href='javascript:void(0)' name="+herf+" class='iframeurl'>" + cnames + "</a>");
        parent.layer.close(index);

    });
    // $(function() {
    //     var oTable1 = $('#sample-table').dataTable( {
    //         "aaSorting": [[ 1, "desc" ]],//默认第几个排序
    //         "bStateSave": true,//状态保存
    //         "aoColumnDefs": [
    //             //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
    //             {"orderable":false,"aTargets":[0,2,3,4,5,7,]}// 制定列不参与排序
    //         ] } );
    //     $('table th input:checkbox').on('click' , function(){
    //         var that = this;
    //         $(this).closest('table').find('tr > td:first-child input:checkbox')
    //             .each(function(){
    //                 this.checked = that.checked;
    //                 $(this).closest('tr').toggleClass('selected');
    //             });
    //
    //     });
    // })

    $(function() {
        $("#article_style").fix({
            float : 'left',
            //minStatue : true,
            skin : 'green',
            durationTime :false,
            stylewidth:'220',
            spacingw:30,//设置隐藏时的距离
            spacingh:250,//设置显示时间距
            set_scrollsidebar:'.Ads_style',
            table_menu:'.Ads_list'
        });
    });
    //初始化宽度、高度
    $(".widget-box").height($(window).height());
    $(".Ads_list").width($(window).width()-220);
    //当文档窗口发生改变时 触发
    $(window).resize(function(){
        $(".widget-box").height($(window).height());
        $(".Ads_list").width($(window).width()-220);
    });

    /*文章-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',{icon:0,},function(index){
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
        });
    }
</script>

