package com.example.blcteam.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blcteam.mapper.PaperMapper;
import com.example.blcteam.po.PaperPO;
import com.example.blcteam.service.PaperService;
import com.example.blcteam.service.TagService;
import com.example.blcteam.vo.PaperVO;
import com.example.blcteam.vo.ResponseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaperServiceImpl extends ServiceImpl<PaperMapper, PaperPO> implements PaperService {

    @Autowired
    TagService tagService;

    @Autowired
    PaperMapper paperMapper;



    @Override
    public List<PaperVO> getPapers() {
        List<PaperPO> paperPOList =list(); //list()是ServiceImpl带有的，选中所有记录
        return packagingPaperVOList(paperPOList);
    }

    @Override
    public List<PaperVO> searchPaperByName(String str){
        List<PaperPO> paperPOList = paperMapper.searchPaperByName(str);
        return packagingPaperVOList(paperPOList);
    }

    @Override
    public List<PaperVO> searchPaperByTag(String tagName) {
        List<PaperPO> paperPOList=paperMapper.searchPaperByTagName(tagName);
        return packagingPaperVOList(paperPOList);
    }


    @Override
    public ResponseVO savePaper(PaperVO paperVO) {
        if(paperExist(paperVO)!=-1){
            return ResponseVO.buildFailure("同名文章已存在");
        }
        saveOrUpdate(paperVO.getPaperPO());
        int pid=paperExist(paperVO);
        List<String> tags=paperVO.getTags();

        if(tagService.addTagToPaperBatch(pid,tags)){
            return ResponseVO.buildSuccess();
        }else{
            return ResponseVO.buildFailure("文章添加成功，标签设置失败");
        }
    }


    @Override
    public ResponseVO updatePaper(PaperVO paperVO) {
        if(saveOrUpdate(paperVO.getPaperPO())){
            int pid = paperVO.getId();
            tagService.deleteTags(pid);
            List<String> tags=paperVO.getTags();
            tagService.addTagToPaperBatch(pid,tags);
            return ResponseVO.buildSuccess("更新文章成功");
        }
        return ResponseVO.buildFailure("更新文章失败");
    }


    /**
     * 判断是否存在 若存在返回id
     */
    private int paperExist(PaperVO paperVO){
        QueryWrapper<PaperPO> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("id").eq("name",paperVO.getName());
        List<PaperPO> sameNamePaperList = paperMapper.selectList(queryWrapper);
        if(sameNamePaperList.size()==0){
            return -1;
        }
        return sameNamePaperList.get(0).getId();
    }

    /**
     * 辅助方法 将持久化对象PO列表装配成视图对象VO列表
     * @return 返回VO对象的列表
     */
    public List<PaperVO> packagingPaperVOList(List<PaperPO> paperPOList){
        ArrayList<PaperVO> paperVOList=new ArrayList<>();
        for(PaperPO paperPO : paperPOList){
            PaperVO paperVO=new PaperVO();
            BeanUtils.copyProperties(paperPO,paperVO);
            int pid= paperPO.getId();
            List<String> paperTags= tagService.getTagsNameByPaper(pid);
            paperVO.setTags(paperTags);
            paperVOList.add(paperVO);
        }
        return paperVOList;
    }


}
