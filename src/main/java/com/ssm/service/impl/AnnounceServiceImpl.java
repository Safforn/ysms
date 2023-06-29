package com.ssm.service.impl;

import com.ssm.dao.AnnounceInfoDao;
import com.ssm.pojo.AnnounceInfo;
import com.ssm.service.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.ssm.pojo.Pager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("announceService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class AnnounceServiceImpl implements AnnounceService {
    @Autowired
    AnnounceInfoDao announceInfoDao;

    @Override
    public Integer addAnnouncement(AnnounceInfo announceInfo) {
        return announceInfoDao.addAnnouncement(announceInfo);
    }

    @Override
    public int count(Map<String, Object> params) {
        return announceInfoDao.count(params);
    }

    @Override
    public List<AnnounceInfo> findAnnounceInfo(AnnounceInfo announceInfo, Pager pager) {
        //创建对象params
        Map<String,Object> params=new HashMap<>();
        //将封装有查询条件的AnnounceInfo对象放入params
        params.put("announceInfo",announceInfo);
        //根据条件计算成绩总数
        int recordCount=announceInfoDao.count(params);
        //给pager对象设置rowCount属性值(记录总数)
        pager.setRowCount(recordCount);
        if(recordCount>0){
            //将pager对象放入params
            params.put("pager",pager);
        }
        //分页获取公告信息
        return announceInfoDao.selectByPage(params);
    }

}
