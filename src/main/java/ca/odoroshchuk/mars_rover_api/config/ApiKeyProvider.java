package ca.odoroshchuk.mars_rover_api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiKeyProvider {

    @Value("${mars_rover_api.api.key}")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }
}
