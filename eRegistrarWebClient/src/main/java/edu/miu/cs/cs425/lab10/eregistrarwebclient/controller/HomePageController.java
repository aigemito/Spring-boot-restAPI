package edu.miu.cs.cs425.lab10.eregistrarwebclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping(value={"/","/home","/index","/eRegistrar/home"})
    public String showHomePage(){
        return "home/index";
    }

}
