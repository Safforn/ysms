package com.ssm.pojo;

import java.util.List;

public class CourseInfo {
    private String cid;      //课程编号
    private String cname;    //课程名称
    private String time;     //上课时间
    private String location;     //上课地点
    private String allNumber;    //课程容量
    private TeacherInfo teacherInfo;  //教师信息
    private DepartmentInfo departmentInfo;  //院系编号(外键)

    public CourseInfo() {
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public TeacherInfo getTeacherInfo() {
        return teacherInfo;
    }

    public void setTeacherInfo(TeacherInfo teacherInfo) {
        this.teacherInfo = teacherInfo;
    }

    public String getAllNumber() {
        return allNumber;
    }

    public void setAllNumber(String allNumber) {
        this.allNumber = allNumber;
    }

    public DepartmentInfo getDepartmentInfo() {
        return departmentInfo;
    }

    public void setDepartmentInfo(DepartmentInfo departmentInfo) {
        this.departmentInfo = departmentInfo;
    }

    @Override
    public String toString() {
        return "CourseInfo{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", allNumber=" + allNumber+
                ", teacherInfo=" + teacherInfo +
                '}';
    }
}
