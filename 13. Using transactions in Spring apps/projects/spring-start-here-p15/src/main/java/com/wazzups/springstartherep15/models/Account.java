package com.wazzups.springstartherep15.models;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Account {

    private long id;
    private String name;
    private BigDecimal amount;
}
