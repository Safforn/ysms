package com.ssm.service;

import com.ssm.pojo.Pager;
import com.ssm.pojo.AskForLeaveInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AskForLeaveInfoService {
    //获取满足条件的请假总数
    int count(Map<String,Object> params);
    //获取满足条件的请假列表
    List<AskForLeaveInfo> findAskForLeaveInfo(AskForLeaveInfo askForLeaveInfo, Pager pager);
    //添加请假
    int addAskForLeave(AskForLeaveInfo askForLeaveInfo);

    //查看所有请假列表
    List<AskForLeaveInfo> getAllAskForLeave();

}
