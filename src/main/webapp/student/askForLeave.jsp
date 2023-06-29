<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>请假</title>
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
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-2">
        </div>
        <div class="col-sm-8">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h3>请假</h3>
                </div>
                <div class="ibox-content">
                    <form method="post" class="form-horizontal" id="updateform">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">请假编号:</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" value="${askForLeave.aid}" readonly="true"
                                       id="aid" name="aid"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学号:</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" value="${STUDENT.sno}" readonly="true"
                                       id="sno" name="sno"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">请假原因:</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" value="${askForLeave.reason}"
                                       id="reason" name="reason"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">请假时间:</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" value="${askForLeave.time}"
                                       id="time" name="time"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">申请状态:</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" value="${askForLeave.time}" readonly="true"
                                       id="state" name="state"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <button type="button" class="btn btn-w-m btn-primary text-center m-t-n-xs" onclick="checkAskForLeave()">
                                <strong>提 交</strong>
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-sm-2"></div>
    </div>
</div>
<script type="text/javascript">
    function checkAskForLeave() {
        var now = new Date();
        var aid=now.getFullYear() +
            ((now.getMonth()+1)<10?"0":"")+(now.getMonth()+1)+
            (now.getDate()<10?"0":"")+now.getDate()+
            (now.getHours()<10?"0":"")+now.getHours()+
            (now.getMinutes()<10?"0":"")+now.getMinutes()+
            (now.getSeconds()<10?"0":"")+now.getSeconds();
        var sno = ${STUDENT.sno};
        var reason= $('#reason').val();
        var time  = $('#time').val();
        var state = "待审批";

        console.log("前端传输的数据为：aid="+aid+"|sno="+sno+"|time="+time+"|state="+state);
        $.ajax({
            url:'/ysms/askForLeave/addAskForLeave',
            type:'post',
            async:true,
            cache:false,
            data:{
                aid:aid,
                "studentInfo.sno":sno,
                reason:reason,
                time:time,          //将当前时间作为考勤时间(年-月-日)
                state:state
            },
            dataType:'json',
            success:function (data) {
                if (data.message=='true'){
                    swal({
                        title:'系统提示',
                        text:'提交成功\n请假编号：'+aid+'\n学号：'+sno+
                            '\n请假原因：'+reason+'\n请假时间：'+time+'\n申请状态：'+state,
                        icon:'success',
                        confirmButtonColor:'#DD6B55',
                        confirmButtonText:'确定'
                    },function (isconfirm) {
                        window.location.reload();        //刷新当前页面
                    });
                }else{
                    swal('系统提示','请假申请提交失败','error');
                }
            }
        });
    }
</script>
</body>
</html>
