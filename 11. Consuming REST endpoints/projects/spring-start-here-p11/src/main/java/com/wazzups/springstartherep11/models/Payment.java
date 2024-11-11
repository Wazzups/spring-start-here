package com.wazzups.springstartherep11.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Payment {
    private String paymentId;
    private double amount;
}
