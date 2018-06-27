package com.smartdev.user.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
public class Customer {
    private Integer id;
    @NotEmpty(message = "Name is required")
    private String name;
    @NotNull(message = "Age is required")
    @Min(18) @Max(100)
    private Integer age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != null ? !id.equals(customer.id) : customer.id != null) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (age != null ? !age.equals(customer.age) : customer.age != null) return false;
        if (phone != null ? !phone.equals(customer.phone) : customer.phone != null) return false;
        if (mail != null ? !mail.equals(customer.mail) : customer.mail != null) return false;
        if (facebook != null ? !facebook.equals(customer.facebook) : customer.facebook != null) return false;
        if (productType != null ? !productType.equals(customer.productType) : customer.productType != null)
            return false;
        if (company != null ? !company.equals(customer.company) : customer.company != null) return false;
        if (isDelete != null ? !isDelete.equals(customer.isDelete) : customer.isDelete != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (facebook != null ? facebook.hashCode() : 0);
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        return result;
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
    public Collection<HistoryAdvisory> getHistoryAdvisoriesById(Integer id) {
        return historyAdvisoriesById;
    }

    public void setHistoryAdvisoriesById(Collection<HistoryAdvisory> historyAdvisoriesById) {
        this.historyAdvisoriesById = historyAdvisoriesById;
    }
}
