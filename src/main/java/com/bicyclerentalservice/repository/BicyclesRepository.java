package com.bicyclerentalservice.repository;

import com.bicyclerentalservice.model.Bicycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BicyclesRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BicyclesRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Bicycle> getAll() {
        return jdbcTemplate.query("SELECT * FROM Bicycle", new BicycleMapper());
    }
}
