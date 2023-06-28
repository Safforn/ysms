package com.ssm.service;

import com.ssm.pojo.CourseInfo;
import com.ssm.pojo.Pager;
import com.ssm.pojo.StudentInfo;

import java.util.List;
import java.util.Map;

public interface CourseInfoService {
    //获取满足条件的学生总数
    int count(Map<String,Object> params);
    //添加学生
    int addCourse(CourseInfo courseInfo);
    //删除学生
    int deleteCourse(String cid);
    //更新学生
    int updateCourse(CourseInfo courseInfo);
    //获取满足条件的学生列表
    List<CourseInfo> findCourseInfo(CourseInfo courseInfo, Pager pager);
    //获取全部课程信息
    List<CourseInfo> getAll();

}
