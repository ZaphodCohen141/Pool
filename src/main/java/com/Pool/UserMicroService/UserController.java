package com.Pool.UserMicroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userId")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public User getUserById(@RequestParam Integer userId){
        return userService.getUser(userId);
    }
}
