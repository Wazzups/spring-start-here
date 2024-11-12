package com.wazzups.springstartherep13.repositories;

import com.wazzups.springstartherep13.model.Purchase;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbcTemplate;

    public PurchaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void storePurchase(Purchase purchase) {
        String sql = "INSERT INTO purchases (product, price) VALUES (?, ?)";

        jdbcTemplate.update(sql, purchase.getProduct(), purchase.getPrice());
    }

    public List<Purchase> findAllPurchases() {
        String sql = "SELECT * FROM purchases";

        RowMapper<Purchase> rowMapper = (rs, rowNum) -> new Purchase(
            rs.getInt("id"),
            rs.getString("product"),
            rs.getBigDecimal("price"));

        return jdbcTemplate.query(sql, rowMapper);
    }
}
