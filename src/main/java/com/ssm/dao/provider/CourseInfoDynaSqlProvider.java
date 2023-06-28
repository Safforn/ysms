package com.ssm.dao.provider;

import com.ssm.pojo.CourseInfo;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class CourseInfoDynaSqlProvider {
    //根据条件查询学生总数
    public String count(Map<String,Object> params){
        return new SQL(){
            {
                SELECT("count(*)");
                FROM("course");
                if(params.get("courseInfo")!=null){
                    CourseInfo courseInfo=(CourseInfo)params.get("courseInfo");
                    if(courseInfo.getCid()!=null&&!"".equals(courseInfo.getCid())){
                        WHERE("cid=#{courseInfo.cid}");
                    }
                    if(courseInfo.getCname()!=null&&!"".equals(courseInfo.getCname())){
                        WHERE("cname like CONCAT('%',#{courseInfo.cname},'%')");
                    }
                    if(courseInfo.getTime()!=null&&!"".equals(courseInfo.getTime())){
                        WHERE("time=#{courseInfo.time}");
                    }
                    if(courseInfo.getLocation()!=null&&!"".equals(courseInfo.getLocation())){
                        WHERE("location=#{courseInfo.location}");
                    }
                    if(courseInfo.getAllNumber()!=null&&!"".equals(courseInfo.getAllNumber())){
                        WHERE("allNumber=#{courseInfo.allNumber}");
                    }
                    if(courseInfo.getTeacherInfo()!=null&&!"".equals(courseInfo.getTeacherInfo().getTno())&&!"0".equals(courseInfo.getTeacherInfo().getTno())){
                        WHERE("tno=#{courseInfo.teacherInfo.tno}");
                    }
                    if(courseInfo.getDepartmentInfo()!=null&&courseInfo.getDepartmentInfo().getId()>0){
                        WHERE("dep_id=#{courseInfo.departmentInfo.id}");
                    }
                }
            }
        }.toString();
    }

    //根据条件查询课程列表
    public String selectWithParam(Map<String,Object> params){
        String sql=new SQL(){
            {
                SELECT("*");
                FROM("course");
                if(params.get("courseInfo")!=null){
                    CourseInfo courseInfo=(CourseInfo)params.get("courseInfo");
                    if(courseInfo.getCid()!=null&&!"".equals(courseInfo.getCid())){
                        WHERE("cid=#{courseInfo.cid}");
                    }
                    if(courseInfo.getCname()!=null&&!"".equals(courseInfo.getCname())){
                        WHERE("cname like CONCAT('%',#{courseInfo.cname},'%')");
                    }
                    if(courseInfo.getTime()!=null&&!"".equals(courseInfo.getTime())&&!"请选择".equals(courseInfo.getTime())){
                        WHERE("time=#{courseInfo.time}");
                    }
                    if(courseInfo.getLocation()!=null&&!"".equals(courseInfo.getLocation())&&!"请选择".equals(courseInfo.getLocation())){
                        WHERE("location=#{courseInfo.location}");
                    }
                    if(courseInfo.getAllNumber()!=null&&!"".equals(courseInfo.getAllNumber())){
                        WHERE("allNumber=#{courseInfo.allNumber}");
                    }
                    if(courseInfo.getTeacherInfo()!=null&&!"".equals(courseInfo.getTeacherInfo().getTno())&&!"0".equals(courseInfo.getTeacherInfo().getTno())){
                        WHERE("tno=#{courseInfo.teacherInfo.tno}");
                    }
                    if(courseInfo.getDepartmentInfo()!=null&&courseInfo.getDepartmentInfo().getId()>0){
                        WHERE("dep_id=#{courseInfo.departmentInfo.id}");
                    }
                }
            }
        }.toString();
        if(params.get("pager")!=null){
            sql+=" limit #{pager.firstLimitParam},#{pager.perPageRows}";
        }
        return sql;
    }
    public String updateWithParam(CourseInfo courseInfo){
        String sql=new SQL(){
            {
                UPDATE("course");
                if(courseInfo.getCname()!=null&&!"".equals(courseInfo.getCname())){
                    SET("cname=#{cname}");
                }
                if(courseInfo.getTime()!=null&&!"请选择".equals(courseInfo.getTime())&&!"".equals(courseInfo.getTime())){
                    SET("time=#{time}");
                }
                if(courseInfo.getLocation()!=null&&!"".equals(courseInfo.getLocation())&&!"请选择".equals(courseInfo.getLocation())){
                    SET("location=#{location}");
                }
                if(courseInfo.getAllNumber()!=null&&!"".equals(courseInfo.getAllNumber())){
                    SET("allNumber=#{allNumber}");
                }
                if(courseInfo.getTeacherInfo()!=null&&!"0".equals(courseInfo.getTeacherInfo().getTno())&&!"".equals(courseInfo.getTeacherInfo().getTno())){
                    SET("tno=#{teacherInfo.tno}");
                }
                if(courseInfo.getDepartmentInfo()!=null&&courseInfo.getDepartmentInfo().getId()>0){
                    SET("dep_id=#{departmentInfo.id}");
                }
                WHERE("cid=#{cid}");
            }
        }.toString();
        return sql;
    }

}
