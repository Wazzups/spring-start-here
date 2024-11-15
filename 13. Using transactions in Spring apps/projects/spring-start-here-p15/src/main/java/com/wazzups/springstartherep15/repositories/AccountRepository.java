package com.wazzups.springstartherep15.repositories;

import com.wazzups.springstartherep15.models.Account;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {

    private JdbcTemplate jdbcTemplate;

    AccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account findAccountById(long id) {
        String sql = "SELECT * FROM account WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, Account.class);
    }

    public List<Account> findAllAccounts() {
        String sql = "SELECT * FROM account";
        return jdbcTemplate.queryForList(sql, Account.class);
    }

    public void changeAmount(long id, BigDecimal amount) {
        String sql = "UPDATE account SET amount = ? WHERE id = ?";

        jdbcTemplate.update(sql, amount, id);
    }

}
