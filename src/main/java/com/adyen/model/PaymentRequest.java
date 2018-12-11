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
package com.adyen.model;

import java.util.List;
import java.util.Objects;
import com.adyen.Util.Util;
import com.adyen.constants.ApiConstants;
import com.adyen.model.additionalData.InvoiceLine;
import com.adyen.model.additionalData.SplitPayment;
import com.adyen.model.additionalData.SplitPaymentItem;
import com.adyen.model.applicationinfo.ApplicationInfo;
import com.adyen.model.applicationinfo.CommonField;
import com.adyen.model.checkout.AccountInfo;
import com.adyen.model.checkout.MerchantRiskIndicator;
import com.adyen.model.checkout.Split;
import com.adyen.model.checkout.ThreeDS2RequestData;
import com.google.gson.annotations.SerializedName;
import static com.adyen.Client.LIB_NAME;
import static com.adyen.Client.LIB_VERSION;

/**
 * PaymentRequest
 */
public class PaymentRequest extends AbstractPaymentRequest<PaymentRequest> {
    private static final String ADDITIONAL_DATA = "/authorise-3d-adyen-response";

    @SerializedName("accountInfo")
    private AccountInfo accountInfo = null;

    @SerializedName("card")
    private Card card = null;

    @SerializedName("mpiData")
    private ThreeDSecureData mpiData = null;

    @SerializedName("bankAccount")
    private BankAccount bankAccount = null;

    @SerializedName("store")
    private String store = null;

    @SerializedName("applicationInfo")
    private ApplicationInfo applicationInfo;

    @SerializedName("merchantRiskIndicator")
    private MerchantRiskIndicator merchantRiskIndicator = null;

    @SerializedName("splits")
    private List<Split> splits = null;

    @SerializedName("trustedShopper")
    private Boolean trustedShopper = null;

       public PaymentRequest() {
        CommonField adyenLibrary = new CommonField();
        adyenLibrary.setName(LIB_NAME);
        adyenLibrary.setVersion(LIB_VERSION);

        this.applicationInfo = new ApplicationInfo();
        this.applicationInfo.setAdyenLibrary(adyenLibrary);
    }

    /**
     * how the shopper interacts with the system
     */
    public enum RecurringProcessingModelEnum {
        @SerializedName("Subscription")
        SUBSCRIPTION("Subscription"),

        @SerializedName("CardOnFile")
        CARD_ON_FILE("CardOnFile");

        private String value;

        RecurringProcessingModelEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("recurringProcessingModel")
    private RecurringProcessingModelEnum recurringProcessingModel = null;

    public PaymentRequest setAmountData(String amount, String currency) {
        Amount amountData = Util.createAmount(amount, currency);
        this.setAmount(amountData);
        return this;
    }

    public PaymentRequest setCSEToken(String cseToken) {
        getOrCreateAdditionalData().put(ApiConstants.AdditionalData.Card.Encrypted.JSON, cseToken);
        return this;
    }

    public PaymentRequest setCardData(String cardNumber, String cardHolder, String expiryMonth, String expiryYear, String cvc) {
        Card card = new Card();
        card.setExpiryMonth(expiryMonth);
        card.setExpiryYear(expiryYear);
        card.setHolderName(cardHolder);
        card.setNumber(cardNumber);
        card.setCvc(cvc);

        this.setCard(card);
        return this;
    }

    /**
     * Set Data needed for payment request using secured fields
     */
    public PaymentRequest setSecuredFieldsData(String encryptedCardNumber, String cardHolder, String encryptedExpiryMonth, String encryptedExpiryYear, String encryptedSecurityCode) {
        this.setCardHolder(cardHolder)
            .setEncryptedCardNumber(encryptedCardNumber)
            .setEncryptedExpiryMonth(encryptedExpiryMonth)
            .setEncryptedExpiryYear(encryptedExpiryYear)
            .setEncryptedSecurityCode(encryptedSecurityCode);

        return this;
    }

    public PaymentRequest setCardHolder(String cardHolder) {
        if (card == null) {
            card = new Card();
        }
        card.setHolderName(cardHolder);

        return this;
    }

    public PaymentRequest setEncryptedCardNumber(String encryptedCardNumber) {
        getOrCreateAdditionalData().put(ApiConstants.AdditionalData.ENCRYPTED_CARD_NUMBER, encryptedCardNumber);
        return this;
    }

    public PaymentRequest setEncryptedExpiryMonth(String encryptedExpiryMonth) {
        getOrCreateAdditionalData().put(ApiConstants.AdditionalData.ENCRYPTED_EXPIRY_MONTH, encryptedExpiryMonth);
        return this;
    }

    public PaymentRequest setEncryptedExpiryYear(String encryptedExpiryYear) {
        getOrCreateAdditionalData().put(ApiConstants.AdditionalData.ENCRYPTED_EXPIRY_YEAR, encryptedExpiryYear);
        return this;
    }

    public PaymentRequest setEncryptedSecurityCode(String encryptedSecurityCode) {
        getOrCreateAdditionalData().put(ApiConstants.AdditionalData.ENCRYPTED_SECURITY_CODE, encryptedSecurityCode);
        return this;
    }

    public PaymentRequest setPaymentToken(String paymentToken) {
        getOrCreateAdditionalData().put(ApiConstants.AdditionalData.PAYMENT_TOKEN, paymentToken);
        return this;
    }

    public RecurringProcessingModelEnum getRecurringProcessingModel() {
        return recurringProcessingModel;
    }

    public PaymentRequest setRecurringProcessingModel(RecurringProcessingModelEnum recurringProcessingModel) {
        this.recurringProcessingModel = recurringProcessingModel;
        return this;
    }

    /**
     * Set invoiceLines in addtionalData
     */
    public PaymentRequest setInvoiceLines(List<InvoiceLine> invoiceLines) {
        Integer count = 1;
        for (InvoiceLine invoiceLine : invoiceLines) {
            StringBuilder sb = new StringBuilder();
            sb.append("openinvoicedata.line");
            sb.append(Integer.toString(count));
            String lineNumber = sb.toString();

            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".currencyCode").toString(), invoiceLine.getCurrencyCode());

            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".description").toString(), invoiceLine.getDescription());

            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".itemAmount").toString(), invoiceLine.getItemAmount().toString());

            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".itemVatAmount").toString(), invoiceLine.getItemVATAmount().toString());

            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".itemVatPercentage").toString(), invoiceLine.getItemVatPercentage().toString());

            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".numberOfItems").toString(), Integer.toString(invoiceLine.getNumberOfItems()));

            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".vatCategory").toString(), invoiceLine.getVatCategory().toString());

            // Addional field only for RatePay
            if (invoiceLine.getItemId() != null && ! invoiceLine.getItemId().isEmpty()) {
                this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".itemId").toString(), invoiceLine.getItemId());
            }

            count++;
        }

        this.getOrCreateAdditionalData().put("openinvoicedata.numberOfLines", Integer.toString(invoiceLines.size()));
        return this;
    }

    public PaymentRequest setSplitPayment(SplitPayment splitPayment) {
        this.getOrCreateAdditionalData().put("split.api", splitPayment.getApi().toString());
        this.getOrCreateAdditionalData().put("split.totalAmount", splitPayment.getTotalAmount().toString());
        this.getOrCreateAdditionalData().put("split.currencyCode", splitPayment.getCurrencyCode());

        Integer count = 1;
        for (SplitPaymentItem splitPaymentItem : splitPayment.getSplitPaymentItems()) {

            StringBuilder sb = new StringBuilder();
            sb.append("split.item");
            sb.append(Integer.toString(count));
            String lineNumber = sb.toString();
            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".amount").toString(), splitPaymentItem.getAmount().toString());
            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".type").toString(), splitPaymentItem.getType());
            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".account").toString(), splitPaymentItem.getAccount());
            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".reference").toString(), splitPaymentItem.getReference());
            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".description").toString(), splitPaymentItem.getDescription());

            count++;
        }
        this.getOrCreateAdditionalData().put("split.nrOfItems", Integer.toString(splitPayment.getSplitPaymentItems().size()));

        return this;
    }

    public PaymentRequest card(Card card) {
        this.card = card;
        return this;
    }

    /**
     * a representation of a (credit or debit) card
     *
     * @return card
     **/

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public PaymentRequest mpiData(ThreeDSecureData mpiData) {
        this.mpiData = mpiData;
        return this;
    }

    /**
     * authentication data produced by an MPI (MasterCard SecureCode or Verified By Visa)
     *
     * @return mpiData
     **/

    public ThreeDSecureData getMpiData() {
        return mpiData;
    }

    public void setMpiData(ThreeDSecureData mpiData) {
        this.mpiData = mpiData;
    }

    public PaymentRequest bankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    /**
     * a representation of a bank account
     *
     * @return bankAccount
     **/
    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public PaymentRequest store(String store) {
        this.store = store;
        return this;
    }

    /**
     * store id from which the payment request is made from
     *
     * @return store
     **/
    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public ApplicationInfo getApplicationInfo() {
        return applicationInfo;
    }

    public void setApplicationInfo(ApplicationInfo applicationInfo) {
        this.applicationInfo = applicationInfo;
    }

    public PaymentRequest applicationInfo(ApplicationInfo applicationInfo) {
        this.applicationInfo = applicationInfo;
        return this;
    }
    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public MerchantRiskIndicator getMerchantRiskIndicator() {
        return merchantRiskIndicator;
    }

    public void setMerchantRiskIndicator(MerchantRiskIndicator merchantRiskIndicator) {
        this.merchantRiskIndicator = merchantRiskIndicator;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public Boolean getTrustedShopper() {
        return trustedShopper;
    }

    public void setTrustedShopper(Boolean trustedShopper) {
        this.trustedShopper = trustedShopper;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentRequest paymentRequest = (PaymentRequest) o;
        return Objects.equals(this.accountInfo, paymentRequest.accountInfo) &&
                Objects.equals(this.applicationInfo, paymentRequest.applicationInfo) &&
                Objects.equals(this.bankAccount, paymentRequest.bankAccount) &&
                Objects.equals(this.card, paymentRequest.card) &&
                Objects.equals(this.merchantRiskIndicator, paymentRequest.merchantRiskIndicator) &&
                Objects.equals(this.mpiData, paymentRequest.mpiData) &&
                Objects.equals(this.recurringProcessingModel, paymentRequest.recurringProcessingModel) &&
                Objects.equals(this.splits, paymentRequest.splits) &&
                Objects.equals(this.store, paymentRequest.store) &&

                Objects.equals(this.trustedShopper, paymentRequest.trustedShopper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(card, mpiData, bankAccount, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentRequest {\n");
        sb.append("    accountInfo: ").append(toIndentedString(accountInfo)).append("\n");
        sb.append("    applicationInfo: ").append(toIndentedString(applicationInfo)).append("\n");
        sb.append("    bankAccount: ").append(toIndentedString(bankAccount)).append("\n");
        sb.append("    card: ").append(toIndentedString(card)).append("\n");
        sb.append("    merchantRiskIndicator: ").append(toIndentedString(merchantRiskIndicator)).append("\n");
        sb.append("    mpiData: ").append(toIndentedString(mpiData)).append("\n");
        sb.append("    recurringProcessingModel: ").append(toIndentedString(recurringProcessingModel)).append("\n");
        sb.append("    splits: ").append(toIndentedString(splits)).append("\n");
        sb.append("    store: ").append(toIndentedString(store)).append("\n");
        sb.append("    trustedShopper: ").append(toIndentedString(trustedShopper)).append("\n");
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

}
