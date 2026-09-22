package ma.enset.sdia.customer.domain;

import org.springframework.data.rest.core.config.Projection;

// GET /api/customers?projection=summary
@Projection(name = "summary", types = Customer.class)
public interface CustomerSummary {
    Long getId();
    String getFullName();
}
