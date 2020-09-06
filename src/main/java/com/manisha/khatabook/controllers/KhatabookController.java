package com.manisha.khatabook.controllers;

import com.manisha.khatabook.managers.KhatabookManager;
import com.manisha.khatabook.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KhatabookController {

    @Autowired
    KhatabookManager khatabookManager;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/khatabooks", method = RequestMethod.POST)
    public void getKhatabooksForUser(@RequestBody User user) {

        try {
//            khatabookManager.getKhatabookListOfUser(user);
        } catch (Exception e) {
            System.out.println("Failed to add customer." + e.getStackTrace());
            e.printStackTrace();
        }
    }
}
