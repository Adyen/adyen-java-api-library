package com.adyen.util.tapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Sale information intended for the Acquirer, decoded from the Base64-encoded JSON string found in
 * {@code SaleData.SaleToAcquirerData}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaleToAcquirerData {

  @JsonProperty("metadata")
  private Map<String, String> metadata;

  @JsonProperty("shopperEmail")
  private String shopperEmail;

  @JsonProperty("shopperReference")
  private String shopperReference;

  @JsonProperty("recurringContract")
  private String recurringContract;

  @JsonProperty("shopperStatement")
  private String shopperStatement;

  @JsonProperty("recurringDetailName")
  private String recurringDetailName;

  @JsonProperty("recurringTokenService")
  private String recurringTokenService;

  @JsonProperty("store")
  private String store;

  @JsonProperty("merchantAccount")
  private String merchantAccount;

  @JsonProperty("currency")
  private String currency;

  @JsonProperty("applicationInfo")
  private Map<String, Object> applicationInfo;

  @JsonProperty("tenderOption")
  private String tenderOption;

  @JsonProperty("additionalData")
  private Map<String, String> additionalData;

  @JsonProperty("authorisationType")
  private String authorisationType;

  @JsonProperty("ssc")
  private String ssc;

  @JsonProperty("recurringProcessingModel")
  private RecurringProcessingModel recurringProcessingModel;

  @JsonProperty("redemptionType")
  private String redemptionType;

  public enum RecurringProcessingModel {
    SUBSCRIPTION("Subscription"),
    CARD_ON_FILE("CardOnFile"),
    UNSCHEDULED_CARD_ON_FILE("UnscheduledCardOnFile");

    private static final Logger LOG = Logger.getLogger(RecurringProcessingModel.class.getName());

    private final String value;

    RecurringProcessingModel(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @JsonCreator
    public static RecurringProcessingModel fromValue(String value) {
      for (RecurringProcessingModel v : values()) {
        if (v.value.equals(value)) {
          return v;
        }
      }
      LOG.warning(
          "RecurringProcessingModel: unexpected enum value '"
              + value
              + "' - Supported values are "
              + Arrays.toString(RecurringProcessingModel.values()));
      return null;
    }
  }

  public Map<String, String> getMetadata() {
    return metadata;
  }

  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }

  public String getShopperEmail() {
    return shopperEmail;
  }

  public void setShopperEmail(String shopperEmail) {
    this.shopperEmail = shopperEmail;
  }

  public String getShopperReference() {
    return shopperReference;
  }

  public void setShopperReference(String shopperReference) {
    this.shopperReference = shopperReference;
  }

  public String getRecurringContract() {
    return recurringContract;
  }

  public void setRecurringContract(String recurringContract) {
    this.recurringContract = recurringContract;
  }

  public String getShopperStatement() {
    return shopperStatement;
  }

  public void setShopperStatement(String shopperStatement) {
    this.shopperStatement = shopperStatement;
  }

  public String getRecurringDetailName() {
    return recurringDetailName;
  }

  public void setRecurringDetailName(String recurringDetailName) {
    this.recurringDetailName = recurringDetailName;
  }

  public String getRecurringTokenService() {
    return recurringTokenService;
  }

  public void setRecurringTokenService(String recurringTokenService) {
    this.recurringTokenService = recurringTokenService;
  }

  public String getStore() {
    return store;
  }

  public void setStore(String store) {
    this.store = store;
  }

  public String getMerchantAccount() {
    return merchantAccount;
  }

  public void setMerchantAccount(String merchantAccount) {
    this.merchantAccount = merchantAccount;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Map<String, Object> getApplicationInfo() {
    return applicationInfo;
  }

  public void setApplicationInfo(Map<String, Object> applicationInfo) {
    this.applicationInfo = applicationInfo;
  }

  public String getTenderOption() {
    return tenderOption;
  }

  public void setTenderOption(String tenderOption) {
    this.tenderOption = tenderOption;
  }

  public Map<String, String> getAdditionalData() {
    return additionalData;
  }

  public void setAdditionalData(Map<String, String> additionalData) {
    this.additionalData = additionalData;
  }

  public String getAuthorisationType() {
    return authorisationType;
  }

  public void setAuthorisationType(String authorisationType) {
    this.authorisationType = authorisationType;
  }

  public String getSsc() {
    return ssc;
  }

  public void setSsc(String ssc) {
    this.ssc = ssc;
  }

  public RecurringProcessingModel getRecurringProcessingModel() {
    return recurringProcessingModel;
  }

  public void setRecurringProcessingModel(RecurringProcessingModel recurringProcessingModel) {
    this.recurringProcessingModel = recurringProcessingModel;
  }

  public String getRedemptionType() {
    return redemptionType;
  }

  public void setRedemptionType(String redemptionType) {
    this.redemptionType = redemptionType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SaleToAcquirerData that = (SaleToAcquirerData) o;
    return Objects.equals(metadata, that.metadata)
        && Objects.equals(shopperEmail, that.shopperEmail)
        && Objects.equals(shopperReference, that.shopperReference)
        && Objects.equals(recurringContract, that.recurringContract)
        && Objects.equals(shopperStatement, that.shopperStatement)
        && Objects.equals(recurringDetailName, that.recurringDetailName)
        && Objects.equals(recurringTokenService, that.recurringTokenService)
        && Objects.equals(store, that.store)
        && Objects.equals(merchantAccount, that.merchantAccount)
        && Objects.equals(currency, that.currency)
        && Objects.equals(applicationInfo, that.applicationInfo)
        && Objects.equals(tenderOption, that.tenderOption)
        && Objects.equals(additionalData, that.additionalData)
        && Objects.equals(authorisationType, that.authorisationType)
        && Objects.equals(ssc, that.ssc)
        && Objects.equals(recurringProcessingModel, that.recurringProcessingModel)
        && Objects.equals(redemptionType, that.redemptionType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        metadata,
        shopperEmail,
        shopperReference,
        recurringContract,
        shopperStatement,
        recurringDetailName,
        recurringTokenService,
        store,
        merchantAccount,
        currency,
        applicationInfo,
        tenderOption,
        additionalData,
        authorisationType,
        ssc,
        recurringProcessingModel,
        redemptionType);
  }

  @Override
  public String toString() {
    try {
      return SaleToAcquirerDataParser.toJson(this);
    } catch (Exception e) {
      return "SaleToAcquirerData{serialization error: " + e.getMessage() + "}";
    }
  }
}
