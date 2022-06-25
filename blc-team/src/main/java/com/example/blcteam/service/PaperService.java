package com.example.blcteam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blcteam.po.PaperPO;
import com.example.blcteam.vo.PaperVO;
import com.example.blcteam.vo.ResponseVO;

import java.util.List;

public interface PaperService extends IService<PaperPO> {

    /**
     * 获取所有文章，并获得文章的tag
     * @return 前端可用的VO对象列表
     */
    List<PaperVO> getPapers();



    List<PaperVO> searchPaperByName(String str);


    /**
     * 通过标签名字筛选文章
     * @param tagName 标签名
     * @return 最有这个标签的文章列表
     */
    List<PaperVO> searchPaperByTag(String tagName);


    /**
     * 增加文章，加入前做重复检查
     * 特别说明：这里假定了tags都是库中已存在的
     */
    ResponseVO savePaper(PaperVO paperVO);


    /**
     * 更新文章信息
     */
    ResponseVO updatePaper(PaperVO paperVO);

}
