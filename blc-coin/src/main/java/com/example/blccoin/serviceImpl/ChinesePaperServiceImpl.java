package com.example.blccoin.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blccoin.mapper.ChinesePaperMapper;
import com.example.blccoin.pojo.ChinesePaper;
import com.example.blccoin.pojo.PageData;
import com.example.blccoin.pojo.Paper;
import com.example.blccoin.pojo.PaperQuery;
import com.example.blccoin.service.ChinesePaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ChinesePaperServiceImpl extends ServiceImpl<ChinesePaperMapper, ChinesePaper> implements ChinesePaperService {

    @Autowired
    ChinesePaperMapper chinesePaperMapper;

    public final static Integer pageSize=10;

    @Override
    public List<ChinesePaper> getSampleList() {
        QueryWrapper<ChinesePaper> wrapper=new QueryWrapper<>();
        wrapper.orderByAsc("level");
        //使用last方法拼接sql语句
        wrapper.last("limit 10");
        return list(wrapper);
    }

    @Override
    public List<ChinesePaper> getListByQuery(PaperQuery paperQuery, long current) {
        Page<ChinesePaper> paperPage=getPageDataByQuery(paperQuery,current);
        return paperPage.getRecords();
    }

    private Page<ChinesePaper> getPageDataByQuery(PaperQuery paperQuery, long current){
        QueryWrapper<ChinesePaper> queryWrapper=new QueryWrapper<>();
        if(!(paperQuery.getLevel()==null)){
            List<String> levelList= Arrays.asList(paperQuery.getLevel());
            queryWrapper.in("level",levelList);
        }
        if(!(paperQuery.getYear()==null)){
            List<String> yearList=Arrays.asList(paperQuery.getYear());
            queryWrapper.in("year",yearList);
        }
        if(!(paperQuery.getKeyword()==null)){
            queryWrapper.like("keywords",paperQuery.getKeyword());
        }
        if(!(paperQuery.getWordInTitle()==null)){
            queryWrapper.like("name",paperQuery.getWordInTitle());
        }
        Page<ChinesePaper> paperPage=new Page<>(current,pageSize);
        chinesePaperMapper.selectPage(paperPage,queryWrapper);
        return paperPage;
    }

    @Override
    public PageData getPageData(PaperQuery paperQuery) {
        Page<ChinesePaper> paperPage=getPageDataByQuery(paperQuery,1);
        return new PageData(paperPage.getTotal(),pageSize);
    }
}
