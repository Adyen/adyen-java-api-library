package com.adyen;

public class ClientEnvironment {

    private Config config;
    public static final String TERMINAL_API_ENDPOINT_TEST = "https://terminal-api-test.adyen.com";
    public static final String TERMINAL_API_ENDPOINT_LIVE = "https://terminal-api-live.adyen.com";

    public ClientEnvironment(Config config) {
        this.config = config;
    }

    /**
     * @param environment This defines the payment environment live or test
     * @deprecated As of library version 1.5.4, replaced by {@link #setEnvironment(com.adyen.enums.Environment environment, String liveEndpointUrlPrefix)}.
     */
    @Deprecated
    public void setEnvironment(com.adyen.enums.Environment environment) {
        this.setEnvironment(environment, null);
    }

    /**
     * @param environment           This defines the payment environment live or test
     * @param liveEndpointUrlPrefix Provide the unique live url prefix from the "API URLs and Response" menu in the Adyen Customer Area
     */
    public void setEnvironment(com.adyen.enums.Environment environment, String liveEndpointUrlPrefix) {
        if (liveEndpointUrlPrefix != null) {
            config.setLiveEndpointUrlPrefix(liveEndpointUrlPrefix);
        }
        if (com.adyen.enums.Environment.TEST.equals(environment)) {
            this.config.setEnvironment(environment);
            this.config.setTerminalApiCloudEndpoint(TERMINAL_API_ENDPOINT_TEST);
        } else if (com.adyen.enums.Environment.LIVE.equals(environment)) {
            this.config.setEnvironment(environment);
            this.config.setTerminalApiCloudEndpoint(TERMINAL_API_ENDPOINT_LIVE);
        }
    }
}
