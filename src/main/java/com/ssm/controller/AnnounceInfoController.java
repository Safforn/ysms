package com.ssm.controller;

import com.ssm.pojo.AdminInfo;
import com.ssm.pojo.AnnounceInfo;
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

@Controller
@RequestMapping("/announce")
public class AnnounceInfoController {

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
}
