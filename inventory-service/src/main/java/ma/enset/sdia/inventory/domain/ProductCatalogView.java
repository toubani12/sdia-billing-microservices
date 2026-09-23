package ma.enset.sdia.inventory.domain;

import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

// GET /api/products?projection=catalog  (hides stock levels)
@Projection(name = "catalog", types = Product.class)
public interface ProductCatalogView {
    Long getId();
    String getLabel();
    BigDecimal getUnitPrice();
}
