package com.ssm.pojo;

public class AttendanceInfo {
    private String aid;
    private StudentInfo studentInfo;
    private String cname;
    private String time;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
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

    @Override
    public String toString() {
        return "AttendanceInfo{" +
                "aid='" + aid + '\'' +
                ", studentInfo='" + studentInfo + '\'' +
                ", cname='" + cname + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
