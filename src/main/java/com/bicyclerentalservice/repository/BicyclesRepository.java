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

    public Bicycle getById(int id) {
        return jdbcTemplate.query("SELECT * FROM Bicycle WHERE id=?", new Object[]{id}, new BicycleMapper())
                .stream().findAny().orElse(null);
    }

    public void save(Bicycle bicycle) {
        jdbcTemplate.update("INSERT INTO Bicycle(brand_name, model, serial_number) VALUES(?, ?, ?)",
                bicycle.getBrandName(), bicycle.getModel(), bicycle.getSerialNumber());
    }

    public void update(int id, Bicycle updatedBicycle) {
        jdbcTemplate.update("UPDATE Bicycle SET brand_name=?, model=?, serial_number=? WHERE id=?",
                updatedBicycle.getBrandName(), updatedBicycle.getModel(), updatedBicycle.getSerialNumber(),
                id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Bicycle WHERE id=?", id);
    }

    
}
