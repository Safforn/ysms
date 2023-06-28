package com.ssm.controller;

import com.ssm.pojo.AttendanceInfo;
import com.ssm.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
