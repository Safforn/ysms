package com.ssm.dao;

import com.ssm.dao.provider.AskForLeaveInfoDynaSqlProvider;
import com.ssm.pojo.AskForLeaveInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

public interface AskForLeaveInfoDao {

    //根据条件查询请假总数
    //    @Select("select count(*) from askForLeave")
    @SelectProvider(type = AskForLeaveInfoDynaSqlProvider.class,method ="count")
    Integer count(Map<String, Object> params);

    //分页获取请假列表
    @Results({@Result(id = true,column = "aid",property = "aid"),
            @Result(column = "sno",property = "sno"),
            @Result(column = "reason",property = "reason"),
            @Result(column = "time",property = "time"),
            @Result(column = "state",property = "state")})
    @SelectProvider(type = AskForLeaveInfoDynaSqlProvider.class,method="selectWithParam")
    List<AskForLeaveInfo> selectByPage(Map<String,Object> params);

    //添加请假
    @Insert("insert into ask_for_leave(aid,sno,reason,time,state) values(#{aid},#{studentInfo.sno},#{reason},#{time},#{state})")
    int addAskForLeave(AskForLeaveInfo askForLeaveInfo);

    //获取所有请假列表
    @Results({@Result(id = true,column = "aid",property = "aid"),
            @Result(column = "sno",property = "sno"),
            @Result(column = "reason",property = "reason"),
            @Result(column = "time",property = "time"),
            @Result(column = "state",property = "state")})
    @Select("select * from ask_for_leave")
    List<AskForLeaveInfo> getAllAskForLeave();


    @Results({@Result(id = true,column = "aid",property = "aid"),
            @Result(column = "sno",property = "sno"),
            @Result(column = "reason",property = "reason"),
            @Result(column = "time",property = "time"),
            @Result(column = "state",property = "state")})
    @Select("select * from ask_for_leave where aid=#{aid}")
    AskForLeaveInfo getAskForLeave(AskForLeaveInfo askForLeaveInfo);

}
