package com.example.blcactivity.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blcactivity.mapper.NewsMapper;
import com.example.blcactivity.po.NewsPO;
import com.example.blcactivity.service.NewsService;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, NewsPO> implements NewsService {

}
