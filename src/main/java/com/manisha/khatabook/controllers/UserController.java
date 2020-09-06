package com.manisha.khatabook.controllers;

import com.manisha.khatabook.managers.UserAuthManager;
import com.manisha.khatabook.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserAuthManager userAuthManager;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/register")
    public void registerUser(@RequestBody User user) {
        try {
            userAuthManager.registerUser(user);
        } catch (Exception e) {
            System.out.println("Failed to save." + e.getStackTrace());
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody User user) {
        try {
            return userAuthManager.login(user);
        } catch (Exception e) {
            System.out.println("Failed to login." + e.getStackTrace());
            e.printStackTrace();
        }
        return null;
    }
}
