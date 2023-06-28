package com.ssm.dao;

import com.ssm.pojo.AnnounceInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


public interface AnnounceInfoDao {

    @Select("select * from announce where aid=#{aid}")
    AnnounceInfo viewAnnouncement(AnnounceInfo announceInfo);

    @Insert("insert into announce(aid,title,text,time) values(#{aid},#{title},#{text},#{time})")
    int addAnnouncement(AnnounceInfo announceInfo);

}
