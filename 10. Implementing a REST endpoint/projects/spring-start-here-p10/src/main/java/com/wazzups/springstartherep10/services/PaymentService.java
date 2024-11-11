package com.wazzups.springstartherep10.services;

import com.wazzups.springstartherep10.exceptions.NotEnoughMoneyException;
import com.wazzups.springstartherep10.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
