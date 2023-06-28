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
                    <label class="col-sm-1 control-label text-right">学号</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="studentInfo.sno" id="sno"><!--动态加载-->
                        </select>
                    </div>
                    <label class="col-sm-1 control-label text-right">课程编号</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="courseInfo.cid" id="cid"><!--动态加载-->
                        </select>
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-1 control-label text-right">学分</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control input-sm" id="credit" name="credit" placeholder="学分"/>
                    </div>
                    <label class="col-sm-1 control-label text-right">成绩</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control input-sm" id="score" name="score" placeholder="成绩"/>
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

    <!--添加-->
    <div class="modal fade" id="addCourseScore">
        <div class="modal-dialog" style="width:400px">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true" onclick="clear_add()" id="btn_close_add">
                        &times;
                    </button>
                    <h4 class="modal-title" id="addCourseScorelable">成绩信息录入</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <form method="post" class="form-horizontal" id="addform">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">成绩编号</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" value="" class="form-control"
                                           name="sid" id="sid_add"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">学号</label>
                                <div class="col-sm-8 controls">
                                    <select class="form-control" name="studentInfo.sno" id="sno_add"><!--动态加载-->
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">课程编号</label>
                                <div class="col-sm-8 controls">
                                    <select class="form-control" name="courseInfo.cid" id="cid_add"><!--动态加载-->
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">学分</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" value="" class="form-control" name="credit" id="credit_add">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">成绩</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" value="" class="form-control" name="score" id="score_add">
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
                    <h4 class="modal-title" id="updateCourseScoreLabel">成绩信息修改</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <form method="post" class="form-horizontal" id="updateform">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">成绩编号</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" value="" class="form-control"
                                           name="sid" id="sid_up" readonly="true"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">学号</label>
                                <div class="col-sm-8 controls">
                                    <select class="form-control" name="studentInfo.sno" id="sno_up"><!--动态加载-->
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">课程编号</label>
                                <div class="col-sm-8 controls">
                                    <select class="form-control" name="courseInfo.cid" id="cid_up"><!--动态加载-->
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">学分</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" value="" class="form-control"
                                           name="credit" id="credit_up" readonly="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">成绩</label>
                                <div class="col-sm-8 controls">
                                    <input type="text" value="" class="form-control"
                                           name="score" id="score_up">
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
        //动态加载学生下拉框
        loadStudentType("/ysms/student/getStudent","sno");
        loadStudentType("/ysms/student/getStudent","sno_add");
        loadStudentType("/ysms/student/getStudent","sno_up");
        //加载课程编号
        loadCourse("/ysms/course/getCourse","cid");
        loadCourse("/ysms/course/getCourse","cid_add");
        loadCourse('/ysms/course/getCourse',"cid_up");
        //表单校验
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
                    "studentInfo.sno":$('#sno option:selected').val(),
                    "courseInfo.cid":$('#cid option:selected').val(),
                    credit:$('#credit').val(),
                    score:$('#score').val()
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
                title:'课程编号',
                field:'courseInfo',
                formatter:function (value,row,index) {
                    if (row.courseInfo){
                        return row.courseInfo.cname;
                    }else{
                        return value;
                    }
                }
            },{
                title:'学分',
                field:'credit',
                valign:'middle'
            },{
                title:'成绩',
                field:'score',
                valign:'middle'
            }]
        });
    });
    function search() {
        $('#table').bootstrapTable('refresh');
    }
    //成绩信息录入
    function addCourseScore() {
        var sid=$('#sid_add').val();
        var sno=$('#sno_add option:selected').val();
        var cid=$('#cid_add option:selected').val();
        var credit=$('#credit_add').val();
        var score =$('#score_add').val();
        //alert("$\n"+sid+"\n"+sno+"\n"+cid+"\n"+credit+"\n"+score);
        $.ajax({
           url:'/ysms/courseScore/addCourseScore',
            dataType:'json',
            type:'post',
            data:{
                sid:sid,
                "studentInfo.sno":sno,
                "courseInfo.cid":cid,
                credit:credit,
                score:score
            },
            success:function (data) {
                if (data.success=='true'){
                    swal("系统提示","添加成功","success");
                    $('#sid_add').val('');
                    $('#sno_add').val('');
                    $('#cid_add').val('');
                    $('#credit_add').val('');
                    $('#score_add').val('');
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
        var sno=$('#sno_up option:selected').val();
        var cid=$('#cid_up option:selected').val();
        var credit=$('#credit_up').val();
        var score =$('#score_up').val();
        // alert(sid+sno+cid+credit+score);
        $.ajax({
            url:'/ysms/courseScore/updateCourseScore',
            type:'post',
            async:true,
            cache:false,
            dataType:'json',
            data:{
                sid:sid,
                "studentInfo.sno":sno,
                "courseInfo.cid":cid,
                credit:credit,
                score:score
            },
            success:function (data) {
                if (data.success =='true' ){
                    swal({
                        title:'系统提示',
                        text:'修改成功',
                        type:'success'
                    });
                    $('#sid_up').val('');
                    $('#sno_up').val('');
                    $('#cid_up').val('');
                    $('#credit_up').val('');
                    $('#score_up').val('');
                    $('#updateCourseScore').modal('hide');
                    $('#table').bootstrapTable('refresh');
                }else{

                }
            }
        });

    }
    function btn_clear() {
        $('#sid').val('');
        $('#sno').val('');
        $('#cid').val('');
        $('#credit').val('');
        $('#score').val('');
    }
    var sid_update='';
    function showUpdateModal() {
        var selects=$('#table').bootstrapTable('getSelections');
        if (selects.length<=0){
            swal("系统提示","请选择要编辑的成绩信息!",'warning');
            return;
        }
        if (selects.length>1){
            swal('系统提示','不能同时编辑多个成绩信息','warning');
            return;
        }
        sid_update=selects[0].sid;
        //将选中行的成绩信息信息赋值给成绩修改对话框
        $('#sid_up').val(selects[0].sid);
        if (typeof(selects[0].studentInfo)=="undefined"){
            $('#sno_up').val('0');
        }else{
            $('#sno_up').val(selects[0].studentInfo.sno);
        }
        if (typeof(selects[0].courseInfo)=="undefined"){
            $('#cid_up').val('0');
        }else{
            $('#cid_up').val(selects[0].courseInfo.cid);
        }
        //alert(selects[0].studentInfo.sname+"\n"+selects[0].courseInfo.cname);
        $('#credit_up').val(selects[0].credit);
        $('#score_up').val(selects[0].score);

        $('#updateCourseScore').modal('show');
    }
    function loadStudentType(url,idStr) {
        $.ajax({
            url:url,
            dataType:'json',
            async:false,
            data:{},
            type:'post',
            success:function (data) {
                var options="<option value='0'>请选择</option>";
                $.each(data.StudentType,function (key,val) {
                    options+='<option value='+val.sno+'>'+val.sname+'</option>';
                });
                $('#'+idStr).empty();
                $('#'+idStr).append(options);
                //alert(options);
            },
            error:function () {
                swal('系统提示','Student加载失败','warning');
            }
        });
    }
    function loadCourse(url,idStr) {
        $.ajax({
           url:url,
            dataType:'json',
            async:false,
            data:{},
            type:'post',
            success:function (data) {
               var options="<option value='0'>请选择</option>";
               $.each(data.CourseType,function (key,val) {
                    options+='<option value='+val.cid+'>'+val.cname+'</option>';
               });
               $('#'+idStr).empty();
               $('#'+idStr).append(options);
            },
            error:function () {
                swal('系统提示','Course加载失败','warning');
            }
        });
    }
    function vform(dom,func) {
        $('#'+dom).validate({
           rules:{
               sid:{
                   required:true,
                   maxlength:20
               },
               "studentInfo.sno":{
                   required:true,
               },
               "courseInfo.cid":{
                   required:true
               },
               credit:{
                   required:true,
                   maxlength:10
               },
               score:{
                   required:true,
                   maxlength:10
               }
           },
            messages:{
                sid:{
                    required:'请输入成绩编号',
                    maxlength:'参数名过长'
                },
                "studentInfo.sno":{
                    required:'请选择学生',
                },
                "courseInfo.cid":{
                    required:'请选择课程'
                },
                credit:{
                    required:'请输入学分',
                    maxlength:'参数名过长'
                },
                score:{
                    required:'请输入成绩',
                    maxlength:'参数名过长'
                },
            },
            submitHandler:function () {
                func();
            }
        });
    }
</script>

</body>
</html>
