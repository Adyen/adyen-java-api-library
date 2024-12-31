package com.adyen.enums;

import java.util.Map;
import com.adyen.Client;

public enum Region {

    /**
     * European Union region
     */
    EU,

    /**
     * Australia region
     */
    AU,

    /**
     * United States region
     */
    US,

    /**
     * India region
     */
    IN,

    /**
     * Asia-Pacific, South East region
     */
    APSE;

    /**
     * Maps regions to their respective Terminal API endpoints.
     */
    public static final Map<Region, String> TERMINAL_API_ENDPOINTS_MAPPING;

    static {
        TERMINAL_API_ENDPOINTS_MAPPING = Map.of(
                Region.EU, Client.TERMINAL_API_ENDPOINT_LIVE,
                Region.AU, Client.TERMINAL_API_ENDPOINT_AU,
                Region.US, Client.TERMINAL_API_ENDPOINT_US,
                Region.APSE, Client.TERMINAL_API_ENDPOINT_APSE
        );
    }
}
