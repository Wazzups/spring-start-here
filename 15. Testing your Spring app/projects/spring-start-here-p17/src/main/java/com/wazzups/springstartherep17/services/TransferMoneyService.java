package com.wazzups.springstartherep17.services;

import com.wazzups.springstartherep17.exceptions.AccountNotFoundException;
import com.wazzups.springstartherep17.model.Account;
import com.wazzups.springstartherep17.repositories.AccountRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferMoneyService {

    private final AccountRepository accountRepository;

    public TransferMoneyService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(Long senderId, Long receiverId, BigDecimal amount) {
        Account senderAccount = accountRepository.findById(senderId).orElseThrow(AccountNotFoundException::new);
        Account receiverAccount = accountRepository.findById(receiverId).orElseThrow(AccountNotFoundException::new);

        BigDecimal senderBalance = senderAccount.getBalance().subtract(amount);
        BigDecimal receiverBalance = receiverAccount.getBalance().add(amount);

        accountRepository.updateAccountBalanceById(senderAccount.getId(), senderBalance);
        accountRepository.updateAccountBalanceById(receiverAccount.getId(), receiverBalance);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
