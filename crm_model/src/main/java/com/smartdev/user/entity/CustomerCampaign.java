package com.smartdev.user.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customer_campaign")
public class CustomerCampaign {
    private int id;
    private String name;
    private Integer age;
    private Integer phone;
    private String mail;
    private String facebook;
    private Integer statusId;
    private Integer productType;
    private String company;
    private Integer isMoved;
    private Campaign campaignByCampaignId;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Column(name = "isMoved")
    public Integer getIsMoved() {
        return isMoved;
    }

    public void setIsMoved(Integer isMoved) {
        this.isMoved = isMoved;
    }

    @ManyToOne
    @JoinColumn(name = "campaign_id", referencedColumnName = "id")
    public Campaign getCampaignByCampaignId() {
        return campaignByCampaignId;
    }

    public void setCampaignByCampaignId(Campaign campaignByCampaignId) {
        this.campaignByCampaignId = campaignByCampaignId;
    }
}
