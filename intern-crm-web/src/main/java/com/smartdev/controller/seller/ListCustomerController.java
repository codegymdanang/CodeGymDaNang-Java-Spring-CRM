package com.smartdev.controller.seller;

import com.smartdev.user.entity.Customer;
import org.crm.services.service.ListCustomManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/seller")
public class ListCustomerController {

    @Autowired
    ListCustomManageService listCustomManageService;


    @RequestMapping(value = "/list-custom", method = RequestMethod.GET)
    public String listCustom(Model model){
        List<Customer> customerList = listCustomManageService.listAllCustomer();
        model.addAttribute("list",customerList);
        return "list-custom";
    }
    @RequestMapping(value = "addcustomer",method = RequestMethod.GET)
    public String addCustomer(){ return "addcustomer";}
}
