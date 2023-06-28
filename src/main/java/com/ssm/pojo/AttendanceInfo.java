package com.ssm.pojo;

public class AttendanceInfo {
    private String aid;
    private String cname;
    private String time;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
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
                ", cname='" + cname + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
