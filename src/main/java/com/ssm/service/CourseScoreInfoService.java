//package com.ssm.service;
//
//import com.ssm.pojo.Pager;
//import com.ssm.pojo.CourseScoreInfo;
//import org.apache.ibatis.annotations.Param;
//
//import java.util.List;
//import java.util.Map;
//
//public interface CourseScoreInfoService {
//    //获取满足条件的成绩总数
//    int count(Map<String,Object> params);
//    //获取满足条件的成绩列表
//    List<CourseScoreInfo> findCourseScoreInfo(CourseScoreInfo courseScoreInfo, Pager pager);
//    //添加成绩
//    int addCourseScore(CourseScoreInfo courseScoreInfo);
//    //删除成绩
//    int deleteCourseScore(String aid);
//    //更新成绩
//    int updateCourseScore(CourseScoreInfo courseScoreInfo);
//
//    //根据条件查询成绩列表
//    List<CourseScoreInfo> allocationCourseScore(CourseScoreInfo courseScoreInfo);
//
//    //查看所有成绩列表
//    List<CourseScoreInfo> getAllCourseScore();
//
//}
