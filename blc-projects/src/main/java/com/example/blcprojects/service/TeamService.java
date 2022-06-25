package com.example.blcprojects.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blcprojects.po.TeamPO;

public interface TeamService extends IService<TeamPO> {

    /**
     * 由团队id获得团队名 （已废弃
     */
    public String getTeamNameByTid(Integer tid);


    /**
     * 由团队ID获得团队实体
     */
    public TeamPO getTeamByTid(Integer tid);
}
