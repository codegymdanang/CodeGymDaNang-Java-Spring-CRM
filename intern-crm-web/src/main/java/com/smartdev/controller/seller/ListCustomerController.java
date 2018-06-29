package com.smartdev.controller.seller;

import com.smartdev.crm.service.HistoryAdvisoryService;
import com.smartdev.crm.service.ListCustomManageService;
import com.smartdev.crm.service.StatusService;
import com.smartdev.user.entity.Customer;
import com.smartdev.crm.service.CustomerService;
import com.smartdev.user.entity.HistoryAdvisory;
import com.smartdev.user.entity.HistoryTest;
import com.smartdev.user.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/seller")
public class ListCustomerController {

    @Autowired
    ListCustomManageService listCustomManageService;
    @Autowired
    CustomerService customerService;
    @Autowired
    HistoryAdvisoryService historyAdvisoryService;

    @Autowired
    StatusService statusService;

    @RequestMapping(value = "/list-custom", method = RequestMethod.GET)
    public String listCustom(Model model){
        List<Customer> customerList = listCustomManageService.listAllCustomer();
        model.addAttribute("list",customerList);
        return "list-custom";
    }

    @RequestMapping(value = "/advisory", method = RequestMethod.GET)
    public ModelAndView advisory(@RequestParam("customer") Integer theId){
        Customer customer = customerService.afindOneid(theId);
        List<HistoryAdvisory> historyAdvisories= historyAdvisoryService.getHistoryAdvisoriesByCustomer(customer);
        ModelAndView modelAndView = new ModelAndView("advisory");
        modelAndView.addObject("getItemCustomer",customer);
        modelAndView.addObject("historyAdvisories",historyAdvisories);


        //create new historytest
        HistoryTest historyTest = new HistoryTest();

        //get time now
        Timestamp currentDate = new Timestamp(new Date().getTime());

        //set time now to object
        historyTest.setDate(currentDate);

        //set customerId to object
        historyTest.setCustomerId(theId);

        //get all status
        List<Status> statuses = statusService.findAll();
        modelAndView.addObject("listStatus",statuses );

        System.out.println("hhhhh"+historyTest.getStatus());

        //send object to view
        modelAndView.addObject("history",historyTest );



        return modelAndView;
    }

    @RequestMapping(value = "/saveHistoryAdvisory", method = RequestMethod.POST)
    public String saveHistoryAdvisory(@ModelAttribute("history") HistoryTest historyTest) {
        //create new HistoryAdvisory
        HistoryAdvisory historyAdvisory = new HistoryAdvisory();

        //get value status
        Status status = statusService.findById(historyTest.getStatus());

        //set status to historyAdvisory
        historyAdvisory.setStatusByStatusId(status);

        //set date to historyAdvisory
        historyAdvisory.setDate(historyTest.getDate());

        //set comment to historyAdvisory
        historyAdvisory.setComment(historyTest.getComment());

        //get id of customer and set status of customer
        Customer customer = customerService.afindOneid(historyTest.getCustomerId());
        historyAdvisory.setCustomerByCustomerId(customer);
        customer.setStatusByStatusId(status);

        //save data historyAdvisor
        historyAdvisoryService.saveHistoryAdvisory(historyAdvisory);

        //save status customer
        customerService.saveCustomer(customer);

        historyAdvisory.toString();
        return "redirect:/seller/list-custom";
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
        customerService.addCustomer(customer);
        return "redirect:/seller/list-custom";
    }
}
