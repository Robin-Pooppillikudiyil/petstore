package com.cloud.petstore.service;

import com.cloud.petstore.common.ResponseData;
import com.cloud.petstore.data.User;

public interface UserService {


    User findUserByUserName(String userName);

    ResponseData saveUser(User user);

    //List<User> saveAllUser(User user);

    ResponseData updateUserByUserName(String userName, User user);

    ResponseData deleteUserByUserName(String userName);
}
