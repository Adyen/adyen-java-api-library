package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Data entered by the user, related to the input command. */
@JsonPropertyOrder({
  "ConfirmedFlag",
  "FunctionKey",
  "TextInput",
  "DigitInput",
  "Password",
  "MenuEntryNumber",
  "InputCommand"
})
public class Input {

  @JsonProperty("ConfirmedFlag")
  @Schema(
      description =
          "Confirmation or not of what has been requested to the user in a GetConfirmation input command. --Rule: Mandatory, if InputCommand is GetConfirmation or SiteManager Not allowed, otherwise")
  protected Boolean confirmedFlag;

  @JsonProperty("FunctionKey")
  @Schema(
      description =
          "The number of the function key which is typed by the Customer on the POI or the Cashier on the Sale Terminal. --Rule: Mandatory, if InputCommand is GetFunctionKey  Not allowed, otherwise")
  protected String functionKey;

  @JsonProperty("TextInput")
  @Schema(
      description =
          "The text which is typed by the Customer on the POI or the Cashier on the Sale Terminal. --Rule: Mandatory, if InputCommand is TextString  Not allowed, otherwise")
  protected String textInput;

  @JsonProperty("DigitInput")
  @Schema(
      description =
          "The digits which are typed by the Customer on the POI or the Cashier on the Sale Terminal. --Rule: Mandatory, if InputCommand is DigitString  Not allowed, otherwise")
  protected String digitInput;

  @JsonProperty("Password")
  @Schema(
      description =
          "A text password which is typed by the Customer on the POI or the Cashier on the Sale Terminal. --Rule: Mandatory, if InputCommand is Password  Not allowed, otherwise")
  protected ContentInformation password;

  @JsonProperty("MenuEntryNumber")
  @Schema(
      description =
          "The index from 1 to n, of the menu item which is selected by the Cashier on the Sale Terminal. The value -1 indicates --Rule: Mandatory, if InputCommand is GetMenuEntry  Not allowed, otherwise")
  protected Integer[] menuEntryNumber;

  @JsonProperty("InputCommand")
  @Schema(description = "Type of requested input --Rule: Copy")
  protected InputCommandType inputCommand;

  /**
   * Is confirmed flag boolean.
   *
   * @return the boolean
   */
  public Boolean isConfirmedFlag() {
    return confirmedFlag;
  }

  /**
   * Sets confirmed flag.
   *
   * @param confirmedFlag the confirmed flag
   */
  public void setConfirmedFlag(Boolean confirmedFlag) {
    this.confirmedFlag = confirmedFlag;
  }

  /**
   * Gets function key.
   *
   * @return the function key
   */
  public String getFunctionKey() {
    return functionKey;
  }

  /**
   * Sets function key.
   *
   * @param functionKey the function key
   */
  public void setFunctionKey(String functionKey) {
    this.functionKey = functionKey;
  }

  /**
   * Gets text input.
   *
   * @return the text input
   */
  public String getTextInput() {
    return textInput;
  }

  /**
   * Sets text input.
   *
   * @param textInput the text input
   */
  public void setTextInput(String textInput) {
    this.textInput = textInput;
  }

  /**
   * Gets digit input.
   *
   * @return the digit input
   */
  public String getDigitInput() {
    return digitInput;
  }

  /**
   * Sets digit input.
   *
   * @param digitInput the digit input
   */
  public void setDigitInput(String digitInput) {
    this.digitInput = digitInput;
  }

  /**
   * Gets password.
   *
   * @return the password
   */
  public ContentInformation getPassword() {
    return password;
  }

  /**
   * Sets password.
   *
   * @param password the password
   */
  public void setPassword(ContentInformation password) {
    this.password = password;
  }

  /**
   * Get menu entry number.
   *
   * @return the integer [ ]
   */
  public Integer[] getMenuEntryNumber() {
    return menuEntryNumber;
  }

  /**
   * Sets menu entry number.
   *
   * @param menuEntryNumber the menu entry number
   */
  public void setMenuEntryNumber(Integer[] menuEntryNumber) {
    this.menuEntryNumber = menuEntryNumber;
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
}
