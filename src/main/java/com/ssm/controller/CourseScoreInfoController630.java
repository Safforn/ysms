package com.ssm.controller;

import com.ssm.pojo.*;
import com.ssm.service.DepartmentInfoService;
import com.ssm.service.DormInfoService;
import com.ssm.service.CourseScoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/courseScore")
public class CourseScoreInfoController630 {
    @Autowired
    CourseScoreInfoService courseScoreInfoService;
    @Autowired
    DormInfoService dormInfoService;
    @Autowired
    DepartmentInfoService departmentInfoService;


    //分页显示成绩列表
    @RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> list(Integer page, Integer rows, CourseScoreInfo courseScoreInfo, HttpServletRequest req) throws Exception{
//        System.out.println(courseScoreInfo);
        //初始化分页类对象
        Pager pager=new Pager();
        pager.setCurPage(page);
        pager.setPerPageRows(rows);
        //创建params对象，封装查询条件
        Map<String,Object> params=new HashMap<>();
        params.put("courseScoreInfo",courseScoreInfo);
        //获取满足条件的成绩总数
        int totalCount=courseScoreInfoService.count(params);
        //获取满足条件的成绩列表
        List<CourseScoreInfo> courseScoreInfos=courseScoreInfoService.findCourseScoreInfo(courseScoreInfo,pager);
        //创建result对象,保存查询结果数据
        Map<String,Object> result=new HashMap<>(2);
        result.put("total",totalCount);
        result.put("rows",courseScoreInfos);
        return result;
    }

    //分页显示成绩列表
    @RequestMapping(value = "/viewList",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> viewList(Integer page, Integer rows, CourseScoreInfo courseScoreInfo, HttpServletRequest req) throws Exception{
        //初始化分页类对象
        Pager pager=new Pager();
        pager.setCurPage(page);
        pager.setPerPageRows(rows);
        //获取当前登录信息
        StudentInfo loginer= (StudentInfo)req.getSession().getAttribute("STUDENT");
        courseScoreInfo.setStudentInfo(loginer);
        System.out.println("搜索条件："+courseScoreInfo+"\n");
        List<CourseScoreInfo> tnoCSInfos = courseScoreInfoService.selectBySno(courseScoreInfo);

        for (CourseScoreInfo csi : tnoCSInfos) {
            System.out.println(csi.toString()+"\n");
        }
        int totalCount = 0;
        List<CourseScoreInfo> courseScoreInfos = new ArrayList<>();
        for (CourseScoreInfo csi : tnoCSInfos) {
            //创建params对象，封装查询条件
            Map<String,Object> params=new HashMap<>();
            params.put("courseScoreInfo", csi);
            //获取满足条件的成绩总数
            int tempCount=courseScoreInfoService.count(params);
            totalCount = totalCount + tempCount;
            //获取满足条件的成绩列表
            courseScoreInfos.addAll(courseScoreInfoService.findCourseScoreInfo(csi,pager));
        }
//        System.out.println("totalCount="+totalCount+"|courseScoreInfos=\n"+courseScoreInfos.toString());
        //创建result对象,保存查询结果数据
        Map<String,Object> result=new HashMap<>(2);
        result.put("total",totalCount);
        result.put("rows",courseScoreInfos);
        return result;
    }


    //添加成绩
    @RequestMapping(value = "/addCourseScore",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String addCourseScore(CourseScoreInfo courseScoreInfo){
        try{
            int count=courseScoreInfoService.addCourseScore(courseScoreInfo);
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
    //删除成绩
    @RequestMapping(value = "/deleteCourseScore",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String deleteCourseScore(String sno){
        try{
            int count=courseScoreInfoService.deleteCourseScore(sno);
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

    //更新成绩
    @RequestMapping(value = "/updateCourseScore",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String updateCourseScore(CourseScoreInfo courseScoreInfo){
        try{
            int count=courseScoreInfoService.updateCourseScore(courseScoreInfo);
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

}
