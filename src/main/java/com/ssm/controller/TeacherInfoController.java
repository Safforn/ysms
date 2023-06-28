package com.ssm.controller;

import com.ssm.pojo.DepartmentInfo;
import com.ssm.pojo.DormInfo;
import com.ssm.pojo.Pager;
import com.ssm.pojo.TeacherInfo;
import com.ssm.service.DepartmentInfoService;
import com.ssm.service.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class TeacherInfoController {
    @Autowired
    TeacherInfoService teacherInfoService;

    @Autowired
    DepartmentInfoService departmentInfoService;

    //动态加载院系类别列表
    @RequestMapping(value = "/getTno",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> getTno(HttpServletResponse res, HttpServletRequest req)throws Exception{
        //获取类别
        List<TeacherInfo> teacherInfos=teacherInfoService.getAll();
//        System.out.println("teacherInfoService.getAll()");
//        for(TeacherInfo teacherInfo:teacherInfos){
//            System.out.println(teacherInfo);
//        }
        int count=0;
        if(teacherInfos!=null&&teacherInfos.size()>0){
            count=teacherInfos.size();
        }
        //创建对象result,保存返回结果
        Map<String, Object> result=new HashMap<>(2);
        result.put("count",count);
        result.put("teacherInfoType",teacherInfos);

//        System.out.println("getTno Result");
//        for (Map.Entry<String, Object> entry : result.entrySet()) {
//            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
//        }
        return result;
    }


    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String login(TeacherInfo tch, HttpServletRequest req){
//        System.out.println(stu);
        TeacherInfo teacherInfo=teacherInfoService.login(tch);
//        System.out.println(teacherInfo);
        if(teacherInfo!=null){
            req.getSession().setAttribute("STUDENT",teacherInfo);
            return "{\"success\":\"true\"}";
        }else{
            return "{\"success\":\"false\"}";
        }
    }

    //分页显示老师列表
    @RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> list(Integer page, Integer rows, TeacherInfo teacherInfo) throws Exception{
//        System.out.println(teacherInfo);
        //初始化分页类对象
        Pager pager=new Pager();
        pager.setCurPage(page);
        pager.setPerPageRows(rows);
        //创建params对象，封装查询条件
        Map<String,Object> params=new HashMap<>();
        params.put("teacherInfo",teacherInfo);
        //获取满足条件的老师总数
        int totalCount=teacherInfoService.count(params);

        //获取满足条件的商品列表
        List<TeacherInfo> teacherInfos=teacherInfoService.findTeacherInfo(teacherInfo,pager);
//        for(TeacherInfo teacherInfo1:teacherInfos){
//            System.out.println(teacherInfo1);
//        }
        //创建result对象,保存查询结果数据
        Map<String,Object> result=new HashMap<>(2);
        result.put("total",totalCount);
        result.put("rows",teacherInfos);
        return result;
    }

    //添加老师
    @RequestMapping(value = "/addTeacher",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String addTeacher(TeacherInfo teacherInfo){
        try{
            teacherInfo.setPassword("000");
            int count=teacherInfoService.addTeacher(teacherInfo);
            if(count>0){
                return "{\"success\":\"true\"}";
            }else{
                return "{\"success\":\"false\"}";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //删除老师
    @RequestMapping(value = "/deleteTeacher",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String deleteTeacher(String tno){
        try{
            int count=teacherInfoService.deleteTeacher(tno);
            if(count>0){
                return "{\"success\":\"true\"}";
            }else{
                return "{\"success\":\"false\"}";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //更新老师
    @RequestMapping(value = "/updateTeacher",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String updateTeacher(TeacherInfo teacherInfo){
        try{
            int count=teacherInfoService.updateTeacher(teacherInfo);
            if(count>0){
                return "{\"success\":\"true\"}";
            }else{
                return "{\"success\":\"false\"}";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //退出登录
    @RequestMapping(value = "/loginOut",method = {RequestMethod.GET,RequestMethod.POST})
    public String loginOut(HttpServletRequest req){
        req.getSession().invalidate();//清除session对象中的所有信息
        return "redirect:/login.jsp";
    }

    //老师修改密码
    @RequestMapping(value = "/changePassword",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String changePassword(TeacherInfo teacherInfo,HttpServletRequest req){
        int count=teacherInfoService.changePassword(teacherInfo);
        TeacherInfo teacherInfo1= (TeacherInfo) req.getSession().getAttribute("STUDENT");
        teacherInfo1.setTname(teacherInfo.getTname());
        teacherInfo1.setPassword(teacherInfo.getPassword());
        req.getSession().setAttribute("STUDENT",teacherInfo1);
        if(count>0){
            return "{\"message\":\"true\"}";
        }else{
            return "{\"message\":\"false\"}";
        }
    }
}
