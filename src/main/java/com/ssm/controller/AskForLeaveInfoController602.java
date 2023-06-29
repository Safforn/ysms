package com.ssm.controller;


import com.ssm.pojo.Pager;
import com.ssm.pojo.AskForLeaveInfo;
import com.ssm.service.AskForLeaveInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/askForLeave")
public class AskForLeaveInfoController602 {
    @Autowired
    AskForLeaveInfoService askForLeaveInfoService;

    @RequestMapping(value = "/addAskForLeave", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String addAskForLeave(AskForLeaveInfo askForLeaveInfo){
        System.out.println(askForLeaveInfo);
        Integer count=askForLeaveInfoService.addAskForLeave(askForLeaveInfo);
        System.out.println("askForLeaveService.addAskForLeave返回:"+count);
        if(count>0){
            return "{\"message\":\"true\"}";
        }else{
            return "{\"message\":\"false\"}";
        }
    }

    //分页显示请假申请列表
    @RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> list(Integer page, Integer rows, AskForLeaveInfo askForLeaveInfo) throws Exception{
        //初始化分页类对象
        System.out.println("_____________________"+askForLeaveInfo.toString());
        Pager pager=new Pager();
        pager.setCurPage(page);
        pager.setPerPageRows(rows);
        //创建params对象，封装查询条件
        Map<String,Object> params=new HashMap<>();
        params.put("askForLeaveInfo",askForLeaveInfo);
        //获取满足条件的请假申请总数
        int totalCount=askForLeaveInfoService.count(params);
        System.out.println("_____________________"+totalCount);
        //获取满足条件的请假申请列表
        List<AskForLeaveInfo> askForLeaveInfos=askForLeaveInfoService.findAskForLeaveInfo(askForLeaveInfo,pager);
        System.out.println("$$$ 输出 askForLeaveService.findAskForLeaveInfo");
        for (AskForLeaveInfo afl : askForLeaveInfos) {
            System.out.println(afl.toString());
        }
        //创建result对象,保存查询结果数据
        Map<String,Object> result=new HashMap<>(2);
        result.put("total",totalCount);
        result.put("rows",askForLeaveInfos);
        return result;
    }

}
