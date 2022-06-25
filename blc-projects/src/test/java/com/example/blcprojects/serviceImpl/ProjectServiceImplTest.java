package com.example.blcprojects.serviceImpl;

import com.example.blcprojects.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProjectServiceImplTest {

    @Autowired
    ProjectService projectService;

    @Test
    void getPageAmount() {
        System.out.println(projectService.getTotalAmount());
    }

    @Test
    void test(){
        System.out.println(projectService.list());
    }

    @Test
    void getPaperList() {
        System.out.println(projectService.getProjectList(2));
    }

    @Test
    void getProjectDetail() {
        System.out.println(projectService.getProjectDetail(1));
    }

    @Test
    void getProjectDetailList() {
        System.out.println(projectService.getProjectDetailList());
    }
}