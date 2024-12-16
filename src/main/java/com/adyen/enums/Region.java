package com.adyen.enums;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.adyen.Client;

public final class Region {

    // Prevent instantiation
    private Region() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * European Union region
     */
    public static final String EU = "eu";

    /**
     * United States region
     */
    public static final String US = "us";

    /**
     * Australia region
     */
    public static final String AU = "au";

    /** 
     * India region
     */ 
    public static final String IN = "in";

    /**
     * Asia-Pacific, South East region
     */
    public static final String APSE = "apse";

    /**
     * List of all valid regions
     */
    public static final List<String> VALID_REGIONS =
            Collections.unmodifiableList(List.of(EU, US, AU, IN, APSE));

    /**
     * Maps regions to their respective Terminal API endpoints.
     */
    public static final Map<String, String> TERMINAL_API_ENDPOINTS_MAPPING;

    static {
        Map<String, String> endpointsMapping = new HashMap<>();
        endpointsMapping.put(EU, Client.ENDPOINT_TERMINAL_CLOUD_LIVE);
        endpointsMapping.put(US, Client.ENDPOINT_TERMINAL_CLOUD_US_LIVE);
        endpointsMapping.put(AU, Client.ENDPOINT_TERMINAL_CLOUD_AU_LIVE);
        endpointsMapping.put(APSE, Client.ENDPOINT_TERMINAL_CLOUD_APSE_LIVE);
        TERMINAL_API_ENDPOINTS_MAPPING = Collections.unmodifiableMap(endpointsMapping);
    }
}