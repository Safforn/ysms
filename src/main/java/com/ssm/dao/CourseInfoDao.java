package com.ssm.dao;

import com.ssm.dao.provider.CourseInfoDynaSqlProvider;
import com.ssm.dao.provider.StudentInfoDynaSqlProvider;
import com.ssm.pojo.CourseInfo;
import com.ssm.pojo.StudentInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

public interface CourseInfoDao {

    //根据条件查询学生总数
    //    @Select("select count(*) from course")
    @SelectProvider(type = CourseInfoDynaSqlProvider.class, method ="count")
    Integer count(Map<String, Object> params);

    //分页获取课程列表
    @Results({
            @Result(id = true,column = "cid",property = "cid"),
            @Result(column = "cname",property = "cname"),
            @Result(column = "time",property = "time"),
            @Result(column = "location",property = "location"),
            @Result(column = "allNumber",property = "allNumber"),
            @Result(column = "tno",property = "teacherInfo",
                    one=@One(select = "com.ssm.dao.TeacherInfoDao.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "dep_id",property ="departmentInfo",
                    one = @One(select = "com.ssm.dao.DepartmentInfoDao.selectById", fetchType = FetchType.EAGER))
    })
    @SelectProvider(type = CourseInfoDynaSqlProvider.class, method="selectWithParam")
    List<CourseInfo> selectByPage(Map<String,Object> params);

    //添加课程
    @Insert("insert into course(cid,cname,time,location,allNumber,tno,dep_id) values(#{cid},#{cname},#{time},#{location},#{allNumber},#{teacherInfo.tno},#{departmentInfo.id})")
    int addCourse(CourseInfo courseInfo);

    //删除课程
    @Delete("delete from course where cid in (${cid})")
    int deleteCourse(@Param("cid") String cid);

    //更新课程
    @UpdateProvider(type = CourseInfoDynaSqlProvider.class, method = "updateWithParam")
    int updateCourse(CourseInfo courseInfo);

    //获取所有课程列表
    @Results({@Result(id = true,column = "cid",property = "cid"),
            @Result(column = "cname",property = "cname"),
            @Result(column = "time",property = "time"),
            @Result(column = "location",property = "location"),
            @Result(column = "allNumber",property = "allNumber"),
            @Result(column = "tno",property = "teacherInfo",
                    one=@One(select = "com.ssm.dao.TeacherInfoDao.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "dep_id",property ="departmentInfo",
                    one = @One(select = "com.ssm.dao.DepartmentInfoDao.selectById", fetchType = FetchType.EAGER))
    })
    @Select("select * from course")
    List<CourseInfo> getAllCourse();

    //获取所有课程列表
    @Results({@Result(id = true,column = "cid",property = "cid"),
            @Result(column = "cname",property = "cname"),
            @Result(column = "time",property = "time"),
            @Result(column = "location",property = "location"),
            @Result(column = "allNumber",property = "allNumber"),
            @Result(column = "tno",property = "teacherInfo",
                    one=@One(select = "com.ssm.dao.TeacherInfoDao.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "dep_id",property ="departmentInfo",
                    one = @One(select = "com.ssm.dao.DepartmentInfoDao.selectById", fetchType = FetchType.EAGER))
    })
    @Select("select * from course where cid=#{cid}")
    List<CourseInfo> selectById();

}
