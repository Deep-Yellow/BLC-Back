package com.example.blccoin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blccoin.pojo.Keyword;
import com.example.blccoin.pojo.PageData;
import com.example.blccoin.pojo.Paper;
import com.example.blccoin.pojo.PaperQuery;

import java.util.List;

public interface PaperService extends IService<Paper> {

    /**
     * 测试用 得到一个文章列表
     */
    public List<Paper> getSampleList();
    /**
     * 示例用 获得A级别的文献集合
     */
    public List<Paper> getALevelPapers();

    /**
     * 流程如下：
     * 1. 根据筛选条件 比如年份、CCF评级来获得一批文献集合
     * 2. 对文献集合的关键词字段进行提取 并进行分析
     * 3. 关键词的value即包含该关键词的文献数目 在文献集过大时需要进行特殊处理 如等比缩小，避免前端的图里图元长度过长
     */
    List<Keyword> getKeywords(String[] level,String[] year);


    /**
     * 双击图中某一关键词后需要给出包含该关键词的文献集合
     * 22.0529修改 增加了检索模块 调用此方法
     */
    List<Paper> getListByQuery(PaperQuery paperQuery, long current);

    /**
     * 分页信息 条目数 page-size
     */
    PageData getPageData(PaperQuery paperQuery);

}
