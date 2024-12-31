package com.adyen;

import com.adyen.enums.Regions.Region;
import com.adyen.enums.Regions;
import java.util.stream.Collectors;
import org.junit.Test;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RegionTest {
    @Test
    public void testValidRegions() {

        // Convert Regions.VALID_REGIONS to lowercase strings for comparison
        List<String> actual = Regions.VALID_REGIONS.stream()
            .map(region -> region.name().toLowerCase())
            .collect(Collectors.toList());

        // Define the expected list of valid regions
        List<String> expected = List.of(
            "eu",
            "us",
            "au",
            "in",
            "apse"
        );

        // Assert that the VALID_REGIONS in Region matches the expected list
        assertEquals(
            "VALID_REGIONS should match the expected regions.",
            expected,
            actual
        );
    }

    @Test
    public void testTerminalApiEndpointsMapping() {

        // Convert TERMINAL_API_ENDPOINTS_MAPPING keys to lowercase strings for comparison
        Map<String, String> actual = Regions.TERMINAL_API_ENDPOINTS_MAPPING.entrySet()
            .stream()
            .collect(Collectors.toMap(
                entry -> entry.getKey().name().toLowerCase(), // Convert key (Region enum) to lowercase
                Map.Entry::getValue
        ));
        
        // Define the expected map of region to endpoint mappings
        Map<String, String> expected = Map.of(
            "eu", "https://terminal-api-live.adyen.com",
            "us", "https://terminal-api-live-us.adyen.com",
            "au", "https://terminal-api-live-au.adyen.com",
            "apse", "https://terminal-api-live-apse.adyen.com"
        );

        // Assert that the TERMINAL_API_ENDPOINTS_MAPPING in Region matches the expected map
        assertEquals(
            "TERMINAL_API_ENDPOINTS_MAPPING should match the expected mappings.",
            expected,
            actual
        );
    }
}
