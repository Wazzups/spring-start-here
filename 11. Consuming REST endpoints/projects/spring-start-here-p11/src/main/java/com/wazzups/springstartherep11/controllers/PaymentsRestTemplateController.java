package com.wazzups.springstartherep11.controllers;

import com.wazzups.springstartherep11.models.Payment;
import com.wazzups.springstartherep11.proxy.PaymentsRestTemplateProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsRestTemplateController {

    private final PaymentsRestTemplateProxy paymentsRestTemplateProxy;

    public PaymentsRestTemplateController(PaymentsRestTemplateProxy paymentsRestTemplateProxy) {
        this.paymentsRestTemplateProxy = paymentsRestTemplateProxy;
    }

    @PostMapping("/paymentv2")
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentsRestTemplateProxy.createPayment(payment);
    }

}
