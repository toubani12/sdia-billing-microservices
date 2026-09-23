package ma.enset.sdia.inventory.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String label;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal unitPrice;

    private int stock;

    protected Product() {
        // required by JPA
    }

    public Product(String label, BigDecimal unitPrice, int stock) {
        this.label = label;
        this.unitPrice = unitPrice;
        this.stock = stock;
    }

    public Long getId() { return id; }
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}
