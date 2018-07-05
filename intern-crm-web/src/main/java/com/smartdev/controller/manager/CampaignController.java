package com.smartdev.controller.manager;

import com.smartdev.crm.service.CampaignService;
import com.smartdev.crm.service.CustomerCampaignService;
import com.smartdev.user.entity.Campaign;
import com.smartdev.user.entity.CustomerCampaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/manager_crm")
public class CampaignController {

    @Autowired
    CampaignService campaignService;

    @Autowired
    CustomerCampaignService customerCampaignService;


    @RequestMapping(value = "/campaign", method = RequestMethod.GET)
    public String getCampaign(){
        return "campaign";
    }
    @RequestMapping(value = "/campaign-manager", method = RequestMethod.GET)
    public String getCampaignManager(Model model){
        List<Campaign> campaigns = campaignService.getAll();
        model.addAttribute("campaigns",campaigns );
        return "campaign-manager";
    }
    @RequestMapping(value = "/campaign-customer", method = RequestMethod.GET)
    public String getCampaignCustomer(Model model,@RequestParam(value = "campaignId") Integer campainId){

        List<CustomerCampaign> customerCampaigns = customerCampaignService.getCustomerCampaignsByCampaignId(campainId);

        model.addAttribute("customers",customerCampaigns);

        return "campaign-customer";
    }
}
