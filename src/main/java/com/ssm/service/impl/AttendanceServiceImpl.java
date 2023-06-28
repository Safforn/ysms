package com.ssm.service.impl;

import com.ssm.dao.AnnounceInfoDao;
import com.ssm.dao.AttendanceInfoDao;
import com.ssm.pojo.AnnounceInfo;
import com.ssm.pojo.AttendanceInfo;
import com.ssm.service.AnnounceService;
import com.ssm.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("attendanceService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    AttendanceInfoDao attendanceInfoDao;

    @Override
    public Integer addAttendance(AttendanceInfo attendanceInfo) {
        return attendanceInfoDao.addAttendance(attendanceInfo);
    }

}
