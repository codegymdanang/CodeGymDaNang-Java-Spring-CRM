package com.smartdev.controller.seller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/seller")
public class ListCustomerController {


    @RequestMapping(value = "/list-custom", method = RequestMethod.GET)
    public String listCustom(){
        return "list-custom";
    }
}
