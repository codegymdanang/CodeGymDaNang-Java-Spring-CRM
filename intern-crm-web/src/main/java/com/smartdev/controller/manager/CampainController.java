package com.smartdev.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/manager_crm")
public class CampainController {
    @RequestMapping(value = "/campain", method = RequestMethod.GET)
    public String getCampain(){
        return "campain";
    }
    @RequestMapping(value = "/campain-manager", method = RequestMethod.GET)
    public String getCampainManager(){
        return "campain-manager";
    }
    @RequestMapping(value = "/campain-customer", method = RequestMethod.GET)
    public String getCampainCustomer(){
        return "campain-customer";
    }
}
