package ma.enset.sdia.inventory.config;

import ma.enset.sdia.inventory.domain.Product;
import ma.enset.sdia.inventory.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class SampleDataLoader {

    @Bean
    CommandLineRunner seedProducts(ProductRepository products) {
        return args -> {
            if (products.count() > 0) return;
            products.saveAll(List.of(
                    new Product("Laptop ThinkPad T14", new BigDecimal("11500.00"), 12),
                    new Product("Monitor 27\" 4K", new BigDecimal("3200.00"), 25),
                    new Product("Mechanical keyboard", new BigDecimal("650.00"), 4),
                    new Product("USB-C dock", new BigDecimal("980.00"), 40)));
        };
    }
}
