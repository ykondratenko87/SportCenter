package by.tms.sportcenter.service;

import by.tms.sportcenter.entity.Customer;
import by.tms.sportcenter.repository.CustomerRepository;
import by.tms.sportcenter.repository.impl.CustomerRepositoryImpl;
import by.tms.sportcenter.repository.javaConfig.CustomerRepositoryConfig;

public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService() {
        this.repository = new CustomerRepositoryConfig();
    }

    public void add(Customer customer) {
        repository.add(customer);
    }
}