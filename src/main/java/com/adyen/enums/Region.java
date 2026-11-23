package com.adyen.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Region {

  /** European Union region */
  EU,

  /** Australia region */
  AU,

  /** United States region */
  US,

  /** Asia-Pacific, South East region */
  APSE,

  /** North East Asia region */
  NEA;

  private static final Map<Region, String> REGIONAL_LIVE_URL_TEMPLATES =
      Map.of(
          Region.EU, "https://%s-live.adyen.com",
          Region.AU, "https://%s-live-au.adyen.com",
          Region.US, "https://%s-live-us.adyen.com",
          Region.APSE, "https://%s-live-apse.adyen.com",
          Region.NEA, "https://%s-live-nea.adyen.com");

  /** Maps regions to their respective Terminal API endpoints. */
  public static final Map<Region, String> TERMINAL_API_ENDPOINTS_MAPPING =
      Arrays.stream(values())
          .collect(
              Collectors.toUnmodifiableMap(
                  region -> region, region -> regionalLiveUrl("terminal-api", region)));

  /**
   * Forms a LIVE URL for an API that supports regional hosts.
   *
   * @param apiHostName API hostname prefix, such as {@code device-api} or {@code softposconfig}.
   * @param region Target region. If null, defaults to EU.
   * @return The regional LIVE URL, without an API path.
   */
  public static String regionalLiveUrl(String apiHostName, Region region) {
    Region effectiveRegion = region == null ? Region.EU : region;
    return String.format(REGIONAL_LIVE_URL_TEMPLATES.get(effectiveRegion), apiHostName);
  }
}
