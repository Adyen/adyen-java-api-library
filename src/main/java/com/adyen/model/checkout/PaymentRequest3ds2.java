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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.checkout;


import java.util.Objects;
import com.adyen.model.*;
import com.adyen.model.applicationinfo.ApplicationInfo;
import com.adyen.model.recurring.Recurring;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;

/**
 * PaymentRequest3ds2
 */
public class PaymentRequest3ds2 {

    @SerializedName("accountInfo")
    private AccountInfo accountInfo = null;

    @SerializedName("additionalAmount")
    private Amount additionalAmount = null;

    @SerializedName("additionalData")
    private Object additionalData = null;

    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("applicationInfo")
    private ApplicationInfo applicationInfo = null;

    @SerializedName("billingAddress")
    private Address billingAddress = null;

    @SerializedName("browserInfo")
    private BrowserInfo browserInfo = null;

    @SerializedName("captureDelayHours")
    private Integer captureDelayHours = null;

    @SerializedName("dateOfBirth")
    private OffsetDateTime dateOfBirth = null;

    @SerializedName("dccQuote")
    private ForexQuote dccQuote = null;

    @SerializedName("deliveryAddress")
    private Address deliveryAddress = null;

    @SerializedName("deliveryDate")
    private OffsetDateTime deliveryDate = null;

    @SerializedName("deviceFingerprint")
    private String deviceFingerprint = null;

    @SerializedName("fraudOffset")
    private Integer fraudOffset = null;

    @SerializedName("installments")
    private Installments installments = null;

    @SerializedName("mcc")
    private String mcc = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("merchantOrderReference")
    private String merchantOrderReference = null;

    @SerializedName("merchantRiskIndicator")
    private MerchantRiskIndicator merchantRiskIndicator = null;

    @SerializedName("metadata")
    private Object metadata = null;

    @SerializedName("orderReference")
    private String orderReference = null;

    @SerializedName("recurring")
    private Recurring recurring = null;

    /**
     * Defines a recurring payment type. Allowed values: * &#x60;Subscription&#x60; – A transaction for a fixed or variable amount, which follows a fixed schedule. * &#x60;CardOnFile&#x60; – Card details are stored to enable one-click or omnichannel journeys, or simply to streamline the checkout process. Any subscription not following a fixed schedule is also considered a card-on-file transaction.
     */
    @JsonAdapter(RecurringProcessingModelEnum.Adapter.class)
    public enum RecurringProcessingModelEnum {

        CARDONFILE("CardOnFile"),
        SUBSCRIPTION("Subscription");

        private String value;

        RecurringProcessingModelEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static RecurringProcessingModelEnum fromValue(String text) {
            for (RecurringProcessingModelEnum b : RecurringProcessingModelEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<RecurringProcessingModelEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final RecurringProcessingModelEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public RecurringProcessingModelEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return RecurringProcessingModelEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("recurringProcessingModel")
    private RecurringProcessingModelEnum recurringProcessingModel = null;

    @SerializedName("reference")
    private String reference = null;

    @SerializedName("selectedBrand")
    private String selectedBrand = null;

    @SerializedName("selectedRecurringDetailReference")
    private String selectedRecurringDetailReference = null;

    @SerializedName("sessionId")
    private String sessionId = null;

    @SerializedName("shopperEmail")
    private String shopperEmail = null;

    @SerializedName("shopperIP")
    private String shopperIP = null;

    /**
     * Specifies the sales channel, through which the shopper gives their card details, and whether the shopper is a returning customer. For the web service API, Adyen assumes Ecommerce shopper interaction by default.  This field has the following possible values: * &#x60;Ecommerce&#x60; - Online transactions where the cardholder is present (online). For better authorisation rates, we recommend sending the card security code (CSC) along with the request. * &#x60;ContAuth&#x60; - Card on file and/or subscription transactions, where the cardholder is known to the merchant (returning customer). If the shopper is present (online), you can supply also the CSC to improve authorisation (one-click payment). * &#x60;Moto&#x60; - Mail-order and telephone-order transactions where the shopper is in contact with the merchant via email or telephone. * &#x60;POS&#x60; - Point-of-sale transactions where the shopper is physically present to make a payment using a secure payment terminal.
     */
    @JsonAdapter(ShopperInteractionEnum.Adapter.class)
    public enum ShopperInteractionEnum {

        ECOMMERCE("Ecommerce"),
        CONTAUTH("ContAuth"),
        MOTO("Moto"),
        POS("POS");

        private String value;

        ShopperInteractionEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static ShopperInteractionEnum fromValue(String text) {
            for (ShopperInteractionEnum b : ShopperInteractionEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<ShopperInteractionEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ShopperInteractionEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public ShopperInteractionEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return ShopperInteractionEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("shopperInteraction")
    private ShopperInteractionEnum shopperInteraction = null;

    @SerializedName("shopperLocale")
    private String shopperLocale = null;

    @SerializedName("shopperName")
    private Name shopperName = null;

    @SerializedName("shopperReference")
    private String shopperReference = null;

    @SerializedName("shopperStatement")
    private String shopperStatement = null;

    @SerializedName("socialSecurityNumber")
    private String socialSecurityNumber = null;

    @SerializedName("splits")
    private List<Split> splits = null;

    @SerializedName("store")
    private String store = null;

    @SerializedName("telephoneNumber")
    private String telephoneNumber = null;

    @SerializedName("threeDS2RequestData")
    private ThreeDS2RequestData threeDS2RequestData = null;

    @SerializedName("threeDS2Result")
    private ThreeDS2Result threeDS2Result = null;

    @SerializedName("threeDS2Token")
    private String threeDS2Token = null;

    @SerializedName("totalsGroup")
    private String totalsGroup = null;

    @SerializedName("trustedShopper")
    private Boolean trustedShopper = null;

    public PaymentRequest3ds2 accountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
        return this;
    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public PaymentRequest3ds2 additionalAmount(Amount additionalAmount) {
        this.additionalAmount = additionalAmount;
        return this;
    }

    public Amount getAdditionalAmount() {
        return additionalAmount;
    }

    public void setAdditionalAmount(Amount additionalAmount) {
        this.additionalAmount = additionalAmount;
    }

    public PaymentRequest3ds2 additionalData(Object additionalData) {
        this.additionalData = additionalData;
        return this;
    }

    public Object getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Object additionalData) {
        this.additionalData = additionalData;
    }

    public PaymentRequest3ds2 amount(Amount amount) {
        this.amount = amount;
        return this;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public PaymentRequest3ds2 applicationInfo(ApplicationInfo applicationInfo) {
        this.applicationInfo = applicationInfo;
        return this;
    }

    public ApplicationInfo getApplicationInfo() {
        return applicationInfo;
    }

    public void setApplicationInfo(ApplicationInfo applicationInfo) {
        this.applicationInfo = applicationInfo;
    }

    public PaymentRequest3ds2 billingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public PaymentRequest3ds2 browserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
        return this;
    }


    public BrowserInfo getBrowserInfo() {
        return browserInfo;
    }

    public void setBrowserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
    }

    public PaymentRequest3ds2 captureDelayHours(Integer captureDelayHours) {
        this.captureDelayHours = captureDelayHours;
        return this;
    }

    public Integer getCaptureDelayHours() {
        return captureDelayHours;
    }

    public void setCaptureDelayHours(Integer captureDelayHours) {
        this.captureDelayHours = captureDelayHours;
    }

    public PaymentRequest3ds2 dateOfBirth(OffsetDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public OffsetDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(OffsetDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public PaymentRequest3ds2 dccQuote(ForexQuote dccQuote) {
        this.dccQuote = dccQuote;
        return this;
    }

    public ForexQuote getDccQuote() {
        return dccQuote;
    }

    public void setDccQuote(ForexQuote dccQuote) {
        this.dccQuote = dccQuote;
    }

    public PaymentRequest3ds2 deliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }


    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public PaymentRequest3ds2 deliveryDate(OffsetDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }

    public OffsetDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(OffsetDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public PaymentRequest3ds2 deviceFingerprint(String deviceFingerprint) {
        this.deviceFingerprint = deviceFingerprint;
        return this;
    }

    public String getDeviceFingerprint() {
        return deviceFingerprint;
    }

    public void setDeviceFingerprint(String deviceFingerprint) {
        this.deviceFingerprint = deviceFingerprint;
    }

    public PaymentRequest3ds2 fraudOffset(Integer fraudOffset) {
        this.fraudOffset = fraudOffset;
        return this;
    }

    public Integer getFraudOffset() {
        return fraudOffset;
    }

    public void setFraudOffset(Integer fraudOffset) {
        this.fraudOffset = fraudOffset;
    }

    public PaymentRequest3ds2 installments(Installments installments) {
        this.installments = installments;
        return this;
    }


    public Installments getInstallments() {
        return installments;
    }

    public void setInstallments(Installments installments) {
        this.installments = installments;
    }

    public PaymentRequest3ds2 mcc(String mcc) {
        this.mcc = mcc;
        return this;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public PaymentRequest3ds2 merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public PaymentRequest3ds2 merchantOrderReference(String merchantOrderReference) {
        this.merchantOrderReference = merchantOrderReference;
        return this;
    }

    public String getMerchantOrderReference() {
        return merchantOrderReference;
    }

    public void setMerchantOrderReference(String merchantOrderReference) {
        this.merchantOrderReference = merchantOrderReference;
    }

    public PaymentRequest3ds2 merchantRiskIndicator(MerchantRiskIndicator merchantRiskIndicator) {
        this.merchantRiskIndicator = merchantRiskIndicator;
        return this;
    }

    public MerchantRiskIndicator getMerchantRiskIndicator() {
        return merchantRiskIndicator;
    }

    public void setMerchantRiskIndicator(MerchantRiskIndicator merchantRiskIndicator) {
        this.merchantRiskIndicator = merchantRiskIndicator;
    }

    public PaymentRequest3ds2 metadata(Object metadata) {
        this.metadata = metadata;
        return this;
    }

    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    public PaymentRequest3ds2 orderReference(String orderReference) {
        this.orderReference = orderReference;
        return this;
    }

    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    public PaymentRequest3ds2 recurring(Recurring recurring) {
        this.recurring = recurring;
        return this;
    }

    public Recurring getRecurring() {
        return recurring;
    }

    public void setRecurring(Recurring recurring) {
        this.recurring = recurring;
    }

    public PaymentRequest3ds2 recurringProcessingModel(RecurringProcessingModelEnum recurringProcessingModel) {
        this.recurringProcessingModel = recurringProcessingModel;
        return this;
    }

    public RecurringProcessingModelEnum getRecurringProcessingModel() {
        return recurringProcessingModel;
    }

    public void setRecurringProcessingModel(RecurringProcessingModelEnum recurringProcessingModel) {
        this.recurringProcessingModel = recurringProcessingModel;
    }

    public PaymentRequest3ds2 reference(String reference) {
        this.reference = reference;
        return this;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public PaymentRequest3ds2 selectedBrand(String selectedBrand) {
        this.selectedBrand = selectedBrand;
        return this;
    }

    public String getSelectedBrand() {
        return selectedBrand;
    }

    public void setSelectedBrand(String selectedBrand) {
        this.selectedBrand = selectedBrand;
    }

    public PaymentRequest3ds2 selectedRecurringDetailReference(String selectedRecurringDetailReference) {
        this.selectedRecurringDetailReference = selectedRecurringDetailReference;
        return this;
    }

    public String getSelectedRecurringDetailReference() {
        return selectedRecurringDetailReference;
    }

    public void setSelectedRecurringDetailReference(String selectedRecurringDetailReference) {
        this.selectedRecurringDetailReference = selectedRecurringDetailReference;
    }

    public PaymentRequest3ds2 sessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public PaymentRequest3ds2 shopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
        return this;
    }

    public String getShopperEmail() {
        return shopperEmail;
    }

    public void setShopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
    }

    public PaymentRequest3ds2 shopperIP(String shopperIP) {
        this.shopperIP = shopperIP;
        return this;
    }


    public String getShopperIP() {
        return shopperIP;
    }

    public void setShopperIP(String shopperIP) {
        this.shopperIP = shopperIP;
    }

    public PaymentRequest3ds2 shopperInteraction(ShopperInteractionEnum shopperInteraction) {
        this.shopperInteraction = shopperInteraction;
        return this;
    }

    public ShopperInteractionEnum getShopperInteraction() {
        return shopperInteraction;
    }

    public void setShopperInteraction(ShopperInteractionEnum shopperInteraction) {
        this.shopperInteraction = shopperInteraction;
    }

    public PaymentRequest3ds2 shopperLocale(String shopperLocale) {
        this.shopperLocale = shopperLocale;
        return this;
    }

    public String getShopperLocale() {
        return shopperLocale;
    }

    public void setShopperLocale(String shopperLocale) {
        this.shopperLocale = shopperLocale;
    }

    public PaymentRequest3ds2 shopperName(Name shopperName) {
        this.shopperName = shopperName;
        return this;
    }


    public Name getShopperName() {
        return shopperName;
    }

    public void setShopperName(Name shopperName) {
        this.shopperName = shopperName;
    }

    public PaymentRequest3ds2 shopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
        return this;
    }


    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    public PaymentRequest3ds2 shopperStatement(String shopperStatement) {
        this.shopperStatement = shopperStatement;
        return this;
    }


    public String getShopperStatement() {
        return shopperStatement;
    }

    public void setShopperStatement(String shopperStatement) {
        this.shopperStatement = shopperStatement;
    }

    public PaymentRequest3ds2 socialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
        return this;
    }


    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public PaymentRequest3ds2 splits(List<Split> splits) {
        this.splits = splits;
        return this;
    }

    public PaymentRequest3ds2 addSplitsItem(Split splitsItem) {

        if (this.splits == null) {
            this.splits = new ArrayList<Split>();
        }

        this.splits.add(splitsItem);
        return this;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public PaymentRequest3ds2 store(String store) {
        this.store = store;
        return this;
    }


    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public PaymentRequest3ds2 telephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public PaymentRequest3ds2 threeDS2RequestData(ThreeDS2RequestData threeDS2RequestData) {
        this.threeDS2RequestData = threeDS2RequestData;
        return this;
    }

    public ThreeDS2RequestData getThreeDS2RequestData() {
        return threeDS2RequestData;
    }

    public void setThreeDS2RequestData(ThreeDS2RequestData threeDS2RequestData) {
        this.threeDS2RequestData = threeDS2RequestData;
    }

    public PaymentRequest3ds2 threeDS2Result(ThreeDS2Result threeDS2Result) {
        this.threeDS2Result = threeDS2Result;
        return this;
    }

    public ThreeDS2Result getThreeDS2Result() {
        return threeDS2Result;
    }

    public void setThreeDS2Result(ThreeDS2Result threeDS2Result) {
        this.threeDS2Result = threeDS2Result;
    }

    public PaymentRequest3ds2 threeDS2Token(String threeDS2Token) {
        this.threeDS2Token = threeDS2Token;
        return this;
    }

    public String getThreeDS2Token() {
        return threeDS2Token;
    }

    public void setThreeDS2Token(String threeDS2Token) {
        this.threeDS2Token = threeDS2Token;
    }

    public PaymentRequest3ds2 totalsGroup(String totalsGroup) {
        this.totalsGroup = totalsGroup;
        return this;
    }


    public String getTotalsGroup() {
        return totalsGroup;
    }

    public void setTotalsGroup(String totalsGroup) {
        this.totalsGroup = totalsGroup;
    }

    public PaymentRequest3ds2 trustedShopper(Boolean trustedShopper) {
        this.trustedShopper = trustedShopper;
        return this;
    }


    public Boolean isTrustedShopper() {
        return trustedShopper;
    }

    public void setTrustedShopper(Boolean trustedShopper) {
        this.trustedShopper = trustedShopper;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentRequest3ds2 paymentRequest3ds2 = (PaymentRequest3ds2) o;
        return Objects.equals(this.accountInfo, paymentRequest3ds2.accountInfo) &&
                Objects.equals(this.additionalAmount, paymentRequest3ds2.additionalAmount) &&
                Objects.equals(this.additionalData, paymentRequest3ds2.additionalData) &&
                Objects.equals(this.amount, paymentRequest3ds2.amount) &&
                Objects.equals(this.applicationInfo, paymentRequest3ds2.applicationInfo) &&
                Objects.equals(this.billingAddress, paymentRequest3ds2.billingAddress) &&
                Objects.equals(this.browserInfo, paymentRequest3ds2.browserInfo) &&
                Objects.equals(this.captureDelayHours, paymentRequest3ds2.captureDelayHours) &&
                Objects.equals(this.dateOfBirth, paymentRequest3ds2.dateOfBirth) &&
                Objects.equals(this.dccQuote, paymentRequest3ds2.dccQuote) &&
                Objects.equals(this.deliveryAddress, paymentRequest3ds2.deliveryAddress) &&
                Objects.equals(this.deliveryDate, paymentRequest3ds2.deliveryDate) &&
                Objects.equals(this.deviceFingerprint, paymentRequest3ds2.deviceFingerprint) &&
                Objects.equals(this.fraudOffset, paymentRequest3ds2.fraudOffset) &&
                Objects.equals(this.installments, paymentRequest3ds2.installments) &&
                Objects.equals(this.mcc, paymentRequest3ds2.mcc) &&
                Objects.equals(this.merchantAccount, paymentRequest3ds2.merchantAccount) &&
                Objects.equals(this.merchantOrderReference, paymentRequest3ds2.merchantOrderReference) &&
                Objects.equals(this.merchantRiskIndicator, paymentRequest3ds2.merchantRiskIndicator) &&
                Objects.equals(this.metadata, paymentRequest3ds2.metadata) &&
                Objects.equals(this.orderReference, paymentRequest3ds2.orderReference) &&
                Objects.equals(this.recurring, paymentRequest3ds2.recurring) &&
                Objects.equals(this.recurringProcessingModel, paymentRequest3ds2.recurringProcessingModel) &&
                Objects.equals(this.reference, paymentRequest3ds2.reference) &&
                Objects.equals(this.selectedBrand, paymentRequest3ds2.selectedBrand) &&
                Objects.equals(this.selectedRecurringDetailReference, paymentRequest3ds2.selectedRecurringDetailReference) &&
                Objects.equals(this.sessionId, paymentRequest3ds2.sessionId) &&
                Objects.equals(this.shopperEmail, paymentRequest3ds2.shopperEmail) &&
                Objects.equals(this.shopperIP, paymentRequest3ds2.shopperIP) &&
                Objects.equals(this.shopperInteraction, paymentRequest3ds2.shopperInteraction) &&
                Objects.equals(this.shopperLocale, paymentRequest3ds2.shopperLocale) &&
                Objects.equals(this.shopperName, paymentRequest3ds2.shopperName) &&
                Objects.equals(this.shopperReference, paymentRequest3ds2.shopperReference) &&
                Objects.equals(this.shopperStatement, paymentRequest3ds2.shopperStatement) &&
                Objects.equals(this.socialSecurityNumber, paymentRequest3ds2.socialSecurityNumber) &&
                Objects.equals(this.splits, paymentRequest3ds2.splits) &&
                Objects.equals(this.store, paymentRequest3ds2.store) &&
                Objects.equals(this.telephoneNumber, paymentRequest3ds2.telephoneNumber) &&
                Objects.equals(this.threeDS2RequestData, paymentRequest3ds2.threeDS2RequestData) &&
                Objects.equals(this.threeDS2Result, paymentRequest3ds2.threeDS2Result) &&
                Objects.equals(this.threeDS2Token, paymentRequest3ds2.threeDS2Token) &&
                Objects.equals(this.totalsGroup, paymentRequest3ds2.totalsGroup) &&
                Objects.equals(this.trustedShopper, paymentRequest3ds2.trustedShopper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountInfo, additionalAmount, additionalData, amount, applicationInfo, billingAddress, browserInfo, captureDelayHours, dateOfBirth, dccQuote, deliveryAddress, deliveryDate, deviceFingerprint, fraudOffset, installments, mcc, merchantAccount, merchantOrderReference, merchantRiskIndicator, metadata, orderReference, recurring, recurringProcessingModel, reference, selectedBrand, selectedRecurringDetailReference, sessionId, shopperEmail, shopperIP, shopperInteraction, shopperLocale, shopperName, shopperReference, shopperStatement, socialSecurityNumber, splits, store, telephoneNumber, threeDS2RequestData, threeDS2Result, threeDS2Token, totalsGroup, trustedShopper);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentRequest3ds2 {\n");

        sb.append("    accountInfo: ").append(toIndentedString(accountInfo)).append("\n");
        sb.append("    additionalAmount: ").append(toIndentedString(additionalAmount)).append("\n");
        sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    applicationInfo: ").append(toIndentedString(applicationInfo)).append("\n");
        sb.append("    billingAddress: ").append(toIndentedString(billingAddress)).append("\n");
        sb.append("    browserInfo: ").append(toIndentedString(browserInfo)).append("\n");
        sb.append("    captureDelayHours: ").append(toIndentedString(captureDelayHours)).append("\n");
        sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
        sb.append("    dccQuote: ").append(toIndentedString(dccQuote)).append("\n");
        sb.append("    deliveryAddress: ").append(toIndentedString(deliveryAddress)).append("\n");
        sb.append("    deliveryDate: ").append(toIndentedString(deliveryDate)).append("\n");
        sb.append("    deviceFingerprint: ").append(toIndentedString(deviceFingerprint)).append("\n");
        sb.append("    fraudOffset: ").append(toIndentedString(fraudOffset)).append("\n");
        sb.append("    installments: ").append(toIndentedString(installments)).append("\n");
        sb.append("    mcc: ").append(toIndentedString(mcc)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    merchantOrderReference: ").append(toIndentedString(merchantOrderReference)).append("\n");
        sb.append("    merchantRiskIndicator: ").append(toIndentedString(merchantRiskIndicator)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    orderReference: ").append(toIndentedString(orderReference)).append("\n");
        sb.append("    recurring: ").append(toIndentedString(recurring)).append("\n");
        sb.append("    recurringProcessingModel: ").append(toIndentedString(recurringProcessingModel)).append("\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    selectedBrand: ").append(toIndentedString(selectedBrand)).append("\n");
        sb.append("    selectedRecurringDetailReference: ").append(toIndentedString(selectedRecurringDetailReference)).append("\n");
        sb.append("    sessionId: ").append(toIndentedString(sessionId)).append("\n");
        sb.append("    shopperEmail: ").append(toIndentedString(shopperEmail)).append("\n");
        sb.append("    shopperIP: ").append(toIndentedString(shopperIP)).append("\n");
        sb.append("    shopperInteraction: ").append(toIndentedString(shopperInteraction)).append("\n");
        sb.append("    shopperLocale: ").append(toIndentedString(shopperLocale)).append("\n");
        sb.append("    shopperName: ").append(toIndentedString(shopperName)).append("\n");
        sb.append("    shopperReference: ").append(toIndentedString(shopperReference)).append("\n");
        sb.append("    shopperStatement: ").append(toIndentedString(shopperStatement)).append("\n");
        sb.append("    socialSecurityNumber: ").append(toIndentedString(socialSecurityNumber)).append("\n");
        sb.append("    splits: ").append(toIndentedString(splits)).append("\n");
        sb.append("    store: ").append(toIndentedString(store)).append("\n");
        sb.append("    telephoneNumber: ").append(toIndentedString(telephoneNumber)).append("\n");
        sb.append("    threeDS2RequestData: ").append(toIndentedString(threeDS2RequestData)).append("\n");
        sb.append("    threeDS2Result: ").append(toIndentedString(threeDS2Result)).append("\n");
        sb.append("    threeDS2Token: ").append(toIndentedString(threeDS2Token)).append("\n");
        sb.append("    totalsGroup: ").append(toIndentedString(totalsGroup)).append("\n");
        sb.append("    trustedShopper: ").append(toIndentedString(trustedShopper)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }


}



