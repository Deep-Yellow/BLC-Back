package com.example.blcactivity.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ActivityMapperTest {

    @Autowired
    ActivityMapper activityMapper;

    @Test
    void getShortListTest(){
        System.out.println(activityMapper.getShortList("承接项目").size());
    }

    @Test
    void getClassify() {
        System.out.println(activityMapper.getClassification());
    }

    @Test
    void getActivityCount() {
        System.out.println(activityMapper.getActivityCount("承接项目"));
    }
}