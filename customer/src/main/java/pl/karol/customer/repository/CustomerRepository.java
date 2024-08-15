package pl.karol.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.karol.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
