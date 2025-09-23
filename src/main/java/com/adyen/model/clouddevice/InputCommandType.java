package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of input command. */
public enum InputCommandType {

  /**
   * Wait for a key pressed on the Terminal, to be able to read the messageType displayed on the
   * Terminal.
   */
  @Schema(
      description =
          "Wait for a key pressed on the Terminal, to be able to read the message displayed on the Terminal.")
  GET_ANY_KEY("GetAnyKey"),

  /**
   * Wait for a confirmation Yes (Y) or No (N) on the Sale Terminal. Wait for a confirmation (Valid
   * or Cancel button) on the POI Terminal. The result of the command
   */
  @Schema(
      description =
          "Wait for a confirmation Yes (Y) or No (N) on the Sale Terminal. Wait for a confirmation (Valid or Cancel button) on the POI Terminal. The result of the command")
  GET_CONFIRMATION("GetConfirmation"),

  /** Wait for a confirmation Yes (Y) or No (N) of the Site Manager on the Sale Terminal. */
  @Schema(
      description =
          "Wait for a confirmation Yes (Y) or No (N) of the Site Manager on the Sale Terminal.")
  SITE_MANAGER("SiteManager"),

  /** Wait for a string of alphanumeric characters, the length range could be specified. */
  @Schema(
      description =
          "Wait for a string of alphanumeric characters, the length range could be specified.")
  TEXT_STRING("TextString"),

  /** Wait for a string of digit characters, the length range could be specified. */
  @Schema(
      description = "Wait for a string of digit characters, the length range could be specified.")
  DIGIT_STRING("DigitString"),

  /**
   * Wait for a string of digit characters with a decimal point, the length range could be
   * specified.
   */
  @Schema(
      description =
          "Wait for a string of digit characters with a decimal point, the length range could be specified.")
  DECIMAL_STRING("DecimalString"),

  /**
   * Wait for a function key pressed on the Terminal: From POI, Valid, Clear, Correct, Generic
   * Function key number. From Sale, Generic Function key.
   */
  @Schema(
      description =
          "Wait for a function key pressed on the Terminal:  From POI, Valid, Clear, Correct, Generic Function key number. From Sale, Generic Function key.")
  GET_FUNCTION_KEY("GetFunctionKey"),

  /**
   * To choose an entry among a list of entrys (all of them are not necessary selectable). The
   * OutputFormat has to be MenuEntry.
   */
  @Schema(
      description =
          "To choose an entry among a list of entrys (all of them are not necessary selectable). The OutputFormat has to be MenuEntry.")
  GET_MENU_ENTRY("GetMenuEntry"),

  /** Request to enter a password with masked characters while typing the password. */
  @Schema(
      description = "Request to enter a password with masked characters while typing the password.")
  PASSWORD("Password");

  private final String value;

  InputCommandType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the InputCommandType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a InputCommandType from a string value.
   *
   * @param v the string value
   * @return the corresponding InputCommandType
   */
  @JsonCreator
  public static InputCommandType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}