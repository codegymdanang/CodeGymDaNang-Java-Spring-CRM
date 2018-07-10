package com.smartdev.crm.service.helper;

import com.smartdev.user.entity.Customer;
import com.smartdev.user.entity.CustomerCampaign;

public class Converter {
    public static Customer convertCustomerCampaignToCustomer(CustomerCampaign customerCampaign){
        Customer customer = new Customer();
        customer.setAge(customerCampaign.getAge());
        customer.setCompany(customerCampaign.getCompany());
        customer.setPhone(customerCampaign.getPhone());
        customer.setMail(customerCampaign.getMail());
        customer.setName(customerCampaign.getName());
        customer.setFacebook(customerCampaign.getFacebook());
        customer.setProductType(customerCampaign.getProductType());
        customer.setIsDelete(0);
        return customer;
    }
}
