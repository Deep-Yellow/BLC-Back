package com.example.blcprojects.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blcprojects.mapper.ProjectMapper;
import com.example.blcprojects.po.ProjectPO;
import com.example.blcprojects.po.TeamPO;
import com.example.blcprojects.service.ProjectService;
import com.example.blcprojects.service.TagService;
import com.example.blcprojects.service.TeamService;
import com.example.blcprojects.vo.BriefProjectVO;
import com.example.blcprojects.vo.ProjectDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, ProjectPO> implements ProjectService {

    public final static Integer pageSize=2;

    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    TeamService teamService;

    @Autowired
    TagService tagService;
  
    @Override
    public Long getTotalAmount() {
        IPage<ProjectPO> iPage=new Page<>(1,pageSize);
        IPage<ProjectPO> page=page(iPage);
        return page.getTotal();
    }

    @Override
    public List<BriefProjectVO> getProjectList(int current) {
        IPage<ProjectPO> iPage=new Page<>(current,pageSize);
        IPage<ProjectPO> page=page(iPage);
        List<ProjectPO> projectPOList=page.getRecords();
        return assembleBriefProjectList(projectPOList);
    }

    @Override
    public Integer getPageSize(){
        return pageSize;
    }


    /**
     * 这里考虑到未来会有变更的可能，如多一个project多个team，往下多做一层封装
     */
    @Override
    public ProjectDetailVO getProjectDetail(int projectId) {
        ProjectPO projectPO=getById(projectId);
        return assembleProjectDetailVO(projectPO);
    }

    @Override
    public List<ProjectDetailVO> getProjectDetailList() {
        ArrayList<ProjectDetailVO> res=new ArrayList<>();
        List<ProjectPO> projectPOList= list();
        for(ProjectPO projectPO:projectPOList){
            res.add(assembleProjectDetailVO(projectPO));
        }
        return res;
    }


    private ProjectDetailVO assembleProjectDetailVO(ProjectPO projectPO){
        ProjectDetailVO detailVO=new ProjectDetailVO(projectPO);
        TeamPO teamPO=teamService.getTeamByTid(projectPO.getTeamId());
        //设置团队相关
        detailVO.setTeamInfo(teamPO.getTeamInfo());
        detailVO.setTeamMember(teamPO.getTeamMember());
        detailVO.setTeamName(teamPO.getTeamName());
        //设置标签
        List<String> tags=tagService.getTagsByProj(projectPO.getId());
        detailVO.setTags(tags);
        return detailVO;
    }

    /**
     * 辅助方法 返回一级页面所需要的列表条目
     */

    public List<BriefProjectVO> assembleBriefProjectList(List<ProjectPO> projectPOList){
        ArrayList<BriefProjectVO> res=new ArrayList<>();
        for(ProjectPO projectPO:projectPOList){
            String teamName=teamService.getTeamByTid(projectPO.getTeamId()).getTeamName();
            BriefProjectVO briefProjectVO=new BriefProjectVO(projectPO.getId(),projectPO.getProjectName(),projectPO.getSynopsis(),teamName);
            res.add(briefProjectVO);
        }
        return res;
    }



}
