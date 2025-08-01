/*
 * Management API
 *
 * The version of the OpenAPI document: 3
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.management;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** ReceiptOptions */
@JsonPropertyOrder({
  ReceiptOptions.JSON_PROPERTY_LOGO,
  ReceiptOptions.JSON_PROPERTY_PROMPT_BEFORE_PRINTING,
  ReceiptOptions.JSON_PROPERTY_QR_CODE_DATA
})
public class ReceiptOptions {
  public static final String JSON_PROPERTY_LOGO = "logo";
  private String logo;

  public static final String JSON_PROPERTY_PROMPT_BEFORE_PRINTING = "promptBeforePrinting";
  private Boolean promptBeforePrinting;

  public static final String JSON_PROPERTY_QR_CODE_DATA = "qrCodeData";
  private String qrCodeData;

  public ReceiptOptions() {}

  /**
   * The receipt logo converted to a Base64-encoded string. The image must be a .bmp file of &lt;
   * 256 KB, dimensions 240 (H) x 384 (W) px.
   *
   * @param logo The receipt logo converted to a Base64-encoded string. The image must be a .bmp
   *     file of &lt; 256 KB, dimensions 240 (H) x 384 (W) px.
   * @return the current {@code ReceiptOptions} instance, allowing for method chaining
   */
  public ReceiptOptions logo(String logo) {
    this.logo = logo;
    return this;
  }

  /**
   * The receipt logo converted to a Base64-encoded string. The image must be a .bmp file of &lt;
   * 256 KB, dimensions 240 (H) x 384 (W) px.
   *
   * @return logo The receipt logo converted to a Base64-encoded string. The image must be a .bmp
   *     file of &lt; 256 KB, dimensions 240 (H) x 384 (W) px.
   */
  @JsonProperty(JSON_PROPERTY_LOGO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getLogo() {
    return logo;
  }

  /**
   * The receipt logo converted to a Base64-encoded string. The image must be a .bmp file of &lt;
   * 256 KB, dimensions 240 (H) x 384 (W) px.
   *
   * @param logo The receipt logo converted to a Base64-encoded string. The image must be a .bmp
   *     file of &lt; 256 KB, dimensions 240 (H) x 384 (W) px.
   */
  @JsonProperty(JSON_PROPERTY_LOGO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLogo(String logo) {
    this.logo = logo;
  }

  /**
   * Indicates whether a screen appears asking if you want to print the shopper receipt.
   *
   * @param promptBeforePrinting Indicates whether a screen appears asking if you want to print the
   *     shopper receipt.
   * @return the current {@code ReceiptOptions} instance, allowing for method chaining
   */
  public ReceiptOptions promptBeforePrinting(Boolean promptBeforePrinting) {
    this.promptBeforePrinting = promptBeforePrinting;
    return this;
  }

  /**
   * Indicates whether a screen appears asking if you want to print the shopper receipt.
   *
   * @return promptBeforePrinting Indicates whether a screen appears asking if you want to print the
   *     shopper receipt.
   */
  @JsonProperty(JSON_PROPERTY_PROMPT_BEFORE_PRINTING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getPromptBeforePrinting() {
    return promptBeforePrinting;
  }

  /**
   * Indicates whether a screen appears asking if you want to print the shopper receipt.
   *
   * @param promptBeforePrinting Indicates whether a screen appears asking if you want to print the
   *     shopper receipt.
   */
  @JsonProperty(JSON_PROPERTY_PROMPT_BEFORE_PRINTING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPromptBeforePrinting(Boolean promptBeforePrinting) {
    this.promptBeforePrinting = promptBeforePrinting;
  }

  /**
   * Data to print on the receipt as a QR code. This can include static text and the following
   * variables: - &#x60;${merchantreference}&#x60;: the merchant reference of the transaction. -
   * &#x60;${pspreference}&#x60;: the PSP reference of the transaction. For example,
   * **http://www.example.com/order/${pspreference}/${merchantreference}**.
   *
   * @param qrCodeData Data to print on the receipt as a QR code. This can include static text and
   *     the following variables: - &#x60;${merchantreference}&#x60;: the merchant reference of the
   *     transaction. - &#x60;${pspreference}&#x60;: the PSP reference of the transaction. For
   *     example, **http://www.example.com/order/${pspreference}/${merchantreference}**.
   * @return the current {@code ReceiptOptions} instance, allowing for method chaining
   */
  public ReceiptOptions qrCodeData(String qrCodeData) {
    this.qrCodeData = qrCodeData;
    return this;
  }

  /**
   * Data to print on the receipt as a QR code. This can include static text and the following
   * variables: - &#x60;${merchantreference}&#x60;: the merchant reference of the transaction. -
   * &#x60;${pspreference}&#x60;: the PSP reference of the transaction. For example,
   * **http://www.example.com/order/${pspreference}/${merchantreference}**.
   *
   * @return qrCodeData Data to print on the receipt as a QR code. This can include static text and
   *     the following variables: - &#x60;${merchantreference}&#x60;: the merchant reference of the
   *     transaction. - &#x60;${pspreference}&#x60;: the PSP reference of the transaction. For
   *     example, **http://www.example.com/order/${pspreference}/${merchantreference}**.
   */
  @JsonProperty(JSON_PROPERTY_QR_CODE_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getQrCodeData() {
    return qrCodeData;
  }

  /**
   * Data to print on the receipt as a QR code. This can include static text and the following
   * variables: - &#x60;${merchantreference}&#x60;: the merchant reference of the transaction. -
   * &#x60;${pspreference}&#x60;: the PSP reference of the transaction. For example,
   * **http://www.example.com/order/${pspreference}/${merchantreference}**.
   *
   * @param qrCodeData Data to print on the receipt as a QR code. This can include static text and
   *     the following variables: - &#x60;${merchantreference}&#x60;: the merchant reference of the
   *     transaction. - &#x60;${pspreference}&#x60;: the PSP reference of the transaction. For
   *     example, **http://www.example.com/order/${pspreference}/${merchantreference}**.
   */
  @JsonProperty(JSON_PROPERTY_QR_CODE_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setQrCodeData(String qrCodeData) {
    this.qrCodeData = qrCodeData;
  }

  /** Return true if this ReceiptOptions object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReceiptOptions receiptOptions = (ReceiptOptions) o;
    return Objects.equals(this.logo, receiptOptions.logo)
        && Objects.equals(this.promptBeforePrinting, receiptOptions.promptBeforePrinting)
        && Objects.equals(this.qrCodeData, receiptOptions.qrCodeData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(logo, promptBeforePrinting, qrCodeData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReceiptOptions {\n");
    sb.append("    logo: ").append(toIndentedString(logo)).append("\n");
    sb.append("    promptBeforePrinting: ")
        .append(toIndentedString(promptBeforePrinting))
        .append("\n");
    sb.append("    qrCodeData: ").append(toIndentedString(qrCodeData)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * Create an instance of ReceiptOptions given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ReceiptOptions
   * @throws JsonProcessingException if the JSON string is invalid with respect to ReceiptOptions
   */
  public static ReceiptOptions fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, ReceiptOptions.class);
  }

  /**
   * Convert an instance of ReceiptOptions to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
