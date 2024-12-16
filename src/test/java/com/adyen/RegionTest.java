/**
 * Adyen Java API Library
 * Copyright (c) 2022 Adyen N.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.adyen.enums.Region;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RegionTest {
    @Test
    public void testValidRegions() {
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
            Region.VALID_REGIONS
        );
    }

    @Test
    public void testTerminalApiEndpointsMapping() {
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
            Region.TERMINAL_API_ENDPOINTS_MAPPING
        );
    }
}