/*
 * Configuration webhooks
 *
 * The version of the OpenAPI document: 2
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.configurationwebhooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** NetworkTokenRiskRuleData */
@JsonPropertyOrder({
  NetworkTokenRiskRuleData.JSON_PROPERTY_DESCRIPTION,
  NetworkTokenRiskRuleData.JSON_PROPERTY_ID,
  NetworkTokenRiskRuleData.JSON_PROPERTY_OUTCOME_TYPE,
  NetworkTokenRiskRuleData.JSON_PROPERTY_REFERENCE,
  NetworkTokenRiskRuleData.JSON_PROPERTY_SCORE
})
public class NetworkTokenRiskRuleData {
  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_OUTCOME_TYPE = "outcomeType";
  private String outcomeType;

  public static final String JSON_PROPERTY_REFERENCE = "reference";
  private String reference;

  public static final String JSON_PROPERTY_SCORE = "score";
  private Integer score;

  public NetworkTokenRiskRuleData() {}

  /**
   * The description of the transaction rule.
   *
   * @param description The description of the transaction rule.
   * @return the current {@code NetworkTokenRiskRuleData} instance, allowing for method chaining
   */
  public NetworkTokenRiskRuleData description(String description) {
    this.description = description;
    return this;
  }

  /**
   * The description of the transaction rule.
   *
   * @return description The description of the transaction rule.
   */
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDescription() {
    return description;
  }

  /**
   * The description of the transaction rule.
   *
   * @param description The description of the transaction rule.
   */
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * The unique identifier of the transaction rule.
   *
   * @param id The unique identifier of the transaction rule.
   * @return the current {@code NetworkTokenRiskRuleData} instance, allowing for method chaining
   */
  public NetworkTokenRiskRuleData id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The unique identifier of the transaction rule.
   *
   * @return id The unique identifier of the transaction rule.
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getId() {
    return id;
  }

  /**
   * The unique identifier of the transaction rule.
   *
   * @param id The unique identifier of the transaction rule.
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The outcome type of the transaction rule.
   *
   * @param outcomeType The outcome type of the transaction rule.
   * @return the current {@code NetworkTokenRiskRuleData} instance, allowing for method chaining
   */
  public NetworkTokenRiskRuleData outcomeType(String outcomeType) {
    this.outcomeType = outcomeType;
    return this;
  }

  /**
   * The outcome type of the transaction rule.
   *
   * @return outcomeType The outcome type of the transaction rule.
   */
  @JsonProperty(JSON_PROPERTY_OUTCOME_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getOutcomeType() {
    return outcomeType;
  }

  /**
   * The outcome type of the transaction rule.
   *
   * @param outcomeType The outcome type of the transaction rule.
   */
  @JsonProperty(JSON_PROPERTY_OUTCOME_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOutcomeType(String outcomeType) {
    this.outcomeType = outcomeType;
  }

  /**
   * The reference for the transaction rule.
   *
   * @param reference The reference for the transaction rule.
   * @return the current {@code NetworkTokenRiskRuleData} instance, allowing for method chaining
   */
  public NetworkTokenRiskRuleData reference(String reference) {
    this.reference = reference;
    return this;
  }

  /**
   * The reference for the transaction rule.
   *
   * @return reference The reference for the transaction rule.
   */
  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getReference() {
    return reference;
  }

  /**
   * The reference for the transaction rule.
   *
   * @param reference The reference for the transaction rule.
   */
  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReference(String reference) {
    this.reference = reference;
  }

  /**
   * The transaction score determined by the rule.
   *
   * @param score The transaction score determined by the rule.
   * @return the current {@code NetworkTokenRiskRuleData} instance, allowing for method chaining
   */
  public NetworkTokenRiskRuleData score(Integer score) {
    this.score = score;
    return this;
  }

  /**
   * The transaction score determined by the rule.
   *
   * @return score The transaction score determined by the rule.
   */
  @JsonProperty(JSON_PROPERTY_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getScore() {
    return score;
  }

  /**
   * The transaction score determined by the rule.
   *
   * @param score The transaction score determined by the rule.
   */
  @JsonProperty(JSON_PROPERTY_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setScore(Integer score) {
    this.score = score;
  }

  /** Return true if this NetworkTokenRiskRuleData object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkTokenRiskRuleData networkTokenRiskRuleData = (NetworkTokenRiskRuleData) o;
    return Objects.equals(this.description, networkTokenRiskRuleData.description)
        && Objects.equals(this.id, networkTokenRiskRuleData.id)
        && Objects.equals(this.outcomeType, networkTokenRiskRuleData.outcomeType)
        && Objects.equals(this.reference, networkTokenRiskRuleData.reference)
        && Objects.equals(this.score, networkTokenRiskRuleData.score);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, id, outcomeType, reference, score);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkTokenRiskRuleData {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    outcomeType: ").append(toIndentedString(outcomeType)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
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
   * Create an instance of NetworkTokenRiskRuleData given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of NetworkTokenRiskRuleData
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     NetworkTokenRiskRuleData
   */
  public static NetworkTokenRiskRuleData fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, NetworkTokenRiskRuleData.class);
  }

  /**
   * Convert an instance of NetworkTokenRiskRuleData to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
