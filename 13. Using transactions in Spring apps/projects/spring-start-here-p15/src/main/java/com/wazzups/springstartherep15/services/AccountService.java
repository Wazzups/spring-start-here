package com.wazzups.springstartherep15.services;

import com.wazzups.springstartherep15.models.Account;
import com.wazzups.springstartherep15.repositories.AccountRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(Long idSender, Long idReceiver, double amount) {
        Account senderAccount = accountRepository.findAccountById(idSender);
        Account receiverAccount = accountRepository.findAccountById(idReceiver);
        BigDecimal senderNewAmount = senderAccount.getAmount().subtract(BigDecimal.valueOf(amount));
        BigDecimal receiverNewAmount = receiverAccount.getAmount().add(BigDecimal.valueOf(amount));

        accountRepository.changeAmount(senderAccount.getId(), senderNewAmount);
        accountRepository.changeAmount(receiverAccount.getId(), receiverNewAmount);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAllAccounts();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findAccountById(id);
    }
}
