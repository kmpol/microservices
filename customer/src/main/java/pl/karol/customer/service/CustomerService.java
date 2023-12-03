package pl.karol.customer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.karol.clients.fraud.FraudClient;
import pl.karol.clients.fraud.FraudCheckResponse;
import pl.karol.customer.model.Customer;
import pl.karol.customer.repository.CustomerRepository;
import pl.karol.customer.request.CustomerRegistrationRequest;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder().firstName(request.firstName()).lastName(request.lastName()).email(request.email()).build();
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
        //todo: check if email taken
        //todo: check if emial valid
        //todo: check if fraudster
    }
}
