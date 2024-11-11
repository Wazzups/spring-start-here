package com.wazzups.springstartherep11.controllers;

import com.wazzups.springstartherep11.models.Payment;
import com.wazzups.springstartherep11.proxy.PaymentsProxy;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PaymentsController {

    private final PaymentsProxy paymentsProxy;

    public PaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/payment")
    public Payment createPayment(@RequestHeader String requestId, @RequestBody Payment payment) {
        log.info("Creating payment {}", payment);

        payment.setPaymentId(UUID.randomUUID().toString());

        return paymentsProxy.createPayment(requestId, payment);
    }

}
