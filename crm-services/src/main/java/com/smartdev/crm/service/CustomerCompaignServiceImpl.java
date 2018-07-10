package com.smartdev.crm.service;

import com.smartdev.user.dao.repository.CustomerCompaignRepository;
import com.smartdev.user.entity.Campaign;
import com.smartdev.user.entity.CustomerCampaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerCompaignServiceImpl implements CustomerCompaignService {

    @Autowired
    CustomerCompaignRepository repository;

    @Override
    public void save(CustomerCampaign customerCampaign) {
        repository.save(customerCampaign);
    }

    @Override
    public void save(List<CustomerCampaign> customerCampaigns, Campaign campaign) {
        for (CustomerCampaign customer : customerCampaigns) {
            customer.setCampaignByCampaignId(campaign);
            customer.setIsMoved(0);
            save(customer);
        }
    }
}
