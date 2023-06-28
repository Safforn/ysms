package com.ssm.service;

import com.ssm.pojo.DepartmentInfo;
import com.ssm.pojo.Pager;
import com.ssm.pojo.TeacherInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TeacherInfoService {

    List<TeacherInfo> getAll();
    //老师登录验证
    TeacherInfo login(TeacherInfo tno);
    //获取满足条件的老师总数
    int count(Map<String,Object> params);
    //获取满足条件的老师列表
    List<TeacherInfo> findTeacherInfo(TeacherInfo teacherInfo, Pager pager);
    //添加老师
    int addTeacher(TeacherInfo teacherInfo);
    //删除老师
    int deleteTeacher(String sno);
    //更新老师
    int updateTeacher(TeacherInfo teacherInfo);

    //根据条件查询老师列表
    List<TeacherInfo> allocationTeacher(TeacherInfo teacherInfo);

    //查看所有老师列表
    List<TeacherInfo> getAllTeacher();

    //根据学号查询老师所有信息
    TeacherInfo getTeacher(TeacherInfo teacherInfo);

    //老师修改密码
    int changePassword(TeacherInfo teacherInfo);
}
