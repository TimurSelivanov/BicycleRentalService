package com.bicyclerentalservice.repository;

import com.bicyclerentalservice.model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
        Customer customer = new Customer();

        customer.setId(resultSet.getInt("id"));
        customer.setName(resultSet.getString("name"));
        customer.setDocumentNumber(resultSet.getInt("document_number"));
        customer.setPhoneNumber(resultSet.getInt("phone_number"));
        customer.setEmail(resultSet.getString("email"));
        return customer;
    }
}
