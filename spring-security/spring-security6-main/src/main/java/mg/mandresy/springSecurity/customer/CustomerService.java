package mg.mandresy.springSecurity.customer;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public Optional<Customer> selectUserByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public Customer createCustomer(Customer customer) {
         customer.setPassword( passwordEncoder.encode(customer.getPassword()) );
        return customerRepository.save(customer);
    }
}
