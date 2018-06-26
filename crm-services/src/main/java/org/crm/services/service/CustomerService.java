package org.crm.services.service;

import com.smartdev.user.entity.Customer;

public interface CustomerService {
    void saveCustomer(Customer customer);
    void addCustomer(Customer customer);
}
