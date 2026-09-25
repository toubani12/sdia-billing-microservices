package ma.enset.sdia.billing.web;

import ma.enset.sdia.billing.config.BillingSettings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettingsController {

    private final BillingSettings billingSettings;

    public SettingsController(BillingSettings billingSettings) {
        this.billingSettings = billingSettings;
    }

    @GetMapping("/settings")
    public BillingSettings settings() {
        return billingSettings;
    }
}
