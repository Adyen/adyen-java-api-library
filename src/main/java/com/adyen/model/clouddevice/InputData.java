package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigInteger;

/** Information related to an Input request. */
@JsonPropertyOrder({
    "DefaultInputString",
    "StringMask",
    "Device",
    "InfoQualify",
    "InputCommand",
    "NotifyCardInputFlag",
    "MaxInputTime",
    "ImmediateResponseFlag",
    "MinLength",
    "MaxLength",
    "MaxDecimalLength",
    "WaitUserValidationFlag",
    "FromRightToLeftFlag",
    "MaskCharactersFlag",
    "BeepKeyFlag",
    "GlobalCorrectionFlag",
    "DisableCancelFlag",
    "DisableCorrectFlag",
    "DisableValidFlag",
    "MenuBackFlag"
})
public class InputData {

  @JsonProperty("DefaultInputString")
  @Schema(
      description =
          "Default string value for an input command. --Rule: Not allowed if InputCommand is not TextString, DigitString or DecimalString")
  protected String defaultInputString;

  @JsonProperty("StringMask")
  @Schema(
      description =
          "String mask to get information requiring a specific format. --Rule: Not allowed if InputCommand is not TextString, DigitString or DecimalString")
  protected String stringMask;

  @JsonProperty("Device")
  @Schema(
      description =
          "Logical device located on a Sale Terminal or a POI Terminal, in term of class of information to output (display, print --Rule: CashierInput , CustomerInput, CustomerAssistance")
  protected DeviceType device;

  @JsonProperty("InfoQualify")
  @Schema(
      description =
          "Qualification of the information to sent to an output logical device, to display or print to the Cashier or the --Rule: Input, CustomerAssistance")
  protected InfoQualifyType infoQualify;

  @JsonProperty("InputCommand")
  @Schema(description = "Type of requested input")
  protected InputCommandType inputCommand;

  @JsonProperty("NotifyCardInputFlag")
  @Schema(description = "Request Notification of card entered in the POI card reader.")
  protected Boolean notifyCardInputFlag;

  @JsonProperty("MaxInputTime")
  @Schema(description = "Maximum input time in seconds --Rule: If time limit for responding")
  protected BigInteger maxInputTime;

  @JsonProperty("ImmediateResponseFlag")
  @Schema(
      description =
          "Request Immediate response to the message without waiting for the completion of the command. --Rule: Optional if InputCommand is \"GetAnyKey\".")
  protected Boolean immediateResponseFlag;

  @JsonProperty("MinLength")
  @Schema(
      description =
          "Minimum input length --Rule: Not allowed if InputCommand is not TextString or DigitString")
  protected BigInteger minLength;

  @JsonProperty("MaxLength")
  @Schema(
      description =
          "Maximum input length --Rule: Not allowed if InputCommand is not TextString or DigitString")
  protected BigInteger maxLength;

  @JsonProperty("MaxDecimalLength")
  @Schema(
      description =
          "Maximum input length of the decimal part (without decimal point) --Rule: Not allowed if InputCommand is not DecimalString Greater than MinLength, lower than MaxLength.")
  protected BigInteger maxDecimalLength;

  @JsonProperty("WaitUserValidationFlag")
  @Schema(
      description =
          "Indicates that the user must confirm the entered characters, when the maximum allowed length is reached. --Rule: Optional if MaxLength or MaxDecimalLength present ")
  protected Boolean waitUserValidationFlag;

  @JsonProperty("FromRightToLeftFlag")
  @Schema(
      description =
          "Indicate if the entered character has to be displayed from the right to the left of the display field. --Rule: Not allowed if InputCommand is not TextString, DigitString or DecimalString")
  protected Boolean fromRightToLeftFlag;

  @JsonProperty("MaskCharactersFlag")
  @Schema(
      description =
          "Indicates to mask the characters entered by the user (i.e. replacing in the display of the input, the entered character --Rule: Not allowed if InputCommand is not TextString, DigitString or Password")
  protected Boolean maskCharactersFlag;

  @JsonProperty("BeepKeyFlag")
  @Schema(
      description =
          "Indicates, when the user press a key, if a beep has to be generated (value True).")
  protected Boolean beepKeyFlag;

  @JsonProperty("GlobalCorrectionFlag")
  @Schema(
      description =
          "Indicates, when the user press the Correct function key in an input entry, if all the entered characters are removed --Rule: Not allowed if InputCommand is not TextString, DigitString, Password or DecimalString")
  protected Boolean globalCorrectionFlag;

  @JsonProperty("DisableCancelFlag")
  @Schema(
      description =
          "Indicates if the Cancel function key has to be desactived (value True). --Rule: Not allowed if InputCommand is not GetConfirmation, SiteManager, or GetMenuEntry")
  protected Boolean disableCancelFlag;

  @JsonProperty("DisableCorrectFlag")
  @Schema(
      description =
          "Indicates if the Correct function key has to be desactived (value True). --Rule: Not allowed if InputCommand is not GetConfirmation, SiteManager, or GetMenuEntry")
  protected Boolean disableCorrectFlag;

  @JsonProperty("DisableValidFlag")
  @Schema(
      description =
          "Indicates if the Valid function key has to be desactived (value True). --Rule: Not allowed if InputCommand is not GetConfirmation, SiteManager, or GetMenuEntry")
  protected Boolean disableValidFlag;

  @JsonProperty("MenuBackFlag")
  @Schema(
      description =
          "If it has the value True, it indicates that the \"Back\" function key (respectively \"Home\" function key) may be used to --Rule: Allowed for the GetMenuEntry value of InputCommand.")
  protected Boolean menuBackFlag;

  /**
   * Gets default input string.
   *
   * @return the default input string
   */
  public String getDefaultInputString() {
    return defaultInputString;
  }

  /**
   * Sets default input string.
   *
   * @param defaultInputString the default input string
   */
  public void setDefaultInputString(String defaultInputString) {
    this.defaultInputString = defaultInputString;
  }

  /**
   * Gets string mask.
   *
   * @return the string mask
   */
  public String getStringMask() {
    return stringMask;
  }

  /**
   * Sets string mask.
   *
   * @param stringMask the string mask
   */
  public void setStringMask(String stringMask) {
    this.stringMask = stringMask;
  }

  /**
   * Gets device.
   *
   * @return the device
   */
  public DeviceType getDevice() {
    return device;
  }

  /**
   * Sets device.
   *
   * @param device the device
   */
  public void setDevice(DeviceType device) {
    this.device = device;
  }

  /**
   * Gets info qualify.
   *
   * @return the info qualify
   */
  public InfoQualifyType getInfoQualify() {
    return infoQualify;
  }

  /**
   * Sets info qualify.
   *
   * @param infoQualify the info qualify
   */
  public void setInfoQualify(InfoQualifyType infoQualify) {
    this.infoQualify = infoQualify;
  }

  /**
   * Gets input command.
   *
   * @return the input command
   */
  public InputCommandType getInputCommand() {
    return inputCommand;
  }

  /**
   * Sets input command.
   *
   * @param inputCommand the input command
   */
  public void setInputCommand(InputCommandType inputCommand) {
    this.inputCommand = inputCommand;
  }

  /**
   * Is notify card input flag boolean.
   *
   * @return the boolean
   */
  public boolean isNotifyCardInputFlag() {
    if (notifyCardInputFlag == null) {
      return false;
    } else {
      return notifyCardInputFlag;
    }
  }

  /**
   * Sets notify card input flag.
   *
   * @param notifyCardInputFlag the notify card input flag
   */
  public void setNotifyCardInputFlag(Boolean notifyCardInputFlag) {
    this.notifyCardInputFlag = notifyCardInputFlag;
  }

  /**
   * Gets max input time.
   *
   * @return the max input time
   */
  public BigInteger getMaxInputTime() {
    return maxInputTime;
  }

  /**
   * Sets max input time.
   *
   * @param maxInputTime the max input time
   */
  public void setMaxInputTime(BigInteger maxInputTime) {
    this.maxInputTime = maxInputTime;
  }

  /**
   * Is immediate response flag boolean.
   *
   * @return the boolean
   */
  public boolean isImmediateResponseFlag() {
    if (immediateResponseFlag == null) {
      return false;
    } else {
      return immediateResponseFlag;
    }
  }

  /**
   * Sets immediate response flag.
   *
   * @param immediateResponseFlag the immediate response flag
   */
  public void setImmediateResponseFlag(Boolean immediateResponseFlag) {
    this.immediateResponseFlag = immediateResponseFlag;
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

  /**
   * Is wait user validation flag boolean.
   *
   * @return the boolean
   */
  public boolean isWaitUserValidationFlag() {
    if (waitUserValidationFlag == null) {
      return true;
    } else {
      return waitUserValidationFlag;
    }
  }

  /**
   * Sets wait user validation flag.
   *
   * @param waitUserValidationFlag the wait user validation flag
   */
  public void setWaitUserValidationFlag(Boolean waitUserValidationFlag) {
    this.waitUserValidationFlag = waitUserValidationFlag;
  }

  /**
   * Is from right to left flag boolean.
   *
   * @return the boolean
   */
  public boolean isFromRightToLeftFlag() {
    if (fromRightToLeftFlag == null) {
      return false;
    } else {
      return fromRightToLeftFlag;
    }
  }

  /**
   * Sets from right to left flag.
   *
   * @param fromRightToLeftFlag the from right to left flag
   */
  public void setFromRightToLeftFlag(Boolean fromRightToLeftFlag) {
    this.fromRightToLeftFlag = fromRightToLeftFlag;
  }

  /**
   * Is mask characters flag boolean.
   *
   * @return the boolean
   */
  public boolean isMaskCharactersFlag() {
    if (maskCharactersFlag == null) {
      return false;
    } else {
      return maskCharactersFlag;
    }
  }

  /**
   * Sets mask characters flag.
   *
   * @param maskCharactersFlag the mask characters flag
   */
  public void setMaskCharactersFlag(Boolean maskCharactersFlag) {
    this.maskCharactersFlag = maskCharactersFlag;
  }

  /**
   * Is beep key flag boolean.
   *
   * @return the boolean
   */
  public boolean isBeepKeyFlag() {
    if (beepKeyFlag == null) {
      return false;
    } else {
      return beepKeyFlag;
    }
  }

  /**
   * Sets beep key flag.
   *
   * @param beepKeyFlag the beep key flag
   */
  public void setBeepKeyFlag(Boolean beepKeyFlag) {
    this.beepKeyFlag = beepKeyFlag;
  }

  /**
   * Is global correction flag boolean.
   *
   * @return the boolean
   */
  public boolean isGlobalCorrectionFlag() {
    if (globalCorrectionFlag == null) {
      return false;
    } else {
      return globalCorrectionFlag;
    }
  }

  /**
   * Sets global correction flag.
   *
   * @param globalCorrectionFlag the global correction flag
   */
  public void setGlobalCorrectionFlag(Boolean globalCorrectionFlag) {
    this.globalCorrectionFlag = globalCorrectionFlag;
  }

  /**
   * Is disable cancel flag boolean.
   *
   * @return the boolean
   */
  public boolean isDisableCancelFlag() {
    if (disableCancelFlag == null) {
      return false;
    } else {
      return disableCancelFlag;
    }
  }

  /**
   * Sets disable cancel flag.
   *
   * @param disableCancelFlag the disable cancel flag
   */
  public void setDisableCancelFlag(Boolean disableCancelFlag) {
    this.disableCancelFlag = disableCancelFlag;
  }

  /**
   * Is disable correct flag boolean.
   *
   * @return the boolean
   */
  public boolean isDisableCorrectFlag() {
    if (disableCorrectFlag == null) {
      return false;
    } else {
      return disableCorrectFlag;
    }
  }

  /**
   * Sets disable correct flag.
   *
   * @param disableCorrectFlag the disable correct flag
   */
  public void setDisableCorrectFlag(Boolean disableCorrectFlag) {
    this.disableCorrectFlag = disableCorrectFlag;
  }

  /**
   * Is disable valid flag boolean.
   *
   * @return the boolean
   */
  public boolean isDisableValidFlag() {
    if (disableValidFlag == null) {
      return false;
    } else {
      return disableValidFlag;
    }
  }

  /**
   * Sets disable valid flag.
   *
   * @param disableValidFlag the disable valid flag
   */
  public void setDisableValidFlag(Boolean disableValidFlag) {
    this.disableValidFlag = disableValidFlag;
  }

  /**
   * Is menu back flag boolean.
   *
   * @return the boolean
   */
  public boolean isMenuBackFlag() {
    if (menuBackFlag == null) {
      return false;
    } else {
      return menuBackFlag;
    }
  }

  /**
   * Sets menu back flag.
   *
   * @param menuBackFlag the menu back flag
   */
  public void setMenuBackFlag(Boolean menuBackFlag) {
    this.menuBackFlag = menuBackFlag;
  }
}