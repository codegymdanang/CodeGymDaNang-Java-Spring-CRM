package com.smartdev.user.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Customer {
    private int id;
    private String name;
    private Integer age;
    private Integer phone;
    private String mail;
    private String facebook;
    private Integer statusId;
    private Integer productType;
    private String company;
    private String seller;
    private Integer isDelete;
    private Status statusByStatusId;
    private User userBySeller;
    private Collection<HistoryAdvisory> historyAdvisoriesById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "phone")
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "facebook")
    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    @Basic
    @Column(name = "status_id")
    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "product_type")
    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    @Basic
    @Column(name = "company")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "seller")
    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
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
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equals(name, customer.name) &&
                Objects.equals(age, customer.age) &&
                Objects.equals(phone, customer.phone) &&
                Objects.equals(mail, customer.mail) &&
                Objects.equals(facebook, customer.facebook) &&
                Objects.equals(statusId, customer.statusId) &&
                Objects.equals(productType, customer.productType) &&
                Objects.equals(company, customer.company) &&
                Objects.equals(seller, customer.seller) &&
                Objects.equals(isDelete, customer.isDelete);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, age, phone, mail, facebook, statusId, productType, company, seller, isDelete);
    }

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    public Status getStatusByStatusId() {
        return statusByStatusId;
    }

    public void setStatusByStatusId(Status statusByStatusId) {
        this.statusByStatusId = statusByStatusId;
    }

    @ManyToOne
    @JoinColumn(name = "seller", referencedColumnName = "user_name")
    public User getUserBySeller() {
        return userBySeller;
    }

    public void setUserBySeller(User userBySeller) {
        this.userBySeller = userBySeller;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<HistoryAdvisory> getHistoryAdvisoriesById() {
        return historyAdvisoriesById;
    }

    public void setHistoryAdvisoriesById(Collection<HistoryAdvisory> historyAdvisoriesById) {
        this.historyAdvisoriesById = historyAdvisoriesById;
    }
}
