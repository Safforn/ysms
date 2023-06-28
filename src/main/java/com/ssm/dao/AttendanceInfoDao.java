package com.ssm.dao;

import com.ssm.pojo.AnnounceInfo;
import com.ssm.pojo.AttendanceInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


public interface AttendanceInfoDao {

    @Select("select * from attendance where aid=#{aid}")
    AttendanceInfo viewAttendance(AttendanceInfo attendanceInfo);

    @Insert("insert into attendance(aid,cname,time) values(#{aid},#{cname},#{time})")
    int addAttendance(AttendanceInfo attendanceInfo);

}
