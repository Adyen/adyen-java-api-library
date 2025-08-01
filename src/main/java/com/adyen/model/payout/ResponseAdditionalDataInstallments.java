/*
 * Adyen Payout API
 *
 * The version of the OpenAPI document: 68
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.payout;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** ResponseAdditionalDataInstallments */
@JsonPropertyOrder({
  ResponseAdditionalDataInstallments.JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_INSTALLMENT_TYPE,
  ResponseAdditionalDataInstallments
      .JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_ANNUAL_PERCENTAGE_RATE,
  ResponseAdditionalDataInstallments
      .JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_FIRST_INSTALLMENT_AMOUNT,
  ResponseAdditionalDataInstallments
      .JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_INSTALLMENT_FEE,
  ResponseAdditionalDataInstallments
      .JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_INTEREST_RATE,
  ResponseAdditionalDataInstallments
      .JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_MAXIMUM_NUMBER_OF_INSTALLMENTS,
  ResponseAdditionalDataInstallments
      .JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_MINIMUM_NUMBER_OF_INSTALLMENTS,
  ResponseAdditionalDataInstallments
      .JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_NUMBER_OF_INSTALLMENTS,
  ResponseAdditionalDataInstallments
      .JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_SUBSEQUENT_INSTALLMENT_AMOUNT,
  ResponseAdditionalDataInstallments
      .JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_TOTAL_AMOUNT_DUE,
  ResponseAdditionalDataInstallments.JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_PAYMENT_OPTIONS,
  ResponseAdditionalDataInstallments.JSON_PROPERTY_INSTALLMENTS_VALUE
})
public class ResponseAdditionalDataInstallments {
  public static final String JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_INSTALLMENT_TYPE =
      "installmentPaymentData.installmentType";
  private String installmentPaymentDataInstallmentType;

  public static final String
      JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_ANNUAL_PERCENTAGE_RATE =
          "installmentPaymentData.option[itemNr].annualPercentageRate";
  private String installmentPaymentDataOptionItemNrAnnualPercentageRate;

  public static final String
      JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_FIRST_INSTALLMENT_AMOUNT =
          "installmentPaymentData.option[itemNr].firstInstallmentAmount";
  private String installmentPaymentDataOptionItemNrFirstInstallmentAmount;

  public static final String JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_INSTALLMENT_FEE =
      "installmentPaymentData.option[itemNr].installmentFee";
  private String installmentPaymentDataOptionItemNrInstallmentFee;

  public static final String JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_INTEREST_RATE =
      "installmentPaymentData.option[itemNr].interestRate";
  private String installmentPaymentDataOptionItemNrInterestRate;

  public static final String
      JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_MAXIMUM_NUMBER_OF_INSTALLMENTS =
          "installmentPaymentData.option[itemNr].maximumNumberOfInstallments";
  private String installmentPaymentDataOptionItemNrMaximumNumberOfInstallments;

  public static final String
      JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_MINIMUM_NUMBER_OF_INSTALLMENTS =
          "installmentPaymentData.option[itemNr].minimumNumberOfInstallments";
  private String installmentPaymentDataOptionItemNrMinimumNumberOfInstallments;

  public static final String
      JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_NUMBER_OF_INSTALLMENTS =
          "installmentPaymentData.option[itemNr].numberOfInstallments";
  private String installmentPaymentDataOptionItemNrNumberOfInstallments;

  public static final String
      JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_SUBSEQUENT_INSTALLMENT_AMOUNT =
          "installmentPaymentData.option[itemNr].subsequentInstallmentAmount";
  private String installmentPaymentDataOptionItemNrSubsequentInstallmentAmount;

  public static final String
      JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_TOTAL_AMOUNT_DUE =
          "installmentPaymentData.option[itemNr].totalAmountDue";
  private String installmentPaymentDataOptionItemNrTotalAmountDue;

  public static final String JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_PAYMENT_OPTIONS =
      "installmentPaymentData.paymentOptions";
  private String installmentPaymentDataPaymentOptions;

  public static final String JSON_PROPERTY_INSTALLMENTS_VALUE = "installments.value";
  private String installmentsValue;

  public ResponseAdditionalDataInstallments() {}

  /**
   * Type of installment. The value of &#x60;installmentType&#x60; should be **IssuerFinanced**.
   *
   * @param installmentPaymentDataInstallmentType Type of installment. The value of
   *     &#x60;installmentType&#x60; should be **IssuerFinanced**.
   * @return the current {@code ResponseAdditionalDataInstallments} instance, allowing for method
   *     chaining
   */
  public ResponseAdditionalDataInstallments installmentPaymentDataInstallmentType(
      String installmentPaymentDataInstallmentType) {
    this.installmentPaymentDataInstallmentType = installmentPaymentDataInstallmentType;
    return this;
  }

  /**
   * Type of installment. The value of &#x60;installmentType&#x60; should be **IssuerFinanced**.
   *
   * @return installmentPaymentDataInstallmentType Type of installment. The value of
   *     &#x60;installmentType&#x60; should be **IssuerFinanced**.
   */
  @JsonProperty(JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_INSTALLMENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getInstallmentPaymentDataInstallmentType() {
    return installmentPaymentDataInstallmentType;
  }

  /**
   * Type of installment. The value of &#x60;installmentType&#x60; should be **IssuerFinanced**.
   *
   * @param installmentPaymentDataInstallmentType Type of installment. The value of
   *     &#x60;installmentType&#x60; should be **IssuerFinanced**.
   */
  @JsonProperty(JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_INSTALLMENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInstallmentPaymentDataInstallmentType(
      String installmentPaymentDataInstallmentType) {
    this.installmentPaymentDataInstallmentType = installmentPaymentDataInstallmentType;
  }

  /**
   * Annual interest rate.
   *
   * @param installmentPaymentDataOptionItemNrAnnualPercentageRate Annual interest rate.
   * @return the current {@code ResponseAdditionalDataInstallments} instance, allowing for method
   *     chaining
   */
  public ResponseAdditionalDataInstallments installmentPaymentDataOptionItemNrAnnualPercentageRate(
      String installmentPaymentDataOptionItemNrAnnualPercentageRate) {
    this.installmentPaymentDataOptionItemNrAnnualPercentageRate =
        installmentPaymentDataOptionItemNrAnnualPercentageRate;
    return this;
  }

  /**
   * Annual interest rate.
   *
   * @return installmentPaymentDataOptionItemNrAnnualPercentageRate Annual interest rate.
   */
  @JsonProperty(JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_ANNUAL_PERCENTAGE_RATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getInstallmentPaymentDataOptionItemNrAnnualPercentageRate() {
    return installmentPaymentDataOptionItemNrAnnualPercentageRate;
  }

  /**
   * Annual interest rate.
   *
   * @param installmentPaymentDataOptionItemNrAnnualPercentageRate Annual interest rate.
   */
  @JsonProperty(JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_ANNUAL_PERCENTAGE_RATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInstallmentPaymentDataOptionItemNrAnnualPercentageRate(
      String installmentPaymentDataOptionItemNrAnnualPercentageRate) {
    this.installmentPaymentDataOptionItemNrAnnualPercentageRate =
        installmentPaymentDataOptionItemNrAnnualPercentageRate;
  }

  /**
   * First Installment Amount in minor units.
   *
   * @param installmentPaymentDataOptionItemNrFirstInstallmentAmount First Installment Amount in
   *     minor units.
   * @return the current {@code ResponseAdditionalDataInstallments} instance, allowing for method
   *     chaining
   */
  public ResponseAdditionalDataInstallments
      installmentPaymentDataOptionItemNrFirstInstallmentAmount(
          String installmentPaymentDataOptionItemNrFirstInstallmentAmount) {
    this.installmentPaymentDataOptionItemNrFirstInstallmentAmount =
        installmentPaymentDataOptionItemNrFirstInstallmentAmount;
    return this;
  }

  /**
   * First Installment Amount in minor units.
   *
   * @return installmentPaymentDataOptionItemNrFirstInstallmentAmount First Installment Amount in
   *     minor units.
   */
  @JsonProperty(JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_FIRST_INSTALLMENT_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getInstallmentPaymentDataOptionItemNrFirstInstallmentAmount() {
    return installmentPaymentDataOptionItemNrFirstInstallmentAmount;
  }

  /**
   * First Installment Amount in minor units.
   *
   * @param installmentPaymentDataOptionItemNrFirstInstallmentAmount First Installment Amount in
   *     minor units.
   */
  @JsonProperty(JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_FIRST_INSTALLMENT_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInstallmentPaymentDataOptionItemNrFirstInstallmentAmount(
      String installmentPaymentDataOptionItemNrFirstInstallmentAmount) {
    this.installmentPaymentDataOptionItemNrFirstInstallmentAmount =
        installmentPaymentDataOptionItemNrFirstInstallmentAmount;
  }

  /**
   * Installment fee amount in minor units.
   *
   * @param installmentPaymentDataOptionItemNrInstallmentFee Installment fee amount in minor units.
   * @return the current {@code ResponseAdditionalDataInstallments} instance, allowing for method
   *     chaining
   */
  public ResponseAdditionalDataInstallments installmentPaymentDataOptionItemNrInstallmentFee(
      String installmentPaymentDataOptionItemNrInstallmentFee) {
    this.installmentPaymentDataOptionItemNrInstallmentFee =
        installmentPaymentDataOptionItemNrInstallmentFee;
    return this;
  }

  /**
   * Installment fee amount in minor units.
   *
   * @return installmentPaymentDataOptionItemNrInstallmentFee Installment fee amount in minor units.
   */
  @JsonProperty(JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_INSTALLMENT_FEE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getInstallmentPaymentDataOptionItemNrInstallmentFee() {
    return installmentPaymentDataOptionItemNrInstallmentFee;
  }

  /**
   * Installment fee amount in minor units.
   *
   * @param installmentPaymentDataOptionItemNrInstallmentFee Installment fee amount in minor units.
   */
  @JsonProperty(JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_INSTALLMENT_FEE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInstallmentPaymentDataOptionItemNrInstallmentFee(
      String installmentPaymentDataOptionItemNrInstallmentFee) {
    this.installmentPaymentDataOptionItemNrInstallmentFee =
        installmentPaymentDataOptionItemNrInstallmentFee;
  }

  /**
   * Interest rate for the installment period.
   *
   * @param installmentPaymentDataOptionItemNrInterestRate Interest rate for the installment period.
   * @return the current {@code ResponseAdditionalDataInstallments} instance, allowing for method
   *     chaining
   */
  public ResponseAdditionalDataInstallments installmentPaymentDataOptionItemNrInterestRate(
      String installmentPaymentDataOptionItemNrInterestRate) {
    this.installmentPaymentDataOptionItemNrInterestRate =
        installmentPaymentDataOptionItemNrInterestRate;
    return this;
  }

  /**
   * Interest rate for the installment period.
   *
   * @return installmentPaymentDataOptionItemNrInterestRate Interest rate for the installment
   *     period.
   */
  @JsonProperty(JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_INTEREST_RATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getInstallmentPaymentDataOptionItemNrInterestRate() {
    return installmentPaymentDataOptionItemNrInterestRate;
  }

  /**
   * Interest rate for the installment period.
   *
   * @param installmentPaymentDataOptionItemNrInterestRate Interest rate for the installment period.
   */
  @JsonProperty(JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_INTEREST_RATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInstallmentPaymentDataOptionItemNrInterestRate(
      String installmentPaymentDataOptionItemNrInterestRate) {
    this.installmentPaymentDataOptionItemNrInterestRate =
        installmentPaymentDataOptionItemNrInterestRate;
  }

  /**
   * Maximum number of installments possible for this payment.
   *
   * @param installmentPaymentDataOptionItemNrMaximumNumberOfInstallments Maximum number of
   *     installments possible for this payment.
   * @return the current {@code ResponseAdditionalDataInstallments} instance, allowing for method
   *     chaining
   */
  public ResponseAdditionalDataInstallments
      installmentPaymentDataOptionItemNrMaximumNumberOfInstallments(
          String installmentPaymentDataOptionItemNrMaximumNumberOfInstallments) {
    this.installmentPaymentDataOptionItemNrMaximumNumberOfInstallments =
        installmentPaymentDataOptionItemNrMaximumNumberOfInstallments;
    return this;
  }

  /**
   * Maximum number of installments possible for this payment.
   *
   * @return installmentPaymentDataOptionItemNrMaximumNumberOfInstallments Maximum number of
   *     installments possible for this payment.
   */
  @JsonProperty(
      JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_MAXIMUM_NUMBER_OF_INSTALLMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getInstallmentPaymentDataOptionItemNrMaximumNumberOfInstallments() {
    return installmentPaymentDataOptionItemNrMaximumNumberOfInstallments;
  }

  /**
   * Maximum number of installments possible for this payment.
   *
   * @param installmentPaymentDataOptionItemNrMaximumNumberOfInstallments Maximum number of
   *     installments possible for this payment.
   */
  @JsonProperty(
      JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_MAXIMUM_NUMBER_OF_INSTALLMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInstallmentPaymentDataOptionItemNrMaximumNumberOfInstallments(
      String installmentPaymentDataOptionItemNrMaximumNumberOfInstallments) {
    this.installmentPaymentDataOptionItemNrMaximumNumberOfInstallments =
        installmentPaymentDataOptionItemNrMaximumNumberOfInstallments;
  }

  /**
   * Minimum number of installments possible for this payment.
   *
   * @param installmentPaymentDataOptionItemNrMinimumNumberOfInstallments Minimum number of
   *     installments possible for this payment.
   * @return the current {@code ResponseAdditionalDataInstallments} instance, allowing for method
   *     chaining
   */
  public ResponseAdditionalDataInstallments
      installmentPaymentDataOptionItemNrMinimumNumberOfInstallments(
          String installmentPaymentDataOptionItemNrMinimumNumberOfInstallments) {
    this.installmentPaymentDataOptionItemNrMinimumNumberOfInstallments =
        installmentPaymentDataOptionItemNrMinimumNumberOfInstallments;
    return this;
  }

  /**
   * Minimum number of installments possible for this payment.
   *
   * @return installmentPaymentDataOptionItemNrMinimumNumberOfInstallments Minimum number of
   *     installments possible for this payment.
   */
  @JsonProperty(
      JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_MINIMUM_NUMBER_OF_INSTALLMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getInstallmentPaymentDataOptionItemNrMinimumNumberOfInstallments() {
    return installmentPaymentDataOptionItemNrMinimumNumberOfInstallments;
  }

  /**
   * Minimum number of installments possible for this payment.
   *
   * @param installmentPaymentDataOptionItemNrMinimumNumberOfInstallments Minimum number of
   *     installments possible for this payment.
   */
  @JsonProperty(
      JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_MINIMUM_NUMBER_OF_INSTALLMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInstallmentPaymentDataOptionItemNrMinimumNumberOfInstallments(
      String installmentPaymentDataOptionItemNrMinimumNumberOfInstallments) {
    this.installmentPaymentDataOptionItemNrMinimumNumberOfInstallments =
        installmentPaymentDataOptionItemNrMinimumNumberOfInstallments;
  }

  /**
   * Total number of installments possible for this payment.
   *
   * @param installmentPaymentDataOptionItemNrNumberOfInstallments Total number of installments
   *     possible for this payment.
   * @return the current {@code ResponseAdditionalDataInstallments} instance, allowing for method
   *     chaining
   */
  public ResponseAdditionalDataInstallments installmentPaymentDataOptionItemNrNumberOfInstallments(
      String installmentPaymentDataOptionItemNrNumberOfInstallments) {
    this.installmentPaymentDataOptionItemNrNumberOfInstallments =
        installmentPaymentDataOptionItemNrNumberOfInstallments;
    return this;
  }

  /**
   * Total number of installments possible for this payment.
   *
   * @return installmentPaymentDataOptionItemNrNumberOfInstallments Total number of installments
   *     possible for this payment.
   */
  @JsonProperty(JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_NUMBER_OF_INSTALLMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getInstallmentPaymentDataOptionItemNrNumberOfInstallments() {
    return installmentPaymentDataOptionItemNrNumberOfInstallments;
  }

  /**
   * Total number of installments possible for this payment.
   *
   * @param installmentPaymentDataOptionItemNrNumberOfInstallments Total number of installments
   *     possible for this payment.
   */
  @JsonProperty(JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_NUMBER_OF_INSTALLMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInstallmentPaymentDataOptionItemNrNumberOfInstallments(
      String installmentPaymentDataOptionItemNrNumberOfInstallments) {
    this.installmentPaymentDataOptionItemNrNumberOfInstallments =
        installmentPaymentDataOptionItemNrNumberOfInstallments;
  }

  /**
   * Subsequent Installment Amount in minor units.
   *
   * @param installmentPaymentDataOptionItemNrSubsequentInstallmentAmount Subsequent Installment
   *     Amount in minor units.
   * @return the current {@code ResponseAdditionalDataInstallments} instance, allowing for method
   *     chaining
   */
  public ResponseAdditionalDataInstallments
      installmentPaymentDataOptionItemNrSubsequentInstallmentAmount(
          String installmentPaymentDataOptionItemNrSubsequentInstallmentAmount) {
    this.installmentPaymentDataOptionItemNrSubsequentInstallmentAmount =
        installmentPaymentDataOptionItemNrSubsequentInstallmentAmount;
    return this;
  }

  /**
   * Subsequent Installment Amount in minor units.
   *
   * @return installmentPaymentDataOptionItemNrSubsequentInstallmentAmount Subsequent Installment
   *     Amount in minor units.
   */
  @JsonProperty(JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_SUBSEQUENT_INSTALLMENT_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getInstallmentPaymentDataOptionItemNrSubsequentInstallmentAmount() {
    return installmentPaymentDataOptionItemNrSubsequentInstallmentAmount;
  }

  /**
   * Subsequent Installment Amount in minor units.
   *
   * @param installmentPaymentDataOptionItemNrSubsequentInstallmentAmount Subsequent Installment
   *     Amount in minor units.
   */
  @JsonProperty(JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_SUBSEQUENT_INSTALLMENT_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInstallmentPaymentDataOptionItemNrSubsequentInstallmentAmount(
      String installmentPaymentDataOptionItemNrSubsequentInstallmentAmount) {
    this.installmentPaymentDataOptionItemNrSubsequentInstallmentAmount =
        installmentPaymentDataOptionItemNrSubsequentInstallmentAmount;
  }

  /**
   * Total amount in minor units.
   *
   * @param installmentPaymentDataOptionItemNrTotalAmountDue Total amount in minor units.
   * @return the current {@code ResponseAdditionalDataInstallments} instance, allowing for method
   *     chaining
   */
  public ResponseAdditionalDataInstallments installmentPaymentDataOptionItemNrTotalAmountDue(
      String installmentPaymentDataOptionItemNrTotalAmountDue) {
    this.installmentPaymentDataOptionItemNrTotalAmountDue =
        installmentPaymentDataOptionItemNrTotalAmountDue;
    return this;
  }

  /**
   * Total amount in minor units.
   *
   * @return installmentPaymentDataOptionItemNrTotalAmountDue Total amount in minor units.
   */
  @JsonProperty(JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_TOTAL_AMOUNT_DUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getInstallmentPaymentDataOptionItemNrTotalAmountDue() {
    return installmentPaymentDataOptionItemNrTotalAmountDue;
  }

  /**
   * Total amount in minor units.
   *
   * @param installmentPaymentDataOptionItemNrTotalAmountDue Total amount in minor units.
   */
  @JsonProperty(JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_OPTION_ITEM_NR_TOTAL_AMOUNT_DUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInstallmentPaymentDataOptionItemNrTotalAmountDue(
      String installmentPaymentDataOptionItemNrTotalAmountDue) {
    this.installmentPaymentDataOptionItemNrTotalAmountDue =
        installmentPaymentDataOptionItemNrTotalAmountDue;
  }

  /**
   * Possible values: * PayInInstallmentsOnly * PayInFullOnly * PayInFullOrInstallments
   *
   * @param installmentPaymentDataPaymentOptions Possible values: * PayInInstallmentsOnly *
   *     PayInFullOnly * PayInFullOrInstallments
   * @return the current {@code ResponseAdditionalDataInstallments} instance, allowing for method
   *     chaining
   */
  public ResponseAdditionalDataInstallments installmentPaymentDataPaymentOptions(
      String installmentPaymentDataPaymentOptions) {
    this.installmentPaymentDataPaymentOptions = installmentPaymentDataPaymentOptions;
    return this;
  }

  /**
   * Possible values: * PayInInstallmentsOnly * PayInFullOnly * PayInFullOrInstallments
   *
   * @return installmentPaymentDataPaymentOptions Possible values: * PayInInstallmentsOnly *
   *     PayInFullOnly * PayInFullOrInstallments
   */
  @JsonProperty(JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_PAYMENT_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getInstallmentPaymentDataPaymentOptions() {
    return installmentPaymentDataPaymentOptions;
  }

  /**
   * Possible values: * PayInInstallmentsOnly * PayInFullOnly * PayInFullOrInstallments
   *
   * @param installmentPaymentDataPaymentOptions Possible values: * PayInInstallmentsOnly *
   *     PayInFullOnly * PayInFullOrInstallments
   */
  @JsonProperty(JSON_PROPERTY_INSTALLMENT_PAYMENT_DATA_PAYMENT_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInstallmentPaymentDataPaymentOptions(String installmentPaymentDataPaymentOptions) {
    this.installmentPaymentDataPaymentOptions = installmentPaymentDataPaymentOptions;
  }

  /**
   * The number of installments that the payment amount should be charged with. Example: 5 &gt; Only
   * relevant for card payments in countries that support installments.
   *
   * @param installmentsValue The number of installments that the payment amount should be charged
   *     with. Example: 5 &gt; Only relevant for card payments in countries that support
   *     installments.
   * @return the current {@code ResponseAdditionalDataInstallments} instance, allowing for method
   *     chaining
   */
  public ResponseAdditionalDataInstallments installmentsValue(String installmentsValue) {
    this.installmentsValue = installmentsValue;
    return this;
  }

  /**
   * The number of installments that the payment amount should be charged with. Example: 5 &gt; Only
   * relevant for card payments in countries that support installments.
   *
   * @return installmentsValue The number of installments that the payment amount should be charged
   *     with. Example: 5 &gt; Only relevant for card payments in countries that support
   *     installments.
   */
  @JsonProperty(JSON_PROPERTY_INSTALLMENTS_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getInstallmentsValue() {
    return installmentsValue;
  }

  /**
   * The number of installments that the payment amount should be charged with. Example: 5 &gt; Only
   * relevant for card payments in countries that support installments.
   *
   * @param installmentsValue The number of installments that the payment amount should be charged
   *     with. Example: 5 &gt; Only relevant for card payments in countries that support
   *     installments.
   */
  @JsonProperty(JSON_PROPERTY_INSTALLMENTS_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInstallmentsValue(String installmentsValue) {
    this.installmentsValue = installmentsValue;
  }

  /** Return true if this ResponseAdditionalDataInstallments object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseAdditionalDataInstallments responseAdditionalDataInstallments =
        (ResponseAdditionalDataInstallments) o;
    return Objects.equals(
            this.installmentPaymentDataInstallmentType,
            responseAdditionalDataInstallments.installmentPaymentDataInstallmentType)
        && Objects.equals(
            this.installmentPaymentDataOptionItemNrAnnualPercentageRate,
            responseAdditionalDataInstallments
                .installmentPaymentDataOptionItemNrAnnualPercentageRate)
        && Objects.equals(
            this.installmentPaymentDataOptionItemNrFirstInstallmentAmount,
            responseAdditionalDataInstallments
                .installmentPaymentDataOptionItemNrFirstInstallmentAmount)
        && Objects.equals(
            this.installmentPaymentDataOptionItemNrInstallmentFee,
            responseAdditionalDataInstallments.installmentPaymentDataOptionItemNrInstallmentFee)
        && Objects.equals(
            this.installmentPaymentDataOptionItemNrInterestRate,
            responseAdditionalDataInstallments.installmentPaymentDataOptionItemNrInterestRate)
        && Objects.equals(
            this.installmentPaymentDataOptionItemNrMaximumNumberOfInstallments,
            responseAdditionalDataInstallments
                .installmentPaymentDataOptionItemNrMaximumNumberOfInstallments)
        && Objects.equals(
            this.installmentPaymentDataOptionItemNrMinimumNumberOfInstallments,
            responseAdditionalDataInstallments
                .installmentPaymentDataOptionItemNrMinimumNumberOfInstallments)
        && Objects.equals(
            this.installmentPaymentDataOptionItemNrNumberOfInstallments,
            responseAdditionalDataInstallments
                .installmentPaymentDataOptionItemNrNumberOfInstallments)
        && Objects.equals(
            this.installmentPaymentDataOptionItemNrSubsequentInstallmentAmount,
            responseAdditionalDataInstallments
                .installmentPaymentDataOptionItemNrSubsequentInstallmentAmount)
        && Objects.equals(
            this.installmentPaymentDataOptionItemNrTotalAmountDue,
            responseAdditionalDataInstallments.installmentPaymentDataOptionItemNrTotalAmountDue)
        && Objects.equals(
            this.installmentPaymentDataPaymentOptions,
            responseAdditionalDataInstallments.installmentPaymentDataPaymentOptions)
        && Objects.equals(
            this.installmentsValue, responseAdditionalDataInstallments.installmentsValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        installmentPaymentDataInstallmentType,
        installmentPaymentDataOptionItemNrAnnualPercentageRate,
        installmentPaymentDataOptionItemNrFirstInstallmentAmount,
        installmentPaymentDataOptionItemNrInstallmentFee,
        installmentPaymentDataOptionItemNrInterestRate,
        installmentPaymentDataOptionItemNrMaximumNumberOfInstallments,
        installmentPaymentDataOptionItemNrMinimumNumberOfInstallments,
        installmentPaymentDataOptionItemNrNumberOfInstallments,
        installmentPaymentDataOptionItemNrSubsequentInstallmentAmount,
        installmentPaymentDataOptionItemNrTotalAmountDue,
        installmentPaymentDataPaymentOptions,
        installmentsValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseAdditionalDataInstallments {\n");
    sb.append("    installmentPaymentDataInstallmentType: ")
        .append(toIndentedString(installmentPaymentDataInstallmentType))
        .append("\n");
    sb.append("    installmentPaymentDataOptionItemNrAnnualPercentageRate: ")
        .append(toIndentedString(installmentPaymentDataOptionItemNrAnnualPercentageRate))
        .append("\n");
    sb.append("    installmentPaymentDataOptionItemNrFirstInstallmentAmount: ")
        .append(toIndentedString(installmentPaymentDataOptionItemNrFirstInstallmentAmount))
        .append("\n");
    sb.append("    installmentPaymentDataOptionItemNrInstallmentFee: ")
        .append(toIndentedString(installmentPaymentDataOptionItemNrInstallmentFee))
        .append("\n");
    sb.append("    installmentPaymentDataOptionItemNrInterestRate: ")
        .append(toIndentedString(installmentPaymentDataOptionItemNrInterestRate))
        .append("\n");
    sb.append("    installmentPaymentDataOptionItemNrMaximumNumberOfInstallments: ")
        .append(toIndentedString(installmentPaymentDataOptionItemNrMaximumNumberOfInstallments))
        .append("\n");
    sb.append("    installmentPaymentDataOptionItemNrMinimumNumberOfInstallments: ")
        .append(toIndentedString(installmentPaymentDataOptionItemNrMinimumNumberOfInstallments))
        .append("\n");
    sb.append("    installmentPaymentDataOptionItemNrNumberOfInstallments: ")
        .append(toIndentedString(installmentPaymentDataOptionItemNrNumberOfInstallments))
        .append("\n");
    sb.append("    installmentPaymentDataOptionItemNrSubsequentInstallmentAmount: ")
        .append(toIndentedString(installmentPaymentDataOptionItemNrSubsequentInstallmentAmount))
        .append("\n");
    sb.append("    installmentPaymentDataOptionItemNrTotalAmountDue: ")
        .append(toIndentedString(installmentPaymentDataOptionItemNrTotalAmountDue))
        .append("\n");
    sb.append("    installmentPaymentDataPaymentOptions: ")
        .append(toIndentedString(installmentPaymentDataPaymentOptions))
        .append("\n");
    sb.append("    installmentsValue: ").append(toIndentedString(installmentsValue)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * Create an instance of ResponseAdditionalDataInstallments given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ResponseAdditionalDataInstallments
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     ResponseAdditionalDataInstallments
   */
  public static ResponseAdditionalDataInstallments fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, ResponseAdditionalDataInstallments.class);
  }

  /**
   * Convert an instance of ResponseAdditionalDataInstallments to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
