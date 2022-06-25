package com.example.blcteam.serviceImpl;

import com.example.blcteam.mapper.PersonMapper;
import com.example.blcteam.po.PersonPO;


import com.example.blcteam.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    PersonMapper personMapper;

    @Autowired
    PersonService personService;

    @Test
    public void test(){
        System.out.println(personService.getPersonList());
    }

    @Test
    @Transactional
    public void testAdd(){
        PersonPO personPO=new PersonPO(null,1,"123","123","123");
        personService.save(personPO);
        PersonPO personPO2=new PersonPO(null,1,"123","123","123");
        personService.save(personPO2);
        System.out.println(personService.list());
    }


}