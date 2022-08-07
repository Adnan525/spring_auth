package com.pro.testapp.user;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

//controller needs to be part of the same package as the main class
@RestController
public class UserController {

    //in memory com.pro.testapp.user list
    private static List<User> users = Arrays.asList(
            new User(1, "adnaan525@gmail.com"),
            new User(2, "adnaan525@yahoo.com"),
            new User(3, "u3234602@uni.canberra.edu.au")
    );

    @RequestMapping("/{userID}")
    public User getUser(@PathVariable("userID") Integer userID)
    {
        return users.stream()
                .filter(user -> user.getId().equals(userID))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("User with ID: " + userID+ " not found"));
    }
}
