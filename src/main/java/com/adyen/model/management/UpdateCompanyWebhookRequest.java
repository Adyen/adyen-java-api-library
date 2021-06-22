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

package com.adyen.model.management;

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

import static com.adyen.util.Util.toIndentedString;

public class UpdateCompanyWebhookRequest {
    @SerializedName("acceptsExpiredCertificate")
    private Boolean acceptsExpiredCertificate = null;

    @SerializedName("acceptsSelfSignedCertificate")
    private Boolean acceptsSelfSignedCertificate = null;

    @SerializedName("acceptsUntrustedRootCertificate")
    private Boolean acceptsUntrustedRootCertificate = null;

    @SerializedName("active")
    private Boolean active = null;

    @SerializedName("additionalSettings")
    private AdditionalSettings additionalSettings = null;

    /**
     * Format or protocol for receiving webhooks. Possible values: * **SOAP** * **HTTP** * **JSON**
     */
    @JsonAdapter(CommunicationFormatEnum.Adapter.class)
    public enum CommunicationFormatEnum {
        HTTP("http"),
        JSON("json"),
        SOAP("soap");

        @JsonValue
        private String value;

        CommunicationFormatEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static CommunicationFormatEnum fromValue(String text) {
            for (CommunicationFormatEnum b : CommunicationFormatEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<CommunicationFormatEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final CommunicationFormatEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public CommunicationFormatEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return CommunicationFormatEnum.fromValue(String.valueOf(value));
            }
        }
    }  @SerializedName("communicationFormat")
    private CommunicationFormatEnum communicationFormat = null;

    @SerializedName("description")
    private String description = null;

    /**
     * Shows how merchant accounts are filtered when configuring the webhook. Possible values: * **includeAccounts**: The webhook is configured for the merchant accounts listed in &#x60;filterMerchantAccounts&#x60;. * **excludeAccounts**: The webhook is not configured for the merchant accounts listed in &#x60;filterMerchantAccounts&#x60;. * **allAccounts**: includes all merchant accounts, and does not require specifying &#x60;filterMerchantAccounts&#x60;.
     */
    @JsonAdapter(FilterMerchantAccountTypeEnum.Adapter.class)
    public enum FilterMerchantAccountTypeEnum {
        EXCLUDE_LIST("EXCLUDE_LIST"),
        INCLUDE_ALL("INCLUDE_ALL"),
        INCLUDE_LIST("INCLUDE_LIST");

        private String value;

        FilterMerchantAccountTypeEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static FilterMerchantAccountTypeEnum fromValue(String text) {
            for (FilterMerchantAccountTypeEnum b : FilterMerchantAccountTypeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<FilterMerchantAccountTypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final FilterMerchantAccountTypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public FilterMerchantAccountTypeEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return FilterMerchantAccountTypeEnum.fromValue(String.valueOf(value));
            }
        }
    }  @SerializedName("filterMerchantAccountType")
    private FilterMerchantAccountTypeEnum filterMerchantAccountType = null;

    @SerializedName("filterMerchantAccounts")
    private List<String> filterMerchantAccounts = null;

    /**
     * Network type for Terminal API notification webhooks.
     */
    @JsonAdapter(NetworkTypeEnum.Adapter.class)
    public enum NetworkTypeEnum {
        LOCAL("LOCAL"),
        PUBLIC("PUBLIC");

        private String value;

        NetworkTypeEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static NetworkTypeEnum fromValue(String text) {
            for (NetworkTypeEnum b : NetworkTypeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<NetworkTypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final NetworkTypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public NetworkTypeEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return NetworkTypeEnum.fromValue(String.valueOf(value));
            }
        }
    }  @SerializedName("networkType")
    private NetworkTypeEnum networkType = null;

    @SerializedName("password")
    private String password = null;

    @SerializedName("populateSoapActionHeader")
    private Boolean populateSoapActionHeader = null;

    /**
     * SSL version to access the public webhook URL specified in the &#x60;url&#x60; field. Possible values: * **TLSv1.2** * **SSL** * **SSLv3** * **TLS** * **TLSv1** * **TLSv1.1**  If not specified, the webhook will use &#x60;sslVersion&#x60;: **TLSv1.2**.
     */
    @JsonAdapter(SslVersionEnum.Adapter.class)
    public enum SslVersionEnum {
        HTTP("HTTP"),
        SSL("SSL"),
        SSLV3("SSLv3"),
        SSL_INSECURE_CIPHERS("SSL"),
        TLS("TLS"),
        TLSV1("TLSv1"),
        TLSV1_1("TLSv1.1"),
        TLSV1_2("TLSv1.2"),
        TLSV1_INSECURE_CIPHERS("TLSv1");

        @JsonValue
        private String value;

        SslVersionEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static SslVersionEnum fromValue(String text) {
            for (SslVersionEnum b : SslVersionEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<SslVersionEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final SslVersionEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public SslVersionEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return SslVersionEnum.fromValue(String.valueOf(value));
            }
        }
    }  @SerializedName("sslVersion")
    private SslVersionEnum sslVersion = null;

    @SerializedName("type")
    private String type = null;

    @SerializedName("url")
    private String url = null;

    @SerializedName("username")
    private String username = null;

    public UpdateCompanyWebhookRequest acceptsExpiredCertificate(Boolean acceptsExpiredCertificate) {
        this.acceptsExpiredCertificate = acceptsExpiredCertificate;
        return this;
    }

    /**
     * Indicates if expired SSL certificates are accepted. If not specified, the default value is **false**, meaning expired SSL certificates are not accepted.
     * @return acceptsExpiredCertificate
     **/
    public Boolean isAcceptsExpiredCertificate() {
        return acceptsExpiredCertificate;
    }

    public void setAcceptsExpiredCertificate(Boolean acceptsExpiredCertificate) {
        this.acceptsExpiredCertificate = acceptsExpiredCertificate;
    }

    public UpdateCompanyWebhookRequest acceptsSelfSignedCertificate(Boolean acceptsSelfSignedCertificate) {
        this.acceptsSelfSignedCertificate = acceptsSelfSignedCertificate;
        return this;
    }

    /**
     * Indicates if self-signed SSL certificates are accepted. If not specified, the default value is **false**, meaning self-signed SSL certificates are not accepted.
     * @return acceptsSelfSignedCertificate
     **/
    public Boolean isAcceptsSelfSignedCertificate() {
        return acceptsSelfSignedCertificate;
    }

    public void setAcceptsSelfSignedCertificate(Boolean acceptsSelfSignedCertificate) {
        this.acceptsSelfSignedCertificate = acceptsSelfSignedCertificate;
    }

    public UpdateCompanyWebhookRequest acceptsUntrustedRootCertificate(Boolean acceptsUntrustedRootCertificate) {
        this.acceptsUntrustedRootCertificate = acceptsUntrustedRootCertificate;
        return this;
    }

    /**
     * Indicates if untrusted SSL certificates are accepted. If not specified, the default value is **false**, meaning untrusted root certificates are not accepted.
     * @return acceptsUntrustedRootCertificate
     **/
    public Boolean isAcceptsUntrustedRootCertificate() {
        return acceptsUntrustedRootCertificate;
    }

    public void setAcceptsUntrustedRootCertificate(Boolean acceptsUntrustedRootCertificate) {
        this.acceptsUntrustedRootCertificate = acceptsUntrustedRootCertificate;
    }

    public UpdateCompanyWebhookRequest active(Boolean active) {
        this.active = active;
        return this;
    }

    /**
     * Indicates if the webhook configuration is active. The field must be **true** for us to send webhooks about events related an account.
     * @return active
     **/
    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public UpdateCompanyWebhookRequest additionalSettings(AdditionalSettings additionalSettings) {
        this.additionalSettings = additionalSettings;
        return this;
    }

    /**
     * Get additionalSettings
     * @return additionalSettings
     **/
    public AdditionalSettings getAdditionalSettings() {
        return additionalSettings;
    }

    public void setAdditionalSettings(AdditionalSettings additionalSettings) {
        this.additionalSettings = additionalSettings;
    }

    public UpdateCompanyWebhookRequest communicationFormat(CommunicationFormatEnum communicationFormat) {
        this.communicationFormat = communicationFormat;
        return this;
    }

    /**
     * Format or protocol for receiving webhooks. Possible values: * **SOAP** * **HTTP** * **JSON**
     * @return communicationFormat
     **/
    public CommunicationFormatEnum getCommunicationFormat() {
        return communicationFormat;
    }

    public void setCommunicationFormat(CommunicationFormatEnum communicationFormat) {
        this.communicationFormat = communicationFormat;
    }

    public UpdateCompanyWebhookRequest description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Your description for this webhook configuration.
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UpdateCompanyWebhookRequest filterMerchantAccountType(FilterMerchantAccountTypeEnum filterMerchantAccountType) {
        this.filterMerchantAccountType = filterMerchantAccountType;
        return this;
    }

    /**
     * Shows how merchant accounts are filtered when configuring the webhook. Possible values: * **includeAccounts**: The webhook is configured for the merchant accounts listed in &#x60;filterMerchantAccounts&#x60;. * **excludeAccounts**: The webhook is not configured for the merchant accounts listed in &#x60;filterMerchantAccounts&#x60;. * **allAccounts**: includes all merchant accounts, and does not require specifying &#x60;filterMerchantAccounts&#x60;.
     * @return filterMerchantAccountType
     **/
    public FilterMerchantAccountTypeEnum getFilterMerchantAccountType() {
        return filterMerchantAccountType;
    }

    public void setFilterMerchantAccountType(FilterMerchantAccountTypeEnum filterMerchantAccountType) {
        this.filterMerchantAccountType = filterMerchantAccountType;
    }

    public UpdateCompanyWebhookRequest filterMerchantAccounts(List<String> filterMerchantAccounts) {
        this.filterMerchantAccounts = filterMerchantAccounts;
        return this;
    }

    public UpdateCompanyWebhookRequest addFilterMerchantAccountsItem(String filterMerchantAccountsItem) {
        if (this.filterMerchantAccounts == null) {
            this.filterMerchantAccounts = new ArrayList<String>();
        }
        this.filterMerchantAccounts.add(filterMerchantAccountsItem);
        return this;
    }

    /**
     * A list of merchant account names that are included or excluded from receiving the webhook. Inclusion or exclusion is based on the value defined for &#x60;filterMerchantAccountType&#x60;.  Required if &#x60;filterMerchantAccountType&#x60; is either: * **includeAccounts** * **excludeAccounts**  Not needed for &#x60;filterMerchantAccountType&#x60;: **allAccounts**.
     * @return filterMerchantAccounts
     **/
    public List<String> getFilterMerchantAccounts() {
        return filterMerchantAccounts;
    }

    public void setFilterMerchantAccounts(List<String> filterMerchantAccounts) {
        this.filterMerchantAccounts = filterMerchantAccounts;
    }

    public UpdateCompanyWebhookRequest networkType(NetworkTypeEnum networkType) {
        this.networkType = networkType;
        return this;
    }

    /**
     * Network type for Terminal API notification webhooks.
     * @return networkType
     **/
    public NetworkTypeEnum getNetworkType() {
        return networkType;
    }

    public void setNetworkType(NetworkTypeEnum networkType) {
        this.networkType = networkType;
    }

    public UpdateCompanyWebhookRequest password(String password) {
        this.password = password;
        return this;
    }

    /**
     * Password to access the webhook URL.
     * @return password
     **/
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UpdateCompanyWebhookRequest populateSoapActionHeader(Boolean populateSoapActionHeader) {
        this.populateSoapActionHeader = populateSoapActionHeader;
        return this;
    }

    /**
     * Indicates if the SOAP action header needs to be populated. The default value is &#x60;populateSoapActionHeader&#x60;: **false**.  Only applies if &#x60;communicationFormat&#x60;: **SOAP**.
     * @return populateSoapActionHeader
     **/
    public Boolean isPopulateSoapActionHeader() {
        return populateSoapActionHeader;
    }

    public void setPopulateSoapActionHeader(Boolean populateSoapActionHeader) {
        this.populateSoapActionHeader = populateSoapActionHeader;
    }

    public UpdateCompanyWebhookRequest sslVersion(SslVersionEnum sslVersion) {
        this.sslVersion = sslVersion;
        return this;
    }

    /**
     * SSL version to access the public webhook URL specified in the &#x60;url&#x60; field. Possible values: * **TLSv1.2** * **SSL** * **SSLv3** * **TLS** * **TLSv1** * **TLSv1.1**  If not specified, the webhook will use &#x60;sslVersion&#x60;: **TLSv1.2**.
     * @return sslVersion
     **/
    public SslVersionEnum getSslVersion() {
        return sslVersion;
    }

    public void setSslVersion(SslVersionEnum sslVersion) {
        this.sslVersion = sslVersion;
    }

    public UpdateCompanyWebhookRequest type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The type of webhook that is being created. Possible values are:  - **standard** - **account-settings-notification** - **banktransfer-notification** - **boletobancario-notification** - **directdebit-notification** - **pending-notification** - **ideal-notification** - **ideal-pending-notification** - **report-notification** - **terminal-api-notification**  Find out more about [standard notification webhooks](https://docs.adyen.com/development-resources/webhooks/understand-notifications#event-codes) and [other types of notifications](https://docs.adyen.com/development-resources/webhooks/understand-notifications#other-notifications).
     * @return type
     **/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UpdateCompanyWebhookRequest url(String url) {
        this.url = url;
        return this;
    }

    /**
     * Public URL where webhooks will be sent, for example **https://www.domain.com/webhook-endpoint**.
     * @return url
     **/
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UpdateCompanyWebhookRequest username(String username) {
        this.username = username;
        return this;
    }

    /**
     * Username to access the webhook URL.
     * @return username
     **/
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateCompanyWebhookRequest updateCompanyWebhookRequest = (UpdateCompanyWebhookRequest) o;
        return Objects.equals(this.acceptsExpiredCertificate, updateCompanyWebhookRequest.acceptsExpiredCertificate) &&
                Objects.equals(this.acceptsSelfSignedCertificate, updateCompanyWebhookRequest.acceptsSelfSignedCertificate) &&
                Objects.equals(this.acceptsUntrustedRootCertificate, updateCompanyWebhookRequest.acceptsUntrustedRootCertificate) &&
                Objects.equals(this.active, updateCompanyWebhookRequest.active) &&
                Objects.equals(this.additionalSettings, updateCompanyWebhookRequest.additionalSettings) &&
                Objects.equals(this.communicationFormat, updateCompanyWebhookRequest.communicationFormat) &&
                Objects.equals(this.description, updateCompanyWebhookRequest.description) &&
                Objects.equals(this.filterMerchantAccountType, updateCompanyWebhookRequest.filterMerchantAccountType) &&
                Objects.equals(this.filterMerchantAccounts, updateCompanyWebhookRequest.filterMerchantAccounts) &&
                Objects.equals(this.networkType, updateCompanyWebhookRequest.networkType) &&
                Objects.equals(this.password, updateCompanyWebhookRequest.password) &&
                Objects.equals(this.populateSoapActionHeader, updateCompanyWebhookRequest.populateSoapActionHeader) &&
                Objects.equals(this.sslVersion, updateCompanyWebhookRequest.sslVersion) &&
                Objects.equals(this.type, updateCompanyWebhookRequest.type) &&
                Objects.equals(this.url, updateCompanyWebhookRequest.url) &&
                Objects.equals(this.username, updateCompanyWebhookRequest.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acceptsExpiredCertificate, acceptsSelfSignedCertificate, acceptsUntrustedRootCertificate, active, additionalSettings, communicationFormat, description, filterMerchantAccountType, filterMerchantAccounts, networkType, password, populateSoapActionHeader, sslVersion, type, url, username);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateCompanyWebhookRequest {\n");

        sb.append("    acceptsExpiredCertificate: ").append(toIndentedString(acceptsExpiredCertificate)).append("\n");
        sb.append("    acceptsSelfSignedCertificate: ").append(toIndentedString(acceptsSelfSignedCertificate)).append("\n");
        sb.append("    acceptsUntrustedRootCertificate: ").append(toIndentedString(acceptsUntrustedRootCertificate)).append("\n");
        sb.append("    active: ").append(toIndentedString(active)).append("\n");
        sb.append("    additionalSettings: ").append(toIndentedString(additionalSettings)).append("\n");
        sb.append("    communicationFormat: ").append(toIndentedString(communicationFormat)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    filterMerchantAccountType: ").append(toIndentedString(filterMerchantAccountType)).append("\n");
        sb.append("    filterMerchantAccounts: ").append(toIndentedString(filterMerchantAccounts)).append("\n");
        sb.append("    networkType: ").append(toIndentedString(networkType)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    populateSoapActionHeader: ").append(toIndentedString(populateSoapActionHeader)).append("\n");
        sb.append("    sslVersion: ").append(toIndentedString(sslVersion)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
