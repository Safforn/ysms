package com.ssm.dao.provider;

import com.ssm.pojo.AskForLeaveInfo;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class AskForLeaveInfoDynaSqlProvider {

    //根据条件查询请假总数
    public String count(Map<String,Object> params){
        return new SQL(){
            {
                SELECT("count(*)");
                FROM("ask_for_leave");
                if(params.get("askForLeaveInfo")!=null){
                    AskForLeaveInfo askForLeaveInfo=(AskForLeaveInfo)params.get("askForLeaveInfo");
                    if(askForLeaveInfo.getAid()!=null&&!"".equals(askForLeaveInfo.getAid())){
                        WHERE("aid=#{askForLeaveInfo.aid}");
                    }
                    if(askForLeaveInfo.getStudentInfo().getSno()!=null&&!"".equals(askForLeaveInfo.getStudentInfo().getSno())){
                        WHERE("sno=#{askForLeaveInfo.studentInfo.sno}");
                    }
                    if(askForLeaveInfo.getReason()!=null&&!"".equals(askForLeaveInfo.getReason())){
                        WHERE("reason=#{askForLeaveInfo.reason}");
                    }
                    if(askForLeaveInfo.getTime()!=null&&!"".equals(askForLeaveInfo.getTime())){
                        WHERE("time=#{askForLeaveInfo.time}");
                    }
                    if(askForLeaveInfo.getState()!=null&&!"".equals(askForLeaveInfo.getState())){
                        WHERE("state=#{askForLeaveInfo.state}");
                    }
                }
            }
        }.toString();
    }

    //根据条件查询请假列表
    public String selectWithParam(Map<String,Object> params){
        String sql=new SQL(){
            {
                SELECT("*");
                FROM("ask_for_leave");
                if(params.get("askForLeaveInfo")!=null){
                    AskForLeaveInfo askForLeaveInfo=(AskForLeaveInfo)params.get("askForLeaveInfo");
                    if(askForLeaveInfo.getAid()!=null&&!"".equals(askForLeaveInfo.getAid())){
                        WHERE("aid=#{askForLeaveInfo.aid}");
                    }
                    if(askForLeaveInfo.getStudentInfo().getSno()!=null&&!"".equals(askForLeaveInfo.getStudentInfo().getSno())){
                        WHERE("sno=#{askForLeaveInfo.studentInfo.sno}");
                    }
                    if(askForLeaveInfo.getReason()!=null&&!"".equals(askForLeaveInfo.getReason())){
                        WHERE("reason=#{askForLeaveInfo.reason}");
                    }
                    if(askForLeaveInfo.getTime()!=null&&!"".equals(askForLeaveInfo.getTime())){
                        WHERE("time=#{askForLeaveInfo.time}");
                    }
                    if(askForLeaveInfo.getState()!=null&&!"".equals(askForLeaveInfo.getState())){
                        WHERE("state=#{askForLeaveInfo.state}");
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
