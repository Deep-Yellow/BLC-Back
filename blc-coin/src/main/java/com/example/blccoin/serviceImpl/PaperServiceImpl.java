package com.example.blccoin.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blccoin.mapper.PaperMapper;
import com.example.blccoin.pojo.Keyword;
import com.example.blccoin.pojo.PageData;
import com.example.blccoin.pojo.Paper;
import com.example.blccoin.pojo.PaperQuery;
import com.example.blccoin.service.PaperService;

import com.example.blccoin.utils.KeywordsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements PaperService{

    @Autowired
    PaperMapper paperMapper;

    public final static Integer pageSize=10;


    @Override
    public List<Paper> getSampleList(){
        QueryWrapper<Paper> wrapper=new QueryWrapper<>();
        wrapper.orderByAsc("level");
        //使用last方法拼接sql语句
        wrapper.last("limit 10");
        return list(wrapper);
    }

    @Override
    public List<Paper> getALevelPapers() {
        return paperMapper.selectALevelPapers();
    }

    @Override
    public List<Keyword> getKeywords(String[] level,String[] year) {
        //针对不同条件获得对应的文献列表 往下封装一层
        List<Paper> paperList=paperListFilter(level,year);
        //这个变量是为了对keywords的value进行放缩
        int paperListSize=paperList.size();
        ArrayList<String> arrayList=new ArrayList<>();
        for(Paper paper:paperList){
            arrayList.add(paper.getKeywords());
        }
        ArrayList<Keyword> res=new ArrayList<>();
        HashMap<String,Integer> keywordMap=KeywordsUtil.count(arrayList);
        for(Map.Entry<String,Integer> entry: keywordMap.entrySet()){
            if((entry.getValue()>paperListSize/16)&&entry.getValue()>2){
                Keyword keyword=new Keyword(entry.getValue(),entry.getKey());
                res.add(keyword);
            }
        }
        return res;
    }

    public List<Paper> paperListFilter(String[] level,String[] year){
        ArrayList<Paper> res = new ArrayList<>();
        for (String l : level) {
            for (String y : year) {
                res.addAll(paperMapper.selectPapersByYearAndLevel(y,l));
            }
        }
        return res;
    }

    @Override
    public List<Paper> getListByQuery(PaperQuery paperQuery, long current){
        Page<Paper> paperPage=getPageDataByQuery(paperQuery,current);
        return paperPage.getRecords();
    }

    private Page<Paper> getPageDataByQuery(PaperQuery paperQuery,long current){
        QueryWrapper<Paper> queryWrapper=new QueryWrapper<>();
        if(!(paperQuery.getLevel()==null)){
            List<String> levelList=Arrays.asList(paperQuery.getLevel());
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
        Page<Paper> paperPage=new Page<>(current,pageSize);
        paperMapper.selectPage(paperPage,queryWrapper);
        return paperPage;
    }

    public PageData getPageData(PaperQuery paperQuery){
        Page<Paper> paperPage=getPageDataByQuery(paperQuery,1);
        return new PageData(paperPage.getTotal(),pageSize);
    }

}
