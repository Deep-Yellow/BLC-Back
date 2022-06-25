package com.example.blcteam.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
class TagMapperTest {

    @Autowired
    TagMapper tagMapper;

    @Test
    void getTagsByPaper() {
        System.out.println(tagMapper.getTagsByPaper(3));
    }

    @Test
    void getTagsCollection() {
        System.out.println(tagMapper.getTagsCollection());
    }

    @Test
    void getTagIdByName() {
        System.out.println(tagMapper.getTagIdByName("tagTest2"));
    }

    @Test
    @Transactional(rollbackFor = Exception.class)
    void addTagToPaper() {
        System.out.println(tagMapper.addTagToPaper(1,5));
    }
}