package com.ssm.pojo;

import java.util.List;

public class CourseInfo {
    private String id;      //课程编号
    private String cname;    //课程名称
    private String location;     //上课地点
    private TeacherInfo teacherInfo;  //教师信息
    private int allNumber;    //课程容量
    private List<StudentInfo> studentInfos;  //上课学生信息

    public CourseInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
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

    public int getAllNumber() {
        return allNumber;
    }

    public void setAllNumber(int allNumber) {
        this.allNumber = allNumber;
    }

    public List<StudentInfo> getStudentInfos() {
        return studentInfos;
    }

    public void setStudentInfos(List<StudentInfo> studentInfos) {
        this.studentInfos = studentInfos;
    }

    @Override
    public String toString() {
        return "CourseInfo{" +
                "id='" + id + '\'' +
                ", cname='" + cname + '\'' +
                ", location='" + location + '\'' +
                ", teacherInfo=" + teacherInfo +
                ", allNumber=" + allNumber +
                ", studentInfos=" + studentInfos +
                '}';
    }
}
