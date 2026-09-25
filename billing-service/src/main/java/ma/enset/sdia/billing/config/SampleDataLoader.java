package ma.enset.sdia.billing.config;

import ma.enset.sdia.billing.domain.Bill;
import ma.enset.sdia.billing.repository.BillRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

// Ids match the seed data of customer-service (1..3) and inventory-service (1..4).
// Prices are stored on each line on purpose: a bill keeps the price of the day it was issued.
@Configuration
public class SampleDataLoader {

    @Bean
    CommandLineRunner seedBills(BillRepository bills) {
        return args -> {
            if (bills.count() > 0) return;
            bills.saveAll(List.of(
                    new Bill(LocalDate.of(2026, 9, 2), 1L)
                            .addItem(1L, 1, new BigDecimal("11500.00"))
                            .addItem(4L, 2, new BigDecimal("980.00")),
                    new Bill(LocalDate.of(2026, 9, 15), 2L)
                            .addItem(2L, 2, new BigDecimal("3200.00"))
                            .addItem(3L, 2, new BigDecimal("650.00")),
                    new Bill(LocalDate.of(2026, 9, 28), 1L)
                            .addItem(3L, 1, new BigDecimal("650.00")),
                    new Bill(LocalDate.of(2026, 10, 1), 3L)
                            .addItem(1L, 3, new BigDecimal("11500.00"))
                            .addItem(2L, 3, new BigDecimal("3200.00"))
                            .addItem(4L, 3, new BigDecimal("980.00"))));
        };
    }
}
