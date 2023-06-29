<%--
  Created by IntelliJ IDEA.
  User: Peroy
  Date: 2021/1/12
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>查看考勤信息</title>
    <link rel="shortcut icon" href="favicon.ico">
    <link href="../commons/jslib/hplus/css/bootstrap.min.css"
          rel="stylesheet">
    <link href="../commons/jslib/hplus/css/font-awesome.min.css?v=4.4.0"
          rel="stylesheet">
    <link href="../commons/jslib/hplus/css/animate.min.css"
          rel="stylesheet">
    <link href="../commons/jslib/hplus/css/style.min.css?v=4.0.0"
          rel="stylesheet">
    <link href="../commons/jslib/hplus/css/plugins/bootstrap-table/bootstrap-table.min.css"
          rel="stylesheet">

    <!-- Sweet Alert -->
    <link href="../commons/jslib/hplus/css/plugins/sweetalert/sweetalert.css"
          rel="stylesheet">
    <!-- Sweet Alert -->
    <link href="../commons/css/qy-style.css" rel="stylesheet">

    <link href="../commons/jslib/hplus/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css"
          rel="stylesheet">
    <script src="../commons/jslib/hplus/js/jquery.min.js?v=2.1.4"></script>
    <script src="../commons/jslib/hplus/js/jquery-ui-1.10.4.min.js"></script>
    <script
            src="../commons/jslib/hplus/js/plugins/validate/jquery.validate.min.js"></script>
    <script
            src="../commons/jslib/hplus/js/plugins/validate/messages_zh.min.js"></script>

    <script type="text/javascript" src="../commons/jslib/jquery-form.js"></script>

    <script src="../commons/jslib/hplus/js/bootstrap.min.js?v=3.3.5"></script>
    <script src="../commons/jslib/hplus/js/content.min.js?v=1.0.0"></script>

    <!-- Sweet Alert -->
    <script type="text/javascript"
            src="../commons/jslib/hplus/js/plugins/sweetalert/sweetalert.min.js"></script>
    <!-- Sweet Alert -->
    <script src="../commons/jslib/hplus/js/plugins/iCheck/icheck.min.js"></script>
    <script src="../commons/jslib/CommonValue.js"></script>
    <script src="../commons/jslib/hplus/js/plugins/prettyfile/bootstrap-prettyfile.js"></script>
    <!--数据导出相关-->
    <script src="../commons/tableExport.jquery.plugin/tableExport.js"></script>
    <script src="../commons/tableExport.jquery.plugin/libs/FileSaver/FileSaver.min.js"></script>
    <script src="../commons/tableExport.jquery.plugin/libs/jsPDF/jspdf.min.js"></script>
    <script src="../commons/tableExport.jquery.plugin/libs/jsPDF-AutoTable/jspdf.plugin.autotable.js"></script>
    <script src="../commons/tableExport.jquery.plugin/libs/js-xlsx/xlsx.core.min.js"></script>
    <script src="../commons/jslib/hplus/js/plugins/bootstrap-table/dist/bootstrap-table.min.js"></script>
    <script src="../commons/jslib/hplus/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"
            type="text/javascript"></script>
    <script src="../commons/jslib/hplus/js/plugins/bootstrap-table/dist/extensions/export/bootstrap-table-export.min.js"></script>
</head>
<body class="gray-bg black-bg-gmtx">
    <div class="wrapper wrapper-content">
        <div class="ibox float-e-margins">
            <div class="ibox-title" style="display:none;">
                <div class="row">
                    <label class="col-sm-1 control-label text-right">考勤编号</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control input-sm" id="aid" name="aid" placeholder="考勤编号"/>
                    </div>
                    <label class="col-sm-1 control-label text-right">学号</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="studentInfo.sno" id="sno"><!--动态加载-->
                        </select>
                    </div>
                    <label class="col-sm-1 control-label text-right">考勤课程</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control input-sm" id="cname" name="cname" placeholder="考勤课程"/>
                    </div>
                </div>
                <div class="row" style="display:none;">
                    <label class="col-sm-1 control-label text-right">考勤时间</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control input-sm" id="time" name="time" placeholder="考勤时间"/>
                    </div>
                </div>
                <div class="row" id="toolbar" style="display:none;">
                    <div class="col-sm-2">
                        <button class="btn btn-w-m btn-primary glyphicon glyphicon-search" type="button"
                                onclick="javascript:search();">搜索</button>
                    </div>
                    <div class="col-sm-2" style="margin-left: 100px">
                        <button class="btn btn-w-m btn-primary glyphicon glyphicon-erase"
                                onclick="javascript:btn_clear()">清空</button>
                    </div>
                </div>
            </div>
            <%--成绩信息列表展示--%>
            <div class="ibox-content table-responsive">
                <table id="table" class="table" data-click-to-select="true">
                </table>
            </div>
        </div>
    </div>

<script type="text/javascript">
    $(function () {
        var $table=$('#table');
        $table.bootstrapTable({
            url:'/ysms/attendance/list',
            toolbar:'#toolbar',
            dataType:'json',    //服务器返回的数据类型
            method:'post',      //请求方式
            contentType: "application/x-www-form-urlencoded;charset=UTF-8",//发送到服务器的数据编码类型
            pagination:true,    //是否显示分页
            pageSize:4,         //设置每页的记录行数
            pageList: [4,8,32,64,256],  //可供选择的每页的行数
            pageNumber:1,       //设置首页页码
            singleSelect:false, //设置是否单选
            checkboxHeader: true,
            showRefresh:true,   //是否显示刷新按钮
            showToggle:true,    //是否显示详细视图和列表视图的切换按钮
            showColumns:true,   //选择要显示的列
            striped: true,      //是否显示行间隔色
            clickToSelect:true, //是否启用点击选中行
            cache:false,            //禁用AJAX数据缓存
            sidePagination:'server',   //服务端处理分页
            queryParamsType:"undefined",    //设置参数格式
            queryParams:function queryParams(params) {//设置查询参数
                var param={
                    page:params.pageNumber,     //首页页码
                    rows:params.pageSize,       //每页的记录数
                    aid:$('#aid').val(),
                    "studentInfo.sno":$('#sno option:selected').val(),
                    cname:$('#cname').val(),
                    time:$('#time').val(),
                };
                return param;
            },
            columns:[{
                checkbox:true
            },{
                title:'考勤编号',
                field:'aid',
                valign:'middle'
            },{
                title:'学号',
                field:'studentInfo',
                formatter:function (value,row,index) {
                    if (row.studentInfo){
                        return row.studentInfo.sname;
                    }else{
                        return value;
                    }
                }
            },{
                title:'课程名称',
                field:'cname',
                valign:'middle'
            },{
                title:'考勤时间',
                field:'time',
                valign:'middle'
            }]
        });
    });
    function search() {
        $('#table').bootstrapTable('refresh');
    }

    function btn_clear() {
        $('#aid').val('');
        $('#sno').val('');
        $('#cname').val('');
        $('#time').val('');
    }

</script>

</body>
</html>
