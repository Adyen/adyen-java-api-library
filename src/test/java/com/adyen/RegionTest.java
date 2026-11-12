package com.adyen;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.adyen.enums.Region;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RegionTest {
  @ParameterizedTest
  @CsvSource({
    "EU, https://terminal-api-live.adyen.com",
    "AU, https://terminal-api-live-au.adyen.com",
    "US, https://terminal-api-live-us.adyen.com",
    "APSE, https://terminal-api-live-apse.adyen.com",
    "NEA, https://terminal-api-live-nea.adyen.com"
  })
  public void testRegionalLiveUrl(Region region, String expectedUrl) {
    assertEquals(expectedUrl, Region.regionalLiveUrl("terminal-api", region));
  }

  @Test
  public void testRegionalLiveUrlDefaultsToEu() {
    assertEquals(
        "https://terminal-api-live.adyen.com", Region.regionalLiveUrl("terminal-api", null));
    assertEquals("https://device-api-live.adyen.com", Region.regionalLiveUrl("device-api", null));
    assertEquals(
        "https://softposconfig-live.adyen.com", Region.regionalLiveUrl("softposconfig", null));
  }

  @Test
  public void testValidRegions() {
    List<Region> VALID_REGIONS = List.of(Region.values());

    // Convert Regions.VALID_REGIONS to lowercase strings for comparison
    List<String> actual =
        VALID_REGIONS.stream()
            .map(region -> region.name().toLowerCase())
            .collect(Collectors.toList());

    // Define the expected list of valid regions
    List<String> expected = List.of("eu", "au", "us", "apse", "nea");

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
            "apse", "https://terminal-api-live-apse.adyen.com",
            "nea", "https://terminal-api-live-nea.adyen.com");

    // Assert that the TERMINAL_API_ENDPOINTS_MAPPING in Region matches the expected map
    assertEquals(expected, actual);
  }
}
