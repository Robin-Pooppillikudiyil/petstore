package com.cloud.petstore.repository;

import com.cloud.petstore.data.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {


    User findUserByUserName(String userName);

}

