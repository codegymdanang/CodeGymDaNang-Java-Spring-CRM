package com.smartdev.crm.service;

import com.smartdev.user.dao.repository.CustomerRepository;
import com.smartdev.user.entity.Customer;
import com.smartdev.user.entity.HistoryAdvisory;
import com.smartdev.user.entity.Status;
import com.smartdev.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final String PROSPECT = "Prospect";

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    SellerDetailService sellerDetailService;

    @Autowired
    StatusService statusService;

    @Autowired
    HistoryAdvisoryService historyAdvisoryService;

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void addCustomer(Customer customer) {
        customer.setIsDelete(0);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = sellerDetailService.findByUsername(username).getUserByUserName();
        Status status = statusService.findByName(PROSPECT);
        customer.setStatusByStatusId(status);
        customer.setUserBySeller(user);
        saveCustomer(customer);
        HistoryAdvisory historyAdvisory = new HistoryAdvisory();
        historyAdvisory.setStatusByStatusId(status);
        historyAdvisory.setCustomerByCustomerId(customer);
        historyAdvisory.setComment("New Customer");
        Timestamp createdDate = new Timestamp(new Date().getTime());
        historyAdvisory.setDate(createdDate);
        historyAdvisoryService.save(historyAdvisory);
    }
    @Override
    public Customer afindOneid(Integer id){
        return customerRepository.findOne(id);
    }
}
