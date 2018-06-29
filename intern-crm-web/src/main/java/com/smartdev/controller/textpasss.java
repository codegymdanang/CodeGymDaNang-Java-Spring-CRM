package com.smartdev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class textpasss {
    @Autowired
    private BCryptPasswordEncoder encoder;
    @RequestMapping(value="/test")
    @ResponseBody
    public String test(){
        return  encoder.encode("123");
    }

}