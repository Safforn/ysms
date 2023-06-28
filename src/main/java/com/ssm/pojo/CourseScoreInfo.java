package com.ssm.pojo;

public class CourseScoreInfo {
    private String sid;  // 成绩编号
    private StudentInfo studentInfo;  // 学号
    private CourseInfo courseInfo;  // 课程编号
    private String credit;  // 学分
    private String score;  // 成绩 得分

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public CourseInfo getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(CourseInfo courseInfo) {
        this.courseInfo = courseInfo;
    }

    @Override
    public String toString() {
        return "CourseScoreInfo{" +
                "sid='" + sid + '\'' +
                ", studentInfo='" + studentInfo + '\'' +
                ", courseInfo='" + courseInfo + '\'' +
                ", credit='" + credit + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
