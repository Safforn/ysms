package com.ssm.service.impl;

import com.ssm.dao.CourseInfoDao;
import com.ssm.dao.DepartmentInfoDao;
import com.ssm.dao.StudentInfoDao;
import com.ssm.pojo.CourseInfo;
import com.ssm.pojo.Pager;
import com.ssm.pojo.StudentInfo;
import com.ssm.service.CourseInfoService;
import com.ssm.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("courseInfoService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)

public class CourseInfoServiceImpl implements CourseInfoService {
    @Autowired
    CourseInfoDao courseInfoDao;
    @Autowired
    DepartmentInfoDao departmentInfoDao;

    @Override
    public int count(Map<String, Object> params) {
        return courseInfoDao.count(params);
    }

    @Override
    public int addCourse(CourseInfo courseInfo) {
        return courseInfoDao.addCourse(courseInfo);
    }

    @Override
    public int deleteCourse(String cid) {
        return courseInfoDao.deleteCourse(cid);
    }

    @Override
    public int updateCourse(CourseInfo courseInfo) {
        return courseInfoDao.updateCourse(courseInfo);
    }

    @Override
    public List<CourseInfo> findCourseInfo(CourseInfo courseInfo, Pager pager) {
        //创建对象params
        Map<String,Object> params=new HashMap<>();
        //将封装有查询条件的studentInfo对象放入params
        params.put("courseInfo",courseInfo);
        //根据条件计算学生总数
        int recordCount=courseInfoDao.count(params);
        //给pager对象设置rowCount属性值(记录总数)
        pager.setRowCount(recordCount);
        if(recordCount>0){
            //将pager对象放入params
            params.put("pager",pager);
        }
        //分页获取学生信息
        return courseInfoDao.selectByPage(params);
    }


}
