package com.smartdev.crm.service;

import com.smartdev.user.entity.CustomerCampaign;

import java.util.List;

public interface CustomerCampaignService {
    public List<CustomerCampaign> getCustomerCampaignsByCampaignId(Integer campaignId);
}
