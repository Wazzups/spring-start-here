package com.wazzups.springstartherep17;

import com.wazzups.springstartherep17.model.Account;
import com.wazzups.springstartherep17.repositories.AccountRepository;
import com.wazzups.springstartherep17.services.TransferMoneyService;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TransferServiceUnitTests {

    @Test
    @DisplayName("Test the amount is transferred from one account to another if no exception occurs.")
    public void money_transfer_happy_flow() {
        AccountRepository accountRepository = mock(AccountRepository.class);

        TransferMoneyService transferMoneyService = new TransferMoneyService(accountRepository);

        Account sender = new Account();
        sender.setId(1L);
        sender.setBalance(new BigDecimal(1000));

        Account receiver = new Account();
        receiver.setId(2L);
        receiver.setBalance(new BigDecimal(1000));

        given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));
        given(accountRepository.findById(receiver.getId())).willReturn(Optional.of(receiver));

        transferMoneyService.transferMoney(sender.getId(), receiver.getId(), BigDecimal.valueOf(100));

        verify(accountRepository).updateAccountBalanceById(sender.getId(), new BigDecimal(900));
        verify(accountRepository).updateAccountBalanceById(receiver.getId(), new BigDecimal(1100));
    }
}
