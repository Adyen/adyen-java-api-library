package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/** Content of the Input Update message. */
@JsonPropertyOrder({
  "MessageReference",
  "OutputContent",
  "MenuEntry",
  "OutputSignature",
  "MinLength",
  "MaxLength",
  "MaxDecimalLength"
})
public class InputUpdate {

  @JsonProperty("MessageReference")
  @Schema(description = "Identification of a previous POI transaction.")
  protected MessageReference messageReference;

  @JsonProperty("OutputContent")
  @Schema(description = "Content to display or print.")
  protected OutputContent outputContent;

  @JsonProperty("MenuEntry")
  @Schema(description = "An entryof the menu to present to the Cashier")
  protected List<MenuEntry> menuEntry;

  @JsonProperty("OutputSignature")
  @Schema(description = "Vendor specific signature of text message to display or print.")
  protected byte[] outputSignature;

  @JsonProperty("MinLength")
  @Schema(description = "Minimum input length --Rule: If present in the Input to update.")
  protected BigInteger minLength;

  @JsonProperty("MaxLength")
  @Schema(description = "Maximum input length --Rule: If present in the Input to update.")
  protected BigInteger maxLength;

  @JsonProperty("MaxDecimalLength")
  @Schema(
      description =
          "Maximum input length of the decimal part (without decimal point) --Rule: If present in the Input to update.")
  protected BigInteger maxDecimalLength;

  /**
   * Gets message reference.
   *
   * @return the message reference
   */
  public MessageReference getMessageReference() {
    return messageReference;
  }

  /**
   * Sets message reference.
   *
   * @param messageReference the message reference
   */
  public void setMessageReference(MessageReference messageReference) {
    this.messageReference = messageReference;
  }

  /**
   * Gets output content.
   *
   * @return the output content
   */
  public OutputContent getOutputContent() {
    return outputContent;
  }

  /**
   * Sets output content.
   *
   * @param outputContent the output content
   */
  public void setOutputContent(OutputContent outputContent) {
    this.outputContent = outputContent;
  }

  /**
   * Gets menu entry.
   *
   * @return the menu entry
   */
  public List<MenuEntry> getMenuEntry() {
    if (menuEntry == null) {
      menuEntry = new ArrayList<>();
    }
    return this.menuEntry;
  }

  /**
   * Sets menu entry.
   *
   * @param menuEntry the menu entry
   */
  public void setMenuEntry(List<MenuEntry> menuEntry) {
    this.menuEntry = menuEntry;
  }

  /**
   * Get output signature.
   *
   * @return the byte [ ]
   */
  public byte[] getOutputSignature() {
    return outputSignature;
  }

  /**
   * Sets output signature.
   *
   * @param outputSignature the output signature
   */
  public void setOutputSignature(byte[] outputSignature) {
    this.outputSignature = outputSignature;
  }

  /**
   * Gets min length.
   *
   * @return the min length
   */
  public BigInteger getMinLength() {
    return minLength;
  }

  /**
   * Sets min length.
   *
   * @param minLength the min length
   */
  public void setMinLength(BigInteger minLength) {
    this.minLength = minLength;
  }

  /**
   * Gets max length.
   *
   * @return the max length
   */
  public BigInteger getMaxLength() {
    return maxLength;
  }

  /**
   * Sets max length.
   *
   * @param maxLength the max length
   */
  public void setMaxLength(BigInteger maxLength) {
    this.maxLength = maxLength;
  }

  /**
   * Gets max decimal length.
   *
   * @return the max decimal length
   */
  public BigInteger getMaxDecimalLength() {
    return maxDecimalLength;
  }

  /**
   * Sets max decimal length.
   *
   * @param maxDecimalLength the max decimal length
   */
  public void setMaxDecimalLength(BigInteger maxDecimalLength) {
    this.maxDecimalLength = maxDecimalLength;
  }
}
