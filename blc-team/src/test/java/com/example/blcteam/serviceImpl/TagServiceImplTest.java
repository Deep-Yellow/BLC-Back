package com.example.blcteam.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blcteam.po.PaperTag;
import com.example.blcteam.service.TagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class TagServiceImplTest {
    @Autowired
    private TagService tagService;

    @Test
    void getTagCollection() {
        System.out.println(tagService.getTagCollection());
    }

    @Test
    void getTagsNameByPaper() {
        System.out.println(tagService.getTagsNameByPaper(3));
    }

    @Test
    void page(){
        IPage<PaperTag> iPage=new Page<>(1,15);
        IPage<PaperTag> page=tagService.page(iPage);
        List<PaperTag> tagList=page.getRecords();
        System.out.println(tagList);
        System.out.println(page.getPages());
    }

    @Test
    void addTagToPaperBatch() {
        int paperId=3;
        List<String> tags=new ArrayList<>();
        tags.add("SOA");
        tags.add("test2");
        tags.add("test3");
        System.out.println(tagService.addTagToPaperBatch(paperId,tags));
    }
}