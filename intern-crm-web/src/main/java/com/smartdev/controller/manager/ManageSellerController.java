package com.smartdev.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager_crm")
public class ManageSellerController {
    @RequestMapping(value="/list-seller")
    public String listSeller(){
        return "list-seller";
    }


}
