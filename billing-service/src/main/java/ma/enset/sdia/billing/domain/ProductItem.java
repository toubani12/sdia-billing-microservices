package ma.enset.sdia.billing.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import ma.enset.sdia.billing.client.ProductDto;

import java.math.BigDecimal;

@Entity
public class ProductItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore // back-reference, would otherwise loop Bill -> items -> bill
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Bill bill;

    @Column(nullable = false)
    private Long productId;

    @Transient
    private ProductDto product;

    private int quantity;

    // price frozen at billing time, independent of later catalog changes
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal unitPrice;

    protected ProductItem() {
        // required by JPA
    }

    ProductItem(Bill bill, Long productId, int quantity, BigDecimal unitPrice) {
        this.bill = bill;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public BigDecimal getAmount() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    public Long getId() { return id; }
    public Bill getBill() { return bill; }
    public Long getProductId() { return productId; }
    public ProductDto getProduct() { return product; }
    public void setProduct(ProductDto product) { this.product = product; }
    public int getQuantity() { return quantity; }
    public BigDecimal getUnitPrice() { return unitPrice; }
}
