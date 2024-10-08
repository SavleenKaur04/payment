package com.savleen.paymentservice.service.paymentGateway;
import com.razorpay.PaymentLink;
import org.json.JSONObject;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import org.springframework.stereotype.Service;

@Service
public class RazorPay implements paymentGateway{
    public String generateLink() {
        try {
            RazorpayClient razorpay = new RazorpayClient("rzp_test_HLmA3RjOzO4w6I", "OtTSutEEgcszYmPpSBtsBU4G");
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", 1000);
            paymentLinkRequest.put("currency", "INR");
            paymentLinkRequest.put("accept_partial", true);
            paymentLinkRequest.put("first_min_partial_amount", 100);
            paymentLinkRequest.put("expire_by",   1719259312);
            paymentLinkRequest.put("reference_id", "TS198900");
            paymentLinkRequest.put("description", "Payment for policy no #23456");
            JSONObject customer = new JSONObject();
            customer.put("name", "+919000090000");
            customer.put("contact", "Gaurav Kumar");
            customer.put("email", "gaurav.kumar@example.com");
            paymentLinkRequest.put("customer", customer);
            JSONObject notify = new JSONObject();
            notify.put("sms", true);
            notify.put("email", true);
            paymentLinkRequest.put("notify", notify);
            paymentLinkRequest.put("reminder_enable", true);
            JSONObject notes = new JSONObject();
            notes.put("policy_name", "Jeevan Bima");
            paymentLinkRequest.put("notes", notes);
            paymentLinkRequest.put("callback_url", "https://example-callback-url.com/");
            paymentLinkRequest.put("callback_method", "get");

            PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
            return payment.toString();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
}
