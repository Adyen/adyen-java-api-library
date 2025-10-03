package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

public class StoredValueAccountID {

  @JsonProperty("StoredValueAccountType")
  @Schema(description = "Type of stored value account")
  protected StoredValueAccountType storedValueAccountType;

  @JsonProperty("StoredValueProvider")
  @Schema(
      description =
          "Identification of the provider of the stored value account load/reload --Rule: If available for the card or account.")
  protected String storedValueProvider;

  @JsonProperty("OwnerName")
  @Schema(description = "Owner name of an account --Rule: If available for the card or account.")
  protected String ownerName;

  @JsonProperty("ExpiryDate")
  @Schema(
      description =
          "Date after which the card cannot be used. --Rule: If required for the card or account.")
  protected String expiryDate;

  @JsonProperty("EntryMode")
  @Schema(description = "Entry mode of the payment instrument information")
  protected List<EntryModeType> entryMode;

  @JsonProperty("IdentificationType")
  @Schema(description = "Type of account identification")
  protected IdentificationType identificationType;

  @JsonProperty("StoredValueID")
  @Schema(description = "Stored value account identification")
  protected String storedValueID;

  /**
   * Gets the value of the storedValueAccountType property.
   *
   * @return possible object is {@link StoredValueAccountType }
   */
  public StoredValueAccountType getStoredValueAccountType() {
    return storedValueAccountType;
  }

  /**
   * Sets the value of the storedValueAccountType property.
   *
   * @param value allowed object is {@link StoredValueAccountType }
   */
  public void setStoredValueAccountType(StoredValueAccountType value) {
    this.storedValueAccountType = value;
  }

  /**
   * Gets the value of the storedValueProvider property.
   *
   * @return possible object is {@link String }
   */
  public String getStoredValueProvider() {
    return storedValueProvider;
  }

  /**
   * Sets the value of the storedValueProvider property.
   *
   * @param value allowed object is {@link String }
   */
  public void setStoredValueProvider(String value) {
    this.storedValueProvider = value;
  }

  /**
   * Gets the value of the ownerName property.
   *
   * @return possible object is {@link String }
   */
  public String getOwnerName() {
    return ownerName;
  }

  /**
   * Sets the value of the ownerName property.
   *
   * @param value allowed object is {@link String }
   */
  public void setOwnerName(String value) {
    this.ownerName = value;
  }

  /**
   * Gets the value of the expiryDate property.
   *
   * @return possible object is {@link String }
   */
  public String getExpiryDate() {
    return expiryDate;
  }

  /**
   * Sets the value of the expiryDate property.
   *
   * @param value allowed object is {@link String }
   */
  public void setExpiryDate(String value) {
    this.expiryDate = value;
  }

  /**
   * Gets the value of the entryMode property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the entryMode property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getEntryMode().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link EntryModeType }
   */
  public List<EntryModeType> getEntryMode() {
    if (entryMode == null) {
      entryMode = new ArrayList<>();
    }
    return this.entryMode;
  }

  /**
   * Gets the value of the identificationType property.
   *
   * @return possible object is {@link IdentificationType }
   */
  public IdentificationType getIdentificationType() {
    return identificationType;
  }

  /**
   * Sets the value of the identificationType property.
   *
   * @param value allowed object is {@link IdentificationType }
   */
  public void setIdentificationType(IdentificationType value) {
    this.identificationType = value;
  }

  /**
   * Gets the value of the storedValueID property.
   *
   * @return possible object is {@link String }
   */
  public String getStoredValueID() {
    return storedValueID;
  }

  /**
   * Sets the value of the storedValueID property.
   *
   * @param value allowed object is {@link String }
   */
  public void setStoredValueID(String value) {
    this.storedValueID = value;
  }
}
