package com.example.blcactivity.controller;

import com.example.blcactivity.po.ActivityPO;
import com.example.blcactivity.service.ActivityService;
import com.example.blcactivity.vo.ActivityGroupVO;
import com.example.blcactivity.vo.ActivityVO;
import com.example.blcactivity.vo.BriefActivityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @GetMapping(value = "/activity_short_list")
    List<ActivityGroupVO> getShortList(){
        return activityService.getBriefActivityShortList();
    }

    @GetMapping(value = "/activity")
    ActivityVO getActivity(Integer id){
        return activityService.getActivityInfo(id);
    }
}
