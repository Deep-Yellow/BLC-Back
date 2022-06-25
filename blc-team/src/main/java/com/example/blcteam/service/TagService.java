package com.example.blcteam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blcteam.po.PaperTag;

import java.util.List;

public interface TagService extends IService<PaperTag> {


    /**
     * 用在门户网站 ”发表文章“ 模块中，根据标签筛选文章会用到
     * @return 可能出现的标签集合
     */
    List<String> getTagCollection();


    /**
     * 根据文章id(pid)获得对应的文章标签
     * @param id 文章id
     * @return 文章的标签列表
     */
    List<String> getTagsNameByPaper(int id);


    /**
     *预留接口 一次只能加一个标签
     */
    Boolean addTagToPaperByTagName(int paperId,String tagName);


    /**
     * 保存文章中的一步，添加文章标签
     * @param paperId paper_id
     * @param tags PaperVO中的List<String> tags
     */
    Boolean addTagToPaperBatch(int paperId,List<String> tags);


    /**
     * 更新文章信息中的一部，删除文章所有标签 （之后重新添加
     */
    Boolean deleteTags(int pid);

}
