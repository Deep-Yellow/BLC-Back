package com.example.blcteam.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blcteam.mapper.PersonMapper;
import com.example.blcteam.po.PersonPO;
import com.example.blcteam.service.PersonService;
import com.example.blcteam.vo.PersonVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, PersonPO> implements PersonService {

    @Override
    public List<PersonVO> getPersonList() {
        return packagingPersonVOList(list());
    }

    private List<PersonVO> packagingPersonVOList(List<PersonPO> personPOList){
        ArrayList<PersonVO> res=new ArrayList<>();
        for(PersonPO personPO:personPOList){
            PersonVO personVO=new PersonVO(personPO);
            res.add(personVO);
        }
        return res;
    }
}
