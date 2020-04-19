package com.cloud.petstore.controller;


import com.cloud.petstore.common.ResponseData;
import com.cloud.petstore.data.User;
import com.cloud.petstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * Get user by user name
     **/

    @GetMapping("/{userName}")
    public ResponseEntity<User> getUserByName(@PathVariable String userName) {
        User user = userService.findUserByUserName(userName);
        if (user != null) {
            return ResponseEntity.ok(user);
            //new ResponseEntity(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ResponseData> createUser(@RequestBody User user) {
        ResponseData responseData = userService.saveUser(user);
        return new ResponseEntity(responseData, HttpStatus.valueOf(responseData.getCode()));

    }
    /*@PostMapping("/createUsersWithListInput")
    public List<User> createUsersWithListInput(@ResponseBody User user){
        return userService.saveAllUser(user);;
    }*/

    @PutMapping("/{userName}")
    public ResponseEntity<ResponseData> updateUser(@PathVariable String userName, @RequestBody User user) {
        ResponseData responseData = userService.updateUserByUserName(userName, user);
        return new ResponseEntity(responseData, HttpStatus.valueOf(responseData.getCode()));
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<ResponseData> deleteUser(@PathVariable String userName) {
        ResponseData responseData = userService.deleteUserByUserName(userName);
        return new ResponseEntity(responseData, HttpStatus.valueOf(responseData.getCode()));

    }
}
