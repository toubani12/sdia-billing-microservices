package ma.enset.sdia.billing.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Local read model of a customer owned by customer-service (HAL _links are ignored)
@JsonIgnoreProperties(ignoreUnknown = true)
public record CustomerDto(Long id, String fullName, String email) {

    public static CustomerDto unavailable(Long id) {
        return new CustomerDto(id, "Customer unavailable", null);
    }
}
