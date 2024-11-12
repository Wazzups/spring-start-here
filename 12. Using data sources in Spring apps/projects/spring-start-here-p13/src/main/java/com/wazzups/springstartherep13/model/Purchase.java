package com.wazzups.springstartherep13.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Purchase {
    private int id;
    private String product;
    private BigDecimal price;
}
