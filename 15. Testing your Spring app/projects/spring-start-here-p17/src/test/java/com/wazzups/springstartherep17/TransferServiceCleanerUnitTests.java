package com.wazzups.springstartherep17;

import com.wazzups.springstartherep17.exceptions.AccountNotFoundException;
import com.wazzups.springstartherep17.model.Account;
import com.wazzups.springstartherep17.repositories.AccountRepository;
import com.wazzups.springstartherep17.services.TransferMoneyService;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TransferServiceCleanerUnitTests {

    @Mock
    AccountRepository accountRepository;

    @InjectMocks
    TransferMoneyService transferMoneyService;

    @Test
    public void moneyTransferHappyFlow() {
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

    @Test
    public void moneyTransferDestinationAccountNotFoundFlow() {
        Account sender = new Account();
        sender.setId(1L);
        sender.setBalance(new BigDecimal(1000));

        given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));

        given(accountRepository.findById(2L)).willReturn(Optional.empty());

        assertThrows(AccountNotFoundException.class, () -> transferMoneyService.transferMoney(1L, 2L, BigDecimal.valueOf(100)));

        verify(accountRepository, never()).updateAccountBalanceById(anyLong(), any());
    }
}
