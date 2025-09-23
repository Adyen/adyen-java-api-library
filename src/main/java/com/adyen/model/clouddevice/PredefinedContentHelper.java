package com.adyen.model.clouddevice;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * A helper class to parse and manage the key-value pairs within a PredefinedContent referenceID
 * string. The referenceID is expected to be in a URL query string format (e.g., {@code
 * key1=value1&key2=value2}).
 */
public final class PredefinedContentHelper {

  private static final String KEY_EVENT = "event";
  private static final String KEY_TRANSACTION_ID = "TransactionID";
  private static final String KEY_TIME_STAMP = "TimeStamp";

  /**
   * Defines the supported events for display notifications within a PredefinedContent reference ID.
   */
  public enum DisplayNotificationEvent {
    TENDER_CREATED,
    CARD_INSERTED,
    CARD_PRESENTED,
    CARD_SWIPED,
    WAIT_FOR_APP_SELECTION,
    APPLICATION_SELECTED,
    ASK_SIGNATURE,
    CHECK_SIGNATURE,
    SIGNATURE_CHECKED,
    WAIT_FOR_PIN,
    PIN_ENTERED,
    PRINT_RECEIPT,
    RECEIPT_PRINTED,
    CARD_REMOVED,
    TENDER_FINAL,
    ASK_DCC,
    DCC_ACCEPTED,
    DCC_REJECTED,
    ASK_GRATUITY,
    GRATUITY_ENTERED,
    BALANCE_QUERY_STARTED,
    BALANCE_QUERY_COMPLETED,
    LOAD_STARTED,
    LOAD_COMPLETED,
    PROVIDE_CARD_DETAILS,
    CARD_DETAILS_PROVIDED
  }

  private final Map<String, String> params;

  /**
   * Constructs a helper instance by parsing the provided reference ID.
   *
   * @param referenceId The string from {@link PredefinedContent#getReferenceID()}, expected to be
   *     in URL query string format.
   */
  public PredefinedContentHelper(String referenceId) {
    this.params = parse(referenceId);
  }

  /**
   * Extracts and validates the 'event' value from the reference ID.
   *
   * @return An {@link Optional} containing the {@link DisplayNotificationEvent} if it is present
   *     and valid, otherwise an empty Optional.
   *     <pre>{@code
   * PredefinedContentHelper helper = new PredefinedContentHelper("...&event=PIN_ENTERED");
   * helper.getEvent().ifPresent(event -> System.out.println(event)); // Prints PIN_ENTERED
   * }</pre>
   */
  public Optional<DisplayNotificationEvent> getEvent() {
    return get(KEY_EVENT)
        .flatMap(
            eventValue -> {
              try {
                return Optional.of(DisplayNotificationEvent.valueOf(eventValue));
              } catch (IllegalArgumentException e) {
                return Optional.empty(); // The event string is not a valid enum constant
              }
            });
  }

  /**
   * Gets the transaction ID from the reference ID.
   *
   * @return An {@link Optional} containing the TransactionID, or an empty Optional if not present.
   */
  public Optional<String> getTransactionId() {
    return get(KEY_TRANSACTION_ID);
  }

  /**
   * Gets the timestamp from the reference ID.
   *
   * @return An {@link Optional} containing the TimeStamp, or an empty Optional if not present.
   */
  public Optional<String> getTimeStamp() {
    return get(KEY_TIME_STAMP);
  }

  /**
   * Gets the value for a given key from the reference ID.
   *
   * @param key The name of the parameter to retrieve.
   * @return An {@link Optional} containing the parameter's value, or an empty Optional if not
   *     present.
   */
  public Optional<String> get(String key) {
    return Optional.ofNullable(params.get(key));
  }

  /**
   * Returns an unmodifiable view of all parsed parameters.
   *
   * @return An unmodifiable {@link Map} of all key-value pairs from the reference ID.
   */
  public Map<String, String> toMap() {
    return Collections.unmodifiableMap(params);
  }

  /**
   * Parses a URL query-like string into a map.
   *
   * @param referenceId The string to parse.
   * @return A map of the parsed key-value pairs.
   */
  private static Map<String, String> parse(String referenceId) {
    if (referenceId == null || referenceId.trim().isEmpty()) {
      return Collections.emptyMap();
    }

    Map<String, String> queryPairs = new LinkedHashMap<>();
    String[] pairs = referenceId.split("&");
    for (String pair : pairs) {
      int idx = pair.indexOf("=");
      if (idx > 0 && idx < pair.length() - 1) {
        String key = URLDecoder.decode(pair.substring(0, idx), StandardCharsets.UTF_8);
        String value = URLDecoder.decode(pair.substring(idx + 1), StandardCharsets.UTF_8);
        queryPairs.put(key, value);
      }
    }
    return queryPairs;
  }
}
