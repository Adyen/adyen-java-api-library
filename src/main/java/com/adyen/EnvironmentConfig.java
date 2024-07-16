package com.adyen;

import com.adyen.enums.Environment;

public class EnvironmentConfig {
    private Environment environment;
    private String liveEndpointUrlPrefix;

    public EnvironmentConfig(Environment environment, String liveEndpointUrlPrefix) {
        this.environment = environment;
        this.liveEndpointUrlPrefix = liveEndpointUrlPrefix;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public String getTerminalApiEndpoint() {
        if (Environment.TEST.equals(environment)) {
            return "https://terminal-api-test.adyen.com";
        } else if (Environment.LIVE.equals(environment)) {
            return "https://terminal-api-live.adyen.com";
        }
        return null;
    }
}
