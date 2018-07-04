package com.smartdev.controller.manager;

import com.smartdev.crm.service.CustomerService;
import com.smartdev.crm.service.StatusService;
import com.smartdev.user.entity.Customer;
import com.smartdev.crm.service.ListCustomManageService;
import com.smartdev.user.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/manager_crm")
public class ManageCustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    StatusService statusService;
    @Autowired
    ListCustomManageService listCustomManageService;

    @RequestMapping(value = "/list-custom", method = RequestMethod.GET)
    public String listCustom(Model model, @RequestParam Integer statusId, @RequestParam Integer productType){
        List<Customer> customerList = new ArrayList<>();
        if(statusId == 0 && productType == 0) {
            customerList = listCustomManageService.listAllCustomer();
        }else{
            if(statusId == 0){
                customerList = customerService.findCustomersByProductType(productType);
            }else{
                Status status = statusService.findById(statusId);
                if(productType == 0){
                    customerList = customerService.findCustomersByStatusId(status);
                }else {
                    customerList = customerService.findByProductTypeAndStatusByStatusId(productType, status);
                }
            }
        }
        model.addAttribute("list",customerList);
        return "list-custom-manage";
    }
    @RequestMapping(value = "addcustomer",method = RequestMethod.GET)
    public String addCustomer(){ return "addcustomer";}
}
