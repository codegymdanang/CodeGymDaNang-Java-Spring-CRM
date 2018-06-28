package com.smartdev.crm.service;

import com.smartdev.user.entity.Status;

import java.util.List;

public interface StatusService {
    List<Status> getAll();
    Status findById(Integer id);
}
