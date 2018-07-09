package com.smartdev.crm.service;

import com.smartdev.user.dao.repository.CustomerCampaignRepository;
import com.smartdev.user.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class CustomerCampaignServiceImpl implements CustomerCampaignService {

    private static final String PROSPECT = "Prospect";

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerCampaignRepository customerCampaignRepository;

    @Autowired
    StatusService statusService;

    @Autowired
    HistoryAdvisoryService historyAdvisoryService;

    @Override
    public List<CustomerCampaign> getCustomerCampaignsByCampaignId(Integer campaignId) {
        return customerCampaignRepository.findByCampaignByCampaignId_Id(campaignId);
    }

    @Override
    public CustomerCampaign getCustomerCampaignById(Integer id) {
        return customerCampaignRepository.findOne(id);
    }

    @Override
    @Transactional
    public void moveCustomerToCRM(Customer customer, User user,CustomerCampaign customerCampaign) {
        System.out.println("before");
        customerCampaign.setIsMoved(1);
        customerCampaignRepository.save(customerCampaign);
        Status status = statusService.findByName(PROSPECT);
        customer.setStatusByStatusId(status);
        customer.setUserBySeller(user);
        customerService.saveCustomer(customer);
        HistoryAdvisory historyAdvisory = new HistoryAdvisory();
        historyAdvisory.setStatusByStatusId(status);
        historyAdvisory.setCustomerByCustomerId(customer);
        historyAdvisory.setComment("Move Customer from campaign");
        Timestamp createdDate = new Timestamp(new Date().getTime());
        historyAdvisory.setDate(createdDate);
        historyAdvisoryService.save(historyAdvisory);
        System.out.println("after");
    }
}
