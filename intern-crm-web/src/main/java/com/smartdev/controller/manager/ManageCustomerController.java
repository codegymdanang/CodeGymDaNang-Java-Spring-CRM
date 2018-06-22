package com.smartdev.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/manager_crm")
public class ManageCustomerController {

    @RequestMapping(value = "/list-custom", method = RequestMethod.GET)
    public String listCustom(){
        return "list-custom-manage";
    }
    @RequestMapping(value = "addcustomer",method = RequestMethod.GET)
    public String addCustomer(){ return "addcustomer";}
}
