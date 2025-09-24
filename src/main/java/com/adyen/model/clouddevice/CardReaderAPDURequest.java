package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Content of the Card Reader APDU Request message. */
@JsonPropertyOrder({
  "APDUData",
  "APDUClass",
  "APDUInstruction",
  "APDUPar1",
  "APDUPar2",
  "APDUExpectedLength"
})
public class CardReaderAPDURequest {

  @JsonProperty("APDUData")
  @Schema(description = "Data field of the APDU command (Lc + Data)")
  protected byte[] apduData;

  @JsonProperty("APDUClass")
  @Schema(description = "Class field of the APDU command (CLA)", minLength = 1, maxLength = 1)
  protected byte[] apduClass;

  @JsonProperty("APDUInstruction")
  @Schema(description = "Instruction field of the APDU command (INS)", minLength = 1, maxLength = 1)
  protected byte[] apduInstruction;

  @JsonProperty("APDUPar1")
  @Schema(description = "Parameter 1 field of the APDU command (P1)", minLength = 1, maxLength = 1)
  protected byte[] apduPar1;

  @JsonProperty("APDUPar2")
  @Schema(description = "Parameter 2 field of the APDU command(P2)", minLength = 1, maxLength = 1)
  protected byte[] apduPar2;

  @JsonProperty("APDUExpectedLength")
  @Schema(
      description = "Expected length of the data field of the APDU response to the command (Le)",
      minLength = 1,
      maxLength = 1)
  protected byte[] apduExpectedLength;

  /**
   * Gets apdu data.
   *
   * @return the apdu data
   */
  public byte[] getAPDUData() {
    return apduData;
  }

  /**
   * Sets apdu data.
   *
   * @param apduData the apdu data
   */
  public void setAPDUData(byte[] apduData) {
    this.apduData = apduData;
  }

  /**
   * Get apdu class.
   *
   * @return the byte [ ]
   */
  public byte[] getAPDUClass() {
    return apduClass;
  }

  /**
   * Sets apdu class.
   *
   * @param apduClass the apdu class
   */
  public void setAPDUClass(byte[] apduClass) {
    this.apduClass = apduClass;
  }

  /**
   * Get apdu instruction.
   *
   * @return the byte [ ]
   */
  public byte[] getAPDUInstruction() {
    return apduInstruction;
  }

  /**
   * Sets apdu instruction.
   *
   * @param apduInstruction the apdu instruction
   */
  public void setAPDUInstruction(byte[] apduInstruction) {
    this.apduInstruction = apduInstruction;
  }

  /**
   * Get apdu par 1.
   *
   * @return the byte [ ]
   */
  public byte[] getAPDUPar1() {
    return apduPar1;
  }

  /**
   * Sets apdu par 1.
   *
   * @param apduPar1 the apdu par 1
   */
  public void setAPDUPar1(byte[] apduPar1) {
    this.apduPar1 = apduPar1;
  }

  /**
   * Get apdu par 2.
   *
   * @return the byte [ ]
   */
  public byte[] getAPDUPar2() {
    return apduPar2;
  }

  /**
   * Sets apdu par 2.
   *
   * @param apduPar2 the apdu par 2
   */
  public void setAPDUPar2(byte[] apduPar2) {
    this.apduPar2 = apduPar2;
  }

  /**
   * Get apdu expected length.
   *
   * @return the byte [ ]
   */
  public byte[] getAPDUExpectedLength() {
    return apduExpectedLength;
  }

  /**
   * Sets apdu expected length.
   *
   * @param apduExpectedLength the apdu expected length
   */
  public void setAPDUExpectedLength(byte[] apduExpectedLength) {
    this.apduExpectedLength = apduExpectedLength;
  }
}
