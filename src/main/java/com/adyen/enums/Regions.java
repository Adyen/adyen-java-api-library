package com.adyen.enums;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.adyen.Client;

public final class Regions {

    // Prevent instantiation
    private Regions() {
        throw new UnsupportedOperationException("Utility class");
    }

    public enum Region {

        /**
         * European Union region
         */
        EU,

        /**
         * United States region
         */
        US,

        /**
         * Australia region
         */
        AU,

        /**
         * India region
         */
        IN,

        /**
         * Asia-Pacific, South East region
         */
        APSE
    }

    /**
     * List of all valid regions
     */
    public static final List<Region> VALID_REGIONS =
            Collections.unmodifiableList(List.of(Region.values()));

    /**
     * Maps regions to their respective Terminal API endpoints.
     */
    public static final Map<Region, String> TERMINAL_API_ENDPOINTS_MAPPING;

    static {
        Map<Region, String> endpointsMapping = new HashMap<>();
        endpointsMapping.put(Region.EU, Client.TERMINAL_API_ENDPOINT_LIVE);
        endpointsMapping.put(Region.US, Client.TERMINAL_API_ENDPOINT_US);
        endpointsMapping.put(Region.AU, Client.TERMINAL_API_ENDPOINT_AU);
        endpointsMapping.put(Region.APSE, Client.TERMINAL_API_ENDPOINT_APSE);
        TERMINAL_API_ENDPOINTS_MAPPING = Collections.unmodifiableMap(endpointsMapping);
    }
}