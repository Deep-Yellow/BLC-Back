package com.example.blcprojects.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blcprojects.po.ProjectPO;
import com.example.blcprojects.vo.BriefProjectVO;
import com.example.blcprojects.vo.ProjectDetailVO;

import java.util.List;


public interface ProjectService extends IService<ProjectPO> {

    /**
     * 列表总条目数目，在初始化列表时候需要
     */
    Long getTotalAmount();


    /**
     * 列表展示所需要的简要项目信息
     */
    List<BriefProjectVO> getProjectList(int page);


    /**
     * 列表每页所展示的条目数量
     */
    Integer getPageSize();


    /**
     * 项目展示二级页面所需要的项目详细信息
     */
    ProjectDetailVO getProjectDetail(int projectId);

    /**
     * 管理后台用的
     */
    List<ProjectDetailVO> getProjectDetailList();
}
