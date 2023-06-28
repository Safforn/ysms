//package com.ssm.service.impl;
//
//import com.ssm.dao.DepartmentInfoDao;
//import com.ssm.dao.CourseScoreInfoDao;
//import com.ssm.pojo.Pager;
//import com.ssm.pojo.CourseScoreInfo;
//import com.ssm.service.CourseScoreInfoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Isolation;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service("courseScoreInfoService")
//@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
//
//public class CourseScoreInfoServiceImpl implements CourseScoreInfoService {
//    @Autowired
//    CourseScoreInfoDao courseScoreInfoDao;
//    @Autowired
//    DepartmentInfoDao departmentInfoDao;
//    @Override
//    public CourseScoreInfo login(CourseScoreInfo stu) {
//        return courseScoreInfoDao.login(stu);
//    }
//
//    @Override
//    public int count(Map<String, Object> params) {
//        return courseScoreInfoDao.count(params);
//    }
//
//    @Override
//    public List<CourseScoreInfo> findCourseScoreInfo(CourseScoreInfo courseScoreInfo, Pager pager) {
//        //创建对象params
//        Map<String,Object> params=new HashMap<>();
//        //将封装有查询条件的courseScoreInfo对象放入params
//        params.put("courseScoreInfo",courseScoreInfo);
//        //根据条件计算成绩总数
//        int recordCount=courseScoreInfoDao.count(params);
//        //给pager对象设置rowCount属性值(记录总数)
//        pager.setRowCount(recordCount);
//        if(recordCount>0){
//            //将pager对象放入params
//            params.put("pager",pager);
//        }
//        //分页获取成绩信息
//        return courseScoreInfoDao.selectByPage(params);
//    }
//
//    @Override
//    public int addCourseScore(CourseScoreInfo courseScoreInfo) {
//        return courseScoreInfoDao.addCourseScore(courseScoreInfo);
//    }
//
//    @Override
//    public int deleteCourseScore(String aid) {
//        return courseScoreInfoDao.deleteCourseScore(aid);
//    }
//
//    @Override
//    public int updateCourseScore(CourseScoreInfo courseScoreInfo) {
//        return courseScoreInfoDao.updateCourseScore(courseScoreInfo);
//    }
//
//    @Override
//    public List<CourseScoreInfo> allocationCourseScore(CourseScoreInfo courseScoreInfo) {
//        return courseScoreInfoDao.allocationCourseScore(courseScoreInfo);
//    }
//
//    @Override
//    public int updateCourseScoreDorm(CourseScoreInfo courseScoreInfo) {
//        return courseScoreInfoDao.updateCourseScoreDorm(courseScoreInfo);
//    }
//
//    @Override
//    public List<CourseScoreInfo> getAllCourseScore() {
//        return courseScoreInfoDao.getAllCourseScore();
//    }
//
//    @Override
//    public List<Integer> getAlreadyDistribute() {
//        return courseScoreInfoDao.getAlreadyDistribute();
//    }
//
//    @Override
//    public List<Integer> getNoDistribute() {
//        return courseScoreInfoDao.getNoDistribute();
//    }
//
//    @Override
//    public int changeMessage(CourseScoreInfo courseScoreInfo) {
//        return courseScoreInfoDao.changeMessage(courseScoreInfo);
//    }
//
//    @Override
//    public CourseScoreInfo getCourseScore(CourseScoreInfo courseScoreInfo) {
//        return courseScoreInfoDao.getCourseScore(courseScoreInfo);
//    }
//
//    @Override
//    public int changePassword(CourseScoreInfo courseScoreInfo) {
//        return courseScoreInfoDao.changePassword(courseScoreInfo);
//    }
//
//
//}
