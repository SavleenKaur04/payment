package com.savleen.paymentservice.service;

import com.savleen.paymentservice.service.paymentGateway.paymentGateway;
import com.savleen.paymentservice.service.paymentGateway.paymentGatewaySelector;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private paymentGatewaySelector paymentGatewaySelector;
    public PaymentService(paymentGatewaySelector paymentGatewaySelector){
        this.paymentGatewaySelector=paymentGatewaySelector;
    }
    public String generateLink(){
        //add details in db

        return paymentGatewaySelector.getPaymentGateway().generateLink();
    }
}
