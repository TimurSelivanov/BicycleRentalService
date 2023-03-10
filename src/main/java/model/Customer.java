package model;

import java.util.List;

public class Customer {
    private String name;
    private int documentNumber;
    private int phoneNumber;
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
