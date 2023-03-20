package com.bicyclerentalservice.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class Customer {
    @NotEmpty(message = "Name shouldn`t be empty")
    private String name;
    @NotEmpty(message = "Document number shouldn`t be empty")
    private int documentNumber;
    private int phoneNumber;
    @Email(message = "Email should be valid")
    private String email;
    private List<Bicycle> listOfBicycles;


    public Customer() {

    }

    public Customer(String name, int documentNumber, int phoneNumber, String email) {
        this.name = name;
        this.documentNumber = documentNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(int documentNumber) {
        this.documentNumber = documentNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Bicycle> getListOfBicycles() {
        return listOfBicycles;
    }

    public void setListOfBicycles(List<Bicycle> listOfBicycles) {
        this.listOfBicycles = listOfBicycles;
    }
}
