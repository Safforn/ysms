package com.ssm.service.impl;

import com.ssm.dao.AnnounceInfoDao;
import com.ssm.dao.AttendanceInfoDao;
import com.ssm.pojo.AnnounceInfo;
import com.ssm.pojo.AttendanceInfo;
import com.ssm.pojo.CourseScoreInfo;
import com.ssm.pojo.Pager;
import com.ssm.service.AnnounceService;
import com.ssm.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("attendanceService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    AttendanceInfoDao attendanceInfoDao;

    @Override
    public Integer addAttendance(AttendanceInfo attendanceInfo) {
        return attendanceInfoDao.addAttendance(attendanceInfo);
    }

    @Override
    public int count(Map<String, Object> params) {
        int ret = attendanceInfoDao.count(params);
        System.out.println("___________________"+ret);
        return ret;
    }

    @Override
    public List<AttendanceInfo> findAttendanceInfo(AttendanceInfo attendanceInfo, Pager pager) {
        //创建对象params
        Map<String,Object> params=new HashMap<>();
        //将封装有查询条件的AttendanceInfo对象放入params
        params.put("attendanceInfo",attendanceInfo);
        //根据条件计算成绩总数
        int recordCount=attendanceInfoDao.count(params);
        //给pager对象设置rowCount属性值(记录总数)
        pager.setRowCount(recordCount);
        if(recordCount>0){
            //将pager对象放入params
            params.put("pager",pager);
        }
        //分页获取成绩信息
        return attendanceInfoDao.selectByPage(params);
    }


}
