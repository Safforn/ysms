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
    <title>课程信息管理</title>
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
                    <label class="col-sm-1 control-label text-right">课程容量</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control input-sm" id="allNumber" name="allNumber" placeholder="课程容量"/>
                    </div>
                    <label class="col-sm-1 control-label text-right">教师姓名</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="teacherInfo.tno" id="tno"><!--动态加载-->
                        </select>
                    </div>
                </div>
                <div class="row">
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
                    <div class="col-sm-2">
                        <button class="btn btn-w-m btn-primary glyphicon glyphicon-plus" data-toggle="modal"
                                href="#addCourse" data-keyboard="true" data-backdrop="false"
                                id="btn_add">新增</button>
                    </div>
                    <div class="col-sm-2">
                        <button class="btn btn-w-m btn-primary glyphicon glyphicon-edit" data-toggle="modal" href="#"
                                onclick="javascript:showUpdateModal()" data-keyboard="true"
                                data-backdrop="false" id="btn_up">修改</button>
                    </div>
                    <div class="col-sm-2">
                        <button class="btn btn-w-m btn-primary glyphicon glyphicon-remove" id="btn_del"
                                onclick="deleteCourse()">删除</button>
                    </div>
                    <div class="col-sm-2">
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
    <!--添加-->
    <div class="modal fade" id="addCourse">
        <div class="modal-dialog" style="width:400px">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true" onclick="clear_add()" id="btn_close_add">
                        &times;
                    </button>
                    <h4 class="modal-title" id="addCourseLabel">课程信息录入</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <form method="post" class="form-horizontal" id="addform">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">课程编号</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" value="" class="form-control" name="cid" id="cid_add"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">课程名称</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" value="" class="form-control" name="cname" id="cname_add">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">上课时间</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" value="" class="form-control" name="time" id="time_add">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">上课地点</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" value="" class="form-control" name="location" id="location_add">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">课程容量</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" value="" class="form-control" name="allNumber" id="allNumber_add">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">教师姓名</label>
                                <div class="col-sm-8 controls">
                                    <%-- TODO: 新增弹窗的选择下拉框，需要修改name属性 --%>
                                    <select class="form-control" id="tno_add" name="teacherInfo.tno">
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">院系</label>
                                <div class="col-sm-8 controls">
                                    <select class="form-control" id="dep_id_add" name="departmentInfo.id">
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="controls">
                                    <input type="submit" class="btn btn-gmtx-define1 center-block"/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--修改-->
    <div class="modal fade" id="updateCourse">
        <div class="modal-dialog" style="width:400px">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true" onclick="clear_add()" id="btn_close_up">
                        &times;
                    </button>
                    <h4 class="modal-title" id="updateCourseLabel">课程信息修改</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <form method="post" class="form-horizontal" id="updateform">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">课程编号</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" value="" class="form-control"
                                           name="cid" id="cid_up" readonly="true"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">课程名称</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" value="" class="form-control"
                                           name="cname" id="cname_up"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">上课时间</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" value="" class="form-control"
                                           name="time" id="time_up"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">上课地点</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" value="" class="form-control"
                                           name="location" id="location_up"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">课程容量</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" value="" class="form-control"
                                           name="allNumber" id="allNumber_up"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">教师姓名</label>
                                <div class="col-sm-8 controls">
                                    <%-- TODO: 修改弹窗的选择下拉框，需要修改name属性 --%>
                                    <select class="form-control"
                                            id="tno_up" name="teacherInfo.tno" readonly="true">
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">院系编号</label>
                                <div class="col-sm-8 controls">
                                    <select class="form-control"
                                            id="dep_id_up" name="departmentInfo.id" readonly="true">
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="controls">
                                    <input type="submit" class="btn btn-gmtx-define1 center-block"/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
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

        //表单校验（如必填项、长度限制等）
        vform('addform',addCourse);
        vform('updateform',updateCourse);

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
                        return row.teacherInfo.tno;
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
    //课程录入
    function addCourse() {
        var cid=$('#cid_add').val();
        var cname=$('#cname_add').val();
        var time=$('#time_add').val();
        var location=$('#location_add').val();
        var allNumber=$('#allNumber_add').val();
        var tno=$('#tno_add option:selected').val();
        var dep_id=$('#dep_id_add option:selected').val();
        $.ajax({
           url:'/ysms/course/addCourse',
            dataType:'json',
            type:'post',
            data:{
                cid:cid,
                cname:cname,
                time:time,
                location:location,
                allNumber:allNumber,
                "teacherInfo.tno":parseInt(tno),
                "departmentInfo.id":parseInt(dep_id)
            },
            success:function (data) {
                if (data.success=='true'){
                    $('#cid_add').val('');
                    $('#cname_add').val('');
                    $('#time_add').val('');
                    $('#location_add').val('');
                    $('#allNumber_add').val('');
                    $('#tno_add').val('请选择')
                    $('#dep_id_add').val('请选择');
                    $('#addCourse').modal('hide');
                    $('#table').bootstrapTable('refresh');
                }else{
                    alert("添加失败!");
                }
            }
        });

    }
    //删除
    function deleteCourse() {
        var cid='';
        var selects=$('#table').bootstrapTable('getSelections');
        if(selects.length<=0){
            swal('系统提示','请选择需要删除的课程!','warning');
            return;
        }
        cid= "'"+selects[0].cid+"'";
        for (var i=1;i<selects.length;i++){
            cid+=","+"'"+selects[i].cid+"'";
        }
        swal({
            title:"您确定要删除选中的课程吗?",
            text:"",
            type:"warning",
            showCancelButton:true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText:"删除",
            cancelButtonText: "取消",
            closeOnConfirm: false,
            closeOnCancel: false
        },function (isconfirm) {
            if (isconfirm){
                $.ajax({
                    url:'/ysms/course/deleteCourse',
                    type:'post',
                    async: 'true',
                    cache:false,
                    contentType:"application/x-www-form-urlencoded; charset=utf-8",
                    data:{
                        cid:cid
                    },
                    dataType:'json',
                    success:function (data) {
                        if (data.success){
                            swal("系统提示","删除成功","success");
                            $('#table').bootstrapTable("refresh");
                        }else{
                            swal({
                                title:"系统提示",
                                text:"删除失败",
                                type:"warning"
                            });
                        }
                    },
                    error:function (aa,ee,rr) {
                        swal({
                            title:"系统提示",
                            text:"请求服务器失败，请稍后再试",
                            type:"warning"
                        });
                    }
                });
            }else{
                swal("系统提示","您取消了删除操作","error");
            }
        });
    }
    function updateCourse() {
        //获取表单上面的值
        var cid=$('#cid_up').val();
        var cname=$('#cname_up').val();
        var time=$('#time_up').val();
        var location=$('#phone_up').val();
        var allNumber=$('#allNumber_up').val();
        var tno=$('#tno_up option:selected').val();
        var dep_id=$('#dep_id_up option:selected').val();
        // alert(sno+sname+sex+phone+email+address+acquireStatus+checkStatus+checkTime+dorm_id+idcard+dep_id);
        $.ajax({
            url:'/ysms/course/updateCourse',
            type:'post',
            async:true,
            cache:false,
            dataType:'json',
            data:{
                cid:cid,
                cname:cname,
                time:time,
                location:location,
                allNumber:allNumber,
                "teacherInfo.tno":parseInt(tno),
                "departmentInfo.id":parseInt(dep_id)
            },
            success:function (data) {
                if (data.success =='true' ){
                    swal({
                        title:'系统提示',
                        text:'修改成功',
                        type:'success'
                    });
                    $('#cid_up').val('');
                    $('#cname_up').val('');
                    $('#time_up').val('');
                    $('#location_up').val('');
                    $('#allNumber_up').val('');
                    $('#tno_up').val('请选择')
                    $('#dep_id_up').val('请选择');
                    $('#updateCourse').modal('hide');
                    $('#table').bootstrapTable('refresh');
                }else{
                    alert("updateCourse进入success，但后端返回值为false");
                }
            }
        });

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

    // 修改课程弹窗的预先设置值
    var cid_update='';
    function showUpdateModal() {
        var selects=$('#table').bootstrapTable('getSelections');
        if (selects.length<=0){
            swal("系统提示","请选择要编辑的课程!",'warning');
            return;
        }
        if (selects.length>1){
            swal('系统提示','不能同时编辑多个课程','warning');
            return;
        }
        cid_update=selects[0].cid;
        //将选中行的学生信息赋值给商品修改对话框
        $('#cid_up').val(selects[0].cid);
        $('#cname_up').val(selects[0].cname);
        $('#time_up').val(selects[0].time);
        $('#location_up').val(selects[0].location);
        $('#allNumber_up').val(selects[0].allNumber);
        if (typeof(selects[0].teacherInfo)=="undefined"){
            $('#tno_up').val('0');
        }else{
            $('#tno_up').val(selects[0].teacherInfo.tno);
        }
        $('#idcard_up').val(selects[0].idcard);
        $('#dep_id_up').val(selects[0].departmentInfo.id);
        $('#updateCourse').modal('show');
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
    function vform(dom,func) {
        $('#'+dom).validate({
           rules:{
               cid:{
                   required:true,
                   maxlength:30
               },
               cname:{
                   required:true,
                   maxlength:10
               },
               time:{
                   required:true,
                   maxlength:30
               },
               location:{
                   required:true,
                   maxlength:20
               },
               allNumber:{
                   required:true,
                   maxlength:10
               },
               "teacherInfo.tno":{
                   required:true
               },
               "dormInfo.id":{
                   required:true
               }
           },
            messages:{
                cid:{
                    required:'请输入课程编号',
                    maxlength:'参数名过长'
                },
                cname:{
                    required:'请输入课程名称',
                    maxlength:'参数名过长'
                },
                time:{
                    required:'请输入上课时间',
                    maxlength:'参数名过长'
                },
                location:{
                    required:'请输入上课地点',
                    maxlength:'参数名过长'
                },
                "teacherInfo.tno":{
                    required:'请选择授课老师'
                },
                "dormInfo.id":{
                    required:'请选择院系'
                }
            },
            submitHandler:function () {
                func();
            }
        });
    }
</script>

</body>
</html>
