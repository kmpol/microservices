package pl.karol.customer.service;

import org.springframework.stereotype.Service;
import pl.karol.customer.model.Customer;
import pl.karol.customer.repository.CustomerRepository;
import pl.karol.customer.request.CustomerRegistrationRequest;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder().firstName(request.firstName()).lastName(request.lastName()).email(request.email()).build();
        customerRepository.save(customer);
        //todo: check if emial valid
        //todo: check if email taken
    }
}
