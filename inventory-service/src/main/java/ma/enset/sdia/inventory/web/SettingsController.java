package ma.enset.sdia.inventory.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RefreshScope
@RestController
public class SettingsController {

    @Value("${platform.name:unknown platform}")
    private String platformName;

    @Value("${inventory.settings.low-stock-threshold:5}")
    private int lowStockThreshold;

    @GetMapping("/settings")
    public Map<String, Object> settings() {
        return Map.of("platformName", platformName, "lowStockThreshold", lowStockThreshold);
    }
}
