package com.smartdev.user.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_name")
    @NotBlank(message = "Please fill out field")
    @Size(min = 6, message = "must more than 6 chars ")
    private String userName;

    @Column(name = "pass_word")
    @NotBlank(message = "Please fill out field")
    @Size(min =6,message = "must more than 6 chars")
    private String passWord;
    @Column(name = "isDelete")
    private Integer isDelete;

    public User(){

    }
    public User(String userName, String passWord, Integer isDelete){
        this.userName = userName;
        this.passWord = passWord;
        this.isDelete = isDelete;
    }

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

    @OneToOne(mappedBy = "userByUserName", fetch = FetchType.EAGER)
    private SellerDetail sellerDetailByUserName;

    public SellerDetail getSellerDetailByUserName() {
        return sellerDetailByUserName;
    }

    public void setSellerDetailByUserName(SellerDetail sellerDetailByUserName) {
        this.sellerDetailByUserName = sellerDetailByUserName;
    }

    @ManyToMany(fetch = FetchType.EAGER)
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
