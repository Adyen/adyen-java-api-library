/*
 * Adyen Terminal API
 *
 * The version of the OpenAPI document: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.adyen.model.terminal;

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
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;


/**
 * Customer order attached to a customer, recorded in the POI system.  Allows the management of customer orders by the POI, for instance in a multi-channel or a click and collect sale transaction.
 */
@ApiModel(description = "Customer order attached to a customer, recorded in the POI system.  Allows the management of customer orders by the POI, for instance in a multi-channel or a click and collect sale transaction.")
@JsonPropertyOrder({
  CustomerOrder.JSON_PROPERTY_CUSTOMER_ORDER_I_D,
  CustomerOrder.JSON_PROPERTY_SALE_REFERENCE_I_D,
  CustomerOrder.JSON_PROPERTY_OPEN_ORDER_STATE,
  CustomerOrder.JSON_PROPERTY_START_DATE,
  CustomerOrder.JSON_PROPERTY_END_DATE,
  CustomerOrder.JSON_PROPERTY_FORECASTED_AMOUNT,
  CustomerOrder.JSON_PROPERTY_CURRENT_AMOUNT,
  CustomerOrder.JSON_PROPERTY_CURRENCY,
  CustomerOrder.JSON_PROPERTY_ACCESSED_BY,
  CustomerOrder.JSON_PROPERTY_ADDITIONAL_INFORMATION
})

public class CustomerOrder {
  public static final String JSON_PROPERTY_CUSTOMER_ORDER_I_D = "CustomerOrderID";
  private String customerOrderID;

  public static final String JSON_PROPERTY_SALE_REFERENCE_I_D = "SaleReferenceID";
  private String saleReferenceID;

  public static final String JSON_PROPERTY_OPEN_ORDER_STATE = "OpenOrderState";
  private Boolean openOrderState = true;

  public static final String JSON_PROPERTY_START_DATE = "StartDate";
  private OffsetDateTime startDate;

  public static final String JSON_PROPERTY_END_DATE = "EndDate";
  private OffsetDateTime endDate;

  public static final String JSON_PROPERTY_FORECASTED_AMOUNT = "ForecastedAmount";
  private BigDecimal forecastedAmount;

  public static final String JSON_PROPERTY_CURRENT_AMOUNT = "CurrentAmount";
  private BigDecimal currentAmount;

  public static final String JSON_PROPERTY_CURRENCY = "Currency";
  private String currency;

  public static final String JSON_PROPERTY_ACCESSED_BY = "AccessedBy";
  private String accessedBy;

  public static final String JSON_PROPERTY_ADDITIONAL_INFORMATION = "AdditionalInformation";
  private String additionalInformation;

  public CustomerOrder() { 
  }

  public CustomerOrder customerOrderID(String customerOrderID) {
    this.customerOrderID = customerOrderID;
    return this;
  }

   /**
   * Additional and optional identification of a customer order.
   * @return customerOrderID
  **/
  @ApiModelProperty(value = "Additional and optional identification of a customer order.")
  @JsonProperty(JSON_PROPERTY_CUSTOMER_ORDER_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCustomerOrderID() {
    return customerOrderID;
  }


 /**
  * Additional and optional identification of a customer order.
  *
  * @param customerOrderID
  */ 
  @JsonProperty(JSON_PROPERTY_CUSTOMER_ORDER_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCustomerOrderID(String customerOrderID) {
    this.customerOrderID = customerOrderID;
  }


  public CustomerOrder saleReferenceID(String saleReferenceID) {
    this.saleReferenceID = saleReferenceID;
    return this;
  }

   /**
   * Get saleReferenceID
   * @return saleReferenceID
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SALE_REFERENCE_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSaleReferenceID() {
    return saleReferenceID;
  }


 /**
  * saleReferenceID
  *
  * @param saleReferenceID
  */ 
  @JsonProperty(JSON_PROPERTY_SALE_REFERENCE_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSaleReferenceID(String saleReferenceID) {
    this.saleReferenceID = saleReferenceID;
  }


  public CustomerOrder openOrderState(Boolean openOrderState) {
    this.openOrderState = openOrderState;
    return this;
  }

   /**
   * Get openOrderState
   * @return openOrderState
  **/
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_OPEN_ORDER_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getOpenOrderState() {
    return openOrderState;
  }


 /**
  * openOrderState
  *
  * @param openOrderState
  */ 
  @JsonProperty(JSON_PROPERTY_OPEN_ORDER_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOpenOrderState(Boolean openOrderState) {
    this.openOrderState = openOrderState;
  }


  public CustomerOrder startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

   /**
   * Date time of the beginning of an operation.
   * @return startDate
  **/
  @ApiModelProperty(required = true, value = "Date time of the beginning of an operation.")
  @JsonProperty(JSON_PROPERTY_START_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getStartDate() {
    return startDate;
  }


 /**
  * Date time of the beginning of an operation.
  *
  * @param startDate
  */ 
  @JsonProperty(JSON_PROPERTY_START_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }


  public CustomerOrder endDate(OffsetDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

   /**
   * Date time of the end of an operation.
   * @return endDate
  **/
  @ApiModelProperty(value = "Date time of the end of an operation.")
  @JsonProperty(JSON_PROPERTY_END_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getEndDate() {
    return endDate;
  }


 /**
  * Date time of the end of an operation.
  *
  * @param endDate
  */ 
  @JsonProperty(JSON_PROPERTY_END_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEndDate(OffsetDateTime endDate) {
    this.endDate = endDate;
  }


  public CustomerOrder forecastedAmount(BigDecimal forecastedAmount) {
    this.forecastedAmount = forecastedAmount;
    return this;
  }

   /**
   * Get forecastedAmount
   * minimum: 0.0
   * maximum: 99999999.999999
   * @return forecastedAmount
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_FORECASTED_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BigDecimal getForecastedAmount() {
    return forecastedAmount;
  }


 /**
  * forecastedAmount
  *
  * @param forecastedAmount
  */ 
  @JsonProperty(JSON_PROPERTY_FORECASTED_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setForecastedAmount(BigDecimal forecastedAmount) {
    this.forecastedAmount = forecastedAmount;
  }


  public CustomerOrder currentAmount(BigDecimal currentAmount) {
    this.currentAmount = currentAmount;
    return this;
  }

   /**
   * Total amount of all completed transactions of a customer order.
   * minimum: 0.0
   * maximum: 99999999.999999
   * @return currentAmount
  **/
  @ApiModelProperty(required = true, value = "Total amount of all completed transactions of a customer order.")
  @JsonProperty(JSON_PROPERTY_CURRENT_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BigDecimal getCurrentAmount() {
    return currentAmount;
  }


 /**
  * Total amount of all completed transactions of a customer order.
  *
  * @param currentAmount
  */ 
  @JsonProperty(JSON_PROPERTY_CURRENT_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCurrentAmount(BigDecimal currentAmount) {
    this.currentAmount = currentAmount;
  }


  public CustomerOrder currency(String currency) {
    this.currency = currency;
    return this;
  }

   /**
   * Currency of a monetary amount.
   * @return currency
  **/
  @ApiModelProperty(value = "Currency of a monetary amount.")
  @JsonProperty(JSON_PROPERTY_CURRENCY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCurrency() {
    return currency;
  }


 /**
  * Currency of a monetary amount.
  *
  * @param currency
  */ 
  @JsonProperty(JSON_PROPERTY_CURRENCY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCurrency(String currency) {
    this.currency = currency;
  }


  public CustomerOrder accessedBy(String accessedBy) {
    this.accessedBy = accessedBy;
    return this;
  }

   /**
   * Get accessedBy
   * @return accessedBy
  **/
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ACCESSED_BY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAccessedBy() {
    return accessedBy;
  }


 /**
  * accessedBy
  *
  * @param accessedBy
  */ 
  @JsonProperty(JSON_PROPERTY_ACCESSED_BY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAccessedBy(String accessedBy) {
    this.accessedBy = accessedBy;
  }


  public CustomerOrder additionalInformation(String additionalInformation) {
    this.additionalInformation = additionalInformation;
    return this;
  }

   /**
   * Unqualified information.
   * @return additionalInformation
  **/
  @ApiModelProperty(value = "Unqualified information.")
  @JsonProperty(JSON_PROPERTY_ADDITIONAL_INFORMATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAdditionalInformation() {
    return additionalInformation;
  }


 /**
  * Unqualified information.
  *
  * @param additionalInformation
  */ 
  @JsonProperty(JSON_PROPERTY_ADDITIONAL_INFORMATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAdditionalInformation(String additionalInformation) {
    this.additionalInformation = additionalInformation;
  }


  /**
   * Return true if this CustomerOrder object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerOrder customerOrder = (CustomerOrder) o;
    return Objects.equals(this.customerOrderID, customerOrder.customerOrderID) &&
        Objects.equals(this.saleReferenceID, customerOrder.saleReferenceID) &&
        Objects.equals(this.openOrderState, customerOrder.openOrderState) &&
        Objects.equals(this.startDate, customerOrder.startDate) &&
        Objects.equals(this.endDate, customerOrder.endDate) &&
        Objects.equals(this.forecastedAmount, customerOrder.forecastedAmount) &&
        Objects.equals(this.currentAmount, customerOrder.currentAmount) &&
        Objects.equals(this.currency, customerOrder.currency) &&
        Objects.equals(this.accessedBy, customerOrder.accessedBy) &&
        Objects.equals(this.additionalInformation, customerOrder.additionalInformation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerOrderID, saleReferenceID, openOrderState, startDate, endDate, forecastedAmount, currentAmount, currency, accessedBy, additionalInformation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerOrder {\n");
    sb.append("    customerOrderID: ").append(toIndentedString(customerOrderID)).append("\n");
    sb.append("    saleReferenceID: ").append(toIndentedString(saleReferenceID)).append("\n");
    sb.append("    openOrderState: ").append(toIndentedString(openOrderState)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    forecastedAmount: ").append(toIndentedString(forecastedAmount)).append("\n");
    sb.append("    currentAmount: ").append(toIndentedString(currentAmount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    accessedBy: ").append(toIndentedString(accessedBy)).append("\n");
    sb.append("    additionalInformation: ").append(toIndentedString(additionalInformation)).append("\n");
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
   * Create an instance of CustomerOrder given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of CustomerOrder
   * @throws JsonProcessingException if the JSON string is invalid with respect to CustomerOrder
   */
  public static CustomerOrder fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, CustomerOrder.class);
  }
/**
  * Convert an instance of CustomerOrder to an JSON string
  *
  * @return JSON string
  */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
