package ma.enset.sdia.billing.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// "customer-service" is the Eureka service id; the load balancer picks an instance
@FeignClient(name = "customer-service", fallback = CustomerClientFallback.class)
public interface CustomerClient {

    @GetMapping("/api/customers/{id}")
    CustomerDto findById(@PathVariable("id") Long id);
}
