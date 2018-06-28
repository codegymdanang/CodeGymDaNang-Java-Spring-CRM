package com.smartdev.crm.service;

import com.smartdev.user.entity.Customer;
import com.smartdev.user.entity.HistoryAdvisory;

public interface CustomerService {
    void saveCustomer(Customer customer);
    void addCustomer(Customer customer);
    Customer getCustomerById(Integer theId);
    Customer afindOneid(Integer id);
}
