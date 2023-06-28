//package com.ssm.dao.provider;
//
//import com.ssm.pojo.AskForLeaveInfo;
//import org.apache.ibatis.jdbc.SQL;
//
//import java.util.Map;
//
//public class AskForLeaveInfoDynaSqlProvider {
//
//    //根据条件查询请假总数
//    public String count(Map<String,Object> params){
//        return new SQL(){
//            {
//                SELECT("count(*)");
//                FROM("askForLeave");
//                if(params.get("askForLeaveInfo")!=null){
//                    AskForLeaveInfo askForLeaveInfo=(AskForLeaveInfo)params.get("askForLeaveInfo");
//                    if(askForLeaveInfo.getSno()!=null&&!"".equals(askForLeaveInfo.getSno())){
//                        WHERE("sno=#{askForLeaveInfo.sno}");
//                    }
//                    if(askForLeaveInfo.getSname()!=null&&!"".equals(askForLeaveInfo.getSname())){
//                        WHERE("sname like CONCAT('%',#{askForLeaveInfo.sname},'%')");
//                    }
//                    if(askForLeaveInfo.getSex()!=null&&!"".equals(askForLeaveInfo.getSex())&&!"请选择".equals(askForLeaveInfo.getSex())){
//                        WHERE("sex=#{askForLeaveInfo.sex}");
//                    }
//                    if(askForLeaveInfo.getAcquireStatus()!=null&&!"".equals(askForLeaveInfo.getAcquireStatus())&&!"请选择".equals(askForLeaveInfo.getAcquireStatus())){
//                        WHERE("acquireStatus=#{askForLeaveInfo.acquireStatus}");
//                    }
//                    if(askForLeaveInfo.getCheckStatus()!=null&&!"".equals(askForLeaveInfo.getCheckStatus())&&!"请选择".equals(askForLeaveInfo.getCheckStatus())){
//                        WHERE("checkStatus=#{askForLeaveInfo.checkStatus}");
//                    }
//                    if(askForLeaveInfo.getDormInfo()!=null&&!"".equals(askForLeaveInfo.getDormInfo().getId())&&!"0".equals(askForLeaveInfo.getDormInfo().getId())){
//                        WHERE("dorm_id=#{askForLeaveInfo.dormInfo.id}");
//                    }
//                    if(askForLeaveInfo.getDepartmentInfo()!=null&&askForLeaveInfo.getDepartmentInfo().getId()>0){
//                        WHERE("dep_id=#{askForLeaveInfo.departmentInfo.id}");
//                    }
//                }
//            }
//        }.toString();
//    }
//
//    //根据条件查询请假列表
//    public String selectWithParam(Map<String,Object> params){
//        String sql=new SQL(){
//            {
//                SELECT("*");
//                FROM("askForLeave");
//                if(params.get("askForLeaveInfo")!=null){
//                    AskForLeaveInfo askForLeaveInfo=(AskForLeaveInfo)params.get("askForLeaveInfo");
//                    if(askForLeaveInfo.getSno()!=null&&!"".equals(askForLeaveInfo.getSno())){
//                        WHERE("sno=#{askForLeaveInfo.sno}");
//                    }
//                    if(askForLeaveInfo.getSname()!=null&&!"".equals(askForLeaveInfo.getSname())){
//                        WHERE("sname like CONCAT('%',#{askForLeaveInfo.sname},'%')");
//                    }
//                    if(askForLeaveInfo.getSex()!=null&&!"".equals(askForLeaveInfo.getSex())&&!"请选择".equals(askForLeaveInfo.getSex())){
//                        WHERE("sex=#{askForLeaveInfo.sex}");
//                    }
//                    if(askForLeaveInfo.getAcquireStatus()!=null&&!"".equals(askForLeaveInfo.getAcquireStatus())&&!"请选择".equals(askForLeaveInfo.getAcquireStatus())){
//                        WHERE("acquireStatus=#{askForLeaveInfo.acquireStatus}");
//                    }
//                    if(askForLeaveInfo.getCheckStatus()!=null&&!"".equals(askForLeaveInfo.getCheckStatus())&&!"请选择".equals(askForLeaveInfo.getCheckStatus())){
//                        WHERE("checkStatus=#{askForLeaveInfo.checkStatus}");
//                    }
//                    if(askForLeaveInfo.getDormInfo()!=null&&!"".equals(askForLeaveInfo.getDormInfo().getId())&&!"0".equals(askForLeaveInfo.getDormInfo().getId())){
//                        WHERE("dorm_id=#{askForLeaveInfo.dormInfo.id}");
//                    }
//                    if(askForLeaveInfo.getDepartmentInfo()!=null&&askForLeaveInfo.getDepartmentInfo().getId()>0){
//                        WHERE("dep_id=#{askForLeaveInfo.departmentInfo.id}");
//                    }
//                }
//            }
//        }.toString();
//        if(params.get("pager")!=null){
//            sql+=" limit #{pager.firstLimitParam},#{pager.perPageRows}";
//        }
//        return sql;
//    }
//    public String updateWithParam(AskForLeaveInfo askForLeaveInfo){
//        String sql=new SQL(){
//            {
//                     UPDATE("askForLeave");
//                    if(askForLeaveInfo.getSname()!=null&&!"".equals(askForLeaveInfo.getSname())){
//                        SET("sname=#{sname}");
//                    }
//                    if(askForLeaveInfo.getPassword()!=null&&!"".equals(askForLeaveInfo.getPassword())){
//                        SET("password=#{password}");
//                    }
//                    if(askForLeaveInfo.getSex()!=null&&!"请选择".equals(askForLeaveInfo.getSex())&&!"".equals(askForLeaveInfo.getSex())){
//                        SET("sex=#{sex}");
//                    }
//                    if(askForLeaveInfo.getPhone()!=null&&!"".equals(askForLeaveInfo.getPhone())){
//                        SET("phone=#{phone}");
//                    }
//                    if(askForLeaveInfo.getEmail()!=null&&!"".equals(askForLeaveInfo.getEmail())){
//                        SET("email=#{email}");
//                    }
//                    if(askForLeaveInfo.getAddress()!=null&&!"".equals(askForLeaveInfo.getAddress())){
//                        SET("address=#{address}");
//                    }
//                    if(askForLeaveInfo.getAcquireStatus()!=null&&!"".equals(askForLeaveInfo.getAcquireStatus())&&!"请选择".equals(askForLeaveInfo.getAcquireStatus())){
//                        SET("acquireStatus=#{acquireStatus}");
//                    }
//                    if(askForLeaveInfo.getCheckStatus()!=null&&!"".equals(askForLeaveInfo.getCheckStatus())&&!"请选择".equals(askForLeaveInfo.getCheckStatus())){
//                        SET("checkStatus=#{checkStatus}");
//                    }
//                    if(askForLeaveInfo.getCheckTime()!=null&&!"".equals(askForLeaveInfo.getCheckTime())){
//                        SET("checkTime=#{checkTime}");
//                    }
//                    if(askForLeaveInfo.getDormInfo()!=null&&!"0".equals(askForLeaveInfo.getDormInfo().getId())&&!"".equals(askForLeaveInfo.getDormInfo().getId())){
//                        SET("dorm_id=#{dormInfo.id}");
//                    }
//                    if(askForLeaveInfo.getIdcard()!=null&&!"".equals(askForLeaveInfo.getIdcard())){
//                        SET("idcard=#{idcard}");
//                    }
//                    if(askForLeaveInfo.getDepartmentInfo()!=null&&askForLeaveInfo.getDepartmentInfo().getId()>0){
//                        SET("dep_id=#{departmentInfo.id}");
//                    }
//                WHERE("sno=#{sno}");
//            }
//        }.toString();
//        return sql;
//    }
//    //根据条件查询未分配宿舍的请假列表
//    public String allocationAskForLeave(AskForLeaveInfo askForLeaveInfo){
//        String sql=new SQL(){
//            {
//                SELECT("*");
//                FROM("askForLeave");
//                if(askForLeaveInfo.getSex()!=null&&!"".equals(askForLeaveInfo.getSex())){
//                    WHERE("sex=#{sex}");
//                }
//                if(askForLeaveInfo.getDepartmentInfo()!=null&&askForLeaveInfo.getDepartmentInfo().getId()>0){
//                    WHERE("dep_id=#{departmentInfo.id}");
//                }
//               WHERE("dorm_id is null");
//            }
//        }.toString();
//        return sql;
//    }
//}
