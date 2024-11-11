package com.wazzups.springstartherep10.controllers;

import com.wazzups.springstartherep10.model.PaymentDetails;
import com.wazzups.springstartherep10.services.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PaymentController {
    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment")
    public ResponseEntity<?> makePayment() {
        PaymentDetails paymentDetails = paymentService.processPayment();

        return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .body(paymentDetails);
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> processPayment(@RequestBody PaymentDetails paymentDetails) {
        log.info("Processing payment details: {}", paymentDetails);

        return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .body(paymentDetails);
    }
}
