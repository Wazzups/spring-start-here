package com.wazzups.springstartherep16.controller;

import com.wazzups.springstartherep16.entity.Account;
import com.wazzups.springstartherep16.services.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAccounts() {
        return transferService.getAccounts();
    }
}
