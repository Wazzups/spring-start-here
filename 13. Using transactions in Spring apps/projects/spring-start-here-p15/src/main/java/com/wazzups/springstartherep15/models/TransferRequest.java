package com.wazzups.springstartherep15.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferRequest {

    private Long senderId;
    private Long receiverId;
    private Double amount;
}
