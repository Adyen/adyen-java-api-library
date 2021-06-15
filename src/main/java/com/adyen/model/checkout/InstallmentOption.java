/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.checkout;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * InstallmentOption
 */

public class InstallmentOption {
  @SerializedName("maxValue")
  private Integer maxValue = null;

  /**
   * Gets or Sets plans
   */
  @JsonAdapter(PlansEnum.Adapter.class)
  public enum PlansEnum {
    REGULAR("regular"),
    REVOLVING("revolving");

    @JsonValue
    private String value;

    PlansEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static PlansEnum fromValue(String text) {
      for (PlansEnum b : PlansEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<PlansEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PlansEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PlansEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return PlansEnum.fromValue(String.valueOf(value));
      }
    }
  }  @SerializedName("plans")
  private List<PlansEnum> plans = null;

  @SerializedName("preselectedValue")
  private Integer preselectedValue = null;

  @SerializedName("values")
  private List<Integer> values = null;

  public InstallmentOption maxValue(Integer maxValue) {
    this.maxValue = maxValue;
    return this;
  }

   /**
   * The maximum number of installments offered for this payment method.
   * @return maxValue
  **/
  public Integer getMaxValue() {
    return maxValue;
  }

  public void setMaxValue(Integer maxValue) {
    this.maxValue = maxValue;
  }

  public InstallmentOption plans(List<PlansEnum> plans) {
    this.plans = plans;
    return this;
  }

  public InstallmentOption addPlansItem(PlansEnum plansItem) {
    if (this.plans == null) {
      this.plans = new ArrayList<>();
    }
    this.plans.add(plansItem);
    return this;
  }

   /**
   * Defines the type of installment plan. If not set, defaults to **regular**.  Possible values: * **regular** * **revolving**
   * @return plans
  **/
  public List<PlansEnum> getPlans() {
    return plans;
  }

  public void setPlans(List<PlansEnum> plans) {
    this.plans = plans;
  }

  public InstallmentOption preselectedValue(Integer preselectedValue) {
    this.preselectedValue = preselectedValue;
    return this;
  }

   /**
   * Preselected number of installments offered for this payment method.
   * @return preselectedValue
  **/
  public Integer getPreselectedValue() {
    return preselectedValue;
  }

  public void setPreselectedValue(Integer preselectedValue) {
    this.preselectedValue = preselectedValue;
  }

  public InstallmentOption values(List<Integer> values) {
    this.values = values;
    return this;
  }

  public InstallmentOption addValuesItem(Integer valuesItem) {
    if (this.values == null) {
      this.values = new ArrayList<>();
    }
    this.values.add(valuesItem);
    return this;
  }

   /**
   * An array of the number of installments that the shopper can choose from. For example, **[2,3,5]**. This cannot be specified simultaneously with &#x60;maxValue&#x60;.
   * @return values
  **/
  public List<Integer> getValues() {
    return values;
  }

  public void setValues(List<Integer> values) {
    this.values = values;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstallmentOption installmentOption = (InstallmentOption) o;
    return Objects.equals(this.maxValue, installmentOption.maxValue) &&
        Objects.equals(this.plans, installmentOption.plans) &&
        Objects.equals(this.preselectedValue, installmentOption.preselectedValue) &&
        Objects.equals(this.values, installmentOption.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxValue, plans, preselectedValue, values);
  }


  @Override
  public String toString() {

    return "class InstallmentOption {\n" +
            "    maxValue: " + toIndentedString(maxValue) + "\n" +
            "    plans: " + toIndentedString(plans) + "\n" +
            "    preselectedValue: " + toIndentedString(preselectedValue) + "\n" +
            "    values: " + toIndentedString(values) + "\n" +
            "}";
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

}
