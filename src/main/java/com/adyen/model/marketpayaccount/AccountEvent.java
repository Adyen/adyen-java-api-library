/*
 * Account API
 * This API is used for the classic integration. If you are just starting your implementation, refer to our [new integration guide](https://docs.adyen.com/marketplaces-and-platforms) instead.  The Account API provides endpoints for managing account-related entities on your platform. These related entities include account holders, accounts, bank accounts, shareholders, and verification-related documents. The management operations include actions such as creation, retrieval, updating, and deletion of them.  For more information, refer to our [documentation](https://docs.adyen.com/marketplaces-and-platforms/classic). ## Authentication Your Adyen contact will provide your API credential and an API key. To connect to the API, add an `X-API-Key` header with the API key as the value, for example:   ``` curl -H \"Content-Type: application/json\" \\ -H \"X-API-Key: YOUR_API_KEY\" \\ ... ```  Alternatively, you can use the username and password to connect to the API using basic authentication. For example:  ``` curl -U \"ws@MarketPlace.YOUR_PLATFORM_ACCOUNT\":\"YOUR_WS_PASSWORD\" \\ -H \"Content-Type: application/json\" \\ ... ``` When going live, you need to generate new web service user credentials to access the [live endpoints](https://docs.adyen.com/development-resources/live-endpoints).  ## Versioning The Account API supports [versioning](https://docs.adyen.com/development-resources/versioning) using a version suffix in the endpoint URL. This suffix has the following format: \"vXX\", where XX is the version number.  For example: ``` https://cal-test.adyen.com/cal/services/Account/v6/createAccountHolder ```
 *
 * The version of the OpenAPI document: 6
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.adyen.model.marketpayaccount;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;


/**
 * AccountEvent
 */
@JsonPropertyOrder({
  AccountEvent.JSON_PROPERTY_EVENT,
  AccountEvent.JSON_PROPERTY_EXECUTION_DATE,
  AccountEvent.JSON_PROPERTY_REASON
})

public class AccountEvent {
  /**
   * The event. &gt;Permitted values: &#x60;InactivateAccount&#x60;, &#x60;RefundNotPaidOutTransfers&#x60;. For more information, refer to [Verification checks](https://docs.adyen.com/marketplaces-and-platforms/classic/verification-process).
   */
  public enum EventEnum {
    INACTIVATEACCOUNT("InactivateAccount"),
    
    REFUNDNOTPAIDOUTTRANSFERS("RefundNotPaidOutTransfers");

    private String value;

    EventEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EventEnum fromValue(String value) {
      for (EventEnum b : EventEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_EVENT = "event";
  private EventEnum event;

  public static final String JSON_PROPERTY_EXECUTION_DATE = "executionDate";
  private OffsetDateTime executionDate;

  public static final String JSON_PROPERTY_REASON = "reason";
  private String reason;

  public AccountEvent() { 
  }

  public AccountEvent event(EventEnum event) {
    this.event = event;
    return this;
  }

   /**
   * The event. &gt;Permitted values: &#x60;InactivateAccount&#x60;, &#x60;RefundNotPaidOutTransfers&#x60;. For more information, refer to [Verification checks](https://docs.adyen.com/marketplaces-and-platforms/classic/verification-process).
   * @return event
  **/
  @ApiModelProperty(value = "The event. >Permitted values: `InactivateAccount`, `RefundNotPaidOutTransfers`. For more information, refer to [Verification checks](https://docs.adyen.com/marketplaces-and-platforms/classic/verification-process).")
  @JsonProperty(JSON_PROPERTY_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public EventEnum getEvent() {
    return event;
  }


  @JsonProperty(JSON_PROPERTY_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEvent(EventEnum event) {
    this.event = event;
  }


  public AccountEvent executionDate(OffsetDateTime executionDate) {
    this.executionDate = executionDate;
    return this;
  }

   /**
   * The date on which the event will take place.
   * @return executionDate
  **/
  @ApiModelProperty(value = "The date on which the event will take place.")
  @JsonProperty(JSON_PROPERTY_EXECUTION_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getExecutionDate() {
    return executionDate;
  }


  @JsonProperty(JSON_PROPERTY_EXECUTION_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExecutionDate(OffsetDateTime executionDate) {
    this.executionDate = executionDate;
  }


  public AccountEvent reason(String reason) {
    this.reason = reason;
    return this;
  }

   /**
   * The reason why this event has been created.
   * @return reason
  **/
  @ApiModelProperty(value = "The reason why this event has been created.")
  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getReason() {
    return reason;
  }


  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReason(String reason) {
    this.reason = reason;
  }


  /**
   * Return true if this AccountEvent object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountEvent accountEvent = (AccountEvent) o;
    return Objects.equals(this.event, accountEvent.event) &&
        Objects.equals(this.executionDate, accountEvent.executionDate) &&
        Objects.equals(this.reason, accountEvent.reason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(event, executionDate, reason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountEvent {\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    executionDate: ").append(toIndentedString(executionDate)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

/**
   * Create an instance of AccountEvent given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of AccountEvent
   * @throws JsonProcessingException if the JSON string is invalid with respect to AccountEvent
   */
  public static AccountEvent fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, AccountEvent.class);
  }
/**
  * Convert an instance of AccountEvent to an JSON string
  *
  * @return JSON string
  */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
