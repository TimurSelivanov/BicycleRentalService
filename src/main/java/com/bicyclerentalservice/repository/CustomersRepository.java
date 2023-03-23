package com.bicyclerentalservice.repository;

import com.bicyclerentalservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomersRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomersRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Customer> getAll() {
        return jdbcTemplate.query("SELECT * FROM Customer", new CustomerMapper());
    }

    public Customer getById(int id) {
        return jdbcTemplate.query("SELECT * FROM Customer WHERE id=?", new Object[]{id}, new CustomerMapper())
                .stream().findAny().orElse(null);
    }
}
