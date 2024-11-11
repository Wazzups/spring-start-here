package com.wazzups.sprintstartherep12.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Payment {
    private String paymentId;
    private String amount;
}
