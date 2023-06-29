package com.ssm.controller;

import com.ssm.pojo.AttendanceInfo;
import com.ssm.pojo.Pager;
import com.ssm.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/attendance")
public class AttendanceInfoController {

    @Autowired
    AttendanceService attendanceService;

    @RequestMapping(value = "/addAttendancement", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String addAttendancement(AttendanceInfo attendanceInfo){
        System.out.println(attendanceInfo);
        Integer count=attendanceService.addAttendance(attendanceInfo);
        System.out.println("attendanceService.addAttendance返回:"+count);
        if(count>0){
            return "{\"message\":\"true\"}";
        }else{
            return "{\"message\":\"false\"}";
        }
    }

    //分页显示成绩列表
    @RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> list(Integer page, Integer rows, AttendanceInfo attendanceInfo) throws Exception{
        //初始化分页类对象
        Pager pager=new Pager();
        pager.setCurPage(page);
        pager.setPerPageRows(rows);
        //创建params对象，封装查询条件
        Map<String,Object> params=new HashMap<>();
        params.put("attendanceInfo",attendanceInfo);
        //获取满足条件的成绩总数
        int totalCount=attendanceService.count(params);
        System.out.println("attendanceService.count -- totalCount="+totalCount);
        //获取满足条件的成绩列表
        List<AttendanceInfo> attendanceInfos=attendanceService.findAttendanceInfo(attendanceInfo,pager);
        System.out.println("$$$ 输出 attendanceService.findAttendanceInfo");
        for (AttendanceInfo ai : attendanceInfos) {
            System.out.println(ai.toString());
        }
        //创建result对象,保存查询结果数据
        Map<String,Object> result=new HashMap<>(2);
        result.put("total",totalCount);
        result.put("rows",attendanceInfos);
        return result;
    }

}
