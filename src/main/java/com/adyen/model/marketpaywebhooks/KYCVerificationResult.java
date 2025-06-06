/*
 * Classic Platforms - Notifications
 *
 * The version of the OpenAPI document: 6
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.marketpaywebhooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** KYCVerificationResult */
@JsonPropertyOrder({
  KYCVerificationResult.JSON_PROPERTY_ACCOUNT_HOLDER,
  KYCVerificationResult.JSON_PROPERTY_LEGAL_ARRANGEMENTS,
  KYCVerificationResult.JSON_PROPERTY_LEGAL_ARRANGEMENTS_ENTITIES,
  KYCVerificationResult.JSON_PROPERTY_PAYOUT_METHODS,
  KYCVerificationResult.JSON_PROPERTY_SHAREHOLDERS,
  KYCVerificationResult.JSON_PROPERTY_SIGNATORIES,
  KYCVerificationResult.JSON_PROPERTY_ULTIMATE_PARENT_COMPANY
})
public class KYCVerificationResult {
  public static final String JSON_PROPERTY_ACCOUNT_HOLDER = "accountHolder";
  private KYCCheckResult accountHolder;

  public static final String JSON_PROPERTY_LEGAL_ARRANGEMENTS = "legalArrangements";
  private List<KYCLegalArrangementCheckResult> legalArrangements = null;

  public static final String JSON_PROPERTY_LEGAL_ARRANGEMENTS_ENTITIES =
      "legalArrangementsEntities";
  private List<KYCLegalArrangementEntityCheckResult> legalArrangementsEntities = null;

  public static final String JSON_PROPERTY_PAYOUT_METHODS = "payoutMethods";
  private List<KYCPayoutMethodCheckResult> payoutMethods = null;

  public static final String JSON_PROPERTY_SHAREHOLDERS = "shareholders";
  private List<KYCShareholderCheckResult> shareholders = null;

  public static final String JSON_PROPERTY_SIGNATORIES = "signatories";
  private List<KYCSignatoryCheckResult> signatories = null;

  public static final String JSON_PROPERTY_ULTIMATE_PARENT_COMPANY = "ultimateParentCompany";
  private List<KYCUltimateParentCompanyCheckResult> ultimateParentCompany = null;

  public KYCVerificationResult() {}

  public KYCVerificationResult accountHolder(KYCCheckResult accountHolder) {
    this.accountHolder = accountHolder;
    return this;
  }

  /**
   * Get accountHolder
   *
   * @return accountHolder
   */
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ACCOUNT_HOLDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public KYCCheckResult getAccountHolder() {
    return accountHolder;
  }

  @JsonProperty(JSON_PROPERTY_ACCOUNT_HOLDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAccountHolder(KYCCheckResult accountHolder) {
    this.accountHolder = accountHolder;
  }

  public KYCVerificationResult legalArrangements(
      List<KYCLegalArrangementCheckResult> legalArrangements) {
    this.legalArrangements = legalArrangements;
    return this;
  }

  public KYCVerificationResult addLegalArrangementsItem(
      KYCLegalArrangementCheckResult legalArrangementsItem) {
    if (this.legalArrangements == null) {
      this.legalArrangements = new ArrayList<>();
    }
    this.legalArrangements.add(legalArrangementsItem);
    return this;
  }

  /**
   * The results of the checks on the legal arrangements.
   *
   * @return legalArrangements
   */
  @ApiModelProperty(value = "The results of the checks on the legal arrangements.")
  @JsonProperty(JSON_PROPERTY_LEGAL_ARRANGEMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<KYCLegalArrangementCheckResult> getLegalArrangements() {
    return legalArrangements;
  }

  @JsonProperty(JSON_PROPERTY_LEGAL_ARRANGEMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLegalArrangements(List<KYCLegalArrangementCheckResult> legalArrangements) {
    this.legalArrangements = legalArrangements;
  }

  public KYCVerificationResult legalArrangementsEntities(
      List<KYCLegalArrangementEntityCheckResult> legalArrangementsEntities) {
    this.legalArrangementsEntities = legalArrangementsEntities;
    return this;
  }

  public KYCVerificationResult addLegalArrangementsEntitiesItem(
      KYCLegalArrangementEntityCheckResult legalArrangementsEntitiesItem) {
    if (this.legalArrangementsEntities == null) {
      this.legalArrangementsEntities = new ArrayList<>();
    }
    this.legalArrangementsEntities.add(legalArrangementsEntitiesItem);
    return this;
  }

  /**
   * The results of the checks on the legal arrangement entities.
   *
   * @return legalArrangementsEntities
   */
  @ApiModelProperty(value = "The results of the checks on the legal arrangement entities.")
  @JsonProperty(JSON_PROPERTY_LEGAL_ARRANGEMENTS_ENTITIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<KYCLegalArrangementEntityCheckResult> getLegalArrangementsEntities() {
    return legalArrangementsEntities;
  }

  @JsonProperty(JSON_PROPERTY_LEGAL_ARRANGEMENTS_ENTITIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLegalArrangementsEntities(
      List<KYCLegalArrangementEntityCheckResult> legalArrangementsEntities) {
    this.legalArrangementsEntities = legalArrangementsEntities;
  }

  public KYCVerificationResult payoutMethods(List<KYCPayoutMethodCheckResult> payoutMethods) {
    this.payoutMethods = payoutMethods;
    return this;
  }

  public KYCVerificationResult addPayoutMethodsItem(KYCPayoutMethodCheckResult payoutMethodsItem) {
    if (this.payoutMethods == null) {
      this.payoutMethods = new ArrayList<>();
    }
    this.payoutMethods.add(payoutMethodsItem);
    return this;
  }

  /**
   * The results of the checks on the payout methods.
   *
   * @return payoutMethods
   */
  @ApiModelProperty(value = "The results of the checks on the payout methods.")
  @JsonProperty(JSON_PROPERTY_PAYOUT_METHODS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<KYCPayoutMethodCheckResult> getPayoutMethods() {
    return payoutMethods;
  }

  @JsonProperty(JSON_PROPERTY_PAYOUT_METHODS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPayoutMethods(List<KYCPayoutMethodCheckResult> payoutMethods) {
    this.payoutMethods = payoutMethods;
  }

  public KYCVerificationResult shareholders(List<KYCShareholderCheckResult> shareholders) {
    this.shareholders = shareholders;
    return this;
  }

  public KYCVerificationResult addShareholdersItem(KYCShareholderCheckResult shareholdersItem) {
    if (this.shareholders == null) {
      this.shareholders = new ArrayList<>();
    }
    this.shareholders.add(shareholdersItem);
    return this;
  }

  /**
   * The results of the checks on the shareholders.
   *
   * @return shareholders
   */
  @ApiModelProperty(value = "The results of the checks on the shareholders.")
  @JsonProperty(JSON_PROPERTY_SHAREHOLDERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<KYCShareholderCheckResult> getShareholders() {
    return shareholders;
  }

  @JsonProperty(JSON_PROPERTY_SHAREHOLDERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setShareholders(List<KYCShareholderCheckResult> shareholders) {
    this.shareholders = shareholders;
  }

  public KYCVerificationResult signatories(List<KYCSignatoryCheckResult> signatories) {
    this.signatories = signatories;
    return this;
  }

  public KYCVerificationResult addSignatoriesItem(KYCSignatoryCheckResult signatoriesItem) {
    if (this.signatories == null) {
      this.signatories = new ArrayList<>();
    }
    this.signatories.add(signatoriesItem);
    return this;
  }

  /**
   * The results of the checks on the signatories.
   *
   * @return signatories
   */
  @ApiModelProperty(value = "The results of the checks on the signatories.")
  @JsonProperty(JSON_PROPERTY_SIGNATORIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<KYCSignatoryCheckResult> getSignatories() {
    return signatories;
  }

  @JsonProperty(JSON_PROPERTY_SIGNATORIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSignatories(List<KYCSignatoryCheckResult> signatories) {
    this.signatories = signatories;
  }

  public KYCVerificationResult ultimateParentCompany(
      List<KYCUltimateParentCompanyCheckResult> ultimateParentCompany) {
    this.ultimateParentCompany = ultimateParentCompany;
    return this;
  }

  public KYCVerificationResult addUltimateParentCompanyItem(
      KYCUltimateParentCompanyCheckResult ultimateParentCompanyItem) {
    if (this.ultimateParentCompany == null) {
      this.ultimateParentCompany = new ArrayList<>();
    }
    this.ultimateParentCompany.add(ultimateParentCompanyItem);
    return this;
  }

  /**
   * The result of the check on the Ultimate Parent Company.
   *
   * @return ultimateParentCompany
   */
  @ApiModelProperty(value = "The result of the check on the Ultimate Parent Company.")
  @JsonProperty(JSON_PROPERTY_ULTIMATE_PARENT_COMPANY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<KYCUltimateParentCompanyCheckResult> getUltimateParentCompany() {
    return ultimateParentCompany;
  }

  @JsonProperty(JSON_PROPERTY_ULTIMATE_PARENT_COMPANY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUltimateParentCompany(
      List<KYCUltimateParentCompanyCheckResult> ultimateParentCompany) {
    this.ultimateParentCompany = ultimateParentCompany;
  }

  /** Return true if this KYCVerificationResult object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KYCVerificationResult kyCVerificationResult = (KYCVerificationResult) o;
    return Objects.equals(this.accountHolder, kyCVerificationResult.accountHolder)
        && Objects.equals(this.legalArrangements, kyCVerificationResult.legalArrangements)
        && Objects.equals(
            this.legalArrangementsEntities, kyCVerificationResult.legalArrangementsEntities)
        && Objects.equals(this.payoutMethods, kyCVerificationResult.payoutMethods)
        && Objects.equals(this.shareholders, kyCVerificationResult.shareholders)
        && Objects.equals(this.signatories, kyCVerificationResult.signatories)
        && Objects.equals(this.ultimateParentCompany, kyCVerificationResult.ultimateParentCompany);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        accountHolder,
        legalArrangements,
        legalArrangementsEntities,
        payoutMethods,
        shareholders,
        signatories,
        ultimateParentCompany);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KYCVerificationResult {\n");
    sb.append("    accountHolder: ").append(toIndentedString(accountHolder)).append("\n");
    sb.append("    legalArrangements: ").append(toIndentedString(legalArrangements)).append("\n");
    sb.append("    legalArrangementsEntities: ")
        .append(toIndentedString(legalArrangementsEntities))
        .append("\n");
    sb.append("    payoutMethods: ").append(toIndentedString(payoutMethods)).append("\n");
    sb.append("    shareholders: ").append(toIndentedString(shareholders)).append("\n");
    sb.append("    signatories: ").append(toIndentedString(signatories)).append("\n");
    sb.append("    ultimateParentCompany: ")
        .append(toIndentedString(ultimateParentCompany))
        .append("\n");
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
   * Create an instance of KYCVerificationResult given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of KYCVerificationResult
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     KYCVerificationResult
   */
  public static KYCVerificationResult fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, KYCVerificationResult.class);
  }

  /**
   * Convert an instance of KYCVerificationResult to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
