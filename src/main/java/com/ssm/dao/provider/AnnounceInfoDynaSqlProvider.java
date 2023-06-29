package com.ssm.dao.provider;

import com.ssm.pojo.AnnounceInfo;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class AnnounceInfoDynaSqlProvider {

    //根据条件查询公告总数
    public String count(Map<String,Object> params){

        return new SQL(){
            {
                SELECT("count(*)");
                FROM("announcement");
                if(params.get("announceInfo")!=null){
                    AnnounceInfo announceInfo=(AnnounceInfo)params.get("announceInfo");
                    if(announceInfo.getAid()!=null&&!"".equals(announceInfo.getAid())){
                        WHERE("aid=#{announceInfo.aid}");
                    }
                    if(announceInfo.getTitle()!=null&&!"".equals(announceInfo.getTitle())){
                        WHERE("title=#{announceInfo.title}");
                    }
                    if(announceInfo.getText()!=null&&!"".equals(announceInfo.getText())){
                        WHERE("text=#{announceInfo.text}");
                    }
                    if(announceInfo.getTime()!=null&&!"".equals(announceInfo.getTime())){
                        WHERE("time=#{announceInfo.time}");
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
                FROM("announcement");
                if(params.get("announceInfo")!=null){
                    AnnounceInfo announceInfo=(AnnounceInfo)params.get("announceInfo");
                    if(announceInfo.getAid()!=null&&!"".equals(announceInfo.getAid())){
                        WHERE("aid=#{announceInfo.aid}");
                    }
                    if(announceInfo.getTitle()!=null&&!"".equals(announceInfo.getTitle())){
                        WHERE("title=#{announceInfo.title}");
                    }
                    if(announceInfo.getText()!=null&&!"".equals(announceInfo.getText())){
                        WHERE("text=#{announceInfo.text}");
                    }
                    if(announceInfo.getTime()!=null&&!"".equals(announceInfo.getTime())){
                        WHERE("time=#{announceInfo.time}");
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
