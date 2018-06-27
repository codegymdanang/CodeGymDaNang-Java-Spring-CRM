package com.smartdev.crm.service;

import com.smartdev.user.entity.Customer;
import com.smartdev.user.entity.HistoryAdvisory;
import com.smartdev.user.model.StatusCount;

import java.util.List;

public interface HistoryAdvisoryService {
//    List<HistoryAdvisory> findAll();
//
//    StatusCount getNumberOfEachStatus();

    public  List<HistoryAdvisory> getHistoryAdvisoriesByCustomer(Customer customer);
}
