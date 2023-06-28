package com.ssm.service.impl;

import com.ssm.dao.DepartmentInfoDao;
import com.ssm.dao.TeacherInfoDao;
import com.ssm.pojo.DepartmentInfo;
import com.ssm.pojo.Pager;
import com.ssm.pojo.TeacherInfo;
import com.ssm.service.TeacherInfoService;
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

@Service("teacherInfoService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)

public class TeacherInfoServiceImpl implements TeacherInfoService {
    @Autowired
    TeacherInfoDao teacherInfoDao;
    @Autowired
    DepartmentInfoDao departmentInfoDao;

    @Override
    public TeacherInfo login(TeacherInfo tch) {
        return teacherInfoDao.login(tch);
    }

    @Override
    public int count(Map<String, Object> params) {
        return teacherInfoDao.count(params);
    }

    @Override
    public List<TeacherInfo> getAll() {
        return teacherInfoDao.getAll();
    }

    @Override
    public List<TeacherInfo> findTeacherInfo(TeacherInfo teacherInfo, Pager pager) {
        //创建对象params
        Map<String,Object> params=new HashMap<>();
        //将封装有查询条件的teacherInfo对象放入params
        params.put("teacherInfo",teacherInfo);
        //根据条件计算学生总数
        int recordCount=teacherInfoDao.count(params);
        //给pager对象设置rowCount属性值(记录总数)
        pager.setRowCount(recordCount);
        if(recordCount>0){
            //将pager对象放入params
            params.put("pager",pager);
        }
        //分页获取学生信息
        return teacherInfoDao.selectByPage(params);
    }

    @Override
    public int addTeacher(TeacherInfo teacherInfo) {
        return teacherInfoDao.addTeacher(teacherInfo);
    }

    @Override
    public int deleteTeacher(String sno) {
        return teacherInfoDao.deleteTeacher(sno);
    }

    @Override
    public int updateTeacher(TeacherInfo teacherInfo) {
        return teacherInfoDao.updateTeacher(teacherInfo);
    }

    @Override
    public List<TeacherInfo> allocationTeacher(TeacherInfo teacherInfo) {
        return teacherInfoDao.allocationTeacher(teacherInfo);
    }

    @Override
    public List<TeacherInfo> getAllTeacher() {
        return teacherInfoDao.getAllTeacher();
    }

    @Override
    public TeacherInfo getTeacher(TeacherInfo teacherInfo) {
        return teacherInfoDao.getTeacher(teacherInfo);
    }

    @Override
    public int changePassword(TeacherInfo teacherInfo) {
        return teacherInfoDao.changePassword(teacherInfo);
    }


}
