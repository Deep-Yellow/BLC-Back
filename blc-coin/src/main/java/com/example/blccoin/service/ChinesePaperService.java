package com.example.blccoin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blccoin.pojo.ChinesePaper;
import com.example.blccoin.pojo.PageData;
import com.example.blccoin.pojo.Paper;
import com.example.blccoin.pojo.PaperQuery;

import java.util.List;

public interface ChinesePaperService extends IService<ChinesePaper> {
    List<ChinesePaper> getSampleList();
    /**
     * 双击图中某一关键词后需要给出包含该关键词的文献集合
     * 22.0529修改 增加了检索模块 调用此方法
     */
    List<ChinesePaper> getListByQuery(PaperQuery paperQuery, long current);

    /**
     * 分页信息 条目数 page-size
     */
    PageData getPageData(PaperQuery paperQuery);
}
