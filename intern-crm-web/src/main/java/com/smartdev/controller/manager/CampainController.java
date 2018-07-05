package com.smartdev.controller.manager;

import com.smartdev.crm.service.CampaignService;
import com.smartdev.user.entity.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/manager_crm")
public class CampainController {

    @Autowired
    CampaignService campaignService;


    @RequestMapping(value = "/campain", method = RequestMethod.GET)
    public String getCampain(){
        return "campain";
    }
    @RequestMapping(value = "/campain-manager", method = RequestMethod.GET)
    public String getCampainManager(Model model){
        List<Campaign> campaigns = campaignService.getAll();
        model.addAttribute("campaigns",campaigns );
        return "campain-manager";
    }
    @RequestMapping(value = "/campain-customer", method = RequestMethod.GET)
    public String getCampainCustomer(){
        return "campain-customer";
    }
}
