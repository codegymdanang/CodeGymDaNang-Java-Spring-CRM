package com.smartdev.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "customer")
public class Customer {
    private Integer id;
    @NotEmpty(message = "Name is required")
    private String name;
    @NotNull(message = "Age is required")
    @Min(18) @Max(100)
    private Integer age;
    @NotNull(message = "Phone is required")
    private Integer phone;
    @Email
    @NotEmpty(message = "Email is required")
    private String mail;
    @NotEmpty(message = "Facebook is required")
    private String facebook;
    @NotNull(message = "Product type is required")
    private Integer productType;
    @NotEmpty(message = "Company is required")
    private String company;
    private Integer isDelete;
    private Status statusByStatusId;
    @JsonIgnore
    private User userBySeller;
    private Collection<HistoryAdvisory> historyAdvisoriesById;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    @Column(name = "isDelete")
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    public Status getStatusByStatusId() {
        return statusByStatusId;
    }

    public void setStatusByStatusId(Status statusByStatusId) {
        this.statusByStatusId = statusByStatusId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seller", referencedColumnName = "user_name")
    public User getUserBySeller() {
        return userBySeller;
    }

    public void setUserBySeller(User userBySeller) {
        this.userBySeller = userBySeller;
    }

    @OneToMany(mappedBy = "customerByCustomerId", fetch = FetchType.EAGER)
    public Collection<HistoryAdvisory> getHistoryAdvisoriesById(Integer id) {
        return historyAdvisoriesById;
    }

    public void setHistoryAdvisoriesById(Collection<HistoryAdvisory> historyAdvisoriesById) {
        this.historyAdvisoriesById = historyAdvisoriesById;
    }
}
