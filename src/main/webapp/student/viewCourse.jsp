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
    <title>课程信息</title>
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


    <%--    <script--%>
    <%--            src="/ssm_test/commons/jslib/hplus/js/plugins/bootstrap-table/bootstrap-table.min.js"--%>
    <%--            type="text/javascript"></script>--%>
    <%--    <script--%>
    <%--            src="/ssm_test/commons/jslib/hplus/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"--%>
    <%--            type="text/javascript"></script>--%>
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
            <div class="ibox-title">
                <div class="row">
                    <label class="col-sm-1 control-label text-right">课程编号</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control input-sm" id="cid" name="cid" placeholder="课程编号"/>
                    </div>
                    <label class="col-sm-1 control-label text-right">课程名称</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control input-sm" id="cname" name="cname" placeholder="课程名称"/>
                    </div>
                    <label class="col-sm-1 control-label text-right">上课时间</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control input-sm" id="time" name="time" placeholder="上课时间"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-1 control-label text-right">上课地点</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control input-sm" id="location" name="location" placeholder="上课地点"/>
                    </div>
                    <label class="col-sm-1 control-label text-right">教师姓名</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="teacherInfo.tno" id="tno"><!--动态加载-->
                        </select>
                    </div>
                    <label class="col-sm-1 control-label text-right">院系编号</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="departmentInfo.id" id="dep_id"><!--动态加载-->
                        </select>
                    </div>
                </div>
                <div class="row" id="toolbar">
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
            <%--学生列表展示--%>
            <div class="ibox-content table-responsive">
                <table id="table" class="table" data-click-to-select="true">
                </table>
            </div>
        </div>
    </div>

<script type="text/javascript">
    $(function () {
        //动态加载院系下拉框
        loadDepartmentType("/ysms/department/getDepartment","dep_id");
        //加载添加对话框界面院系下拉框
        loadDepartmentType("/ysms/department/getDepartment","dep_id_add");
        loadDepartmentType("/ysms/department/getDepartment","dep_id_up");
        //加载根页面教室姓名的下拉框
        loadTeacherId("/ysms/teacher/getTno","tno");
        loadTeacherId("/ysms/teacher/getTno","tno_add");
        loadTeacherId('/ysms/teacher/getTno',"tno_up");

        var $table=$('#table');
        $table.bootstrapTable({
            url:'/ysms/course/list',
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
                    cid:$('#cid').val(),
                    cname:$('#cname').val(),
                    time:$('#time').val(),
                    location:$('#location').val(),
                    allNumber:$('#allNumber').val(),
                    "teacherInfo.tno":$('#tno option:selected').val(),
                    "departmentInfo.id":parseInt($('#dep_id option:selected').val())
                };
                return param;
            },
            columns:[{
                checkbox:true
            },{
                title:'课程编号',
                field:'cid',
                valign:'middle'
            },{
                title:'课程名称',
                field:'cname',
                valign:'middle'
            },{
                title:'上课时间',
                field:'time',
                valign:'middle'
            },{
                title:'上课地点',
                field:'location',
                valign:'middle'
            },{
                title:'课程容量',
                field:'allNumber',
                valign:'middle'
            },{
                title:'教师姓名',
                field:'teacherInfo',
                formatter:function (value,row,index) {
                    if (row.teacherInfo){
                        return row.teacherInfo.tname;
                    }else{
                        return value;
                    }
                }
            },{
                title:'院系',
                field:'departmentInfo',
                formatter:function (value,row,index) {
                    if (row.departmentInfo){
                        return row.departmentInfo.dep_name;
                    }else{
                        return value;
                    }
                }
            }]
        });
    });
    function search() {
        $('#table').bootstrapTable('refresh');
    }

    // 清空按钮 点击事件函数
    function btn_clear() {
        $('#cid').val('');
        $('#cname').val('');
        $('#time').val('');
        $('#location').val('');
        $('#allNumber').val('');
        $('#tno').val('0')
        $('#dep_id').val('0');
    }


    function loadDepartmentType(url,idStr) {
        $.ajax({
           url:url,
            dataType:'json',
            async:false,
            data:{},
            type:'post',
            success:function (data) {
                var options="<option value='0'>请选择</option>";
                $.each(data.DepartmentType,function (key,val) {
                    options+='<option value='+val.id+'>'+val.dep_name+'</option>';
                });
                $('#'+idStr).empty();
                $('#'+idStr).append(options);
            },
            error:function () {
                swal('系统提示','加载失败','warning');
            }
        });
    }
    function loadTeacherId(url,idStr) {
        $.ajax({
           url:url,
            dataType:'json',
            async:false,
            data:{},
            type:'post',
            success:function (data) {
               var options="<option value='0'>请选择</option>";
               $.each(data.teacherInfoType, function (key,val) {
                    options+='<option value='+val.tno+'>'+val.tname+'</option>';
               });
               $('#'+idStr).empty();
               $('#'+idStr).append(options);
            },
            error:function () {
                swal('系统提示','加载失败','warning');
            }
        });
    }
</script>

</body>
</html>
