/*
 * Transfer webhooks
 *
 * The version of the OpenAPI document: 3
 * Contact: developer-experience@adyen.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.adyen.model.transferwebhooks;

import java.util.Objects;
import java.util.Arrays;
import com.adyen.model.transferwebhooks.Amount;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.adyen.model.transferwebhooks.JSON;

/**
 * AmountAdjustment
 */

public class AmountAdjustment {
  public static final String SERIALIZED_NAME_AMOUNT = "amount";
  @SerializedName(SERIALIZED_NAME_AMOUNT)
  private Amount amount;

  /**
   * The type of markup that is applied to an authorised payment.  Possible values: **exchange**, **forexMarkup**, **authHoldReserve**, **atmMarkup**.
   */
  @JsonAdapter(AmountAdjustmentTypeEnum.Adapter.class)
  public enum AmountAdjustmentTypeEnum {
    ATMMARKUP("atmMarkup"),
    
    AUTHHOLDRESERVE("authHoldReserve"),
    
    EXCHANGE("exchange"),
    
    FOREXMARKUP("forexMarkup");

    private String value;

    AmountAdjustmentTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static AmountAdjustmentTypeEnum fromValue(String value) {
      for (AmountAdjustmentTypeEnum b : AmountAdjustmentTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<AmountAdjustmentTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final AmountAdjustmentTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public AmountAdjustmentTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return AmountAdjustmentTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_AMOUNT_ADJUSTMENT_TYPE = "amountAdjustmentType";
  @SerializedName(SERIALIZED_NAME_AMOUNT_ADJUSTMENT_TYPE)
  private AmountAdjustmentTypeEnum amountAdjustmentType;

  public static final String SERIALIZED_NAME_BASEPOINTS = "basepoints";
  @SerializedName(SERIALIZED_NAME_BASEPOINTS)
  private Integer basepoints;

  public AmountAdjustment() { 
  }

  public AmountAdjustment amount(Amount amount) {
    
    this.amount = amount;
    return this;
  }

   /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(value = "")

  public Amount getAmount() {
    return amount;
  }


  public void setAmount(Amount amount) {
    this.amount = amount;
  }


  public AmountAdjustment amountAdjustmentType(AmountAdjustmentTypeEnum amountAdjustmentType) {
    
    this.amountAdjustmentType = amountAdjustmentType;
    return this;
  }

   /**
   * The type of markup that is applied to an authorised payment.  Possible values: **exchange**, **forexMarkup**, **authHoldReserve**, **atmMarkup**.
   * @return amountAdjustmentType
  **/
  @ApiModelProperty(value = "The type of markup that is applied to an authorised payment.  Possible values: **exchange**, **forexMarkup**, **authHoldReserve**, **atmMarkup**.")

  public AmountAdjustmentTypeEnum getAmountAdjustmentType() {
    return amountAdjustmentType;
  }


  public void setAmountAdjustmentType(AmountAdjustmentTypeEnum amountAdjustmentType) {
    this.amountAdjustmentType = amountAdjustmentType;
  }


  public AmountAdjustment basepoints(Integer basepoints) {
    
    this.basepoints = basepoints;
    return this;
  }

   /**
   * The basepoints associated with the applied markup.
   * @return basepoints
  **/
  @ApiModelProperty(value = "The basepoints associated with the applied markup.")

  public Integer getBasepoints() {
    return basepoints;
  }


  public void setBasepoints(Integer basepoints) {
    this.basepoints = basepoints;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AmountAdjustment amountAdjustment = (AmountAdjustment) o;
    return Objects.equals(this.amount, amountAdjustment.amount) &&
        Objects.equals(this.amountAdjustmentType, amountAdjustment.amountAdjustmentType) &&
        Objects.equals(this.basepoints, amountAdjustment.basepoints);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, amountAdjustmentType, basepoints);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AmountAdjustment {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    amountAdjustmentType: ").append(toIndentedString(amountAdjustmentType)).append("\n");
    sb.append("    basepoints: ").append(toIndentedString(basepoints)).append("\n");
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


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("amount");
    openapiFields.add("amountAdjustmentType");
    openapiFields.add("basepoints");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }
  /**
  * logger for Deserialization Errors
  */
  private static final Logger log = Logger.getLogger(AmountAdjustment.class.getName());

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to AmountAdjustment
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (AmountAdjustment.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in AmountAdjustment is not found in the empty JSON string", AmountAdjustment.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!AmountAdjustment.openapiFields.contains(entry.getKey())) {
          log.log(Level.WARNING, String.format("The field `%s` in the JSON string is not defined in the `AmountAdjustment` properties.", entry.getKey()));
        }
      }
      // validate the optional field `amount`
      if (jsonObj.getAsJsonObject("amount") != null) {
        Amount.validateJsonObject(jsonObj.getAsJsonObject("amount"));
      }
      // ensure the field amountAdjustmentType can be parsed to an enum value
      if (jsonObj.get("amountAdjustmentType") != null) {
        if(!jsonObj.get("amountAdjustmentType").isJsonPrimitive()) {
          throw new IllegalArgumentException(String.format("Expected the field `amountAdjustmentType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("amountAdjustmentType").toString()));
        }
        AmountAdjustmentTypeEnum.fromValue(jsonObj.get("amountAdjustmentType").getAsString());
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!AmountAdjustment.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'AmountAdjustment' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<AmountAdjustment> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(AmountAdjustment.class));

       return (TypeAdapter<T>) new TypeAdapter<AmountAdjustment>() {
           @Override
           public void write(JsonWriter out, AmountAdjustment value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public AmountAdjustment read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of AmountAdjustment given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of AmountAdjustment
  * @throws IOException if the JSON string is invalid with respect to AmountAdjustment
  */
  public static AmountAdjustment fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, AmountAdjustment.class);
  }

 /**
  * Convert an instance of AmountAdjustment to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
