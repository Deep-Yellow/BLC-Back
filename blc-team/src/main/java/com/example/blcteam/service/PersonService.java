package com.example.blcteam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blcteam.po.PersonPO;
import com.example.blcteam.vo.PersonVO;

import java.util.List;

public interface PersonService extends IService<PersonPO> {
    List<PersonVO> getPersonList();
}
