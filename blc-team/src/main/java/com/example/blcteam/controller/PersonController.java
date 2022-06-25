package com.example.blcteam.controller;

import com.example.blcteam.service.PersonService;
import com.example.blcteam.vo.PersonVO;
import com.example.blcteam.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping(value = "/person")
    List<PersonVO> getPersonList(){
        return personService.getPersonList();
    }

    @PostMapping(value = "/person")
    ResponseVO addOrUpdatePerson(@RequestBody PersonVO personVO){

        if(personService.saveOrUpdate(personVO.getPersonPO())){
            return ResponseVO.buildSuccess();
        }
        else{
            return ResponseVO.buildFailure("更新成员失败");
        }
    }

    @DeleteMapping(value = "/person")
    ResponseVO removePerson(@RequestParam(value = "person_id")String personId){
        if(personService.removeById(personId)){
            return ResponseVO.buildSuccess();
        }else{
            return ResponseVO.buildFailure("删除成员失败");
        }
    }
}
