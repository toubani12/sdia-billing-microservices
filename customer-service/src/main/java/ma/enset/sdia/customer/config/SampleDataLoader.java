package ma.enset.sdia.customer.config;

import ma.enset.sdia.customer.domain.Customer;
import ma.enset.sdia.customer.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SampleDataLoader {

    @Bean
    CommandLineRunner seedCustomers(CustomerRepository customers) {
        return args -> {
            if (customers.count() > 0) return;
            customers.saveAll(List.of(
                    new Customer("Salma Bennani", "salma.bennani@example.ma"),
                    new Customer("Youssef El Amrani", "youssef.elamrani@example.ma"),
                    new Customer("Imane Chraibi", "imane.chraibi@example.ma")));
        };
    }
}
