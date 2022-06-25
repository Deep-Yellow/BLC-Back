package com.example.blcactivity.service;

import com.example.blcactivity.po.ActivityPO;
import com.example.blcactivity.vo.ActivityGroupVO;
import com.example.blcactivity.vo.ActivityVO;
import com.example.blcactivity.vo.BriefActivityVO;

import java.util.List;

public interface ActivityService {

    /**
     * 根据id返回活动的详细信息，需要对views进行更新
     */
    ActivityVO getActivityInfo(Integer id);


    /**
     * 以及页面用，只显示5条最新记录，需要另补一个‘MORE>>’对应的方法取得所有记录
     */
    List<ActivityGroupVO> getBriefActivityShortList();

}
