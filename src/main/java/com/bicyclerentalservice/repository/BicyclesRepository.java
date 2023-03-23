package com.bicyclerentalservice.repository;

import com.bicyclerentalservice.model.Bicycle;
import com.bicyclerentalservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    //getting customer by bicycle id using JOIN
    public Optional<Customer> getCustomerByBicycleId(int id) {
        return jdbcTemplate.query("SELECT Customer.* FROM Bicycle JOIN Customer ON Bicycle.customer_id = Customer.id " +
                "WHERE Bicycle.id=?", new Object[]{id}, new CustomerMapper()).stream().findAny();
    }

    //return bicycle
    public void returnBicycle(int id) {
        jdbcTemplate.update("UPDATE Bicycle SET customer_id=NULL WHERE id=?", id);
    }

    //rent bicycle
    public void rentBicycle(int id, Customer customer) {
        jdbcTemplate.update("UPDATE Bicycle SET customer_id=? WHERE id=?", customer.getId(), id);
    }
}
