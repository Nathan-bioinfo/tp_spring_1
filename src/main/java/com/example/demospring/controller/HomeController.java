package com.example.demospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HomeController {

    @RequestMapping("/")
    public String getHome(){
        return("Hello world");
    }

    @RequestMapping("/toto")
    public String getToto(){
        return("Hello toto");
    }

    @GetMapping("/get")
    public String pageGet(){
        return("Une page get");
    }

    @PostMapping("/post")
    public String pagePost(){
        return("Une page post");
    }

}
