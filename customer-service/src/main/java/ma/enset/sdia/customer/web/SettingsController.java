package ma.enset.sdia.customer.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

// @RefreshScope: the bean is re-created after POST /actuator/refresh, so @Value fields pick up new values
@RefreshScope
@RestController
public class SettingsController {

    @Value("${platform.name:unknown platform}")
    private String platformName;

    @Value("${platform.environment:local}")
    private String environment;

    @Value("${customer.settings.welcome-message:Welcome}")
    private String welcomeMessage;

    @Value("${customer.settings.max-customers-per-page:10}")
    private int maxCustomersPerPage;

    @GetMapping("/settings")
    public Map<String, Object> settings() {
        return Map.of(
                "platformName", platformName,
                "environment", environment,
                "welcomeMessage", welcomeMessage,
                "maxCustomersPerPage", maxCustomersPerPage);
    }
}
