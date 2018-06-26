package com.smartdev.controller.seller;

import com.smartdev.user.entity.Customer;
import org.crm.services.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/seller")
public class ListCustomerController {


    @Qualifier("CustomerServiceImpl")
    CustomerService customerService;

    @RequestMapping(value = "/list-custom", method = RequestMethod.GET)
    public String listCustom(){
        return "list-custom";
    }

    @RequestMapping(value = "/addcustomer",method = RequestMethod.GET)
    public ModelAndView addCustomer(){
        ModelAndView modelAndView = new ModelAndView("addcustomer");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
    public String handleAddCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult result) {
        if(result.hasErrors()) {
            return "addcustomer";
        }
        return "redirect:/seller/list-custom";
    }
}
