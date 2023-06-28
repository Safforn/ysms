//package com.ssm.service.impl;
//
//import com.ssm.dao.DepartmentInfoDao;
//import com.ssm.dao.AskForLeaveInfoDao;
//import com.ssm.pojo.Pager;
//import com.ssm.pojo.AskForLeaveInfo;
//import com.ssm.service.AskForLeaveInfoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Isolation;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service("askForLeaveInfoService")
//@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
//
//public class AskForLeaveInfoServiceImpl implements AskForLeaveInfoService {
//    @Autowired
//    AskForLeaveInfoDao askForLeaveInfoDao;
//    @Autowired
//    DepartmentInfoDao departmentInfoDao;
//
//
//    @Override
//    public int count(Map<String, Object> params) {
//        return askForLeaveInfoDao.count(params);
//    }
//
//    @Override
//    public List<AskForLeaveInfo> findAskForLeaveInfo(AskForLeaveInfo askForLeaveInfo, Pager pager) {
//        //创建对象params
//        Map<String,Object> params=new HashMap<>();
//        //将封装有查询条件的askForLeaveInfo对象放入params
//        params.put("askForLeaveInfo",askForLeaveInfo);
//        //根据条件计算请假总数
//        int recordCount=askForLeaveInfoDao.count(params);
//        //给pager对象设置rowCount属性值(记录总数)
//        pager.setRowCount(recordCount);
//        if(recordCount>0){
//            //将pager对象放入params
//            params.put("pager",pager);
//        }
//        //分页获取请假信息
//        return askForLeaveInfoDao.selectByPage(params);
//    }
//
//    @Override
//    public int addAskForLeave(AskForLeaveInfo askForLeaveInfo) {
//        return askForLeaveInfoDao.addAskForLeave(askForLeaveInfo);
//    }
//
//    @Override
//    public int deleteAskForLeave(String aid) {
//        return askForLeaveInfoDao.deleteAskForLeave(aid);
//    }
//
//    @Override
//    public int updateAskForLeave(AskForLeaveInfo askForLeaveInfo) {
//        return askForLeaveInfoDao.updateAskForLeave(askForLeaveInfo);
//    }
//
//    @Override
//    public List<AskForLeaveInfo> getAllAskForLeave() {
//        return askForLeaveInfoDao.getAllAskForLeave();
//    }
//
//
//
//}
