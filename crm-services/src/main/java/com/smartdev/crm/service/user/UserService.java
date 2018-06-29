package com.smartdev.crm.service.user;

import com.smartdev.user.entity.User;

public interface UserService {
    public User getUserByUserName(String userName);

    public boolean isUserExist(String userName) ;

    public void save(User user, String roleName);

}
