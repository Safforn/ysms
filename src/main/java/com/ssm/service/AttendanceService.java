package com.ssm.service;

import com.ssm.pojo.AttendanceInfo;
import com.ssm.pojo.Pager;

import java.util.List;
import java.util.Map;

public interface AttendanceService {

    Integer addAttendance(AttendanceInfo attendanceInfo);

    int count(Map<String, Object> params);

    List<AttendanceInfo> findAttendanceInfo(AttendanceInfo attendanceInfo, Pager pager);
}
