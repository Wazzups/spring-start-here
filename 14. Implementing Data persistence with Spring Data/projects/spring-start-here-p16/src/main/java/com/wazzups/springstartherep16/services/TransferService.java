package com.wazzups.springstartherep16.services;

import com.wazzups.springstartherep16.entity.Account;
import com.wazzups.springstartherep16.exception.AccountNotFoundException;
import com.wazzups.springstartherep16.repositories.AccountRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(Long senderId, Long receiverId, BigDecimal amount) {
        Account senderAccount = accountRepository.findById(senderId).orElseThrow(AccountNotFoundException::new);
        Account receiverAccount = accountRepository.findById(receiverId).orElseThrow(AccountNotFoundException::new);

        BigDecimal senderBalance = senderAccount.getBalance().subtract(amount);
        BigDecimal receiverBalance = receiverAccount.getBalance().add(amount);

        accountRepository.changeBalance(senderAccount.getId(), senderBalance);
        accountRepository.changeBalance(receiverAccount.getId(), receiverBalance);
    }

    public Iterable<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public List<Account> findAccountByName(String name) {
        return accountRepository.findByName(name);
    }
}
