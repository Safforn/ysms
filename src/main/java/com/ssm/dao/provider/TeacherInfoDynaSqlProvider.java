package com.ssm.dao.provider;

import com.ssm.pojo.StudentInfo;
import com.ssm.pojo.TeacherInfo;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class TeacherInfoDynaSqlProvider {
    //根据条件查询学生总数
    public String count(Map<String,Object> params){
        return new SQL(){
            {
                SELECT("count(*)");
                FROM("teacher");
                if(params.get("teacherInfo")!=null){
                    TeacherInfo teacherInfo=(TeacherInfo)params.get("teacherInfo");
                    if(teacherInfo.getTno()!=null&&!"".equals(teacherInfo.getTno())){
                        WHERE("tno=#{teacherInfo.tno}");
                    }
                    if(teacherInfo.getTname()!=null&&!"".equals(teacherInfo.getTname())){
                        WHERE("tname like CONCAT('%',#{teacherInfo.tname},'%')");
                    }
                    if(teacherInfo.getSex()!=null&&!"".equals(teacherInfo.getSex())&&!"请选择".equals(teacherInfo.getSex())){
                        WHERE("sex=#{teacherInfo.sex}");
                    }
                }
            }
        }.toString();
    }

    //根据条件查询学生列表
    public String selectWithParam(Map<String,Object> params){
        String sql=new SQL(){
            {
                SELECT("*");
                FROM("teacher");
                if(params.get("teacherInfo")!=null){
                    TeacherInfo teacherInfo=(TeacherInfo)params.get("teacherInfo");
                    if(teacherInfo.getTno()!=null&&!"".equals(teacherInfo.getTno())){
                        WHERE("tno=#{teacherInfo.tno}");
                    }
                    if(teacherInfo.getTname()!=null&&!"".equals(teacherInfo.getTname())){
                        WHERE("tname like CONCAT('%',#{teacherInfo.tname},'%')");
                    }
                    if(teacherInfo.getSex()!=null&&!"".equals(teacherInfo.getSex())&&!"请选择".equals(teacherInfo.getSex())){
                        WHERE("sex=#{teacherInfo.sex}");
                    }
                }
            }
        }.toString();
        if(params.get("pager")!=null){
            sql+=" limit #{pager.firstLimitParam},#{pager.perPageRows}";
        }
        return sql;
    }
    public String updateWithParam(TeacherInfo teacherInfo){
        String sql=new SQL(){
            {
                UPDATE("teacher");
                if(teacherInfo.getTname()!=null&&!"".equals(teacherInfo.getTname())){
                    SET("tname=#{tname}");
                }
                if(teacherInfo.getPassword()!=null&&!"".equals(teacherInfo.getPassword())){
                    SET("password=#{password}");
                }
                if(teacherInfo.getSex()!=null&&!"请选择".equals(teacherInfo.getSex())&&!"".equals(teacherInfo.getSex())){
                    SET("sex=#{sex}");
                }
                if(teacherInfo.getPhone()!=null&&!"".equals(teacherInfo.getPhone())){
                    SET("phone=#{phone}");
                }
                if(teacherInfo.getEmail()!=null&&!"".equals(teacherInfo.getEmail())){
                    SET("email=#{email}");
                }
                if(teacherInfo.getAddress()!=null&&!"".equals(teacherInfo.getAddress())){
                    SET("address=#{address}");
                }
                if(teacherInfo.getIdcard()!=null&&!"".equals(teacherInfo.getIdcard())){
                    SET("idcard=#{idcard}");
                }
                WHERE("tno=#{tno}");
            }
        }.toString();
        return sql;
    }
    //根据条件查询未分配宿舍的学生列表
    public String allocationTeacher(TeacherInfo teacherInfo){
        String sql=new SQL(){
            {
                SELECT("*");
                FROM("teacher");
                if(teacherInfo.getSex()!=null&&!"".equals(teacherInfo.getSex())){
                    WHERE("sex=#{sex}");
                }
                WHERE("dorm_id is null");
            }
        }.toString();
        return sql;
    }
}
