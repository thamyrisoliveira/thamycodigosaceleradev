package com.challenge.endpoints;


import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "user")

public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    public User findById(@PathVariable Long userId){
        return userService.findById(userId).orElse(null);
    }

    @GetMapping(params = "accelerationName")
    public List<User> findByAccelerationName(@RequestParam String accelerationName){
        return userService.findByAccelerationName(accelerationName);
    }

    @GetMapping(params = "companyId")
    public List<User> findByCompanyId(@RequestParam Long companyId){
        return userService.findByCompanyId(companyId);
    }
}
