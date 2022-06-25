package com.example.blcprojects.serviceImpl;

import com.example.blcprojects.service.TagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TagServiceImplTest {

    @Autowired
    TagService tagService;

    @Test
    void deleteTag() {
        tagService.deleteTag("项目标签1",1);
    }
}