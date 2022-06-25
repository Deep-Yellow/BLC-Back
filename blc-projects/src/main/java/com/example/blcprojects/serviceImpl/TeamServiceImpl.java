package com.example.blcprojects.serviceImpl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blcprojects.mapper.TeamMapper;
import com.example.blcprojects.po.TeamPO;
import com.example.blcprojects.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, TeamPO> implements TeamService {

    @Autowired
    TeamMapper teamMapper;

    @Override
    public String getTeamNameByTid(Integer tid) {
        return teamMapper.getTeamById(tid).getTeamName();
    }

    @Override
    public TeamPO getTeamByTid(Integer tid) {
        return teamMapper.getTeamById(tid);
    }
}
