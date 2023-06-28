//package com.ssm.dao.provider;
//
//import com.ssm.pojo.CourseScoreInfo;
//import org.apache.ibatis.jdbc.SQL;
//
//import java.util.Map;
//
//public class CourseScoreInfoDynaSqlProvider {
//
//    //根据条件查询成绩总数
//    public String count(Map<String,Object> params){
//        return new SQL(){
//            {
//                SELECT("count(*)");
//                FROM("courseScore");
//                if(params.get("courseScoreInfo")!=null){
//                    CourseScoreInfo courseScoreInfo=(CourseScoreInfo)params.get("courseScoreInfo");
//                    if(courseScoreInfo.getSno()!=null&&!"".equals(courseScoreInfo.getSno())){
//                        WHERE("sno=#{courseScoreInfo.sno}");
//                    }
//                    if(courseScoreInfo.getSname()!=null&&!"".equals(courseScoreInfo.getSname())){
//                        WHERE("sname like CONCAT('%',#{courseScoreInfo.sname},'%')");
//                    }
//                    if(courseScoreInfo.getSex()!=null&&!"".equals(courseScoreInfo.getSex())&&!"请选择".equals(courseScoreInfo.getSex())){
//                        WHERE("sex=#{courseScoreInfo.sex}");
//                    }
//                    if(courseScoreInfo.getAcquireStatus()!=null&&!"".equals(courseScoreInfo.getAcquireStatus())&&!"请选择".equals(courseScoreInfo.getAcquireStatus())){
//                        WHERE("acquireStatus=#{courseScoreInfo.acquireStatus}");
//                    }
//                    if(courseScoreInfo.getCheckStatus()!=null&&!"".equals(courseScoreInfo.getCheckStatus())&&!"请选择".equals(courseScoreInfo.getCheckStatus())){
//                        WHERE("checkStatus=#{courseScoreInfo.checkStatus}");
//                    }
//                    if(courseScoreInfo.getDormInfo()!=null&&!"".equals(courseScoreInfo.getDormInfo().getId())&&!"0".equals(courseScoreInfo.getDormInfo().getId())){
//                        WHERE("dorm_id=#{courseScoreInfo.dormInfo.id}");
//                    }
//                    if(courseScoreInfo.getDepartmentInfo()!=null&&courseScoreInfo.getDepartmentInfo().getId()>0){
//                        WHERE("dep_id=#{courseScoreInfo.departmentInfo.id}");
//                    }
//                }
//            }
//        }.toString();
//    }
//
//    //根据条件查询成绩列表
//    public String selectWithParam(Map<String,Object> params){
//        String sql=new SQL(){
//            {
//                SELECT("*");
//                FROM("courseScore");
//                if(params.get("courseScoreInfo")!=null){
//                    CourseScoreInfo courseScoreInfo=(CourseScoreInfo)params.get("courseScoreInfo");
//                    if(courseScoreInfo.getSno()!=null&&!"".equals(courseScoreInfo.getSno())){
//                        WHERE("sno=#{courseScoreInfo.sno}");
//                    }
//                    if(courseScoreInfo.getSname()!=null&&!"".equals(courseScoreInfo.getSname())){
//                        WHERE("sname like CONCAT('%',#{courseScoreInfo.sname},'%')");
//                    }
//                    if(courseScoreInfo.getSex()!=null&&!"".equals(courseScoreInfo.getSex())&&!"请选择".equals(courseScoreInfo.getSex())){
//                        WHERE("sex=#{courseScoreInfo.sex}");
//                    }
//                    if(courseScoreInfo.getAcquireStatus()!=null&&!"".equals(courseScoreInfo.getAcquireStatus())&&!"请选择".equals(courseScoreInfo.getAcquireStatus())){
//                        WHERE("acquireStatus=#{courseScoreInfo.acquireStatus}");
//                    }
//                    if(courseScoreInfo.getCheckStatus()!=null&&!"".equals(courseScoreInfo.getCheckStatus())&&!"请选择".equals(courseScoreInfo.getCheckStatus())){
//                        WHERE("checkStatus=#{courseScoreInfo.checkStatus}");
//                    }
//                    if(courseScoreInfo.getDormInfo()!=null&&!"".equals(courseScoreInfo.getDormInfo().getId())&&!"0".equals(courseScoreInfo.getDormInfo().getId())){
//                        WHERE("dorm_id=#{courseScoreInfo.dormInfo.id}");
//                    }
//                    if(courseScoreInfo.getDepartmentInfo()!=null&&courseScoreInfo.getDepartmentInfo().getId()>0){
//                        WHERE("dep_id=#{courseScoreInfo.departmentInfo.id}");
//                    }
//                }
//            }
//        }.toString();
//        if(params.get("pager")!=null){
//            sql+=" limit #{pager.firstLimitParam},#{pager.perPageRows}";
//        }
//        return sql;
//    }
//    public String updateWithParam(CourseScoreInfo courseScoreInfo){
//        String sql=new SQL(){
//            {
//                     UPDATE("courseScore");
//                    if(courseScoreInfo.getSname()!=null&&!"".equals(courseScoreInfo.getSname())){
//                        SET("sname=#{sname}");
//                    }
//                    if(courseScoreInfo.getPassword()!=null&&!"".equals(courseScoreInfo.getPassword())){
//                        SET("password=#{password}");
//                    }
//                    if(courseScoreInfo.getSex()!=null&&!"请选择".equals(courseScoreInfo.getSex())&&!"".equals(courseScoreInfo.getSex())){
//                        SET("sex=#{sex}");
//                    }
//                    if(courseScoreInfo.getPhone()!=null&&!"".equals(courseScoreInfo.getPhone())){
//                        SET("phone=#{phone}");
//                    }
//                    if(courseScoreInfo.getEmail()!=null&&!"".equals(courseScoreInfo.getEmail())){
//                        SET("email=#{email}");
//                    }
//                    if(courseScoreInfo.getAddress()!=null&&!"".equals(courseScoreInfo.getAddress())){
//                        SET("address=#{address}");
//                    }
//                    if(courseScoreInfo.getAcquireStatus()!=null&&!"".equals(courseScoreInfo.getAcquireStatus())&&!"请选择".equals(courseScoreInfo.getAcquireStatus())){
//                        SET("acquireStatus=#{acquireStatus}");
//                    }
//                    if(courseScoreInfo.getCheckStatus()!=null&&!"".equals(courseScoreInfo.getCheckStatus())&&!"请选择".equals(courseScoreInfo.getCheckStatus())){
//                        SET("checkStatus=#{checkStatus}");
//                    }
//                    if(courseScoreInfo.getCheckTime()!=null&&!"".equals(courseScoreInfo.getCheckTime())){
//                        SET("checkTime=#{checkTime}");
//                    }
//                    if(courseScoreInfo.getDormInfo()!=null&&!"0".equals(courseScoreInfo.getDormInfo().getId())&&!"".equals(courseScoreInfo.getDormInfo().getId())){
//                        SET("dorm_id=#{dormInfo.id}");
//                    }
//                    if(courseScoreInfo.getIdcard()!=null&&!"".equals(courseScoreInfo.getIdcard())){
//                        SET("idcard=#{idcard}");
//                    }
//                    if(courseScoreInfo.getDepartmentInfo()!=null&&courseScoreInfo.getDepartmentInfo().getId()>0){
//                        SET("dep_id=#{departmentInfo.id}");
//                    }
//                WHERE("sno=#{sno}");
//            }
//        }.toString();
//        return sql;
//    }
//    //根据条件查询未分配宿舍的成绩列表
//    public String allocationCourseScore(CourseScoreInfo courseScoreInfo){
//        String sql=new SQL(){
//            {
//                SELECT("*");
//                FROM("courseScore");
//                if(courseScoreInfo.getSex()!=null&&!"".equals(courseScoreInfo.getSex())){
//                    WHERE("sex=#{sex}");
//                }
//                if(courseScoreInfo.getDepartmentInfo()!=null&&courseScoreInfo.getDepartmentInfo().getId()>0){
//                    WHERE("dep_id=#{departmentInfo.id}");
//                }
//               WHERE("dorm_id is null");
//            }
//        }.toString();
//        return sql;
//    }
//}
