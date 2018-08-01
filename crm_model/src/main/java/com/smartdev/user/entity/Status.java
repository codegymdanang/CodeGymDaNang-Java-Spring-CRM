package com.smartdev.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @OneToMany(mappedBy = "statusByStatusId")
//    private Collection<Customer> customersById;
//
//    public Collection<Customer> getCustomersById() {
//        return customersById;
//    }
//
//    public void setCustomersById(Collection<Customer> customersById) {
//        this.customersById = customersById;
//    }

    @OneToMany(mappedBy = "statusByStatusId")
    @JsonIgnore
    private Collection<HistoryAdvisory> historyAdvisoriesById;

    public Collection<HistoryAdvisory> getHistoryAdvisoriesById() {
        return historyAdvisoriesById;
    }

    public void setHistoryAdvisoriesById(Collection<HistoryAdvisory> historyAdvisoriesById) {
        this.historyAdvisoriesById = historyAdvisoriesById;
    }
}
