package com.ssm.service;

import com.ssm.pojo.AnnounceInfo;
import com.ssm.pojo.Pager;

import java.util.List;
import java.util.Map;

public interface AnnounceService {

    Integer addAnnouncement(AnnounceInfo announceInfo);

    int count(Map<String, Object> params);

    List<AnnounceInfo> findAnnounceInfo(AnnounceInfo announceInfo, Pager pager);
}
