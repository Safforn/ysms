package com.ssm.dao;

import com.ssm.dao.provider.AttendanceInfoDynaSqlProvider;
import com.ssm.dao.provider.CourseScoreInfoDynaSqlProvider;
import com.ssm.pojo.AnnounceInfo;
import com.ssm.pojo.AttendanceInfo;
import com.ssm.pojo.CourseScoreInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;


public interface AttendanceInfoDao {

    //根据条件查询考勤总数
    @SelectProvider(type = AttendanceInfoDynaSqlProvider.class,method ="count")
    Integer count(Map<String, Object> params);

    @Select("select * from attendance where aid=#{aid}")
    AttendanceInfo viewAttendance(AttendanceInfo attendanceInfo);

    @Insert("insert into attendance(aid,sno,cname,time) values(#{aid},#{studentInfo.sno},#{cname},#{time})")
    int addAttendance(AttendanceInfo attendanceInfo);

    //分页获取成绩列表
    @Results({@Result(id = true,column = "aid",property = "aid"),
            @Result(column = "sno",property = "studentInfo",
                    one=@One(select = "com.ssm.dao.StudentInfoDao.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "cname",property = "cname"),
            @Result(column = "time",property = "time")
    })
    @SelectProvider(type = AttendanceInfoDynaSqlProvider.class,method="selectWithParam")
    List<AttendanceInfo> selectByPage(Map<String,Object> params);

}
