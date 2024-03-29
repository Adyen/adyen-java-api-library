/*
 * Configuration API
 *
 * The version of the OpenAPI document: 2
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.adyen.model.balanceplatform;

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
 * BankAccountModel
 */
@JsonPropertyOrder({
  BankAccountModel.JSON_PROPERTY_FORM_FACTOR
})

public class BankAccountModel {
  /**
   * Form factor of the bank account - **virtual** or **physical** (default)
   */
  public enum FormFactorEnum {
    PHYSICAL("physical"),
    
    UNKNOWN("unknown"),
    
    VIRTUAL("virtual");

    private String value;

    FormFactorEnum(String value) {
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
    public static FormFactorEnum fromValue(String value) {
      for (FormFactorEnum b : FormFactorEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_FORM_FACTOR = "formFactor";
  private FormFactorEnum formFactor;

  public BankAccountModel() { 
  }

  public BankAccountModel formFactor(FormFactorEnum formFactor) {
    this.formFactor = formFactor;
    return this;
  }

   /**
   * Form factor of the bank account - **virtual** or **physical** (default)
   * @return formFactor
  **/
  @ApiModelProperty(value = "Form factor of the bank account - **virtual** or **physical** (default)")
  @JsonProperty(JSON_PROPERTY_FORM_FACTOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public FormFactorEnum getFormFactor() {
    return formFactor;
  }


 /**
  * Form factor of the bank account - **virtual** or **physical** (default)
  *
  * @param formFactor
  */ 
  @JsonProperty(JSON_PROPERTY_FORM_FACTOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFormFactor(FormFactorEnum formFactor) {
    this.formFactor = formFactor;
  }


  /**
   * Return true if this BankAccountModel object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankAccountModel bankAccountModel = (BankAccountModel) o;
    return Objects.equals(this.formFactor, bankAccountModel.formFactor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(formFactor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankAccountModel {\n");
    sb.append("    formFactor: ").append(toIndentedString(formFactor)).append("\n");
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
   * Create an instance of BankAccountModel given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of BankAccountModel
   * @throws JsonProcessingException if the JSON string is invalid with respect to BankAccountModel
   */
  public static BankAccountModel fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, BankAccountModel.class);
  }
/**
  * Convert an instance of BankAccountModel to an JSON string
  *
  * @return JSON string
  */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}

