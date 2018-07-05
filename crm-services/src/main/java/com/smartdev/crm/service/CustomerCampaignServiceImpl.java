package com.smartdev.crm.service;

import com.smartdev.user.dao.repository.CustomerCampaignRepository;
import com.smartdev.user.entity.CustomerCampaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerCampaignServiceImpl implements CustomerCampaignService {

    @Autowired
    CustomerCampaignRepository customerCampaignRepository;

    @Override
    public List<CustomerCampaign> getCustomerCampaignsByCampaignId(Integer campaignId) {
        return customerCampaignRepository.findByCampaignByCampaignId_Id(campaignId);
    }
}
