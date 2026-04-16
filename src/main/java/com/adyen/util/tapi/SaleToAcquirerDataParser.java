package com.adyen.util.tapi;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Parses and serializes {@link SaleToAcquirerData} objects from/to their wire formats.
 *
 * <p>Supports two formats:
 *
 * <ul>
 *   <li><b>Base64-encoded JSON</b>: a JSON object encoded as a Base64 string.
 *   <li><b>Key-value pairs</b>: form-encoded pairs using {@code &} as separator (e.g. {@code
 *       shopperEmail=foo@bar.com&tenderOption=AskGratuity}).
 * </ul>
 */
public final class SaleToAcquirerDataParser {

  private static final ObjectMapper MAPPER =
      new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

  private SaleToAcquirerDataParser() {}

  /**
   * Parses a raw {@code SaleToAcquirerData} string, auto-detecting the format.
   *
   * <ul>
   *   <li>If the string is valid Base64 and decodes to a JSON object, it is parsed as JSON.
   *   <li>Otherwise it is parsed as form-encoded key-value pairs.
   * </ul>
   *
   * @param raw The raw {@code SaleToAcquirerData} string.
   * @return Parsed {@link SaleToAcquirerData}.
   */
  public static SaleToAcquirerData parse(String raw) {
    try {
      byte[] decoded = Base64.getDecoder().decode(raw);
      if (new String(decoded, StandardCharsets.UTF_8).trim().startsWith("{")) {
        return MAPPER.readValue(decoded, SaleToAcquirerData.class);
      }
    } catch (IllegalArgumentException e) {
      // not valid Base64 — fall through to key-value parsing
    } catch (Exception e) {
      throw new IllegalStateException("Failed to deserialize SaleToAcquirerData", e);
    }
    return fromKeyValuePairs(raw);
  }

  /**
   * Decodes a Base64 JSON string into a {@link SaleToAcquirerData} object.
   *
   * @param base64 Base64-encoded JSON string.
   * @return Decoded {@link SaleToAcquirerData}.
   */
  public static SaleToAcquirerData fromBase64(String base64) {
    try {
      byte[] decoded = Base64.getDecoder().decode(base64);
      return MAPPER.readValue(decoded, SaleToAcquirerData.class);
    } catch (Exception e) {
      throw new IllegalStateException("Failed to deserialize SaleToAcquirerData", e);
    }
  }

  /**
   * Parses a form-encoded key-value pair string (e.g. {@code
   * shopperEmail=foo@bar.com&tenderOption=AskGratuity}) into a {@link SaleToAcquirerData} object.
   * Metadata fields use dotted notation: {@code metadata.key=value}.
   *
   * @param keyValuePairs Form-encoded key-value string using {@code &} as separator.
   * @return Parsed {@link SaleToAcquirerData}.
   */
  public static SaleToAcquirerData fromKeyValuePairs(String keyValuePairs) {
    SaleToAcquirerData data = new SaleToAcquirerData();
    Map<String, String> metadata = new HashMap<>();
    Map<String, String> additionalData = new HashMap<>();

    for (String pair : keyValuePairs.split("&")) {
      int idx = pair.indexOf('=');
      if (idx <= 0 || idx >= pair.length() - 1) {
        continue;
      }
      String key = URLDecoder.decode(pair.substring(0, idx), StandardCharsets.UTF_8);
      String value = URLDecoder.decode(pair.substring(idx + 1), StandardCharsets.UTF_8);

      if (key.startsWith("metadata.")) {
        metadata.put(key.substring("metadata.".length()), value);
      } else {
        switch (key) {
          case "shopperEmail":
            data.setShopperEmail(value);
            break;
          case "shopperReference":
            data.setShopperReference(value);
            break;
          case "shopperStatement":
            data.setShopperStatement(value);
            break;
          case "recurringContract":
            data.setRecurringContract(value);
            break;
          case "recurringDetailName":
            data.setRecurringDetailName(value);
            break;
          case "recurringTokenService":
            data.setRecurringTokenService(value);
            break;
          case "recurringProcessingModel":
            data.setRecurringProcessingModel(
                SaleToAcquirerData.RecurringProcessingModel.fromValue(value));
            break;
          case "store":
            data.setStore(value);
            break;
          case "merchantAccount":
            data.setMerchantAccount(value);
            break;
          case "currency":
            data.setCurrency(value);
            break;
          case "tenderOption":
            data.setTenderOption(value);
            break;
          case "authorisationType":
            data.setAuthorisationType(value);
            break;
          case "ssc":
            data.setSsc(value);
            break;
          case "redemptionType":
            data.setRedemptionType(value);
            break;
          default:
            additionalData.put(key, value);
            break;
        }
      }
    }

    if (!metadata.isEmpty()) {
      data.setMetadata(metadata);
    }
    if (!additionalData.isEmpty()) {
      data.setAdditionalData(additionalData);
    }
    return data;
  }

  /**
   * Serializes a {@link SaleToAcquirerData} object to a JSON string.
   *
   * @param data The object to serialize.
   * @return JSON string representation.
   */
  public static String toJson(SaleToAcquirerData data) {
    try {
      return MAPPER.writeValueAsString(data);
    } catch (Exception e) {
      throw new IllegalStateException("Failed to serialize SaleToAcquirerData", e);
    }
  }

  /**
   * Encodes a {@link SaleToAcquirerData} object to a Base64 JSON string.
   *
   * @param data The object to encode.
   * @return Base64-encoded JSON representation.
   */
  public static String toBase64(SaleToAcquirerData data) {
    try {
      byte[] json = MAPPER.writeValueAsBytes(data);
      return Base64.getEncoder().encodeToString(json);
    } catch (Exception e) {
      throw new IllegalStateException("Failed to serialize SaleToAcquirerData", e);
    }
  }
}
