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
    <title>课程成绩管理</title>
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
                    <label class="col-sm-1 control-label text-right">成绩编号</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control input-sm" id="sid" name="sid" placeholder="成绩编号"/>
                    </div>
                    <label class="col-sm-1 control-label text-right">姓名</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control input-sm" id="sname" name="sname" placeholder="姓名"/>
                    </div>
                    <label class="col-sm-1 control-label text-right">性别</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="sex" id="sex">
                            <option value="请选择" selected>请选择</option>
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-1 control-label text-right">领取物品</label>
                   <div class="col-sm-2">
                       <select class="form-control" name="acquireStatus" id="acquireStatus">
                           <option value="请选择" selected>请选择</option>
                           <option value="未领取">未领取</option>
                           <option value="已领取">已领取</option>
                       </select>
                   </div>
                    <label class="col-sm-1 control-label text-right">是否报到</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="checkStatus" id="checkStatus">
                            <option value="请选择" selected>请选择</option>
                            <option value="未报到">未报到</option>
                            <option value="已报到">已报到</option>
                        </select>
                    </div>
                    <label class="col-sm-1 control-label text-right">宿舍分配编号</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="dormInfo.id" id="dorm_id"><!--动态加载-->
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
                                href="#addCourseScore" data-keyboard="true" data-backdrop="false"
                                id="btn_add">新增</button>
                    </div>
                    <div class="col-sm-2">
                        <button class="btn btn-w-m btn-primary glyphicon glyphicon-edit" data-toggle="modal" href="#"
                                onclick="javascript:showUpdateModal()" data-keyboard="true"
                                data-backdrop="false" id="btn_up">修改</button>
                    </div>
                    <div class="col-sm-2">
                        <button class="btn btn-w-m btn-primary glyphicon glyphicon-remove" id="btn_del"
                                onclick="deleteCourseScore()">删除</button>
                    </div>
                    <div class="col-sm-2">
                        <button class="btn btn-w-m btn-primary glyphicon glyphicon-erase" onclick="javascript:btn_clear()">清空</button>
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
    <!--添加-->
    <div class="modal fade" id="addCourseScore">
        <div class="modal-dialog" style="width:400px">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true" onclick="clear_add()" id="btn_close_add">
                        &times;
                    </button>
                    <h4 class="modal-title" id="addCourseScorelable">成绩信息信息录入</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <form method="post" class="form-horizontal" id="addform">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">成绩编号</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" value="" class="form-control" name="sid"
                                           id="sid_add"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">姓名</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" value="" class="form-control" name="sname" id="sname_add">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">性别</label>
                                <div class="col-sm-8 controls">
                                    <select class="form-control" name="sex" id="sex_add">
                                        <option value="">请选择</option>
                                        <option value="男">男</option>
                                        <option value="女">女</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">院系</label>
                                <div class="col-sm-8 controls">
                                    <select class="form-control" id="dep_id_add" name="dormInfo.id">
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
    <div class="modal fade" id="updateCourseScore">
        <div class="modal-dialog" style="width:400px">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true" onclick="clear_add()" id="btn_close_up">
                        &times;
                    </button>
                    <h4 class="modal-title" id="updateCourseScoreLabel">成绩信息信息修改</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <form method="post" class="form-horizontal" id="updateform">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">成绩编号</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" value="" class="form-control" name="sid"
                                           id="sid_up" readonly="true"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">姓名</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" value="" class="form-control" name="sname"
                                           id="sname_up"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">性别</label>
                                <div class="col-sm-8 controls">
                                    <select class="form-control" name="sex" id="sex_up">
                                        <option value="请选择">请选择</option>
                                        <option value="男">男</option>
                                        <option value="女">女</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">电话</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" value="" class="form-control" name="phone"
                                           id="phone_up"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">邮箱</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" value="" class="form-control" name="email"
                                           id="email_up"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">住址</label>
                                <div class="col-sm-8 controls">
                                     <input type="text" value="" class="form-control" name="address"
                                        id="address_up"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">是否领取物品</label>
                                <div class="col-sm-8 controls">
                                    <select class="form-control" name="acquireStatus" id="acquireStatus_up">
                                        <option value="请选择" selected>请选择</option>
                                        <option value="未领取">未领取</option>
                                        <option value="已领取">已领取</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">是否报到</label>
                                <div class="col-sm-8 controls">
                                    <select class="form-control" name="checkStatus" id="checkStatus_up" readonly="true">
                                        <option value="请选择" selected>请选择</option>
                                        <option value="未报到">未报到</option>
                                        <option value="已报到">已报到</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">报到时间</label>
                                <div class="col-sm-8 controls">
                                    <input class="form-control" name="checkTime" value="" id="checkTime_up" readonly="true"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">宿舍编号</label>
                                <div class="col-sm-8 controls">
                                    <select class="form-control" name="dormInfo.id" id="dorm_id_up" disabled="true" ><!--动态加载-->
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">院系编号</label>
                                <div class="col-sm-8 controls">
                                    <select class="form-control" id="dep_id_up" name="dormInfo.id" readonly="true">
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">身份证号</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" class="form-control" value="" name="idcard" id="idcard_up"/>
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
        //加载宿舍分配编号
        loadDormId("/ysms/dorm/getDormId","dorm_id");
        loadDormId('/ysms/dorm/getDormId',"dorm_id_up");

        vform('addform',addCourseScore);
        vform('updateform',updateCourseScore);

        var $table=$('#table');
        $table.bootstrapTable({
            url:'/ysms/courseScore/list',
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
                    sid:$('#sid').val(),
                    sname:$('#sname').val(),
                    sex:$('#sex option:selected').val(),
                    acquireStatus:$('#acquireStatus option:selected').val(),
                    checkStatus:$('#checkStatus option:selected').val(),
                    "dormInfo.id":$('#dorm_id option:selected').val(),
                     "departmentInfo.id":parseInt($('#dep_id option:selected').val())
                };
                return param;
            },
            columns:[{
                checkbox:true
            },{
                title:'成绩编号',
                field:'sid',
                valign:'middle'
            },{
                title:'姓名',
                field:'sname',
                valign:'middle'
            },{
                title:'性别',
                field:'sex',
                valign:'middle'
            },{
                title:'已领物品',
                field:'acquireStatus',
                valign:'middle'
            },{
                title:'是否报到',
                field:'checkStatus',
                valign:'middle'
            },{
                title:'宿舍编号',
                field:'dormInfo',
                formatter:function (value,row,index) {
                    if (row.dormInfo){
                        return row.dormInfo.id;
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
    //成绩信息录入
    function addCourseScore() {
        var sid=$('#sid_add').val();
        var sname=$('#sname_add').val();
        var sex=$('#sex_add option:selected').val();
        var dep_id=$('#dep_id_add option:selected').val();
        $.ajax({
           url:'/ysms/courseScore/addCourseScore',
            dataType:'json',
            type:'post',
            data:{
                sid:sid,
                sname:sname,
                password:"111",  // 初始默认密码 111
                sex:sex,
                "departmentInfo.id":parseInt(dep_id)
            },
            success:function (data) {
                if (data.success=='true'){
                       $('#sid_add').val('');
                       $('#sname_add').val('');
                       $('#sex_add').val('请选择');
                       $('#dep_id_add').val('请选择');
                       $('#addCourseScore').modal('hide');
                       $('#table').bootstrapTable('refresh');
                }else{
                    alert("添加失败!");
                }
            }
        });

    }
    //删除
    function deleteCourseScore() {
        var sid='';
        var selects=$('#table').bootstrapTable('getSelections');
        if(selects.length<=0){
            swal('系统提示','请选择需要删除的成绩信息!','warning');
            return;
        }
        sid= "'"+selects[0].sid+"'";
        for (var i=1;i<selects.length;i++){
            sid+=","+"'"+selects[i].sid+"'";
        }
        swal({
            title:"您确定要删除选中的成绩信息吗?",
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
                    url:'/ysms/courseScore/deleteCourseScore',
                    type:'post',
                    async: 'true',
                    cache:false,
                    contentType:"application/x-www-form-urlencoded; charset=utf-8",
                    data:{
                        sid:sid
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
    function updateCourseScore() {
        //获取表单上面的值
        var sid=$('#sid_up').val();
        var sname=$('#sname_up').val();
        var sex=$('#sex_up option:selected').val();
        var phone=$('#phone_up').val();
        var email=$('#email_up').val();
        var address=$('#address_up').val();
        var acquireStatus=$('#acquireStatus_up option:selected').val();
        var checkStatus=$('#checkStatus_up option:selected').val();
        var checkTime=$('#checkTime_up').val();
        var dorm_id=$('#dorm_id_up option:selected').val();
        var idcard=$('#idcard_up').val();
        var dep_id=$('#dep_id_up option:selected').val();
        // alert(sid+sname+sex+phone+email+address+acquireStatus+checkStatus+checkTime+dorm_id+idcard+dep_id);
        $.ajax({
            url:'/ysms/courseScore/updateCourseScore',
            type:'post',
            async:true,
            cache:false,
            dataType:'json',
            data:{
              sid:sid,
              sname:sname,
              sex:sex,
              phone:phone,
              email:email,
              address:address,
              acquireStatus:acquireStatus,
              checkStatus:checkStatus,
              checkTime:checkTime,
                "dormInfo.id":dorm_id,
                idcard:idcard,
              "departmentInfo.id":parseInt(dep_id)
            },
            success:function (data) {
                if (data.success =='true' ){
                    swal({
                        title:'系统提示',
                        text:'修改成功',
                        type:'success'
                    });
                    $('#sid_up').val('');
                    $('#sname_up').val('');
                    $('#sex_up').val('请选择');
                    $('#phone_up').val('');
                    $('#email_up').val('');
                    $('#address_up').val('');
                    $('#acquireStatus_up').val('请选择');
                    $('#checkStatus_up').val('请选择');
                    $('#checkTime_up').val('');
                    $('#dorm_id_up').val('0');
                    $('#idcard_up').val('');
                    $('#dep_id_up').val('0');
                    $('#updateCourseScore').modal('hide');
                    $('#table').bootstrapTable('refresh');
                }else{

                }
            }
        });

    }
    function btn_clear() {
        $('#sid').val('');
        $('#sname').val('');
        $('#sex').val('请选择');
        $('#acquireStatus').val('请选择');
        $('#checkStatus').val('请选择');
        $('#dorm_id').val('0');
        $('#dep_id').val('0');
    }
    var sid_update='';
    function showUpdateModal() {
        var selects=$('#table').bootstrapTable('getSelections');
        if (selects.length<=0){
            swal("系统提示","请选择要编辑的商品!",'warning');
            return;
        }
        if (selects.length>1){
            swal('系统提示','不能同时编辑多个商品','warning');
            return;
        }
        sid_update=selects[0].sid;
        //将选中行的成绩信息信息赋值给商品修改对话框
        $('#sid_up').val(selects[0].sid);
        $('#sname_up').val(selects[0].sname);
        $('#sex_up').val(selects[0].sex);
        $('#phone_up').val(selects[0].phone);
        $('#email_up').val(selects[0].email);
        $('#address_up').val(selects[0].address);
        $('#acquireStatus_up').val(selects[0].acquireStatus);
        $('#checkStatus_up').val(selects[0].checkStatus);
        $('#checkTime_up').val(selects[0].checkTime);

        if (typeof(selects[0].dormInfo)=="undefined"){
            $('#dorm_id_up').val('0');
        }else{
            $('#dorm_id_up').val(selects[0].dormInfo.id);
        }
        $('#idcard_up').val(selects[0].idcard);
        $('#dep_id_up').val(selects[0].departmentInfo.id);
        $('#updateCourseScore').modal('show');
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
    function loadDormId(url,idStr) {
        $.ajax({
           url:url,
            dataType:'json',
            async:false,
            data:{},
            type:'post',
            success:function (data) {
               var options="<option value='0'>请选择</option>";
               $.each(data.DormId,function (key,val) {
                    options+='<option value='+val.id+'>'+val.id+'</option>';
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
               sid:{
                   required:true,
                   maxlength:30
               },
               sname:{
                   required:true,
                   maxlength:10
               },
               sex:{
                   required:true
               },
               "dormInfo.id":{
                   required:true
               }
           },
            messages:{
               sid:{
                   required:'请输入成绩编号',
                   maxlength:'参数名过长'
               },
                sname:{
                   required:'请输入姓名',
                    maxlength:'参数名过长'
                },
                sex:{
                   required:'请输入性别'
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
