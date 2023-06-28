package com.ssm.service.impl;

import com.ssm.dao.AdminInfoDao;
import com.ssm.dao.AnnounceInfoDao;
import com.ssm.pojo.AdminInfo;
import com.ssm.pojo.AnnounceInfo;
import com.ssm.service.AdminService;
import com.ssm.service.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("announceService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class AnnounceServiceImpl implements AnnounceService {
    @Autowired
    AnnounceInfoDao announceInfoDao;

    @Override
    public Integer addAnnouncement(AnnounceInfo announceInfo) {
        return announceInfoDao.addAnnouncement(announceInfo);
    }

}
