package com.example.blcactivity.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blcactivity.mapper.ActivityMapper;
import com.example.blcactivity.po.ActivityPO;
import com.example.blcactivity.service.ActivityService;
import com.example.blcactivity.vo.ActivityGroupVO;
import com.example.blcactivity.vo.ActivityVO;
import com.example.blcactivity.vo.BriefActivityVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, ActivityPO> implements ActivityService {

    @Autowired
    ActivityMapper activityMapper;

    @Override
    public ActivityVO getActivityInfo(Integer id) {
        ActivityPO temp= getById(id);
        //每次访问后访问次数++
        ActivityVO res = new ActivityVO();
        BeanUtils.copyProperties(temp,res);
        temp.setViews(temp.getViews()+1);
        saveOrUpdate(temp);
        return res;
    }

    @Override
    public List<ActivityGroupVO> getBriefActivityShortList() {
        ArrayList<ActivityGroupVO> res = new ArrayList<>();
        List<String> classification = activityMapper.getClassification();
        for(String title: classification){
            ActivityGroupVO activityGroupVO = new ActivityGroupVO();
            activityGroupVO.setTitle(title);
            activityGroupVO.setHasMore(activityMapper.getActivityCount(title) > 5);
            List<ActivityPO> activityPOList=activityMapper.getShortList(title);
            activityGroupVO.setItems(assembleBriefActivityVOList(activityPOList));
            res.add(activityGroupVO);
        }
        return res;
    }

    private List<BriefActivityVO> assembleBriefActivityVOList(List<ActivityPO> activityPOList){
        ArrayList<BriefActivityVO> res=new ArrayList<>();
        for (ActivityPO activityPO:activityPOList) {
            BriefActivityVO activityVO=new BriefActivityVO();
            BeanUtils.copyProperties(activityPO,activityVO);
            res.add(activityVO);
        }
        return res;
    }
}


