package com.bicyclerentalservice.model;

import jakarta.validation.constraints.NotEmpty;

public class Bicycle {

    private int id;
    @NotEmpty(message = "Brand name shouldn`t be empty")
    private String brandName;
    @NotEmpty(message = "Model shouldn`t be empty")
    private String model;
    @NotEmpty(message = "Serial number shouldn`t be empty")
    private int serialNumber;

    public Bicycle() {

    }

    public Bicycle(String brandName, String model, int serialNumber) {
        this.brandName = brandName;
        this.model = model;
        this.serialNumber = serialNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }
}
