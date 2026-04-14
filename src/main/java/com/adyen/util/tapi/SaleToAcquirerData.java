package com.adyen.util.tapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Sale information intended for the Acquirer, decoded from the Base64-encoded JSON string found in
 * {@code SaleData.SaleToAcquirerData}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaleToAcquirerData {

  private static final ObjectMapper MAPPER =
      new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

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

    private static final Logger LOG =
        Logger.getLogger(RecurringProcessingModel.class.getName());

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

  /**
   * Encodes this object to a Base64 JSON string.
   *
   * @return Base64-encoded JSON representation.
   */
  public String toBase64() {
    try {
      byte[] json = MAPPER.writeValueAsBytes(this);
      return Base64.getEncoder().encodeToString(json);
    } catch (Exception e) {
      throw new IllegalStateException("Failed to serialize SaleToAcquirerData", e);
    }
  }

  /**
   * Parses a raw {@code SaleToAcquirerData} string into a {@link SaleToAcquirerData} object,
   * auto-detecting the format. The Base64 string is decoded only once.
   *
   * <ul>
   *   <li>If the string is valid Base64 and decodes to a JSON object, it is parsed as JSON.
   *   <li>Otherwise it is parsed as form-encoded key-value pairs.
   * </ul>
   *
   * @param raw The raw {@code SaleToAcquirerData} string.
   * @return Parsed {@link SaleToAcquirerData}.
   */
  public static SaleToAcquirerData parse(String raw) {
    try {
      byte[] decoded = Base64.getDecoder().decode(raw);
      if (new String(decoded, StandardCharsets.UTF_8).trim().startsWith("{")) {
        return MAPPER.readValue(decoded, SaleToAcquirerData.class);
      }
    } catch (IllegalArgumentException e) {
      // not valid Base64 — fall through to key-value parsing
    } catch (Exception e) {
      throw new IllegalStateException("Failed to deserialize SaleToAcquirerData", e);
    }
    return fromKeyValuePairs(raw);
  }

  /**
   * Decodes a Base64 JSON string into a {@link SaleToAcquirerData} object.
   *
   * @param base64 Base64-encoded JSON string.
   * @return Decoded {@link SaleToAcquirerData}.
   */
  public static SaleToAcquirerData fromBase64(String base64) {
    try {
      byte[] decoded = Base64.getDecoder().decode(base64);
      return MAPPER.readValue(decoded, SaleToAcquirerData.class);
    } catch (Exception e) {
      throw new IllegalStateException("Failed to deserialize SaleToAcquirerData", e);
    }
  }

  /**
   * Parses a form-encoded key-value pair string (e.g. {@code
   * shopperEmail=foo@bar.com&tenderOption=AskGratuity}) into a {@link SaleToAcquirerData} object.
   * Metadata fields use dotted notation: {@code metadata.key=value}.
   *
   * @param keyValuePairs Form-encoded key-value string using {@code &} as separator.
   * @return Parsed {@link SaleToAcquirerData}.
   */
  public static SaleToAcquirerData fromKeyValuePairs(String keyValuePairs) {
    SaleToAcquirerData data = new SaleToAcquirerData();
    Map<String, String> metadata = new HashMap<>();
    Map<String, String> additionalData = new HashMap<>();

    for (String pair : keyValuePairs.split("&")) {
      int idx = pair.indexOf('=');
      if (idx <= 0 || idx >= pair.length() - 1) {
        continue;
      }
      String key = URLDecoder.decode(pair.substring(0, idx), StandardCharsets.UTF_8);
      String value = URLDecoder.decode(pair.substring(idx + 1), StandardCharsets.UTF_8);

      if (key.startsWith("metadata.")) {
        metadata.put(key.substring("metadata.".length()), value);
      } else {
        switch (key) {
          case "shopperEmail":
            data.setShopperEmail(value);
            break;
          case "shopperReference":
            data.setShopperReference(value);
            break;
          case "shopperStatement":
            data.setShopperStatement(value);
            break;
          case "recurringContract":
            data.setRecurringContract(value);
            break;
          case "recurringDetailName":
            data.setRecurringDetailName(value);
            break;
          case "recurringTokenService":
            data.setRecurringTokenService(value);
            break;
          case "recurringProcessingModel":
            data.setRecurringProcessingModel(RecurringProcessingModel.fromValue(value));
            break;
          case "store":
            data.setStore(value);
            break;
          case "merchantAccount":
            data.setMerchantAccount(value);
            break;
          case "currency":
            data.setCurrency(value);
            break;
          case "tenderOption":
            data.setTenderOption(value);
            break;
          case "authorisationType":
            data.setAuthorisationType(value);
            break;
          case "ssc":
            data.setSsc(value);
            break;
          case "redemptionType":
            data.setRedemptionType(value);
            break;
          default:
            additionalData.put(key, value);
            break;
        }
      }
    }

    if (!metadata.isEmpty()) {
      data.setMetadata(metadata);
    }
    if (!additionalData.isEmpty()) {
      data.setAdditionalData(additionalData);
    }
    return data;
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
      return MAPPER.writeValueAsString(this);
    } catch (Exception e) {
      return "SaleToAcquirerData{serialization error: " + e.getMessage() + "}";
    }
  }

}
