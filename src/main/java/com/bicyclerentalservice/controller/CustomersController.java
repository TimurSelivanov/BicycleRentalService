package com.bicyclerentalservice.controller;

import com.bicyclerentalservice.model.Customer;
import com.bicyclerentalservice.repository.CustomersRepository;
import com.bicyclerentalservice.util.CustomerValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomersController {

    private final CustomersRepository customerRepository;
    private final CustomerValidator customerValidator;

    @Autowired
    public CustomersController(CustomersRepository customerRepository, CustomerValidator customerValidator) {
        this.customerRepository = customerRepository;
        this.customerValidator = customerValidator;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("customers", customerRepository.getAll());
        return "customers/customers";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", customerRepository.getById(id));
        model.addAttribute("bicycles", customerRepository.getBicyclesByCustomerId(id));
        return "customers/details";
    }

    @GetMapping("/new")
    public String newCustomer(@ModelAttribute("customer")Customer customer) {
        return "customers/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("customer") @Valid Customer customer, BindingResult bindingResult) {
        customerValidator.validate(customer, bindingResult);

        if(bindingResult.hasErrors())
            return "customers/new";

        customerRepository.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/update")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("customer", customerRepository.getById(id));
        return "customers/update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("customer") @Valid Customer customer, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if(bindingResult.hasErrors())
            return "customers/update";

        customerRepository.update(id, customer);
        return "redirect:/customers";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        customerRepository.delete(id);
        return "redirect:/customers";
    }
}
