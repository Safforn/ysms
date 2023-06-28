package com.ssm.pojo;

public class CourseScoreInfo {
    private String sid;  // 成绩编号
    private String sno;  // 学号
    private String cid;  // 课程编号
    private String credit;  // 学分
    private String score;  // 成绩 得分

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    @Override
    public String toString() {
        return "AnnounceInfo{" +
                "sid='" + sid + '\'' +
                ", sno='" + sno + '\'' +
                ", cid='" + cid + '\'' +
                ", credit='" + credit + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
