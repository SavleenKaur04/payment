package com.savleen.paymentservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class razorPayWebhook {
    @PostMapping("/razorPayWebhook")
    public void paymentDone(@RequestBody Object obj ){
        System.out.println(obj);

        //update db payment here
    }
}
