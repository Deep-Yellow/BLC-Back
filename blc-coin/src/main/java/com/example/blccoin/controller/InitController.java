package com.example.blccoin.controller;


import com.example.blccoin.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InitController {

    @Autowired
    InitService initService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayhello(){
        return "hello";
    }

    @PostMapping(value = "/initgraph")
    public String initGraph(@RequestParam("code") String s){
        if(s.equals("init")){
            initService.InitPaperTable();
            return "初始化成功";
        }
        return "初始化失败";
    }

}
