package com.savleen.paymentservice.service.paymentGateway;

import org.springframework.stereotype.Service;

@Service
public class paymentGatewaySelector {

    private RazorPay razorPay;
    private stripe stripe;

    public paymentGatewaySelector(RazorPay razorPay, stripe stripe){
      this.razorPay=razorPay;
      this.stripe=stripe;
    }
    public paymentGateway getPaymentGateway(){
        return razorPay;
    }
}
