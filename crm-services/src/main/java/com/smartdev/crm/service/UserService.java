package com.smartdev.crm.service;

import com.smartdev.user.entity.User;

public interface UserService {
    public boolean isUserExist(String userName) ;

    public void save(User user);

}
