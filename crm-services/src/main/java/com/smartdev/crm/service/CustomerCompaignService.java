package com.smartdev.crm.service;

import com.smartdev.user.entity.CustomerCampaign;

import java.util.List;

public interface CustomerCompaignService {
    void save(CustomerCampaign customerCampaign);
    void save(List<CustomerCampaign> customerCampaigns);
}
