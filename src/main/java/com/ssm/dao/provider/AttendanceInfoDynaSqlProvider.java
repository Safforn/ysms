package com.ssm.dao.provider;

import com.ssm.pojo.AttendanceInfo;
import com.ssm.pojo.CourseScoreInfo;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class AttendanceInfoDynaSqlProvider {

    //根据条件查询成绩总数
    public String count(Map<String,Object> params){

        return new SQL(){
            {
                SELECT("count(*)");
                FROM("attendance");
                if(params.get("attendanceInfo")!=null){
                    AttendanceInfo attendanceInfo=(AttendanceInfo)params.get("attendanceInfo");
                    if(attendanceInfo.getAid()!=null&&!"".equals(attendanceInfo.getAid())){
                        WHERE("aid=#{attendanceInfo.aid}");
                    }
                    if(attendanceInfo.getStudentInfo()!=null&&!"0".equals(attendanceInfo.getStudentInfo().getSno())){
                        WHERE("sno=#{attendanceInfo.studentInfo.sno}");
                    }
                    if(attendanceInfo.getCname()!=null&&!"".equals(attendanceInfo.getCname())){
                        WHERE("cname=#{attendanceInfo.cname}");
                    }
                    if(attendanceInfo.getTime()!=null&&!"".equals(attendanceInfo.getTime())){
                        WHERE("time=#{attendanceInfo.time}");
                    }
                }
            }
        }.toString();
    }

    //根据条件查询考勤列表
    public String selectWithParam(Map<String,Object> params){
        String sql=new SQL(){
            {
                SELECT("*");
                FROM("attendance");
                if(params.get("attendanceInfo")!=null){
                    AttendanceInfo attendanceInfo=(AttendanceInfo)params.get("attendanceInfo");
                    if(attendanceInfo.getAid()!=null&&!"".equals(attendanceInfo.getAid())){
                        WHERE("aid=#{attendanceInfo.aid}");
                    }
                    if(attendanceInfo.getStudentInfo()!=null&&!"0".equals(attendanceInfo.getStudentInfo().getSno())){
                        WHERE("sno=#{attendanceInfo.studentInfo.sno}");
                    }
                    if(attendanceInfo.getCname()!=null&&!"".equals(attendanceInfo.getCname())){
                        WHERE("cname=#{attendanceInfo.cname}");
                    }
                    if(attendanceInfo.getTime()!=null&&!"".equals(attendanceInfo.getTime())){
                        WHERE("time=#{attendanceInfo.time}");
                    }
                }
            }
        }.toString();
        if(params.get("pager")!=null){
            sql+=" limit #{pager.firstLimitParam},#{pager.perPageRows}";
        }
        return sql;
    }

}
