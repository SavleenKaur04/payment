package com.savleen.paymentservice.controller;

import com.savleen.paymentservice.inputDto.userInfo;
import com.savleen.paymentservice.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class paymentController {

    private PaymentService paymentService;

    public paymentController(PaymentService paymentService){

        this.paymentService=paymentService;
    }
    @PostMapping("/payments")
    public String initiatePayment(@RequestBody userInfo idto){

        return paymentService.generateLink();
    }
}
