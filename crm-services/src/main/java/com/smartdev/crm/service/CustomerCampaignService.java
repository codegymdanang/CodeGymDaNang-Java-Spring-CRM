package com.smartdev.crm.service;

import com.smartdev.user.entity.Customer;
import com.smartdev.user.entity.CustomerCampaign;
import com.smartdev.user.entity.User;

import java.util.List;

public interface CustomerCampaignService {
    public List<CustomerCampaign> getCustomerCampaignsByCampaignId(Integer campaignId);
    public CustomerCampaign getCustomerCampaignById(Integer id);
    public void moveCustomerToCRM(Customer customer, User user,CustomerCampaign customerCampaign);

}
