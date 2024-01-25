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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;


/**
 * In the Login Request, if a Sale Terminal is involved in the login. In other messages, when a logical device is out of order (SaleCapabilites), or when the other data have changed since or were not in the Login. Information related to the software and hardware feature of the Sale Terminal.
 */
@ApiModel(description = "In the Login Request, if a Sale Terminal is involved in the login. In other messages, when a logical device is out of order (SaleCapabilites), or when the other data have changed since or were not in the Login. Information related to the software and hardware feature of the Sale Terminal.")
@JsonPropertyOrder({
  SaleTerminalData.JSON_PROPERTY_TOTALS_GROUP_I_D
})

public class SaleTerminalData {
  public static final String JSON_PROPERTY_TOTALS_GROUP_I_D = "TotalsGroupID";
  private String totalsGroupID;

  public SaleTerminalData() { 
  }

  public SaleTerminalData totalsGroupID(String totalsGroupID) {
    this.totalsGroupID = totalsGroupID;
    return this;
  }

   /**
   * If present, default value for all transaction.
   * @return totalsGroupID
  **/
  @ApiModelProperty(value = "If present, default value for all transaction.")
  @JsonProperty(JSON_PROPERTY_TOTALS_GROUP_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTotalsGroupID() {
    return totalsGroupID;
  }


 /**
  * If present, default value for all transaction.
  *
  * @param totalsGroupID
  */ 
  @JsonProperty(JSON_PROPERTY_TOTALS_GROUP_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTotalsGroupID(String totalsGroupID) {
    this.totalsGroupID = totalsGroupID;
  }


  /**
   * Return true if this SaleTerminalData object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SaleTerminalData saleTerminalData = (SaleTerminalData) o;
    return Objects.equals(this.totalsGroupID, saleTerminalData.totalsGroupID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalsGroupID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SaleTerminalData {\n");
    sb.append("    totalsGroupID: ").append(toIndentedString(totalsGroupID)).append("\n");
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
   * Create an instance of SaleTerminalData given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of SaleTerminalData
   * @throws JsonProcessingException if the JSON string is invalid with respect to SaleTerminalData
   */
  public static SaleTerminalData fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, SaleTerminalData.class);
  }
/**
  * Convert an instance of SaleTerminalData to an JSON string
  *
  * @return JSON string
  */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
