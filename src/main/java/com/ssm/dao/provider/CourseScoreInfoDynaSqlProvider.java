package com.ssm.dao.provider;

import com.ssm.pojo.CourseScoreInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class CourseScoreInfoDynaSqlProvider {

    //根据条件查询成绩总数
    public String count(Map<String,Object> params){
        return new SQL(){
            {
                SELECT("count(*)");
                FROM("courseScore");
                if(params.get("courseScoreInfo")!=null){
                    CourseScoreInfo courseScoreInfo=(CourseScoreInfo)params.get("courseScoreInfo");
                    if(courseScoreInfo.getSid()!=null&&!"".equals(courseScoreInfo.getSid())){
                        WHERE("sid=#{courseScoreInfo.sid}");
                    }
                    if(courseScoreInfo.getStudentInfo()!=null&&!"0".equals(courseScoreInfo.getStudentInfo().getSno())){
                        WHERE("sno=#{courseScoreInfo.studentInfo.sno}");
                    }
                    if(courseScoreInfo.getCourseInfo()!=null&&!"".equals(courseScoreInfo.getCourseInfo().getCid())&&!"0".equals(courseScoreInfo.getCourseInfo().getCid())){
                        WHERE("cid=#{courseScoreInfo.courseInfo.cid}");
                    }
                    if(courseScoreInfo.getCredit()!=null&&!"".equals(courseScoreInfo.getCredit())){
                        WHERE("credit=#{courseScoreInfo.credit}");
                    }
                    if(courseScoreInfo.getScore()!=null&&!"".equals(courseScoreInfo.getScore())){
                        WHERE("score=#{courseScoreInfo.score}");
                    }
                }
            }
        }.toString();
    }

    //根据条件查询成绩列表
    public String selectWithParam(Map<String,Object> params){
        String sql=new SQL(){
            {
                SELECT("*");
                FROM("courseScore");
                if(params.get("courseScoreInfo")!=null){
                    CourseScoreInfo courseScoreInfo=(CourseScoreInfo)params.get("courseScoreInfo");
                    if(courseScoreInfo.getSid()!=null&&!"".equals(courseScoreInfo.getSid())){
                        WHERE("sid=#{courseScoreInfo.sid}");
                    }
                    if(courseScoreInfo.getStudentInfo()!=null&&!"0".equals(courseScoreInfo.getStudentInfo().getSno())){
                        WHERE("sno=#{courseScoreInfo.studentInfo.sno}");
                    }
                    if(courseScoreInfo.getCourseInfo()!=null&&!"".equals(courseScoreInfo.getCourseInfo().getCid())&&!"0".equals(courseScoreInfo.getCourseInfo().getCid())){
                        WHERE("cid=#{courseScoreInfo.courseInfo.cid}");
                    }
                    if(courseScoreInfo.getCredit()!=null&&!"".equals(courseScoreInfo.getCredit())){
                        WHERE("credit=#{courseScoreInfo.credit}");
                    }
                    if(courseScoreInfo.getScore()!=null&&!"".equals(courseScoreInfo.getScore())){
                        WHERE("score=#{courseScoreInfo.score}");
                    }
                }
            }
        }.toString();
        if(params.get("pager")!=null){
            sql+=" limit #{pager.firstLimitParam},#{pager.perPageRows}";
        }
        return sql;
    }
    public String updateWithParam(CourseScoreInfo courseScoreInfo){
        String sql=new SQL(){
            {
                UPDATE("courseScore");
                if(courseScoreInfo.getStudentInfo()!=null&&!"0".equals(courseScoreInfo.getStudentInfo().getSno())){
                    SET("sno=#{studentInfo.sno}");
                }
                if(courseScoreInfo.getCourseInfo()!=null&&!"".equals(courseScoreInfo.getCourseInfo().getCid())&&!"0".equals(courseScoreInfo.getCourseInfo().getCid())){
                    SET("cid=#{courseInfo.cid}");
                }
                if(courseScoreInfo.getCredit()!=null&&!"".equals(courseScoreInfo.getCredit())){
                    SET("credit=#{credit}");
                }
                if(courseScoreInfo.getScore()!=null&&!"".equals(courseScoreInfo.getScore())){
                    SET("score=#{score}");
                }
                WHERE("sid=#{sid}");
            }
        }.toString();
        return sql;
    }

    public String selectScore(CourseScoreInfo courseScoreInfo) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM("courseScore");
                if (courseScoreInfo != null) {
                    if(courseScoreInfo.getSid()!=null&&!"".equals(courseScoreInfo.getSid())){
                        WHERE("sid=#{courseScoreInfo.sid}");
                    }
                    if(courseScoreInfo.getStudentInfo()!=null&&!"0".equals(courseScoreInfo.getStudentInfo().getSno())){
                        WHERE("sno=#{courseScoreInfo.studentInfo.sno}");
                    }
                    if(courseScoreInfo.getCourseInfo()!=null&&!"".equals(courseScoreInfo.getCourseInfo().getCid())&&!"0".equals(courseScoreInfo.getCourseInfo().getCid())){
                        WHERE("cid=#{courseScoreInfo.courseInfo.cid}");
                    }
                    if(courseScoreInfo.getCredit()!=null&&!"".equals(courseScoreInfo.getCredit())){
                        WHERE("credit=#{courseScoreInfo.credit}");
                    }
                    if(courseScoreInfo.getScore()!=null&&!"".equals(courseScoreInfo.getScore())){
                        WHERE("score=#{courseScoreInfo.score}");
                    }
                }

            }
        }.toString();
        return sql;
    }

}
