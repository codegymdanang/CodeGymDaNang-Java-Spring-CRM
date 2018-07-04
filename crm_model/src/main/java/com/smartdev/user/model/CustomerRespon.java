package com.smartdev.user.model;

import com.smartdev.user.entity.Customer;

public class CustomerRespon {
    private int id;
    private String name;
    private int age;
    private int phone;
    private String sellerName;
    private String statusName;
    private String productType;
    private String company;

    public CustomerRespon(Customer customer){
        this.id = customer.getId();
        this.name = customer.getName();
        this.age = customer.getAge();
        this.phone = customer.getPhone();
        this.sellerName = customer.getUserBySeller().getSellerDetailByUserName().getName();
        this.statusName = customer.getStatusByStatusId().getName();
        this.productType = customer.getProductType()==1 ? "ODD" : "OUT SOURCE";
        this.company = customer.getCompany();
    }
}
