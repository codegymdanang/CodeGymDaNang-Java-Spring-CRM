package com.smartdev.crm.service;

import com.smartdev.crm.service.user.UserService;
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
import java.util.List;

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

    @Autowired
    UserService userService;

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
    public Customer findOneid(Integer id){
        return customerRepository.findOne(id);
    }

    @Override
    public List<Customer> findByUserBySellerAndIsDelete(User user, Integer isDelete) {
        return customerRepository.findByUserBySellerAndIsDelete(user, isDelete);
    }

    @Override
    public List<Customer> findCustomersByStatusId(Status status) {
        return customerRepository.findByStatusByStatusId(status);
    }

    @Override
    public List<Customer> findCustomersByProductType(Integer productType) {
        return customerRepository.findAllByProductType(productType);
    }

    @Override
    public List<Customer> findByProductTypeAndStatusByStatusId(Integer productType, Status statusId) {
        return customerRepository.findByProductTypeAndStatusByStatusId(productType,statusId);
    }


    @Override
    public List<Customer> findByNameContaining(String name) {
        return customerRepository.findByNameContaining(name);
    }

    @Override
    public List<Customer> findByCompanyContaining(String company) {
        return customerRepository.findByCompanyContaining(company);
    }

    @Override
    public List<Customer> findByMailContaining(String mail) {
        return customerRepository.findByMailContaining(mail);
    }

    @Override
    public List<Customer> findByUserBySeller(User user) {

        return customerRepository.findByUserBySeller(user);
    }

    @Override
    public List<Customer> checkOption(String option, String search) {
       List<Customer> customers = null;
        switch (option){
            case "Name":
                customers=findByNameContaining(search);
                break;

            case "Company":
                customers=findByCompanyContaining(search);
                break;
            case "Mail":
                customers= findByMailContaining(search);
                break;
            case "SellerName":
                User user = userService.getUserByUserName(search);
                customers= findByUserBySeller(user);
                break;

        }
        return customers;

    }

}
