package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of result. */
public enum ResultType {

  /**
   * Processing OK. Information related to the result of the processing is contained in other parts
   * of the response messageType.
   */
  @Schema(
      description =
          "Processing OK. Information related to the result of the processing is contained in other parts of the response message.")
  SUCCESS("Success"),

  /** ErrorCondition */
  @Schema(description = "ErrorCondition")
  FAILURE("Failure"),

  /**
   * The transaction has been processed successfully, but the success is not complete (e.g. only a
   * partial amount is available for the payment, the format to be
   */
  @Schema(
      description =
          "The transaction has been processed successfully, but the success is not complete (e.g. only a partial amount is available for the payment, the format to be")
  PARTIAL("Partial");

  private final String value;

  ResultType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the ResultType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a ResultType from a string value.
   *
   * @param v the string value
   * @return the corresponding ResultType
   */
  @JsonCreator
  public static ResultType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}