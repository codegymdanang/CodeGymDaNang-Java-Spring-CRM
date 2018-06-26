package com.smartdev.user.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_name")
    private String userName;
    @Column(name = "pass_word")
    private String passWord;
    @Column(name = "isDelete")
    private Integer isDelete;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @OneToMany(mappedBy = "userBySeller")
    private Collection<Customer> customersByUserName;

    public Collection<Customer> getCustomersByUserName() {
        return customersByUserName;
    }

    public void setCustomersByUserName(Collection<Customer> customersByUserName) {
        this.customersByUserName = customersByUserName;
    }

    @OneToOne(mappedBy = "userByUserName")
    private SellerDetail sellerDetailByUserName;

    public SellerDetail getSellerDetailByUserName() {
        return sellerDetailByUserName;
    }

    public void setSellerDetailByUserName(SellerDetail sellerDetailByUserName) {
        this.sellerDetailByUserName = sellerDetailByUserName;
    }

    @ManyToMany
    @JoinTable(name="user_role",
            joinColumns = @JoinColumn(name = "user_name"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

}
