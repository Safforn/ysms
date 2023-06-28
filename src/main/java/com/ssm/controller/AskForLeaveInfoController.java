//package com.ssm.controller;
//
//import com.ssm.pojo.DepartmentInfo;
//import com.ssm.pojo.DormInfo;
//import com.ssm.pojo.Pager;
//import com.ssm.pojo.AskForLeaveInfo;
//import com.ssm.service.DepartmentInfoService;
//import com.ssm.service.DormInfoService;
//import com.ssm.service.AskForLeaveInfoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@RequestMapping("/askForLeave")
//public class AskForLeaveInfoController {
//    @Autowired
//    AskForLeaveInfoService askForLeaveInfoService;
//    @Autowired
//    DormInfoService dormInfoService;
//    @Autowired
//    DepartmentInfoService departmentInfoService;
//
//    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
//    @ResponseBody
//    public String login(AskForLeaveInfo stu, HttpServletRequest req){
////        System.out.println(stu);
//        AskForLeaveInfo askForLeaveInfo=askForLeaveInfoService.login(stu);
////        System.out.println(askForLeaveInfo);
//        if(askForLeaveInfo!=null){
//            req.getSession().setAttribute("STUDENT",askForLeaveInfo);
//            return "{\"success\":\"true\"}";
//        }else{
//            return "{\"success\":\"false\"}";
//        }
//    }
//
//    //分页显示请假列表
//    @RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
//    @ResponseBody
//    public Map<String,Object> list(Integer page, Integer rows, AskForLeaveInfo askForLeaveInfo) throws Exception{
////        System.out.println(askForLeaveInfo);
//        //初始化分页类对象
//        Pager pager=new Pager();
//        pager.setCurPage(page);
//        pager.setPerPageRows(rows);
//        //创建params对象，封装查询条件
//        Map<String,Object> params=new HashMap<>();
//        params.put("askForLeaveInfo",askForLeaveInfo);
//        //获取满足条件的请假总数
//        int totalCount=askForLeaveInfoService.count(params);
//
//        //获取满足条件的请假列表
//        List<AskForLeaveInfo> askForLeaveInfos=askForLeaveInfoService.findAskForLeaveInfo(askForLeaveInfo,pager);
////        for(AskForLeaveInfo askForLeaveInfo1:askForLeaveInfos){
////            System.out.println(askForLeaveInfo1);
////        }
//        //创建result对象,保存查询结果数据
//        Map<String,Object> result=new HashMap<>(2);
//        result.put("total",totalCount);
//        result.put("rows",askForLeaveInfos);
//        return result;
//    }
//
//    //添加请假
//    @RequestMapping(value = "/addAskForLeave",method = {RequestMethod.GET,RequestMethod.POST})
//    @ResponseBody
//    public String addAskForLeave(AskForLeaveInfo askForLeaveInfo){
//        try{
//            askForLeaveInfo.setPassword("111");
//            int count=askForLeaveInfoService.addAskForLeave(askForLeaveInfo);
//            if(count>0){
//                return "{\"success\":\"true\"}";
//            }else{
//                return "{\"success\":\"false\"}";
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//    //删除请假
//    @RequestMapping(value = "/deleteAskForLeave",method = {RequestMethod.GET,RequestMethod.POST})
//    @ResponseBody
//    public String deleteAskForLeave(String sno){
//        try{
//            int count=askForLeaveInfoService.deleteAskForLeave(sno);
//            if(count>0){
//                return "{\"success\":\"true\"}";
//            }else{
//                return "{\"success\":\"false\"}";
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    //更新请假
//    @RequestMapping(value = "/updateAskForLeave",method = {RequestMethod.GET,RequestMethod.POST})
//    @ResponseBody
//    public String updateAskForLeave(AskForLeaveInfo askForLeaveInfo){
//        try{
//            int count=askForLeaveInfoService.updateAskForLeave(askForLeaveInfo);
//            if(count>0){
//                return "{\"success\":\"true\"}";
//            }else{
//                return "{\"success\":\"false\"}";
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//}
