package com.smartdev.user.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "campaign")
public class Campaign {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "date_start")
    private Timestamp dateStart;
    @Column(name = "date_end")
    private Timestamp dateEnd;
    @OneToMany(mappedBy = "campaignByCampaignId")
    private Collection<CustomerCampaign> customerCampaignsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDateStart() {
        return dateStart;
    }

    public void setDateStart(Timestamp dateStart) {
        this.dateStart = dateStart;
    }

    public Timestamp getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Collection<CustomerCampaign> getCustomerCampaignsById() {
        return customerCampaignsById;
    }

    public void setCustomerCampaignsById(Collection<CustomerCampaign> customerCampaignsById) {
        this.customerCampaignsById = customerCampaignsById;
    }
}
