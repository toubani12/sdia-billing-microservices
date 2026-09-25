package ma.enset.sdia.billing.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import ma.enset.sdia.billing.client.CustomerDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate issuedOn;

    // reference to an aggregate owned by customer-service (no foreign key across services)
    @Column(nullable = false)
    private Long customerId;

    @Transient
    private CustomerDto customer;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductItem> items = new ArrayList<>();

    protected Bill() {
        // required by JPA
    }

    public Bill(LocalDate issuedOn, Long customerId) {
        this.issuedOn = issuedOn;
        this.customerId = customerId;
    }

    public Bill addItem(Long productId, int quantity, BigDecimal unitPrice) {
        items.add(new ProductItem(this, productId, quantity, unitPrice));
        return this;
    }

    public BigDecimal getTotal() {
        return items.stream().map(ProductItem::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Long getId() { return id; }
    public LocalDate getIssuedOn() { return issuedOn; }
    public Long getCustomerId() { return customerId; }
    public CustomerDto getCustomer() { return customer; }
    public void setCustomer(CustomerDto customer) { this.customer = customer; }
    public List<ProductItem> getItems() { return items; }
}
