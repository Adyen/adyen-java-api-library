package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Identification of a Loyalty account. */
@JsonPropertyOrder({"LoyaltyID", "EntryMode", "IdentificationType", "IdentificationSupport"})
public class LoyaltyAccountID {

  @JsonProperty("LoyaltyID")
  @Schema(description = "Loyalty account identification")
  protected String loyaltyID;

  @JsonProperty("EntryMode")
  @Schema(description = "Entry mode of the payment instrument information")
  protected List<EntryModeType> entryMode;

  @JsonProperty("IdentificationType")
  @Schema(description = "Type of account identification")
  protected IdentificationType identificationType;

  @JsonProperty("IdentificationSupport")
  @Schema(
      description =
          "Support of the loyalty account identification --Rule: if PaymentResponse or LoyaltyResponse or BalanceInquiryResponse")
  protected IdentificationSupportType identificationSupport;

  /**
   * Gets loyalty id.
   *
   * @return the loyalty id
   */
  public String getLoyaltyID() {
    return loyaltyID;
  }

  /**
   * Sets loyalty id.
   *
   * @param loyaltyID the loyalty id
   */
  public void setLoyaltyID(String loyaltyID) {
    this.loyaltyID = loyaltyID;
  }

  /**
   * Gets entry mode.
   *
   * @return the entry mode
   */
  public List<EntryModeType> getEntryMode() {
    if (entryMode == null) {
      entryMode = new ArrayList<>();
    }
    return this.entryMode;
  }

  /**
   * Sets entry mode.
   *
   * @param entryMode the entry mode
   */
  public void setEntryMode(List<EntryModeType> entryMode) {
    this.entryMode = entryMode;
  }

  /**
   * Gets identification type.
   *
   * @return the identification type
   */
  public IdentificationType getIdentificationType() {
    return identificationType;
  }

  /**
   * Sets identification type.
   *
   * @param identificationType the identification type
   */
  public void setIdentificationType(IdentificationType identificationType) {
    this.identificationType = identificationType;
  }

  /**
   * Gets identification support.
   *
   * @return the identification support
   */
  public IdentificationSupportType getIdentificationSupport() {
    return identificationSupport;
  }

  /**
   * Sets identification support.
   *
   * @param identificationSupport the identification support
   */
  public void setIdentificationSupport(IdentificationSupportType identificationSupport) {
    this.identificationSupport = identificationSupport;
  }
}
