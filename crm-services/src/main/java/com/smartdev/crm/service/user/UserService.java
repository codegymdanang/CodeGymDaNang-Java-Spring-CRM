package com.smartdev.crm.service.user;

import com.smartdev.user.entity.User;

public interface UserService {
    public void save(User user, String roleName);
}
