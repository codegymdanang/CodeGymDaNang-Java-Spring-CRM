package com.smartdev.controller.manager;

import com.smartdev.crm.service.CampaignService;
import com.smartdev.crm.service.CustomerCampaignService;
import com.smartdev.crm.service.SellerDetailService;
import com.smartdev.crm.service.helper.Converter;
import com.smartdev.crm.service.user.UserService;
import com.smartdev.user.entity.*;
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
    UserService userService;

    @Autowired
    CampaignService campaignService;

    @Autowired
    CustomerCampaignService customerCampaignService;

    @Autowired
    SellerDetailService sellerDetailService;

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
    @RequestMapping(value = "/search_campaign", method = RequestMethod.GET)
    public String search( @RequestParam(value="key" , required = false) String key, @RequestParam(value="month" , required = false) String month,Model model){
        System.out.println("month111:" + month);
        System.out.println("key" + key);

        if(month.equals("")) {
            List<Campaign> campaigns = campaignService.findByNameContaining(key);
            model.addAttribute("campaigns",campaigns );
        }
        if(key.equals("")) {
            int month1 = Integer.valueOf(month);
            List<Campaign> campaigns = campaignService.findByDateEnd_MonthOrAndDateStart_Month(month1, month1);
            model.addAttribute("campaigns",campaigns );
        }
        if(!key.equals("") && !(month.equals(""))) {
            int month1 = Integer.valueOf(month);
            List<Campaign> campaigns = campaignService.findByDateMonAndName(month1, month1, key);
            model.addAttribute("campaigns",campaigns );
        }
        return "campaign-manager";
    }
    @RequestMapping(value = "/campaign-customer", method = RequestMethod.GET)
    public String getCampaignCustomer(Model model,@RequestParam(value = "campaignId") Integer campainId,
                                      @RequestParam(value ="error",required = false) String error){
        if(error!=null){
            model.addAttribute("error","Please choose seller before move");
        }
        List<CustomerCampaign> customerCampaigns = customerCampaignService.getCustomerCampaignsByCampaignId(campainId);
        List<SellerDetail> sellerDetails = sellerDetailService.getAllSellerDetail();
        model.addAttribute("customers",customerCampaigns);
        model.addAttribute("sellers",sellerDetails);
        return "campaign-customer";
    }

    @RequestMapping(value = "/campaign-customer", method = RequestMethod.POST)
    public String moveCampaignCustomer(Model model,@RequestParam("customerId") int customerId, @RequestParam("seller") String userName){

        CustomerCampaign customerCampaign = customerCampaignService.getCustomerCampaignById(customerId);
        String redirect = "redirect:/manager_crm/campaign-customer?campaignId="+customerCampaign.getCampaignByCampaignId().getId();

        if(userName.equals("")){
            model.addAttribute("error","have");
            return redirect;
        }
        Customer customer = Converter.convertCustomerCampaignToCustomer(customerCampaign);
        System.out.println("cutomer  "+ customer.getName());
        User user = userService.getUserByUserName(userName);
        System.out.println("User  "+ user.getPassWord());
        customerCampaignService.moveCustomerToCRM(customer,user,customerCampaign);
        return redirect;
    }
}
