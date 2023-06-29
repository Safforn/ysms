package com.ssm.dao;

import com.ssm.dao.provider.AnnounceInfoDynaSqlProvider;
import com.ssm.pojo.AnnounceInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


public interface AnnounceInfoDao {

    //根据条件查询公告总数
    @SelectProvider(type = AnnounceInfoDynaSqlProvider.class,method ="count")
    Integer count(Map<String, Object> params);

    @Select("select * from announcement where aid=#{aid}")
    AnnounceInfo viewAnnouncement(AnnounceInfo announceInfo);

    @Insert("insert into announcement(aid,title,text,time) values(#{aid},#{title},#{text},#{time})")
    int addAnnouncement(AnnounceInfo announceInfo);

    //分页获取公告列表
    @Results({@Result(id = true,column = "aid",property = "aid"),
            @Result(column = "title",property = "title"),
            @Result(column = "text",property = "text"),
            @Result(column = "time",property = "time")
    })
    @SelectProvider(type = AnnounceInfoDynaSqlProvider.class,method="selectWithParam")
    List<AnnounceInfo> selectByPage(Map<String,Object> params);

}
