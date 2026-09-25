package ma.enset.sdia.billing.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.math.BigDecimal;

// @ConfigurationProperties beans are re-bound on /actuator/refresh without needing @RefreshScope
@ConfigurationProperties(prefix = "billing.settings")
public class BillingSettings {

    private String currency = "MAD";
    private BigDecimal vatRate = BigDecimal.ZERO;
    private int paymentTermsDays = 30;

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public BigDecimal getVatRate() { return vatRate; }
    public void setVatRate(BigDecimal vatRate) { this.vatRate = vatRate; }
    public int getPaymentTermsDays() { return paymentTermsDays; }
    public void setPaymentTermsDays(int paymentTermsDays) { this.paymentTermsDays = paymentTermsDays; }
}
