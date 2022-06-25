package com.example.blcprojects.controller;


import com.example.blcprojects.service.ProjectService;
import com.example.blcprojects.vo.BriefProjectVO;
import com.example.blcprojects.vo.PaginationInfoVO;
import com.example.blcprojects.vo.ProjectDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/page_info")
    PaginationInfoVO getPaginationInfo(){
        int pageSize=projectService.getPageSize();
        long totalAmount=projectService.getTotalAmount();
        return new PaginationInfoVO(pageSize,totalAmount);
    }

    @GetMapping("/projects")
    List<BriefProjectVO> getProjectList(@RequestParam(value = "current_page") int currentPage){
        return projectService.getProjectList(currentPage);
    }

    @GetMapping("/project")
    ProjectDetailVO getProjectDetail(@RequestParam(value = "project_id") int projectId){
        return projectService.getProjectDetail(projectId);
    }

    @GetMapping("/projects_detail")
    List<ProjectDetailVO> getProjectDetailList(){
        return projectService.getProjectDetailList();
    }



}
