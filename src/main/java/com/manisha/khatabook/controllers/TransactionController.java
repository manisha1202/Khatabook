package com.manisha.khatabook.controllers;

import com.manisha.khatabook.managers.TransactionsManager;
import com.manisha.khatabook.dao.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    @Autowired
    TransactionsManager transactionsManager;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/addTransaction", method = RequestMethod.POST)
    public void addTransaction(@RequestBody Transaction transaction) {
        try {
            transactionsManager.addTransaction(transaction);
        } catch (Exception e) {
            System.out.println("Failed to add transaction.");
            e.printStackTrace();
        }
    }
}
