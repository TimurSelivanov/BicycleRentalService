package com.bicyclerentalservice.repository;

import com.bicyclerentalservice.model.Bicycle;
import com.bicyclerentalservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    public void save(Customer customer) {
        jdbcTemplate.update("INSERT INTO Customer(name, document_number, phone_number, email) VALUES(?, ?, ?, ?)",
                customer.getName(), customer.getDocumentNumber(), customer.getPhoneNumber(), customer.getEmail());
    }

    public void update(int id, Customer updatedCustomer) {
        jdbcTemplate.update("UPDATE Customer SET name=?, document_number=?, phone_number=?, email=? WHERE id=?",
                updatedCustomer.getName(), updatedCustomer.getDocumentNumber(), updatedCustomer.getPhoneNumber(),
                updatedCustomer.getEmail(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Customer WHERE id=?", id);
    }

    //getting customer by its phone number and checking that it is unique
    public Optional<Customer> getCustomerByPhoneNumber(int phoneNumber) {
        return jdbcTemplate.query("SELECT * FROM Customer WHERE phone_number=?", new Object[]{phoneNumber},
                new CustomerMapper()).stream().findAny();
    }

    //getting all bikes taken by customer
    public List<Bicycle> getBicyclesByCustomerId(int id) {
        return jdbcTemplate.query("SELECT * FROM Bicycle WHERE customer_id=?", new Object[]{id}, new BicycleMapper());
    }
}
