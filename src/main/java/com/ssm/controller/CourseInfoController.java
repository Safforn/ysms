package com.ssm.controller;

import com.ssm.pojo.*;
import com.ssm.service.CourseInfoService;
import com.ssm.service.DepartmentInfoService;
import com.ssm.service.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/course")
public class CourseInfoController {
    @Autowired
    CourseInfoService courseInfoService;
    @Autowired
    TeacherInfoService teacherInfoService;
    @Autowired
    DepartmentInfoService departmentInfoService;

    //分页显示学生列表
    @RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> list(Integer page, Integer rows, CourseInfo courseInfo) throws Exception{
//        System.out.println(studentInfo);
        //初始化分页类对象
        Pager pager=new Pager();
        pager.setCurPage(page);
        pager.setPerPageRows(rows);
        //创建params对象，封装查询条件
        Map<String,Object> params=new HashMap<>();
        params.put("courseInfo",courseInfo);
        //获取满足条件的学生总数
        int totalCount=courseInfoService.count(params);

        //获取满足条件的商品列表
        List<CourseInfo> courseInfos=courseInfoService.findCourseInfo(courseInfo,pager);
        System.out.println("totalCount="+totalCount+"\n即将输出courseInfos");
        for(CourseInfo courseInfo1:courseInfos){
            System.out.println(courseInfo1);
        }
        //创建result对象,保存查询结果数据
        Map<String,Object> result=new HashMap<>(2);
        result.put("total",totalCount);
        result.put("rows",courseInfos);
        return result;
    }

    //添加课程
    @RequestMapping(value = "/addCourse",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String addCourse(CourseInfo courseInfo){
        try{
            System.out.println(courseInfo.toString());
            int count=courseInfoService.addCourse(courseInfo);
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
    //删除课程
    @RequestMapping(value = "/deleteCourse",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String deleteCourse(String cid){
        try{
            int count=courseInfoService.deleteCourse(cid);
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

    //更新课程
    @RequestMapping(value = "/updateCourse",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String updateCourse(CourseInfo courseInfo){
        try{
            int count=courseInfoService.updateCourse(courseInfo);
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

    //动态加载院系类别列表
    @RequestMapping(value = "/getCourse",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> getCourse(HttpServletResponse res, HttpServletRequest req)throws Exception{
        //获取类别
        List<CourseInfo> courseInfos=courseInfoService.getAll();
//        for(CourseInfo courseInfo:courseInfos){
//            System.out.println(courseInfo);
//        }
        int count=0;
        if(courseInfos!=null&&courseInfos.size()>0){
            count=courseInfos.size();
        }
        //创建对象result,保存返回结果
        Map<String,Object> result=new HashMap<>(2);
        result.put("count",count);
        result.put("CourseType",courseInfos);
        return result;
    }

}
