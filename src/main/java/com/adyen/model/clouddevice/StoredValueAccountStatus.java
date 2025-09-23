package com.adyen.model.clouddevice;

import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class StoredValueAccountStatus {

  /** The Stored value account id. */
  @JsonProperty("StoredValueAccountID")
  @Schema(description = "Identification of the stored value account or the stored value card")
  protected StoredValueAccountID storedValueAccountID;

  /** The Current balance. */
  @JsonProperty("CurrentBalance")
  @Schema(description = "Balance of an account. --Rule: if relevant and known")
  protected BigDecimal currentBalance;

  /**
   * Gets the value of the storedValueAccountID property.
   *
   * @return possible object is {@link StoredValueAccountID }
   */
  public StoredValueAccountID getStoredValueAccountID() {
    return storedValueAccountID;
  }

  /**
   * Sets the value of the storedValueAccountID property.
   *
   * @param value allowed object is {@link StoredValueAccountID }
   */
  public void setStoredValueAccountID(StoredValueAccountID value) {
    this.storedValueAccountID = value;
  }

  /**
   * Gets the value of the currentBalance property.
   *
   * @return possible object is {@link BigDecimal }
   */
  public BigDecimal getCurrentBalance() {
    return currentBalance;
  }

  /**
   * Sets the value of the currentBalance property.
   *
   * @param value allowed object is {@link BigDecimal }
   */
  public void setCurrentBalance(BigDecimal value) {
    this.currentBalance = value;
  }
}
