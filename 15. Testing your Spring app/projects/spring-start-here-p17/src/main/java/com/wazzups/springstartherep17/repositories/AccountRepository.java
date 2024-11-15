package com.wazzups.springstartherep17.repositories;

import com.wazzups.springstartherep17.model.Account;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    @Modifying
    @Query("UPDATE account SET balance = :balance WHERE id = :id")
    public void updateAccountBalanceById(Long id, BigDecimal balance);

    @Query("SELECT * FROM account")
    List<Account> findAll();
}
