package com.adyen.util.tapi;

import com.adyen.model.tapi.SaleData;
import java.util.Objects;
import java.util.Optional;

/**
 * A helper class to work with {@code SaleData} from the TAPI model.
 *
 * <p>The {@code SaleToAcquirerData} field supports two formats:
 *
 * <ul>
 *   <li><b>Base64-encoded JSON</b>: a JSON object encoded as a Base64 string.
 *   <li><b>Key-value pairs</b>: form-encoded pairs using {@code &} as separator (e.g. {@code
 *       shopperEmail=foo@bar.com&tenderOption=AskGratuity}).
 * </ul>
 *
 * This helper auto-detects the format and parses it into a {@link SaleToAcquirerData} object.
 */
public final class SaleDataHelper {

  private final SaleData saleData;

  /**
   * Constructs a helper instance wrapping the provided {@link SaleData}.
   *
   * @param saleData The {@link SaleData} instance to wrap.
   */
  public SaleDataHelper(SaleData saleData) {
    this.saleData = Objects.requireNonNull(saleData, "saleData must not be null");
  }

  /**
   * Parses the {@code SaleToAcquirerData} field into a {@link SaleToAcquirerData} object. Supports
   * both Base64-encoded JSON and form-encoded key-value pair formats.
   *
   * @return An {@link Optional} containing the parsed {@link SaleToAcquirerData}, or an empty
   *     Optional if the field is absent or cannot be parsed.
   */
  public Optional<SaleToAcquirerData> getSaleToAcquirerData() {
    String raw = saleData.getSaleToAcquirerData();
    if (raw == null || raw.trim().isEmpty()) {
      return Optional.empty();
    }
    try {
      return Optional.of(SaleToAcquirerData.parse(raw));
    } catch (Exception e) {
      return Optional.empty();
    }
  }

}
