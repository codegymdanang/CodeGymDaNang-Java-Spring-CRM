package com.smartdev.user.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {
    private String userName;
    private String passWord;
    private Integer isDelete;
    private Collection<Customer> customersByUserName;
    private SellerDetail sellerDetailByUserName;
    private Collection<UserRole> userRolesByUserName;

    @Id
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "pass_word")
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Basic
    @Column(name = "isDelete")
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (passWord != null ? !passWord.equals(user.passWord) : user.passWord != null) return false;
        if (isDelete != null ? !isDelete.equals(user.isDelete) : user.isDelete != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (passWord != null ? passWord.hashCode() : 0);
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userBySeller")
    public Collection<Customer> getCustomersByUserName() {
        return customersByUserName;
    }

    public void setCustomersByUserName(Collection<Customer> customersByUserName) {
        this.customersByUserName = customersByUserName;
    }

    @OneToOne(mappedBy = "userByUserName")
    public SellerDetail getSellerDetailByUserName() {
        return sellerDetailByUserName;
    }

    public void setSellerDetailByUserName(SellerDetail sellerDetailByUserName) {
        this.sellerDetailByUserName = sellerDetailByUserName;
    }

    @OneToMany(mappedBy = "userByUserName")
    public Collection<UserRole> getUserRolesByUserName() {
        return userRolesByUserName;
    }

    public void setUserRolesByUserName(Collection<UserRole> userRolesByUserName) {
        this.userRolesByUserName = userRolesByUserName;
    }
}
