package ma.enset.sdia.billing.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

// Local read model of a product owned by inventory-service
@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductDto(Long id, String label, BigDecimal unitPrice) {

    public static ProductDto unavailable(Long id) {
        return new ProductDto(id, "Product unavailable", null);
    }
}
