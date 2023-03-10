package model;

public class Bicycle {
    private String brandName;
    private String model;
    private int serialNumber;
    private Customer customer;

    public Bicycle() {

    }

    public Bicycle(String brandName, String model, int serialNumber) {
        this.brandName = brandName;
        this.model = model;
        this.serialNumber = serialNumber;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
