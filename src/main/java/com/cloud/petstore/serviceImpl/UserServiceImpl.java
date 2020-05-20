package com.cloud.petstore.serviceImpl;

import com.cloud.petstore.common.ResponseData;
import com.cloud.petstore.data.User;
import com.cloud.petstore.repository.UserRepository;
import com.cloud.petstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findUserByUserName(String userName) {
        User userDetails = userRepository.findUserByUserName(userName);
        return userDetails;
    }

    @Override
    public ResponseData saveUser(User user) {
        User dbUser = findUserByUserName(user.getUserName());
        if (dbUser != null) {
            return new ResponseData(HttpStatus.BAD_REQUEST.value(), "unknown", "Invalid username supplied");
        }
        userRepository.save(user);
        return new ResponseData(HttpStatus.OK.value(), "unknown", String.valueOf(user.getId()));
    }

    @Override
    public ResponseData updateUserByUserName(String userName, User user) {
        User dbUser = findUserByUserName(userName);
        if (dbUser != null) {
            user.setUserName(userName);
            user.setId(dbUser.getId());
            saveUser(user);
            ResponseData responseData = new ResponseData(HttpStatus.OK.value(), "unknown", String.valueOf(dbUser.getId()));
            return responseData;
        }
        return new ResponseData(HttpStatus.NOT_FOUND.value(), "unknown", "User not found");
    }

    @Override
    public ResponseData deleteUserByUserName(String userName) {
        User dbUser = findUserByUserName(userName);
        if (dbUser == null) {
            return new ResponseData(HttpStatus.BAD_REQUEST.value(), "unknown", "Invalid username supplied");
        }
        userRepository.delete(dbUser);
        return new ResponseData(HttpStatus.OK.value(), "unknown", userName);
    }

   /* @Override
    public ResponseData saveUserLoginDetail(String userName, String password) {
        if (userName != null) {
            return new ResponseData(HttpStatus.BAD_REQUEST.value(), "unknown", "Invalid username/password supplied");
        }
        userRepository.save(userName,password);
        return new ResponseData(HttpStatus.OK.value(), "unknown", userName);
    }*/
}
