package com.wazzups.springstartherep15.controllers;

import com.wazzups.springstartherep15.models.Account;
import com.wazzups.springstartherep15.models.TransferRequest;
import com.wazzups.springstartherep15.services.AccountService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/account/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferRequest transferRequest) {
        accountService.transferMoney(transferRequest.getSenderId(), transferRequest.getReceiverId(), transferRequest.getAmount());
    }
}
