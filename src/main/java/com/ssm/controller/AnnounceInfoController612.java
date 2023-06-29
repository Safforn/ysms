package com.ssm.controller;

import com.ssm.pojo.AdminInfo;
import com.ssm.pojo.AnnounceInfo;
import com.ssm.pojo.AttendanceInfo;
import com.ssm.pojo.Pager;
import com.ssm.service.AdminService;
import com.ssm.service.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/announce")
public class AnnounceInfoController612 {

    @Autowired
    AnnounceService announceService;

    @RequestMapping(value = "/addAnnouncement",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String addAnnouncement(AnnounceInfo announceInfo){
        System.out.println(announceInfo);
        Integer count=announceService.addAnnouncement(announceInfo);
        if(count>0){
            return "{\"message\":\"true\"}";
        }else{
            return "{\"message\":\"false\"}";
        }
    }

    //分页显示公告列表
    @RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> list(Integer page, Integer rows, AnnounceInfo announceInfo) throws Exception{
        //初始化分页类对象
        Pager pager=new Pager();
        pager.setCurPage(page);
        pager.setPerPageRows(rows);
        //创建params对象，封装查询条件
        Map<String,Object> params=new HashMap<>();
        params.put("announceInfo",announceInfo);
        //获取满足条件的公告总数
        int totalCount=announceService.count(params);
        //获取满足条件的公告列表
        List<AnnounceInfo> announceInfos=announceService.findAnnounceInfo(announceInfo,pager);
        //创建result对象,保存查询结果数据
        Map<String,Object> result=new HashMap<>(2);
        result.put("total",totalCount);
        result.put("rows",announceInfos);
        return result;
    }

}
