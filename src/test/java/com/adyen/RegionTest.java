package com.adyen;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.adyen.enums.Region;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class RegionTest {
  @Test
  public void testValidRegions() {
    List<Region> VALID_REGIONS = List.of(Region.values());

    // Convert Regions.VALID_REGIONS to lowercase strings for comparison
    List<String> actual =
        VALID_REGIONS.stream()
            .map(region -> region.name().toLowerCase())
            .collect(Collectors.toList());

    // Define the expected list of valid regions
    List<String> expected = List.of("eu", "au", "us", "in", "apse");

    // Assert that the VALID_REGIONS in Region matches the expected list
    assertEquals(expected, actual);
  }

  @Test
  public void testTerminalApiEndpointsMapping() {
    // Convert TERMINAL_API_ENDPOINTS_MAPPING keys to lowercase strings for comparison
    Map<String, String> actual =
        Region.TERMINAL_API_ENDPOINTS_MAPPING.entrySet().stream()
            .collect(
                Collectors.toMap(
                    entry ->
                        entry
                            .getKey()
                            .name()
                            .toLowerCase(), // Convert key (Region enum) to lowercase
                    Map.Entry::getValue));

    // Define the expected map of region to endpoint mappings
    Map<String, String> expected =
        Map.of(
            "eu", "https://terminal-api-live.adyen.com",
            "au", "https://terminal-api-live-au.adyen.com",
            "us", "https://terminal-api-live-us.adyen.com",
            "apse", "https://terminal-api-live-apse.adyen.com");

    // Assert that the TERMINAL_API_ENDPOINTS_MAPPING in Region matches the expected map
    assertEquals(expected, actual);
  }
}
