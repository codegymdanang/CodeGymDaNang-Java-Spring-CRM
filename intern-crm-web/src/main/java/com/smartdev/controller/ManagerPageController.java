package com.smartdev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ManagerPageController {
    @RequestMapping(value="/manage-seller",method = RequestMethod.GET)
    public String manageSeller (){
        return "seller-manager";
    }
}
