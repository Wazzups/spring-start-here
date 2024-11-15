package com.wazzups.springstartherep16.repositories;

import com.wazzups.springstartherep16.entity.Account;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    @Modifying
    @Query("UPDATE accounts SET balance = :amount where id= :id")
    public void changeBalance(Long id, BigDecimal amount);

    @Query("SELECT * FROM accounts where name = :name")
    public List<Account> findByName(String name);
}
