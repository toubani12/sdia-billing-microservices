package ma.enset.sdia.billing.client;

import org.springframework.stereotype.Component;

// Used by the circuit breaker when customer-service fails, times out, or the circuit is open
@Component
class CustomerClientFallback implements CustomerClient {

    @Override
    public CustomerDto findById(Long id) {
        return CustomerDto.unavailable(id);
    }
}
