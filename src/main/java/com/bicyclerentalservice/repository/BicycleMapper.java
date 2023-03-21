package com.bicyclerentalservice.repository;

import com.bicyclerentalservice.model.Bicycle;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BicycleMapper implements RowMapper<Bicycle> {
    @Override
    public Bicycle mapRow(ResultSet resultSet, int i) throws SQLException {
        Bicycle bicycle = new Bicycle();

        bicycle.setId(resultSet.getInt("id"));
        bicycle.setBrandName(resultSet.getString("brand_name"));
        bicycle.setModel(resultSet.getString("model"));
        bicycle.setSerialNumber(resultSet.getInt("serial_number"));
        return bicycle;
    }
}
