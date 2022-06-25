package com.example.blcprojects.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TagMapperTest {

    @Autowired
    TagMapper tagMapper;
    @Test
    void selectTagByProj() {
        System.out.println(tagMapper.getTagsByProject(1));
    }

    @Test
    void getTagIdByName() {
        System.out.println(tagMapper.getTagIdByName("项目标签1"));
    }
}