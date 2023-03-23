package com.bicyclerentalservice.util;

import com.bicyclerentalservice.model.Customer;
import com.bicyclerentalservice.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CustomerValidator implements Validator {
    private final CustomersRepository customersRepository;

    @Autowired
    public CustomerValidator(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Customer customer = (Customer) o;

        if(customersRepository.getCustomerByPhoneNumber(customer.getPhoneNumber()).isPresent())
            errors.rejectValue("phoneNumber", "", "Customer with this number is already exist");
    }
}
