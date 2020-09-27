package com.manisha.khatabook.controllers;

import com.manisha.khatabook.dao.models.response.GetBalanceResponse;
import com.manisha.khatabook.dao.models.response.GetKhatabooksResponse;
import com.manisha.khatabook.managers.KhatabookManager;
import com.manisha.khatabook.models.Khatabook;
import com.manisha.khatabook.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KhatabookController {

    @Autowired
    KhatabookManager khatabookManager;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/khatabooks", method = RequestMethod.POST)
    public GetKhatabooksResponse getKhatabooks(@RequestBody User user) {

        try {
            return khatabookManager.getKhatabooks(user);
        } catch (Exception e) {
            System.out.println("Failed to add customer." + e.getStackTrace());
            e.printStackTrace();
        }
        return null;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/balance", method = RequestMethod.POST)
    public GetBalanceResponse getBalance(@RequestBody Khatabook khatabook){
        try{
            return khatabookManager.getBalance(khatabook);
        }catch(Exception e){
            System.out.println("Failed to get the balance."+e.getStackTrace());
            e.printStackTrace();
        }
        return null;
    }

}
