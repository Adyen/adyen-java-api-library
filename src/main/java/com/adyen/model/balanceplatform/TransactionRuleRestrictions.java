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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** TransactionRuleRestrictions */
@JsonPropertyOrder({
  TransactionRuleRestrictions.JSON_PROPERTY_ACTIVE_NETWORK_TOKENS,
  TransactionRuleRestrictions.JSON_PROPERTY_BRAND_VARIANTS,
  TransactionRuleRestrictions.JSON_PROPERTY_COUNTERPARTY_BANK,
  TransactionRuleRestrictions.JSON_PROPERTY_COUNTERPARTY_TYPES,
  TransactionRuleRestrictions.JSON_PROPERTY_COUNTRIES,
  TransactionRuleRestrictions.JSON_PROPERTY_DAY_OF_WEEK,
  TransactionRuleRestrictions.JSON_PROPERTY_DIFFERENT_CURRENCIES,
  TransactionRuleRestrictions.JSON_PROPERTY_ENTRY_MODES,
  TransactionRuleRestrictions.JSON_PROPERTY_INTERNATIONAL_TRANSACTION,
  TransactionRuleRestrictions.JSON_PROPERTY_MATCHING_TRANSACTIONS,
  TransactionRuleRestrictions.JSON_PROPERTY_MATCHING_VALUES,
  TransactionRuleRestrictions.JSON_PROPERTY_MCCS,
  TransactionRuleRestrictions.JSON_PROPERTY_MERCHANT_NAMES,
  TransactionRuleRestrictions.JSON_PROPERTY_MERCHANTS,
  TransactionRuleRestrictions.JSON_PROPERTY_PROCESSING_TYPES,
  TransactionRuleRestrictions.JSON_PROPERTY_RISK_SCORES,
  TransactionRuleRestrictions.JSON_PROPERTY_SAME_AMOUNT_RESTRICTION,
  TransactionRuleRestrictions.JSON_PROPERTY_SAME_COUNTERPARTY_RESTRICTION,
  TransactionRuleRestrictions.JSON_PROPERTY_SOURCE_ACCOUNT_TYPES,
  TransactionRuleRestrictions.JSON_PROPERTY_TIME_OF_DAY,
  TransactionRuleRestrictions.JSON_PROPERTY_TOKEN_REQUESTORS,
  TransactionRuleRestrictions.JSON_PROPERTY_TOTAL_AMOUNT,
  TransactionRuleRestrictions.JSON_PROPERTY_WALLET_PROVIDER_ACCOUNT_SCORE,
  TransactionRuleRestrictions.JSON_PROPERTY_WALLET_PROVIDER_DEVICE_SCORE,
  TransactionRuleRestrictions.JSON_PROPERTY_WALLET_PROVIDER_DEVICE_TYPE
})
public class TransactionRuleRestrictions {
  public static final String JSON_PROPERTY_ACTIVE_NETWORK_TOKENS = "activeNetworkTokens";
  private ActiveNetworkTokensRestriction activeNetworkTokens;

  public static final String JSON_PROPERTY_BRAND_VARIANTS = "brandVariants";
  private BrandVariantsRestriction brandVariants;

  public static final String JSON_PROPERTY_COUNTERPARTY_BANK = "counterpartyBank";
  private CounterpartyBankRestriction counterpartyBank;

  public static final String JSON_PROPERTY_COUNTERPARTY_TYPES = "counterpartyTypes";
  private CounterpartyTypesRestriction counterpartyTypes;

  public static final String JSON_PROPERTY_COUNTRIES = "countries";
  private CountriesRestriction countries;

  public static final String JSON_PROPERTY_DAY_OF_WEEK = "dayOfWeek";
  private DayOfWeekRestriction dayOfWeek;

  public static final String JSON_PROPERTY_DIFFERENT_CURRENCIES = "differentCurrencies";
  private DifferentCurrenciesRestriction differentCurrencies;

  public static final String JSON_PROPERTY_ENTRY_MODES = "entryModes";
  private EntryModesRestriction entryModes;

  public static final String JSON_PROPERTY_INTERNATIONAL_TRANSACTION = "internationalTransaction";
  private InternationalTransactionRestriction internationalTransaction;

  public static final String JSON_PROPERTY_MATCHING_TRANSACTIONS = "matchingTransactions";
  private MatchingTransactionsRestriction matchingTransactions;

  public static final String JSON_PROPERTY_MATCHING_VALUES = "matchingValues";
  private MatchingValuesRestriction matchingValues;

  public static final String JSON_PROPERTY_MCCS = "mccs";
  private MccsRestriction mccs;

  public static final String JSON_PROPERTY_MERCHANT_NAMES = "merchantNames";
  private MerchantNamesRestriction merchantNames;

  public static final String JSON_PROPERTY_MERCHANTS = "merchants";
  private MerchantsRestriction merchants;

  public static final String JSON_PROPERTY_PROCESSING_TYPES = "processingTypes";
  private ProcessingTypesRestriction processingTypes;

  public static final String JSON_PROPERTY_RISK_SCORES = "riskScores";
  private RiskScoresRestriction riskScores;

  public static final String JSON_PROPERTY_SAME_AMOUNT_RESTRICTION = "sameAmountRestriction";
  private SameAmountRestriction sameAmountRestriction;

  public static final String JSON_PROPERTY_SAME_COUNTERPARTY_RESTRICTION =
      "sameCounterpartyRestriction";
  private SameCounterpartyRestriction sameCounterpartyRestriction;

  public static final String JSON_PROPERTY_SOURCE_ACCOUNT_TYPES = "sourceAccountTypes";
  private SourceAccountTypesRestriction sourceAccountTypes;

  public static final String JSON_PROPERTY_TIME_OF_DAY = "timeOfDay";
  private TimeOfDayRestriction timeOfDay;

  public static final String JSON_PROPERTY_TOKEN_REQUESTORS = "tokenRequestors";
  private TokenRequestorsRestriction tokenRequestors;

  public static final String JSON_PROPERTY_TOTAL_AMOUNT = "totalAmount";
  private TotalAmountRestriction totalAmount;

  public static final String JSON_PROPERTY_WALLET_PROVIDER_ACCOUNT_SCORE =
      "walletProviderAccountScore";
  private WalletProviderAccountScoreRestriction walletProviderAccountScore;

  public static final String JSON_PROPERTY_WALLET_PROVIDER_DEVICE_SCORE =
      "walletProviderDeviceScore";
  private WalletProviderDeviceScore walletProviderDeviceScore;

  public static final String JSON_PROPERTY_WALLET_PROVIDER_DEVICE_TYPE = "walletProviderDeviceType";
  private WalletProviderDeviceType walletProviderDeviceType;

  public TransactionRuleRestrictions() {}

  /**
   * activeNetworkTokens
   *
   * @param activeNetworkTokens
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions activeNetworkTokens(
      ActiveNetworkTokensRestriction activeNetworkTokens) {
    this.activeNetworkTokens = activeNetworkTokens;
    return this;
  }

  /**
   * Get activeNetworkTokens
   *
   * @return activeNetworkTokens
   */
  @JsonProperty(JSON_PROPERTY_ACTIVE_NETWORK_TOKENS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ActiveNetworkTokensRestriction getActiveNetworkTokens() {
    return activeNetworkTokens;
  }

  /**
   * activeNetworkTokens
   *
   * @param activeNetworkTokens
   */
  @JsonProperty(JSON_PROPERTY_ACTIVE_NETWORK_TOKENS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setActiveNetworkTokens(ActiveNetworkTokensRestriction activeNetworkTokens) {
    this.activeNetworkTokens = activeNetworkTokens;
  }

  /**
   * brandVariants
   *
   * @param brandVariants
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions brandVariants(BrandVariantsRestriction brandVariants) {
    this.brandVariants = brandVariants;
    return this;
  }

  /**
   * Get brandVariants
   *
   * @return brandVariants
   */
  @JsonProperty(JSON_PROPERTY_BRAND_VARIANTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public BrandVariantsRestriction getBrandVariants() {
    return brandVariants;
  }

  /**
   * brandVariants
   *
   * @param brandVariants
   */
  @JsonProperty(JSON_PROPERTY_BRAND_VARIANTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBrandVariants(BrandVariantsRestriction brandVariants) {
    this.brandVariants = brandVariants;
  }

  /**
   * counterpartyBank
   *
   * @param counterpartyBank
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions counterpartyBank(
      CounterpartyBankRestriction counterpartyBank) {
    this.counterpartyBank = counterpartyBank;
    return this;
  }

  /**
   * Get counterpartyBank
   *
   * @return counterpartyBank
   */
  @JsonProperty(JSON_PROPERTY_COUNTERPARTY_BANK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public CounterpartyBankRestriction getCounterpartyBank() {
    return counterpartyBank;
  }

  /**
   * counterpartyBank
   *
   * @param counterpartyBank
   */
  @JsonProperty(JSON_PROPERTY_COUNTERPARTY_BANK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCounterpartyBank(CounterpartyBankRestriction counterpartyBank) {
    this.counterpartyBank = counterpartyBank;
  }

  /**
   * counterpartyTypes
   *
   * @param counterpartyTypes
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions counterpartyTypes(
      CounterpartyTypesRestriction counterpartyTypes) {
    this.counterpartyTypes = counterpartyTypes;
    return this;
  }

  /**
   * Get counterpartyTypes
   *
   * @return counterpartyTypes
   */
  @JsonProperty(JSON_PROPERTY_COUNTERPARTY_TYPES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public CounterpartyTypesRestriction getCounterpartyTypes() {
    return counterpartyTypes;
  }

  /**
   * counterpartyTypes
   *
   * @param counterpartyTypes
   */
  @JsonProperty(JSON_PROPERTY_COUNTERPARTY_TYPES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCounterpartyTypes(CounterpartyTypesRestriction counterpartyTypes) {
    this.counterpartyTypes = counterpartyTypes;
  }

  /**
   * countries
   *
   * @param countries
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions countries(CountriesRestriction countries) {
    this.countries = countries;
    return this;
  }

  /**
   * Get countries
   *
   * @return countries
   */
  @JsonProperty(JSON_PROPERTY_COUNTRIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public CountriesRestriction getCountries() {
    return countries;
  }

  /**
   * countries
   *
   * @param countries
   */
  @JsonProperty(JSON_PROPERTY_COUNTRIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCountries(CountriesRestriction countries) {
    this.countries = countries;
  }

  /**
   * dayOfWeek
   *
   * @param dayOfWeek
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions dayOfWeek(DayOfWeekRestriction dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
    return this;
  }

  /**
   * Get dayOfWeek
   *
   * @return dayOfWeek
   */
  @JsonProperty(JSON_PROPERTY_DAY_OF_WEEK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public DayOfWeekRestriction getDayOfWeek() {
    return dayOfWeek;
  }

  /**
   * dayOfWeek
   *
   * @param dayOfWeek
   */
  @JsonProperty(JSON_PROPERTY_DAY_OF_WEEK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDayOfWeek(DayOfWeekRestriction dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
  }

  /**
   * differentCurrencies
   *
   * @param differentCurrencies
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions differentCurrencies(
      DifferentCurrenciesRestriction differentCurrencies) {
    this.differentCurrencies = differentCurrencies;
    return this;
  }

  /**
   * Get differentCurrencies
   *
   * @return differentCurrencies
   */
  @JsonProperty(JSON_PROPERTY_DIFFERENT_CURRENCIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public DifferentCurrenciesRestriction getDifferentCurrencies() {
    return differentCurrencies;
  }

  /**
   * differentCurrencies
   *
   * @param differentCurrencies
   */
  @JsonProperty(JSON_PROPERTY_DIFFERENT_CURRENCIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDifferentCurrencies(DifferentCurrenciesRestriction differentCurrencies) {
    this.differentCurrencies = differentCurrencies;
  }

  /**
   * entryModes
   *
   * @param entryModes
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions entryModes(EntryModesRestriction entryModes) {
    this.entryModes = entryModes;
    return this;
  }

  /**
   * Get entryModes
   *
   * @return entryModes
   */
  @JsonProperty(JSON_PROPERTY_ENTRY_MODES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public EntryModesRestriction getEntryModes() {
    return entryModes;
  }

  /**
   * entryModes
   *
   * @param entryModes
   */
  @JsonProperty(JSON_PROPERTY_ENTRY_MODES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEntryModes(EntryModesRestriction entryModes) {
    this.entryModes = entryModes;
  }

  /**
   * internationalTransaction
   *
   * @param internationalTransaction
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions internationalTransaction(
      InternationalTransactionRestriction internationalTransaction) {
    this.internationalTransaction = internationalTransaction;
    return this;
  }

  /**
   * Get internationalTransaction
   *
   * @return internationalTransaction
   */
  @JsonProperty(JSON_PROPERTY_INTERNATIONAL_TRANSACTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public InternationalTransactionRestriction getInternationalTransaction() {
    return internationalTransaction;
  }

  /**
   * internationalTransaction
   *
   * @param internationalTransaction
   */
  @JsonProperty(JSON_PROPERTY_INTERNATIONAL_TRANSACTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInternationalTransaction(
      InternationalTransactionRestriction internationalTransaction) {
    this.internationalTransaction = internationalTransaction;
  }

  /**
   * matchingTransactions
   *
   * @param matchingTransactions
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions matchingTransactions(
      MatchingTransactionsRestriction matchingTransactions) {
    this.matchingTransactions = matchingTransactions;
    return this;
  }

  /**
   * Get matchingTransactions
   *
   * @return matchingTransactions
   */
  @JsonProperty(JSON_PROPERTY_MATCHING_TRANSACTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public MatchingTransactionsRestriction getMatchingTransactions() {
    return matchingTransactions;
  }

  /**
   * matchingTransactions
   *
   * @param matchingTransactions
   */
  @JsonProperty(JSON_PROPERTY_MATCHING_TRANSACTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMatchingTransactions(MatchingTransactionsRestriction matchingTransactions) {
    this.matchingTransactions = matchingTransactions;
  }

  /**
   * matchingValues
   *
   * @param matchingValues
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions matchingValues(MatchingValuesRestriction matchingValues) {
    this.matchingValues = matchingValues;
    return this;
  }

  /**
   * Get matchingValues
   *
   * @return matchingValues
   */
  @JsonProperty(JSON_PROPERTY_MATCHING_VALUES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public MatchingValuesRestriction getMatchingValues() {
    return matchingValues;
  }

  /**
   * matchingValues
   *
   * @param matchingValues
   */
  @JsonProperty(JSON_PROPERTY_MATCHING_VALUES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMatchingValues(MatchingValuesRestriction matchingValues) {
    this.matchingValues = matchingValues;
  }

  /**
   * mccs
   *
   * @param mccs
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions mccs(MccsRestriction mccs) {
    this.mccs = mccs;
    return this;
  }

  /**
   * Get mccs
   *
   * @return mccs
   */
  @JsonProperty(JSON_PROPERTY_MCCS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public MccsRestriction getMccs() {
    return mccs;
  }

  /**
   * mccs
   *
   * @param mccs
   */
  @JsonProperty(JSON_PROPERTY_MCCS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMccs(MccsRestriction mccs) {
    this.mccs = mccs;
  }

  /**
   * merchantNames
   *
   * @param merchantNames
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions merchantNames(MerchantNamesRestriction merchantNames) {
    this.merchantNames = merchantNames;
    return this;
  }

  /**
   * Get merchantNames
   *
   * @return merchantNames
   */
  @JsonProperty(JSON_PROPERTY_MERCHANT_NAMES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public MerchantNamesRestriction getMerchantNames() {
    return merchantNames;
  }

  /**
   * merchantNames
   *
   * @param merchantNames
   */
  @JsonProperty(JSON_PROPERTY_MERCHANT_NAMES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMerchantNames(MerchantNamesRestriction merchantNames) {
    this.merchantNames = merchantNames;
  }

  /**
   * merchants
   *
   * @param merchants
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions merchants(MerchantsRestriction merchants) {
    this.merchants = merchants;
    return this;
  }

  /**
   * Get merchants
   *
   * @return merchants
   */
  @JsonProperty(JSON_PROPERTY_MERCHANTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public MerchantsRestriction getMerchants() {
    return merchants;
  }

  /**
   * merchants
   *
   * @param merchants
   */
  @JsonProperty(JSON_PROPERTY_MERCHANTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMerchants(MerchantsRestriction merchants) {
    this.merchants = merchants;
  }

  /**
   * processingTypes
   *
   * @param processingTypes
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions processingTypes(ProcessingTypesRestriction processingTypes) {
    this.processingTypes = processingTypes;
    return this;
  }

  /**
   * Get processingTypes
   *
   * @return processingTypes
   */
  @JsonProperty(JSON_PROPERTY_PROCESSING_TYPES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ProcessingTypesRestriction getProcessingTypes() {
    return processingTypes;
  }

  /**
   * processingTypes
   *
   * @param processingTypes
   */
  @JsonProperty(JSON_PROPERTY_PROCESSING_TYPES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProcessingTypes(ProcessingTypesRestriction processingTypes) {
    this.processingTypes = processingTypes;
  }

  /**
   * riskScores
   *
   * @param riskScores
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions riskScores(RiskScoresRestriction riskScores) {
    this.riskScores = riskScores;
    return this;
  }

  /**
   * Get riskScores
   *
   * @return riskScores
   */
  @JsonProperty(JSON_PROPERTY_RISK_SCORES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public RiskScoresRestriction getRiskScores() {
    return riskScores;
  }

  /**
   * riskScores
   *
   * @param riskScores
   */
  @JsonProperty(JSON_PROPERTY_RISK_SCORES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRiskScores(RiskScoresRestriction riskScores) {
    this.riskScores = riskScores;
  }

  /**
   * sameAmountRestriction
   *
   * @param sameAmountRestriction
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions sameAmountRestriction(
      SameAmountRestriction sameAmountRestriction) {
    this.sameAmountRestriction = sameAmountRestriction;
    return this;
  }

  /**
   * Get sameAmountRestriction
   *
   * @return sameAmountRestriction
   */
  @JsonProperty(JSON_PROPERTY_SAME_AMOUNT_RESTRICTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SameAmountRestriction getSameAmountRestriction() {
    return sameAmountRestriction;
  }

  /**
   * sameAmountRestriction
   *
   * @param sameAmountRestriction
   */
  @JsonProperty(JSON_PROPERTY_SAME_AMOUNT_RESTRICTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSameAmountRestriction(SameAmountRestriction sameAmountRestriction) {
    this.sameAmountRestriction = sameAmountRestriction;
  }

  /**
   * sameCounterpartyRestriction
   *
   * @param sameCounterpartyRestriction
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions sameCounterpartyRestriction(
      SameCounterpartyRestriction sameCounterpartyRestriction) {
    this.sameCounterpartyRestriction = sameCounterpartyRestriction;
    return this;
  }

  /**
   * Get sameCounterpartyRestriction
   *
   * @return sameCounterpartyRestriction
   */
  @JsonProperty(JSON_PROPERTY_SAME_COUNTERPARTY_RESTRICTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SameCounterpartyRestriction getSameCounterpartyRestriction() {
    return sameCounterpartyRestriction;
  }

  /**
   * sameCounterpartyRestriction
   *
   * @param sameCounterpartyRestriction
   */
  @JsonProperty(JSON_PROPERTY_SAME_COUNTERPARTY_RESTRICTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSameCounterpartyRestriction(
      SameCounterpartyRestriction sameCounterpartyRestriction) {
    this.sameCounterpartyRestriction = sameCounterpartyRestriction;
  }

  /**
   * sourceAccountTypes
   *
   * @param sourceAccountTypes
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions sourceAccountTypes(
      SourceAccountTypesRestriction sourceAccountTypes) {
    this.sourceAccountTypes = sourceAccountTypes;
    return this;
  }

  /**
   * Get sourceAccountTypes
   *
   * @return sourceAccountTypes
   */
  @JsonProperty(JSON_PROPERTY_SOURCE_ACCOUNT_TYPES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SourceAccountTypesRestriction getSourceAccountTypes() {
    return sourceAccountTypes;
  }

  /**
   * sourceAccountTypes
   *
   * @param sourceAccountTypes
   */
  @JsonProperty(JSON_PROPERTY_SOURCE_ACCOUNT_TYPES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSourceAccountTypes(SourceAccountTypesRestriction sourceAccountTypes) {
    this.sourceAccountTypes = sourceAccountTypes;
  }

  /**
   * timeOfDay
   *
   * @param timeOfDay
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions timeOfDay(TimeOfDayRestriction timeOfDay) {
    this.timeOfDay = timeOfDay;
    return this;
  }

  /**
   * Get timeOfDay
   *
   * @return timeOfDay
   */
  @JsonProperty(JSON_PROPERTY_TIME_OF_DAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public TimeOfDayRestriction getTimeOfDay() {
    return timeOfDay;
  }

  /**
   * timeOfDay
   *
   * @param timeOfDay
   */
  @JsonProperty(JSON_PROPERTY_TIME_OF_DAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTimeOfDay(TimeOfDayRestriction timeOfDay) {
    this.timeOfDay = timeOfDay;
  }

  /**
   * tokenRequestors
   *
   * @param tokenRequestors
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions tokenRequestors(TokenRequestorsRestriction tokenRequestors) {
    this.tokenRequestors = tokenRequestors;
    return this;
  }

  /**
   * Get tokenRequestors
   *
   * @return tokenRequestors
   */
  @JsonProperty(JSON_PROPERTY_TOKEN_REQUESTORS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public TokenRequestorsRestriction getTokenRequestors() {
    return tokenRequestors;
  }

  /**
   * tokenRequestors
   *
   * @param tokenRequestors
   */
  @JsonProperty(JSON_PROPERTY_TOKEN_REQUESTORS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTokenRequestors(TokenRequestorsRestriction tokenRequestors) {
    this.tokenRequestors = tokenRequestors;
  }

  /**
   * totalAmount
   *
   * @param totalAmount
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions totalAmount(TotalAmountRestriction totalAmount) {
    this.totalAmount = totalAmount;
    return this;
  }

  /**
   * Get totalAmount
   *
   * @return totalAmount
   */
  @JsonProperty(JSON_PROPERTY_TOTAL_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public TotalAmountRestriction getTotalAmount() {
    return totalAmount;
  }

  /**
   * totalAmount
   *
   * @param totalAmount
   */
  @JsonProperty(JSON_PROPERTY_TOTAL_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTotalAmount(TotalAmountRestriction totalAmount) {
    this.totalAmount = totalAmount;
  }

  /**
   * walletProviderAccountScore
   *
   * @param walletProviderAccountScore
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions walletProviderAccountScore(
      WalletProviderAccountScoreRestriction walletProviderAccountScore) {
    this.walletProviderAccountScore = walletProviderAccountScore;
    return this;
  }

  /**
   * Get walletProviderAccountScore
   *
   * @return walletProviderAccountScore
   */
  @JsonProperty(JSON_PROPERTY_WALLET_PROVIDER_ACCOUNT_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public WalletProviderAccountScoreRestriction getWalletProviderAccountScore() {
    return walletProviderAccountScore;
  }

  /**
   * walletProviderAccountScore
   *
   * @param walletProviderAccountScore
   */
  @JsonProperty(JSON_PROPERTY_WALLET_PROVIDER_ACCOUNT_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWalletProviderAccountScore(
      WalletProviderAccountScoreRestriction walletProviderAccountScore) {
    this.walletProviderAccountScore = walletProviderAccountScore;
  }

  /**
   * walletProviderDeviceScore
   *
   * @param walletProviderDeviceScore
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions walletProviderDeviceScore(
      WalletProviderDeviceScore walletProviderDeviceScore) {
    this.walletProviderDeviceScore = walletProviderDeviceScore;
    return this;
  }

  /**
   * Get walletProviderDeviceScore
   *
   * @return walletProviderDeviceScore
   */
  @JsonProperty(JSON_PROPERTY_WALLET_PROVIDER_DEVICE_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public WalletProviderDeviceScore getWalletProviderDeviceScore() {
    return walletProviderDeviceScore;
  }

  /**
   * walletProviderDeviceScore
   *
   * @param walletProviderDeviceScore
   */
  @JsonProperty(JSON_PROPERTY_WALLET_PROVIDER_DEVICE_SCORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWalletProviderDeviceScore(WalletProviderDeviceScore walletProviderDeviceScore) {
    this.walletProviderDeviceScore = walletProviderDeviceScore;
  }

  /**
   * walletProviderDeviceType
   *
   * @param walletProviderDeviceType
   * @return the current {@code TransactionRuleRestrictions} instance, allowing for method chaining
   */
  public TransactionRuleRestrictions walletProviderDeviceType(
      WalletProviderDeviceType walletProviderDeviceType) {
    this.walletProviderDeviceType = walletProviderDeviceType;
    return this;
  }

  /**
   * Get walletProviderDeviceType
   *
   * @return walletProviderDeviceType
   */
  @JsonProperty(JSON_PROPERTY_WALLET_PROVIDER_DEVICE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public WalletProviderDeviceType getWalletProviderDeviceType() {
    return walletProviderDeviceType;
  }

  /**
   * walletProviderDeviceType
   *
   * @param walletProviderDeviceType
   */
  @JsonProperty(JSON_PROPERTY_WALLET_PROVIDER_DEVICE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWalletProviderDeviceType(WalletProviderDeviceType walletProviderDeviceType) {
    this.walletProviderDeviceType = walletProviderDeviceType;
  }

  /** Return true if this TransactionRuleRestrictions object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionRuleRestrictions transactionRuleRestrictions = (TransactionRuleRestrictions) o;
    return Objects.equals(this.activeNetworkTokens, transactionRuleRestrictions.activeNetworkTokens)
        && Objects.equals(this.brandVariants, transactionRuleRestrictions.brandVariants)
        && Objects.equals(this.counterpartyBank, transactionRuleRestrictions.counterpartyBank)
        && Objects.equals(this.counterpartyTypes, transactionRuleRestrictions.counterpartyTypes)
        && Objects.equals(this.countries, transactionRuleRestrictions.countries)
        && Objects.equals(this.dayOfWeek, transactionRuleRestrictions.dayOfWeek)
        && Objects.equals(this.differentCurrencies, transactionRuleRestrictions.differentCurrencies)
        && Objects.equals(this.entryModes, transactionRuleRestrictions.entryModes)
        && Objects.equals(
            this.internationalTransaction, transactionRuleRestrictions.internationalTransaction)
        && Objects.equals(
            this.matchingTransactions, transactionRuleRestrictions.matchingTransactions)
        && Objects.equals(this.matchingValues, transactionRuleRestrictions.matchingValues)
        && Objects.equals(this.mccs, transactionRuleRestrictions.mccs)
        && Objects.equals(this.merchantNames, transactionRuleRestrictions.merchantNames)
        && Objects.equals(this.merchants, transactionRuleRestrictions.merchants)
        && Objects.equals(this.processingTypes, transactionRuleRestrictions.processingTypes)
        && Objects.equals(this.riskScores, transactionRuleRestrictions.riskScores)
        && Objects.equals(
            this.sameAmountRestriction, transactionRuleRestrictions.sameAmountRestriction)
        && Objects.equals(
            this.sameCounterpartyRestriction,
            transactionRuleRestrictions.sameCounterpartyRestriction)
        && Objects.equals(this.sourceAccountTypes, transactionRuleRestrictions.sourceAccountTypes)
        && Objects.equals(this.timeOfDay, transactionRuleRestrictions.timeOfDay)
        && Objects.equals(this.tokenRequestors, transactionRuleRestrictions.tokenRequestors)
        && Objects.equals(this.totalAmount, transactionRuleRestrictions.totalAmount)
        && Objects.equals(
            this.walletProviderAccountScore, transactionRuleRestrictions.walletProviderAccountScore)
        && Objects.equals(
            this.walletProviderDeviceScore, transactionRuleRestrictions.walletProviderDeviceScore)
        && Objects.equals(
            this.walletProviderDeviceType, transactionRuleRestrictions.walletProviderDeviceType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        activeNetworkTokens,
        brandVariants,
        counterpartyBank,
        counterpartyTypes,
        countries,
        dayOfWeek,
        differentCurrencies,
        entryModes,
        internationalTransaction,
        matchingTransactions,
        matchingValues,
        mccs,
        merchantNames,
        merchants,
        processingTypes,
        riskScores,
        sameAmountRestriction,
        sameCounterpartyRestriction,
        sourceAccountTypes,
        timeOfDay,
        tokenRequestors,
        totalAmount,
        walletProviderAccountScore,
        walletProviderDeviceScore,
        walletProviderDeviceType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionRuleRestrictions {\n");
    sb.append("    activeNetworkTokens: ")
        .append(toIndentedString(activeNetworkTokens))
        .append("\n");
    sb.append("    brandVariants: ").append(toIndentedString(brandVariants)).append("\n");
    sb.append("    counterpartyBank: ").append(toIndentedString(counterpartyBank)).append("\n");
    sb.append("    counterpartyTypes: ").append(toIndentedString(counterpartyTypes)).append("\n");
    sb.append("    countries: ").append(toIndentedString(countries)).append("\n");
    sb.append("    dayOfWeek: ").append(toIndentedString(dayOfWeek)).append("\n");
    sb.append("    differentCurrencies: ")
        .append(toIndentedString(differentCurrencies))
        .append("\n");
    sb.append("    entryModes: ").append(toIndentedString(entryModes)).append("\n");
    sb.append("    internationalTransaction: ")
        .append(toIndentedString(internationalTransaction))
        .append("\n");
    sb.append("    matchingTransactions: ")
        .append(toIndentedString(matchingTransactions))
        .append("\n");
    sb.append("    matchingValues: ").append(toIndentedString(matchingValues)).append("\n");
    sb.append("    mccs: ").append(toIndentedString(mccs)).append("\n");
    sb.append("    merchantNames: ").append(toIndentedString(merchantNames)).append("\n");
    sb.append("    merchants: ").append(toIndentedString(merchants)).append("\n");
    sb.append("    processingTypes: ").append(toIndentedString(processingTypes)).append("\n");
    sb.append("    riskScores: ").append(toIndentedString(riskScores)).append("\n");
    sb.append("    sameAmountRestriction: ")
        .append(toIndentedString(sameAmountRestriction))
        .append("\n");
    sb.append("    sameCounterpartyRestriction: ")
        .append(toIndentedString(sameCounterpartyRestriction))
        .append("\n");
    sb.append("    sourceAccountTypes: ").append(toIndentedString(sourceAccountTypes)).append("\n");
    sb.append("    timeOfDay: ").append(toIndentedString(timeOfDay)).append("\n");
    sb.append("    tokenRequestors: ").append(toIndentedString(tokenRequestors)).append("\n");
    sb.append("    totalAmount: ").append(toIndentedString(totalAmount)).append("\n");
    sb.append("    walletProviderAccountScore: ")
        .append(toIndentedString(walletProviderAccountScore))
        .append("\n");
    sb.append("    walletProviderDeviceScore: ")
        .append(toIndentedString(walletProviderDeviceScore))
        .append("\n");
    sb.append("    walletProviderDeviceType: ")
        .append(toIndentedString(walletProviderDeviceType))
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
   * Create an instance of TransactionRuleRestrictions given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of TransactionRuleRestrictions
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     TransactionRuleRestrictions
   */
  public static TransactionRuleRestrictions fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, TransactionRuleRestrictions.class);
  }

  /**
   * Convert an instance of TransactionRuleRestrictions to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
